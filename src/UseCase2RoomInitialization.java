public class UseCase2RoomInitialization {
    public static void main(String[] args) {
        System.out.println("Hotel Room Initialization - Version 2.1\n");

        // Static Availability Variables
        int singleAvail = 5, doubleAvail = 3;

        Room s = new SingleRoom();
        Room d = new DoubleRoom();

        System.out.print("Single Room -> ");
        s.displayDetails();
        System.out.println("Available: " + singleAvail + "\n");

        System.out.print("Double Room -> ");
        d.displayDetails();
        System.out.println("Available: " + doubleAvail);
    }
}
