import java.io.*;
import java.util.Map;

/**
 * CLASS - RoomInventoryPersistenceService
 * Handles storing and retrieving room inventory from a file.
 * Format: roomType=availableCount
 */
public class RoomInventoryPersistenceService {

    public void saveInventory(RoomInventory inventory, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : inventory.getRoomAvailability().entrySet()) {
                writer.println(entry.getKey() + "=" + entry.getValue());
            }
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    public void loadInventory(RoomInventory inventory, String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("No persistence file found.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    inventory.updateAvailability(parts[0], Integer.parseInt(parts[1]));
                }
            }
        }
    }
}
