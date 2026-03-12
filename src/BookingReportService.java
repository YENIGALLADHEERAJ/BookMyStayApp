/**
 * CLASS - BookingReportService
 * Generates summaries and reports from stored booking data.
 * @version 8.0
 */
public class BookingReportService {

    /**
     * Displays a summary report of all confirmed bookings.
     * @param history The booking history to report on.
     */
    public void generateReport(BookingHistory history) {
        System.out.println("Booking History Report");
        for (Reservation res : history.getHistory()) {
            System.out.println("Guest: " + res.getGuestName() +
                    ", Room Type: " + res.getRoomType());
        }
    }
}
