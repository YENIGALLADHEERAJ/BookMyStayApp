/**
 * Use Case 7: Add-On Service Selection
 * Version 7.0
 */
public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        System.out.println("Add-On Service Selection");

        // 1. Initialize Service Manager
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // 2. Define Reservation ID (Simulating a confirmed booking)
        String reservationId = "Single-1";

        // 3. Attach multiple services
        serviceManager.addService(reservationId, new Service("Breakfast", 500.0));
        serviceManager.addService(reservationId, new Service("WiFi", 1000.0));

        // 4. Calculate and Display Total Cost
        double totalCost = serviceManager.calculateTotal(reservationId);

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}
