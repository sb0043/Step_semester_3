package week7.assignment_problems;

interface Ringable {
    String ring();
}

class AlarmClock implements Ringable {
    private String time;

    AlarmClock(String time) {
        this.time = time;
    }

    @Override
    public String ring() {
        return "Alarm ringing at " + time;
    }
}

class Doorbell implements Ringable {
    private String location;

    Doorbell(String location) {
        this.location = location;
    }

    @Override
    public String ring() {
        return "Doorbell ringing at " + location;
    }
}

public class MorningWakeUpCircuit {

    public static void ringAll(Ringable[] devices) {
        for (Ringable device : devices) {
            System.out.println(device.ring());
        }
    }

    public static void main(String[] args) {
        Ringable[] devices = {
            new AlarmClock("6:30 AM"),
            new Doorbell("Front Door")
        };

        ringAll(devices);
    }
}