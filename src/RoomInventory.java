import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 6: Room Inventory Management
 */
public class RoomInventory {
    // 1. You must declare the variable here first!
    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        // 2. Initialize it in the constructor
        roomAvailability = new HashMap<>();
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    // Needed for UC4 & UC6
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    // Needed for UC3 & UC5
    public int getAvailability(String roomType) {
        return roomAvailability.getOrDefault(roomType, 0);
    }

    public void incrementAvailability(String roomType) {
        int current = getAvailability(roomType);
        roomAvailability.put(roomType, current + 1);
    }
    /**
     * Updates the availability count for a specific room type.
     * Used during System Recovery (UC12).
     */
    public void updateAvailability(String roomType, int count) {
        // This updates the HashMap with the value from the file
        roomAvailability.put(roomType, count);
    }

    // Needed for UC6 to reduce count
    public void decrementAvailability(String roomType) {
        int current = roomAvailability.getOrDefault(roomType, 0);
        if (current > 0) {
            roomAvailability.put(roomType, current - 1);
        }
    }
}
