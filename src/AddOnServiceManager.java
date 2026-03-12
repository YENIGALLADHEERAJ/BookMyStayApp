import java.util.*;

public class AddOnServiceManager {
    // Map: Reservation ID -> List of Services
    private Map<String, List<Service>> selections = new HashMap<>();

    public void addService(String resId, Service s) {
        // computeIfAbsent ensures the list exists before we .add(s)
        selections.computeIfAbsent(resId, k -> new ArrayList<>()).add(s);
        System.out.println("Service " + s.getName() + " added to " + resId);
    }

    public double calculateTotal(String resId) {
        List<Service> list = selections.getOrDefault(resId, new ArrayList<>());
        double total = 0;
        // Ensure you use 'list' (lowercase) to match your variable name
        for (Service s : list) {
            total += s.getCost();
        }
        return total;
    }
}
