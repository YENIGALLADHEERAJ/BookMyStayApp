/**
 * CUSTOM EXCEPTION - InvalidBookingException
 * Used to represent domain-specific validation errors.
 */
public class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}
