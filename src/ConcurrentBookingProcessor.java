/**
 * CLASS - ConcurrentBookingProcessor
 * Processes booking requests from a shared queue in a thread-safe manner.
 */
public class ConcurrentBookingProcessor implements Runnable {
    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(BookingRequestQueue queue, RoomInventory inventory, RoomAllocationService service) {
        this.bookingQueue = queue;
        this.inventory = inventory;
        this.allocationService = service;
    }

    @Override
    public void run() {
        // We use the bookingQueue as a lock to prevent race conditions
        while (true) {
            Reservation request = null;

            synchronized (bookingQueue) {
                if (bookingQueue.hasPendingRequests()) {
                    request = bookingQueue.getNextRequest();
                } else {
                    break; // No more requests to process
                }
            }

            if (request != null) {
                // Synchronize allocation to prevent double-booking
                synchronized (allocationService) {
                    allocationService.allocateRoom(request, inventory);
                }
            }

            try { Thread.sleep(100); } catch (InterruptedException e) { break; }
        }
    }
}
