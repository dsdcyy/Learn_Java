/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork07 {
    public static void main(String[] args) {
        Car car = new Car(43);
        car.useFlow();
        car.setTemp(-1);
        car.useFlow();
        car.setTemp(3);
        car.useFlow();

    }
}

class Car {
    private double temp;

    class Air {
        public void flow() {
            if (temp > 40) {
                System.out.println("吹冷气...");
            } else if (temp < 0) {
                System.out.println("吹暖气...");
            } else {
                System.out.println("关闭空调...");
            }
        }
    }
    public void useFlow() {
        new Air().flow();
    }

    public Car(double temp) {
        setTemp(temp);
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}