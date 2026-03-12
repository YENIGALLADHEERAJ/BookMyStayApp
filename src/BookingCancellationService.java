import java.util.Stack;

public class BookingCancellationService {
    private Stack<String> rollbackHistory = new Stack<>();

    /**
     * Cancels a confirmed booking and restores inventory safely.
     */
    public void cancelBooking(String reservationId, String roomType, RoomInventory inventory) {
        // 1. Restore Inventory
        inventory.incrementAvailability(roomType);

        // 2. Add to Rollback Stack (LIFO)
        rollbackHistory.push(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    /**
     * Displays recently cancelled reservations in LIFO order.
     */
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        while (!rollbackHistory.isEmpty()) {
            System.out.println("Released Reservation ID: " + rollbackHistory.pop());
        }
    }
}
