public class UseCase3InventorySetup {
    public static void main(String[] args) {
        System.out.println("Hotel Room Inventory Status\n");

        RoomInventory ri = new RoomInventory();

        // Use Polymorphism to display details
        Room[] rooms = { new SingleRoom(), new DoubleRoom(), new SuiteRoom() };
        String[] types = { "Single", "Double", "Suite" };

        for (int i = 0; i < rooms.length; i++) {
            System.out.println(types[i] + " Room:");
            rooms[i].displayDetails();
            System.out.println("Available Rooms: " + ri.getAvailability(types[i]) + "\n");
        }
    }
}
