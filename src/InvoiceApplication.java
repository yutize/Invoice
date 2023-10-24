import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter invoice title:");
        String title = scanner.nextLine();
        System.out.println("Enter customer address:");
        String customerAddress = scanner.nextLine();

        List<LineItem> lineItems = new ArrayList<>();

        while (true) {
            System.out.println("Enter product name (or 'done' to finish):");
            String productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.println("Enter unit price:");
            double unitPrice = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter quantity:");
            int quantity = Integer.parseInt(scanner.nextLine());
            lineItems.add(new LineItem(new Product(productName, unitPrice), quantity));
        }

        double totalAmountDue = 0;
        for (LineItem lineItem : lineItems) {
            totalAmountDue += lineItem.getTotal();
        }

        System.out.println(title);
        System.out.println(customerAddress);
        System.out.println("-----------------------------");
        for (LineItem lineItem : lineItems) {
            System.out.println(lineItem.getProduct().getName() + " x " + lineItem.getQuantity() +
                    " @ " + lineItem.getProduct().getUnitPrice() + " = " + lineItem.getTotal());
        }
        System.out.println("-----------------------------");
        System.out.println("Total amount due: " + totalAmountDue);
    }
}

class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return product.getUnitPrice() * quantity;
    }
}

class Product {
    private String name;
    private double unitPrice;

    public Product(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

}