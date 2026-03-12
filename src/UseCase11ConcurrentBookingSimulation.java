/**
 * MAIN CLASS - UseCase11ConcurrentBookingSimulation
 * Version 11.0
 */
public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) {
        System.out.println("Concurrent Booking Simulation\n");

        // 1. Setup Shared Resources
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // 2. Pre-fill the queue with requests (Matches your screenshot)
        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Double"));
        bookingQueue.addRequest(new Reservation("Kural", "Suite"));
        bookingQueue.addRequest(new Reservation("Subha", "Single"));

        // 3. Create and Start Threads (As shown in your "Main Logic" image)
        Thread t1 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));
        Thread t2 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));

        t1.start();
        t2.start();

        try {
            t1.join(); // Wait for threads to finish
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        // 4. Final Inventory Check (Matches your screenshot)
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.getAvailability("Single"));
        System.out.println("Double: " + inventory.getAvailability("Double"));
        System.out.println("Suite: " + inventory.getAvailability("Suite"));
    }
}
