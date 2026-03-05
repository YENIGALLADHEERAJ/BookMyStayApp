import java.util.Map;

/**
 * Use Case 4: Room Search & Availability Check
 * Version 4.0
 */
public class UseCase4RoomSearch {
    public static void main(String[] args) {
        System.out.println("Room Search Service\n");

        // 1. Initialize data
        RoomInventory inventory = new RoomInventory();
        Room single = new SingleRoom();
        Room doubleRm = new DoubleRoom();
        Room suite = new SuiteRoom();

        Map<String, Integer> currentInventory = inventory.getRoomAvailability();

        // 2. Read-only Search logic
        System.out.println("--- Available Rooms ---");

        System.out.println("Single Room:");
        single.displayDetails();
        System.out.println("Available: " + currentInventory.get("Single") + "\n");

        System.out.println("Double Room:");
        doubleRm.displayDetails();
        System.out.println("Available: " + currentInventory.get("Double") + "\n");

        System.out.println("Suite Room:");
        suite.displayDetails();
        System.out.println("Available: " + currentInventory.get("Suite"));
    }
}
