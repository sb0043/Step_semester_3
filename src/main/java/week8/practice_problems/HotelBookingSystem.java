package week8.practice_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Room {
    private String roomNumber;

    Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public abstract double calculatePrice(long nights);
}

class StandardRoom extends Room {
    StandardRoom(String roomNumber) {
        super(roomNumber);
    }

    @Override
    public double calculatePrice(long nights) {
        return nights * 100.0;
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(String roomNumber) {
        super(roomNumber);
    }

    @Override
    public double calculatePrice(long nights) {
        return nights * 150.0;
    }
}

class Suite extends Room {
    Suite(String roomNumber) {
        super(roomNumber);
    }

    @Override
    public double calculatePrice(long nights) {
        return nights * 250.0;
    }
}

class HotelCustomer {
    private String name;

    HotelCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Reservation {
    private HotelCustomer customer;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

    Reservation(
        HotelCustomer customer,
        Room room,
        LocalDate startDate,
        LocalDate endDate
    ) {
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = true;
    }

    public boolean overlaps(LocalDate start, LocalDate end) {
        return active && start.isBefore(endDate) && end.isAfter(startDate);
    }

    public double calculatePrice() {
        long nights = startDate.until(endDate).getDays();
        return room.calculatePrice(nights);
    }

    public void cancel() {
        active = false;
    }

    public Room getRoom() {
        return room;
    }

    public HotelCustomer getCustomer() {
        return customer;
    }
}

class HotelBookingManager {
    private List<Reservation> reservations = new ArrayList<>();

    public boolean isAvailable(
        Room room,
        LocalDate start,
        LocalDate end
    ) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoom() == room &&
                reservation.overlaps(start, end)) {
                return false;
            }
        }

        return true;
    }

    public Reservation reserve(
        HotelCustomer customer,
        Room room,
        LocalDate start,
        LocalDate end
    ) {
        if (!isAvailable(room, start, end)) {
            System.out.println(
                room.getClass().getSimpleName()
                + " "
                + room.getRoomNumber()
                + " is not available from "
                + start
                + " to "
                + end
                + "."
            );
            return null;
        }

        Reservation reservation =
            new Reservation(customer, room, start, end);

        reservations.add(reservation);

        System.out.println(
            "Reservation confirmed for "
            + customer.getName()
            + ", "
            + room.getClass().getSimpleName()
            + " "
            + room.getRoomNumber()
            + " ("
            + start
            + " to "
            + end
            + ")."
        );

        System.out.printf(
            "Price: $%.2f%n",
            reservation.calculatePrice()
        );

        return reservation;
    }

    public void cancel(Reservation reservation) {
        if (reservation != null) {
            reservation.cancel();

            System.out.println(
                "Reservation for "
                + reservation.getCustomer().getName()
                + ", "
                + reservation.getRoom().getRoomNumber()
                + " cancelled successfully."
            );
        }
    }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        HotelBookingManager manager = new HotelBookingManager();

        HotelCustomer customerA = new HotelCustomer("Customer A");
        HotelCustomer customerB = new HotelCustomer("Customer B");
        HotelCustomer customerC = new HotelCustomer("Customer C");

        Room standard101 = new StandardRoom("101");
        Room deluxe201 = new DeluxeRoom("201");

        LocalDate jan1 = LocalDate.of(2026, 1, 1);
        LocalDate jan5 = LocalDate.of(2026, 1, 5);
        LocalDate jan3 = LocalDate.of(2026, 1, 3);
        LocalDate jan7 = LocalDate.of(2026, 1, 7);

        if (manager.isAvailable(standard101, jan1, jan5)) {
            System.out.println(
                "Standard Room 101 is available from Jan 1 to Jan 5."
            );
        }

        Reservation reservation =
            manager.reserve(customerA, standard101, jan1, jan5);

        manager.reserve(customerB, standard101, jan3, jan7);

        manager.cancel(reservation);

        manager.reserve(
            customerC,
            deluxe201,
            LocalDate.of(2026, 2, 10),
            LocalDate.of(2026, 2, 12)
        );
    }
}