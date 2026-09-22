package week5.assignment_problems;

import java.util.Arrays;

public class CirculationLedger {

    private static String branchCode;

    static {
        branchCode = "PT-LIB-01";
    }

    public static void processNightlyCirculation(
            LoanReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }

        System.out.println(
                processed
                        + " processed | "
                        + nullSkipped
                        + " null skipped | "
                        + referenceOnly
                        + " reference-only | "
                        + regular
                        + " regular"
        );
    }

    public static void main(String[] args) {

        LoanReceipt original =
                new LoanReceipt(
                        "BK-100",
                        new String[]{"BK-100", "BK-101"}
                );

        System.out.println(original.getBookId());

        String[] originalIds = original.getBookIds();
        System.out.println(
                String.join(", ", originalIds)
        );

        LoanReceipt corrected =
                original.withCorrectedBookId("BK-102");

        System.out.println(corrected.getBookId());
        System.out.println(
                String.join(", ", corrected.getBookIds())
        );

        LoanReceipt[] receipts = {
                original,
                new ReferenceOnlyLoanReceipt(
                        "REF-200",
                        new String[]{"REF-200"}
                ),
                null
        };

        processNightlyCirculation(receipts);

        System.out.println("Branch: " + branchCode);
    }
}

class LoanReceipt {

    private final String bookId;
    private final String[] bookIds;

    public LoanReceipt(
            String bookId,
            String[] bookIds) {

        this.bookId = bookId;

        if (bookIds == null) {
            this.bookIds = new String[0];
        } else {
            this.bookIds = Arrays.copyOf(
                    bookIds,
                    bookIds.length
            );
        }
    }

    public String getBookId() {
        return bookId;
    }

    public String[] getBookIds() {
        return Arrays.copyOf(
                bookIds,
                bookIds.length
        );
    }

    public LoanReceipt withCorrectedBookId(
            String correctedBookId) {

        return new LoanReceipt(
                correctedBookId,
                bookIds
        );
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    public ReferenceOnlyLoanReceipt(
            String bookId,
            String[] bookIds) {

        super(bookId, bookIds);
    }
}