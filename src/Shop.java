import java.util.ArrayList;
import java.util.HashMap;

public class Shop {
    private HashMap<Integer, Product> stock = new HashMap<Integer, Product>();
    private ArrayList<Invoice> bills = new ArrayList<Invoice>();
    private int bnum = 1;

    public void add(Product p) {
        stock.put(p.getId(), p);
    }

    public Product find(int id) throws ProductNotFoundException {
        Product p = stock.get(id);
        if (p == null) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        return p;
    }

    public void restock(int id, int q) throws ProductNotFoundException {
        Product p = find(id);
        p.addQty(q);
        System.out.println("Done!");
    }
}
