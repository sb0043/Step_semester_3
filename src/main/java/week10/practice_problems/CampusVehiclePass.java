package week10.practice_problems;

import java.util.Scanner;

interface Chargeable {
    void charge();
}

abstract class Vehicle {
    String passNumber;
    String ownerName;
    int fee;
    String type;

    Vehicle(String passNumber, String ownerName, int fee, String type) {
        this.passNumber = passNumber;
        this.ownerName = ownerName;
        this.fee = fee;
        this.type = type;
    }

    void displayPass() {
        System.out.println(passNumber + " (" + type + ") pass fee " + fee);
    }
}

class Bike extends Vehicle {
    Bike(String passNumber, String ownerName) {
        super(passNumber, ownerName, 300, "Bike");
    }
}

class Car extends Vehicle {
    Car(String passNumber, String ownerName) {
        super(passNumber, ownerName, 1000, "Car");
    }
}

class EBike extends Vehicle implements Chargeable {
    EBike(String passNumber, String ownerName) {
        super(passNumber, ownerName, 300, "EBike");
    }

    @Override
    public void charge() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

class ECar extends Vehicle implements Chargeable {
    ECar(String passNumber, String ownerName) {
        super(passNumber, ownerName, 1000, "ECar");
    }

    @Override
    public void charge() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class CampusVehiclePass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[100];
        int count = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equalsIgnoreCase("PASS") && parts.length == 4) {
                String type = parts[1];
                String passNumber = parts[2];
                String ownerName = parts[3];

                Vehicle vehicle = null;

                switch (type.toLowerCase()) {
                    case "bike":
                        vehicle = new Bike(passNumber, ownerName);
                        break;
                    case "car":
                        vehicle = new Car(passNumber, ownerName);
                        break;
                    case "ebike":
                        vehicle = new EBike(passNumber, ownerName);
                        break;
                    case "ecar":
                        vehicle = new ECar(passNumber, ownerName);
                        break;
                    default:
                        System.out.println("Invalid vehicle type");
                }

                if (vehicle != null && count < vehicles.length) {
                    vehicles[count++] = vehicle;
                    vehicle.displayPass();
                }
            } else if (parts[0].equalsIgnoreCase("CHARGE")
                    && parts.length == 2) {
                String passNumber = parts[1];
                Vehicle found = null;

                for (int i = 0; i < count; i++) {
                    if (vehicles[i].passNumber.equals(passNumber)) {
                        found = vehicles[i];
                        break;
                    }
                }

                if (found == null) {
                    System.out.println("Pass not found");
                } else if (found instanceof Chargeable) {
                    ((Chargeable) found).charge();
                } else {
                    System.out.println(found.passNumber
                            + " rejected: charging unsupported");
                }
            }
        }

        sc.close();
    }
}