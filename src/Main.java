import java.util.Scanner;

 main program
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shop s = new Shop();

        // sample items
        s.add(new Product(1, "Pen", 10.0, 30));
        s.add(new Product(2, "Book", 50.0, 15));
        s.add(new Product(3, "Pencil", 5.0, 10));

        int ch = 0;

        while (ch != 4) {
            System.out.println("\n1.Show Stock 2.Add Item 3.Bill 4.Exit");
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
                    s.add(new Product(id, name, p, q));
                    System.out.println("Added!");
                } else if (ch == 3) {
                    System.out.print("Customer name: ");
                    Invoice inv = s.newBill(sc.next());

                    while (true) {
                        System.out.print("product id (0 to stop): ");
                        int pid = sc.nextInt();
                        if (pid == 0) {
                            break;
                        }
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
                        inv.print();
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Bye!");
        sc.close();
    }
}
