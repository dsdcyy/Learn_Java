/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork06 {
    public static void main(String[] args) {
        Person person = new Person("唐僧", new Horse());
        person.common();
        person.passRiver();
        person.fly();

    }
}

interface Vehicls {
    void work();
}

class Horse implements Vehicls {

    @java.lang.Override
    public void work() {
        System.out.println("一般情况下使用马");
    }
}

class Boat implements Vehicls {

    @java.lang.Override
    public void work() {
        System.out.println("过河的时候使用船");
    }
}

class AirPlane implements Vehicls{

    @java.lang.Override
    public void work() {
        System.out.println("过火焰山时使用飞机");
    }
}

class Transportation {

    private static Horse horse;

    public static Horse getHorse() {
        if (horse == null) {
            horse = new Horse();
        }
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }

    public static AirPlane getAirPlane() {
        return new AirPlane();
    }
}

class Person {
    private String name;
    private Vehicls vehicls;

    public Person(String name, Vehicls vehicls) {
        this.name = name;
        this.vehicls = vehicls;
    }

    public void passRiver() {
        if (!(vehicls instanceof Boat)) {
            vehicls = Transportation.getBoat();
        }
        vehicls.work();
    }

    public void common() {
        if (!(vehicls instanceof Horse)) {
            vehicls = Transportation.getHorse();
        }
        vehicls.work();

    }

    public void fly() {
        if (!(vehicls instanceof AirPlane)){
            vehicls = Transportation.getAirPlane();
        }
        vehicls.work();
    }
}