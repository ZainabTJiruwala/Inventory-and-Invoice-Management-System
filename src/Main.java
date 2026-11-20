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
        }
        sc.close();
    }
}
