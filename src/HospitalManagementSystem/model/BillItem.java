package HospitalManagementSystem.model;

public class BillItem {
    private final String description;
    private final int quantity;
    private final double unitPrice;

    public BillItem(String description, int quantity, double unitPrice) {
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }
    public double getTotal() { return quantity * unitPrice; }

    @Override
    public String toString() {
        return description + " | Qty: " + quantity + " | Unit: Rs. "
                + String.format("%.2f", unitPrice) + " | Total: Rs. "
                + String.format("%.2f", getTotal());
    }
}
