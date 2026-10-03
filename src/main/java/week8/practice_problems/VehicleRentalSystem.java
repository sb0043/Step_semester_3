package week8.practice_problems;

import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String name;
    private boolean available = true;

    Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    protected void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateCharge(int days);
}

class Sedan extends Vehicle {
    Sedan(String name) {
        super(name);
    }

    @Override
    public double calculateCharge(int days) {
        return days * 50.0;
    }
}

class SUV extends Vehicle {
    SUV(String name) {
        super(name);
    }

    @Override
    public double calculateCharge(int days) {
        return days * 80.0;
    }
}

class Truck extends Vehicle {
    Truck(String name) {
        super(name);
    }

    @Override
    public double calculateCharge(int days) {
        return days * 100.0;
    }
}

class Customer {
    private String name;

    Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private int days;
    private boolean active;

    Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.active = true;
    }

    public double calculateCharge() {
        return vehicle.calculateCharge(days);
    }

    public void complete() {
        if (active) {
            active = false;
            vehicle.setAvailable(true);
        }
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }
}

class RentalSystem {
    private List<Rental> rentals = new ArrayList<>();

    public Rental rentVehicle(Customer customer, Vehicle vehicle, int days) {
        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getName() + " is currently unavailable.");
            return null;
        }

        if (days <= 0) {
            System.out.println("Rental duration must be positive.");
            return null;
        }

        vehicle.setAvailable(false);

        Rental rental = new Rental(vehicle, customer, days);
        rentals.add(rental);

        System.out.println(
            vehicle.getName() + " rented successfully by " + customer.getName() + "."
        );
        System.out.printf("Rental charge: $%.2f%n", rental.calculateCharge());

        return rental;
    }

    public void returnVehicle(Rental rental) {
        if (rental != null) {
            rental.complete();

            System.out.println(
                rental.getVehicle().getName()
                + " returned by "
                + rental.getCustomer().getName()
                + "."
            );
        }
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();

        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");
        Customer customer3 = new Customer("Customer 3");

        Vehicle sedanA = new Sedan("Sedan A");
        Vehicle suvB = new SUV("SUV B");

        Rental rental1 = system.rentVehicle(customer1, sedanA, 3);

        system.rentVehicle(customer2, sedanA, 2);

        system.returnVehicle(rental1);

        system.rentVehicle(customer3, suvB, 5);
    }
}