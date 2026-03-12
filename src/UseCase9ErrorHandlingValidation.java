import java.util.Scanner;

/**
 * MAIN CLASS - UseCase9ErrorHandlingValidation
 * Version 9.0
 */
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {
        // Display application header
        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        // Initialize required components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Perform validation
            validator.validate(roomType);

            // If validation passes, add to queue
            bookingQueue.addRequest(new Reservation(guestName, roomType));
            System.out.println("Booking request queued for " + guestName);

        } catch (InvalidBookingException e) {
            // Handle domain-specific validation errors
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            // Ensure resources are closed
            scanner.close();
        }
    }
}
