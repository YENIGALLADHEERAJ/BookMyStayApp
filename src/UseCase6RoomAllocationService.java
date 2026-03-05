/**
 * MAIN CLASS - UseCase6RoomAllocationService
 * Use Case 6: Reservation Confirmation & Room Allocation
 * @version 6.0
 */
public class UseCase6RoomAllocationService {
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing");

        // 1. Initialize System
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        RoomAllocationService service = new RoomAllocationService();

        // 2. Add Requests (From previous UC5)
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        // 3. Process FIFO Allocation
        while (queue.hasPendingRequests()) {
            service.allocateRoom(queue.getNextRequest(), inventory);
        }
    }
}
