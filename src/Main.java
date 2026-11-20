import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shop s = new Shop();

        int ch = 0;
        while (ch != 7) {
            System.out.println("\n1.Show Stock 2.Add Item 3.Restock 4.Low Stock 5.Bill 6.Report 7.Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            try {
                if (ch == 1) {
                    s.showAll();
                } else if (ch == 2) {
                    System.out.print("id: ");
                    int id = sc.nextInt();
                    System.out.print("name: ");
                    String name = sc.next();
                    System.out.print("price: ");
                    double p = sc.nextDouble();
                    System.out.print("qty: ");
                    int q = sc.nextInt();
                    System.out.print("min limit: ");
                    int m = sc.nextInt();
                    s.add(new Product(id, name, p, q, m));
                    System.out.println("Added!");
                } else if (ch == 3) {
                    System.out.print("id: ");
                    int id = sc.nextInt();
                    System.out.print("qty: ");
                    int q = sc.nextInt();
                    s.restock(id, q);
                } else if (ch == 4) {
                    s.lowStock();
                } else if (ch == 5) {
                    System.out.print("Customer name: ");
                    Invoice inv = s.newBill(sc.next());
                    while (true) {
                        System.out.print("product id (0 to stop): ");
                        int pid = sc.nextInt();
                        if (pid == 0) break;
                        System.out.print("qty: ");
                        int q = sc.nextInt();
                        try {
                            s.sell(inv, pid, q);
                            System.out.println("Added!");
                        } catch (ProductNotFoundException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (OutOfStockException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    if (inv.getCount() > 0) {
                        s.save(inv);
                        inv.print();
                    }
                } else if (ch == 6) {
                    s.report();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Bye!");
        sc.close();
    }
}
