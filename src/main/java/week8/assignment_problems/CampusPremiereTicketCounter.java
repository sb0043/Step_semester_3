package week8.assignment_problems;

import java.util.HashSet;
import java.util.Set;

abstract class Seat {
    private String seatNumber;

    Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public abstract double getPrice();
}

class RegularSeat extends Seat {
    RegularSeat(String seatNumber) {
        super(seatNumber);
    }

    @Override
    public double getPrice() {
        return 150;
    }
}

class PremiumSeat extends Seat {
    PremiumSeat(String seatNumber) {
        super(seatNumber);
    }

    @Override
    public double getPrice() {
        return 250;
    }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(String seatNumber) {
        super(seatNumber);
    }

    @Override
    public double getPrice() {
        return 400;
    }
}

class TicketCustomer {
    private String name;

    TicketCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Show {
    private String time;
    private Set<String> bookedSeats = new HashSet<>();
    private boolean started;

    Show(String time) {
        this.time = time;
        this.started = false;
    }

    public boolean isSeatAvailable(String seatNumber) {
        return !bookedSeats.contains(seatNumber);
    }

    public boolean bookSeat(String seatNumber) {
        return bookedSeats.add(seatNumber);
    }

    public void releaseSeat(String seatNumber) {
        bookedSeats.remove(seatNumber);
    }

    public boolean hasStarted() {
        return started;
    }

    public void start() {
        started = true;
    }

    public String getTime() {
        return time;
    }
}

class Booking {
    private TicketCustomer customer;
    private Show show;
    private Seat[] seats;
    private boolean cancelled;

    Booking(
        TicketCustomer customer,
        Show show,
        Seat[] seats
    ) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
        this.cancelled = false;
    }

    public double calculateTotal() {
        double total = 0;

        for (Seat seat : seats) {
            total += seat.getPrice();
        }

        return total;
    }

    public void cancel() {
        if (cancelled) {
            return;
        }

        if (show.hasStarted()) {
            System.out.println(
                "Cannot cancel booking after the show has started."
            );
            return;
        }

        for (Seat seat : seats) {
            show.releaseSeat(seat.getSeatNumber());
        }

        cancelled = true;

        System.out.println(
            customer.getName()
            + "'s booking cancelled."
        );

        System.out.println(
            "Seats released."
        );
    }
}

class TicketBookingSystem {
    public Booking book(
        TicketCustomer customer,
        Show show,
        Seat[] seats
    ) {
        if (seats.length == 0 || seats.length > 6) {
            System.out.println(
                "A booking must contain between 1 and 6 seats."
            );
            return null;
        }

        for (Seat seat : seats) {
            if (!show.isSeatAvailable(seat.getSeatNumber())) {
                System.out.println(
                    "Seat "
                    + seat.getSeatNumber()
                    + " is already booked for this show."
                );
                return null;
            }
        }

        for (Seat seat : seats) {
            show.bookSeat(seat.getSeatNumber());
        }

        Booking booking =
            new Booking(customer, show, seats);

        System.out.println(
            "Booking confirmed for "
            + customer.getName()
            + ": "
            + seatNames(seats)
            + "."
        );

        System.out.printf(
            "Total: %.2f%n",
            booking.calculateTotal()
        );

        return booking;
    }

    private String seatNames(Seat[] seats) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seats.length; i++) {
            if (i > 0) {
                result.append(", ");
            }

            result.append(seats[i].getSeatNumber());
        }

        return result.toString();
    }
}

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {
        TicketBookingSystem system =
            new TicketBookingSystem();

        Show show = new Show("7 PM");

        TicketCustomer asha =
            new TicketCustomer("Asha");

        TicketCustomer ravi =
            new TicketCustomer("Ravi");

        TicketCustomer neha =
            new TicketCustomer("Neha");

        Seat a1 = new RegularSeat("A1");
        Seat a2 = new RegularSeat("A2");
        Seat f5 = new PremiumSeat("F5");
        Seat r1 = new ReclinerSeat("R1");

        Booking ashaBooking =
            system.book(
                asha,
                show,
                new Seat[] {a1, a2, f5}
            );

        system.book(
            ravi,
            show,
            new Seat[] {a2}
        );

        system.book(
            ravi,
            show,
            new Seat[] {r1}
        );

        ashaBooking.cancel();

        system.book(
            neha,
            show,
            new Seat[] {a2}
        );
    }
}