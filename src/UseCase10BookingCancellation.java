/**
 * MAIN CLASS - UseCase10BookingCancellation
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * Version 10.0
 */
public class UseCase10BookingCancellation {

    public static void main(String[] args) {
        System.out.println("Booking Cancellation");

        // 1. Initialize System
        RoomInventory inventory = new RoomInventory();
        BookingCancellationService cancellationService = new BookingCancellationService();

        // 2. Perform Cancellation (Simulating cancelling a 'Single-1' booking)
        cancellationService.cancelBooking("Single-1", "Single", inventory);

        // 3. Show Rollback History
        cancellationService.showRollbackHistory();

        // 4. Verify Inventory Update
        System.out.println("\nUpdated Single Room Availability: " + inventory.getAvailability("Single"));
    }
}
