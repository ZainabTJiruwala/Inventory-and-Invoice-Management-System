import java.util.ArrayList;

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
}
