import java.util.Scanner;

public class ProductInventoryCSVParser {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product records (ID,Name,Price,Quantity): ");
        String input = scanner.nextLine();

        String[] products = input.split(";");

        System.out.println("\nProduct Inventory:");

        for (String product : products) {

            String[] details = product.split(",");

            int id = Integer.parseInt(details[0].trim());
            String name = details[1].trim();
            double price = Double.parseDouble(details[2].trim());
            int quantity = Integer.parseInt(details[3].trim());

            double totalValue = price * quantity;

            System.out.println("Product ID: " + id);
            System.out.println("Product Name: " + name);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Value: " + totalValue);
            System.out.println("-------------------------");
        }

        scanner.close();
    }
}