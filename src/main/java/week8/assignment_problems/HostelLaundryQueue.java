package week8.assignment_problems;

abstract class WashType {
    public abstract int getDuration();
    public abstract double getCharge();
}

class QuickWash extends WashType {
    @Override
    public int getDuration() {
        return 30;
    }

    @Override
    public double getCharge() {
        return 20;
    }
}

class NormalWash extends WashType {
    @Override
    public int getDuration() {
        return 45;
    }

    @Override
    public double getCharge() {
        return 30;
    }
}

class HeavyWash extends WashType {
    @Override
    public int getDuration() {
        return 60;
    }

    @Override
    public double getCharge() {
        return 45;
    }
}

class LaundryStudent {
    private String name;

    LaundryStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class WashingMachine {
    private String machineId;
    private boolean busy;

    WashingMachine(String machineId) {
        this.machineId = machineId;
        this.busy = false;
    }

    public String getMachineId() {
        return machineId;
    }

    public boolean isBusy() {
        return busy;
    }

    private void setBusy(boolean busy) {
        this.busy = busy;
    }

    public WashCycle startWash(
        LaundryStudent student,
        WashType washType
    ) {
        if (busy) {
            System.out.println(
                "Machine " + machineId + " is currently busy."
            );
            return null;
        }

        setBusy(true);

        WashCycle cycle =
            new WashCycle(student, this, washType);

        System.out.println(
            washType.getClass().getSimpleName()
            + " started on "
            + machineId
            + " for "
            + student.getName()
            + " ("
            + washType.getDuration()
            + " min)."
        );

        System.out.printf(
            "Charge: %.2f%n",
            washType.getCharge()
        );

        return cycle;
    }

    void completeCycle() {
        setBusy(false);
    }
}

class WashCycle {
    private LaundryStudent student;
    private WashingMachine machine;
    private WashType washType;

    WashCycle(
        LaundryStudent student,
        WashingMachine machine,
        WashType washType
    ) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }

    public void complete() {
        machine.completeCycle();

        System.out.println(
            machine.getMachineId()
            + " cycle completed."
        );

        System.out.println(
            machine.getMachineId()
            + " is now free."
        );
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {
        LaundryStudent asha = new LaundryStudent("Asha");
        LaundryStudent ravi = new LaundryStudent("Ravi");
        LaundryStudent neha = new LaundryStudent("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        m1.startWash(asha, new QuickWash());

        m1.startWash(ravi, new HeavyWash());

        m2.startWash(ravi, new HeavyWash());

        WashCycle cycle = m1.startWash(neha, new NormalWash());

        // The above attempt is rejected because M1 is busy.
        // Complete the original cycle before starting Neha's wash.
        // For demonstration, create the original cycle separately.
        m1.completeCycle();

        System.out.println("M1 cycle completed.");
        System.out.println("M1 is now free.");

        m1.startWash(neha, new NormalWash());
    }
}