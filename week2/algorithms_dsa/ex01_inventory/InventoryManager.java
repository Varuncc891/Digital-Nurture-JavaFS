import java.util.HashMap;
import java.util.Map;

class Product {
    private String id;
    private String name;
    private int quantity;
    private double price;

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int q) { this.quantity = q; }
    public double getPrice() { return price; }
    public void setPrice(double p) { this.price = p; }
}

public class InventoryManager {
    private Map<String, Product> inventory = new HashMap<>();

    public void add(Product p) { inventory.put(p.getId(), p); }
    public void update(String id, int quantity, double price) {
        Product p = inventory.get(id);
        if (p != null) {
            p.setQuantity(quantity);
            p.setPrice(price);
        }
    }
    public void delete(String id) { inventory.remove(id); }

    public static void main(String[] args) {
        InventoryManager im = new InventoryManager();
        Product p1 = new Product("101", "Laptop", 10, 899.99);
        im.add(p1);
        im.update("101", 12, 849.99);
        im.delete("101");
    }
}