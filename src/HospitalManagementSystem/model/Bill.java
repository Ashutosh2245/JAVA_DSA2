package HospitalManagementSystem.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private final int id;
    private final Patient patient;
    private final List<BillItem> items = new ArrayList<>();
    private final LocalDateTime createdAt = LocalDateTime.now();

    public Bill(int id, Patient patient) {
        this.id = id;
        this.patient = patient;
    }

    public int getId() { return id; }
    public Patient getPatient() { return patient; }
    public List<BillItem> getItems() { return new ArrayList<>(items); }
    public void addItem(BillItem item) { items.add(item); }

    public double getSubtotal() {
        double total = 0;
        for (BillItem item : items) total += item.getTotal();
        return total;
    }

    public double getServiceCharge() { return getSubtotal() * 0.05; }
    public double getGrandTotal() { return getSubtotal() + getServiceCharge(); }

    public String getCreatedAt() {
        return createdAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

    public void printInvoice() {
        System.out.println("\n========== HOSPITAL INVOICE ==========");
        System.out.println("Bill ID: " + id);
        System.out.println("Date: " + getCreatedAt());
        System.out.println(patient);
        System.out.println("--------------------------------------");
        if (items.isEmpty()) {
            System.out.println("No bill items.");
        } else {
            for (BillItem item : items) System.out.println(item);
        }
        System.out.println("--------------------------------------");
        System.out.printf("Subtotal:       Rs. %.2f%n", getSubtotal());
        System.out.printf("Service charge (5%%): Rs. %.2f%n", getServiceCharge());
        System.out.printf("GRAND TOTAL:    Rs. %.2f%n", getGrandTotal());
        System.out.println("======================================\n");
    }
}
