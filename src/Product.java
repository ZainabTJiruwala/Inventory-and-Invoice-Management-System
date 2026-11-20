// product inherits item
public class Product extends Item {
    private double prce;
    private int qty;

    public Product(int id, String name, double prce, int qty) {
        super(id, name);
        this.prce = prce;
        this.qty = qty;
    }

    public double getPrice() { return prce; }
    public int getQty() { return qty; }

    public void show() {
        System.out.println(getId() + ". " + getName() + " - Rs." + prce);
    }
}
