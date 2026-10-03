package week7.assignment_problems;

abstract class ClassroomDevice {
    public abstract String operate();
}

interface Chargeable {
    String charge();

    String charge(int minutes);
}

class Tablet extends ClassroomDevice implements Chargeable {
    private String assetTag;

    Tablet(String assetTag) {
        this.assetTag = assetTag;
    }

    @Override
    public String operate() {
        return "Tablet " + assetTag + " is ready for classroom use";
    }

    @Override
    public String charge() {
        return "Tablet " + assetTag + " is charging";
    }

    @Override
    public String charge(int minutes) {
        return "Tablet " + assetTag + " charged for " + minutes + " minutes";
    }
}

public class DigitalClassroomSetup {

    public static void main(String[] args) {
        Tablet tablet = new Tablet("TAB-101");

        System.out.println(tablet.operate());
        System.out.println(tablet.charge());
        System.out.println(tablet.charge(30));
    }
}