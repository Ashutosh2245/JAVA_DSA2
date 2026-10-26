package HospitalManagementSystem.model;

public class Medicine {
    private final int id;
    private final String name;
    private final double price;
    private int stock;

    public Medicine(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public boolean reduceStock(int quantity) {
        if (quantity <= 0 || quantity > stock) return false;
        stock -= quantity;
        return true;
    }

    @Override
    public String toString() {
        return "Medicine ID: " + id + " | " + name + " | Price/unit: Rs. "
                + String.format("%.2f", price) + " | Stock: " + stock;
    }
}
