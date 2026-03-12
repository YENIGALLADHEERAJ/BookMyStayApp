import java.io.IOException;

/**
 * MAIN CLASS - UseCase12DataPersistenceRecovery
 * Version 12.0
 */
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {
        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();
        RoomInventoryPersistenceService persistenceService = new RoomInventoryPersistenceService();
        String filePath = "inventory.txt";

        try {
            // Attempt to recover state from file
            persistenceService.loadInventory(inventory, filePath);
            System.out.println("System state restored from " + filePath);
        } catch (IOException e) {
            // Failure Tolerance: Start fresh if file is missing
            System.out.println("No valid inventory data found. Starting fresh.");
        }

        // Display current state
        System.out.println("\nCurrent Inventory:");
        inventory.getRoomAvailability().forEach((type, count) ->
                System.out.println(type + ": " + count));

        // Save current state for next restart
        persistenceService.saveInventory(inventory, filePath);
    }
}
