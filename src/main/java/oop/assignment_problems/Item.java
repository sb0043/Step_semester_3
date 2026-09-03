package oop.assignment_problems;

public class Item {
    String itemCode;
    int quantity;

    public Item(String itemCode, int quantity) {
        this.itemCode = itemCode;
        this.quantity = quantity;
    }

    public void restock(int quantity) {
        this.quantity += quantity;
    }

    public void printStatus() {
        System.out.println(itemCode + " | Quantity: " + quantity);
    }

    public static void main(String[] args) {
        String[] itemCodes = {"I101", "I102", "I103", "I104"};
        int[] quantities = {10, 20, 15, 25};
        int[] restockQuantities = {5, 10, 20, 15};

        for (int i = 0; i < itemCodes.length; i++) {
            Item item = new Item(itemCodes[i], quantities[i]);

            item.restock(restockQuantities[i]);

            item.printStatus();
        }
    }
}