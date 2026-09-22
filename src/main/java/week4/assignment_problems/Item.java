package week4.assignment_problems;

public class Item {
    private String itemName;
    private int stock;

    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public void restock(int stock) {
        this.stock = this.stock + stock;
    }

    public void printStock() {
        System.out.println(itemName + " | Updated Stock: " + stock);
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item("Rice", 40),
            new Item("Milk", 25),
            new Item("Bread", 30),
            new Item("Juice", 15)
        };

        for (Item item : items) {
            item.restock(20);
            item.printStock();
        }
    }
}