/**
 * CLASS - ReservationValidator
 * Use Case 9: Error Handling & Validation
 */
public class ReservationValidator {

    public void validate(String roomType) throws InvalidBookingException {
        // Case-sensitive check to match your provided output image
        if (!(roomType.equals("Single") || roomType.equals("Double") || roomType.equals("Suite"))) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
    }
}
