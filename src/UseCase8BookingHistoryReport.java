/**
 * MAIN CLASS - UseCase8BookingHistoryReport
 * Use Case 8: Booking History & Reporting
 * @version 8.0
 */
public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        System.out.println("Booking History and Reporting\n");

        // 1. Initialize History and Service
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // 2. Simulating confirmed bookings being added to history
        history.addRecord(new Reservation("Abhi", "Single"));
        history.addRecord(new Reservation("Subha", "Double"));
        history.addRecord(new Reservation("Vanmathi", "Suite"));

        // 3. Generate the report
        reportService.generateReport(history);
    }
}
