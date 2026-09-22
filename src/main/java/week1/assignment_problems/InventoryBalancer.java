import java.util.Scanner;

public class InventoryBalancer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items in each section: ");
        int n = scanner.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        System.out.println("Enter quantities for Section A:");

        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            sectionA[i] = scanner.nextInt();
        }

        System.out.println("Enter quantities for Section B:");

        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            sectionB[i] = scanner.nextInt();
        }

        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < n; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);

        if (totalA == totalB) {
            System.out.println("Inventory Status: Balanced");
        } else {
            System.out.println("Inventory Status: Not Balanced");
        }

        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 1; i < n; i++) {

            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        for (int i = 0; i < n; i++) {

            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println("Highest Quantity: " + highestQuantity);
        System.out.println("Section: " + highestSection);
        System.out.println("Item Number: " + (highestIndex + 1));

        scanner.close();
    }
}