public class FinalTest01 {
    public static void main(String[] args) {
        System.out.println(new Circle(20).getArea());
    }
}

class Circle {
    private static final double PI = 3.14;
    private final double redis;

    public Circle(double redis) {
        this.redis = redis;
    }


    public double getArea() {
        return PI * (redis * redis);
    }
}