import java.util.ArrayList;
import java.util.List;

/**
 * CLASS - BookingHistory
 * Maintains a chronological record of all confirmed reservations.
 */
public class BookingHistory {
    private List<Reservation> history;

    public BookingHistory() {
        this.history = new ArrayList<>();
    }

    public void addRecord(Reservation reservation) {
        history.add(reservation);
    }

    public List<Reservation> getHistory() {
        return new ArrayList<>(history); // Defensive copy
    }
}
