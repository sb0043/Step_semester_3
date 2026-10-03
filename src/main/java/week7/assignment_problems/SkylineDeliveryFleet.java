package week7.assignment_problems;

abstract class Drone {
    public abstract String fly();
}

interface Trackable {
    String getLocation();
}

class DeliveryDrone extends Drone implements Trackable {
    private String location;

    DeliveryDrone(String location) {
        this.location = location;
    }

    @Override
    public String fly() {
        return "Delivery drone flying to delivery zone";
    }

    @Override
    public String getLocation() {
        return location;
    }
}

class ScoutDrone extends Drone {
    @Override
    public String fly() {
        return "Scout drone flying over the area";
    }
}

class GroundRobot implements Trackable {
    private String location;

    GroundRobot(String location) {
        this.location = location;
    }

    @Override
    public String getLocation() {
        return location;
    }
}

class FleetManager {

    public static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            Trackable trackable = (Trackable) o;
            return trackable.getLocation();
        }

        return "Tracking not available";
    }
}

public class SkylineDeliveryFleet {

    public static void main(String[] args) {
        DeliveryDrone deliveryDrone = new DeliveryDrone("Warehouse A");
        ScoutDrone scoutDrone = new ScoutDrone();
        GroundRobot groundRobot = new GroundRobot("Loading Dock");

        System.out.println(deliveryDrone.fly());
        System.out.println(scoutDrone.fly());
        System.out.println(FleetManager.getLocationIfTrackable(deliveryDrone));
        System.out.println(FleetManager.getLocationIfTrackable(groundRobot));
        System.out.println(FleetManager.getLocationIfTrackable(scoutDrone));
    }
}