package week7.practice_problems;

abstract class Toy {
    private static int counter = 1000;
    private final String toyId;

    public Toy() {
        counter++;
        toyId = "TOY-" + counter;
    }

    public String getToyId() {
        return toyId;
    }

    public abstract String makeSound();
}

class ToyCar extends Toy {
    private final String name;

    public ToyCar(String name) {
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {
    private final String name;

    public ToyRobot(String name) {
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Beep boop!";
    }
}

public class ToyBox {

    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        ToyRobot r = new ToyRobot("Bolt");

        System.out.println(c.makeSound());
        System.out.println(r.makeSound());
        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}