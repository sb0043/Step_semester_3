package oop.assignment_problems;

public class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone();
    }

    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {

        String[] updatedSeats = seatNumbers.clone();

        if (index >= 0 && index < updatedSeats.length) {
            updatedSeats[index] = newSeat;
        }

        return new BookingReceipt(bookingId, updatedSeats);
    }
}

class GroupBookingReceipt extends BookingReceipt {

    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers,
                               int groupSize) {

        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}

class SettlementProcessor {

    public static String processNightlySettlement(BookingReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (BookingReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
            } else {
                processed++;

                if (receipt instanceof GroupBookingReceipt) {
                    group++;
                } else {
                    individual++;
                }
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }
}