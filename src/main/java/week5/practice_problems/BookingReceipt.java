package week5.practice_problems;

public class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(
            String bookingId,
            String[] seatNumbers) {

        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone();
    }

    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    public BookingReceipt withUpdatedSeat(
            int index,
            String newSeat) {

        String[] updatedSeats = seatNumbers.clone();
        updatedSeats[index] = newSeat;

        return new BookingReceipt(
                bookingId,
                updatedSeats
        );
    }

    public static String processNightlySettlement(
            BookingReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (BookingReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof GroupBookingReceipt) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }

    public static void main(String[] args) {

        BookingReceipt b =
                new BookingReceipt(
                        "CH-1001",
                        new String[]{"A1", "A2"}
                );

        // Defensive-copy test
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";

        System.out.println(
                b.getSeatNumbers()[0]
        );

        // with-style update
        BookingReceipt updated =
                b.withUpdatedSeat(1, "A3");

        System.out.println(
                String.join(", ", b.getSeatNumbers())
        );

        System.out.println(
                String.join(", ", updated.getSeatNumbers())
        );

        // instanceof and null-safety test
        BookingReceipt[] receipts = {

                new GroupBookingReceipt(
                        "CH-2002",
                        new String[]{"B1", "B2"},
                        2
                ),

                null,

                new BookingReceipt(
                        "CH-3003",
                        new String[]{"C1"}
                )
        };

        System.out.println(
                processNightlySettlement(receipts)
        );
    }
}

class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(
            String bookingId,
            String[] seatNumbers,
            int groupSize) {

        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}