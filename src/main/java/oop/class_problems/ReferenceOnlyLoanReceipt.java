package oop.class_problems;

public class ReferenceOnlyLoanReceipt extends LoanReceipt {

    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds,
                                    String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}