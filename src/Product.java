// product class extends item
public class Product extends Item {
    private double prce;
    private int qty;
    private int min;

    public Product(int id, String name, double prce, int qty, int min) {
        super(id, name);
        this.prce = prce;
        this.qty = qty;
        this.min = min;
    }

    public double getPrice() { return prce; }
    public int getQty() { return qty; }
    public int getMin() { return min; }

    public void addQty(int n) {
        qty = qty + n;
    }

    public void takeQty(int n) throws OutOfStockException {
        if (n > qty) {
            throw new OutOfStockException("Item is out of stock!");
        }
        qty = qty - n;
    }

    public void show() {
        System.out.println(getId() + ". " + getName() + " - Rs." + prce + " (qty: " + qty + ")");
    }
}
