// product class extends item
public class Product extends Item {
    private double prce;
    private int qty;

    public Product(int id, String name, double prce, int qty) {
        super(id, name);
        this.prce = prce;
        this.qty = qty;
    }

    public double getPrice() {
        return prce;
    }

    public int getQty() {
        return qty;
    }

    public void takeQty(int n) throws OutOfStockException {
        if (n > qty) {
            throw new OutOfStockException("Item is out of stock!");
        }
        qty = qty - n;
    }

    // polymorphism
    public void show() {
        System.out.println(getId() + ". " + getName() + " - Rs." + prce + " (qty: " + qty + ")");
    }
}
