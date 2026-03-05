import java.util.HashSet;
import java.util.Set;

public class RoomAllocationService {
    private Set<String> allocatedRoomIds = new HashSet<>();

    /**
     * Ensures the parameter type matches your global RoomInventory class exactly.
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();

        // 1. Check availability using the inventory object
        if (inventory.getAvailability(type) > 0) {
            // 2. Generate unique Room ID
            String roomId = type.toUpperCase() + "-" + (100 + allocatedRoomIds.size() + 1);

            // 3. Prevent double-booking using the Set
            allocatedRoomIds.add(roomId);

            // 4. Immediately update inventory
            inventory.decrementAvailability(type);

            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() +
                    ", Room ID: " + roomId);
        } else {
            System.out.println("Booking failed for Guest: " + reservation.getGuestName() +
                    " - No " + type + " rooms available.");
        }
    }
}
