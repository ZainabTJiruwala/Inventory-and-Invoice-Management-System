import java.util.ArrayList;

// simple bill class
public class Invoice {
    private int bno;
    private String cust;
    private ArrayList<String> itms = new ArrayList<String>();
    private double tot = 0;

    public Invoice(int bno, String cust) {
        this.bno = bno;
        this.cust = cust;
    }

    public void addItem(Product p, int q) {
        double a = p.getPrice() * q;
        itms.add(p.getName() + " x " + q + " = Rs." + a);
        tot = tot + a;
    }

    public double getTotal() {
        return tot;
    }

    public int getCount() {
        return itms.size();
    }

    public void print() {
        System.out.println("----- BILL " + bno + " -----");
        System.out.println("Customer: " + cust);
        for (int i = 0; i < itms.size(); i++) {
            System.out.println(itms.get(i));
        }
        System.out.println("Total: Rs." + tot);
        System.out.println("-----------------");
    }
}
