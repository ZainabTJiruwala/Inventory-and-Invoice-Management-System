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

    public void showAll() {
        ArrayList<Product> list = new ArrayList<Product>(stock.values());

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).getQty() > list.get(j + 1).getQty()) {
                    Product t = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, t);
                }
            }
        }

        System.out.println("\n--- Products List ---");
        for (int i = 0; i < list.size(); i++) {
            Item itm = list.get(i);
            itm.show();
        }
    }

    public void lowStock() {
        System.out.println("\n--- Low Stock Alerts ---");
        for (Product p : stock.values()) {
            if (p.getQty() <= p.getMin()) {
                System.out.println("ALERT: " + p.getName() + " only " + p.getQty() + " left!");
            }
        }
    }

    public Invoice newBill(String cust) {
        Invoice inv = new Invoice(bnum, cust);
        bnum = bnum + 1;
        return inv;
    }

    public void sell(Invoice inv, int id, int q) throws ProductNotFoundException, OutOfStockException {
        Product p = find(id);
        p.takeQty(q);
        inv.addItem(p, q);
    }

    public void save(Invoice inv) {
        bills.add(inv);
    }
}
