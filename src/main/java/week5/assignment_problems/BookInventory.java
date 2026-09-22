package week5.assignment_problems;

public class BookInventory {

    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {

        if (copiesTotal <= 0) {
            throw new IllegalArgumentException(
                    "copiesTotal must be positive"
            );
        }

        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public void checkOut() {

        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {

        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public static void main(String[] args) {

        BookInventory inventory = new BookInventory(3);

        inventory.checkOut();
        inventory.checkOut();
        inventory.checkOut();
        inventory.checkOut();

        System.out.println(
                "After checkout attempts: "
                        + inventory.getCopiesAvailable()
        );

        inventory.checkIn();
        inventory.checkIn();
        inventory.checkIn();
        inventory.checkIn();

        System.out.println(
                "After check-in attempts: "
                        + inventory.getCopiesAvailable()
        );
    }
}