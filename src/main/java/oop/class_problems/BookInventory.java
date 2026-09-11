package oop.class_problems;

public class BookInventory {

    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        this.copiesTotal = copiesTotal;

        if (copiesTotal < 0) {
            this.copiesAvailable = 0;
        } else {
            this.copiesAvailable = copiesTotal;
        }
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
}