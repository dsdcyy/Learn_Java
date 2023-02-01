public class Test09 {
    public static void main(String[] args) {
        LabeledPoint hello = new LabeledPoint("Hello", 8.7, 6.9);
        System.out.println(hello);
    }
}

class Point {
    double x = 0.0, y = 0.0;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class LabeledPoint extends Point {
    String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "label='" + label + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}