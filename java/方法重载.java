public class 方法重载 {
    public static void main(String[] args) {
        // 基本介绍
        /*
         * java允许在同一个类中，多个同名方法的存在，但要求形参列表不一致
         * 比如System.out.println();out是PrintStream类型
         */
        // 重载的好处
        /*
         * 1.减轻了起名的麻烦
         * 2.减轻了记名的麻烦
         */
        // 注意事项和使用细节
        /*
         * 1.方法名必须相同
         * 2.参数名必须不同(参数类型或个数或顺序)
         * 3.返回类型：无要求
         */
        MyCalculator mycalculator = new MyCalculator();
        System.out.println(mycalculator.calculate(2,3));
        System.out.println(mycalculator.calculate(1.1,2));
        System.out.println(mycalculator.calculate(1,2.2));
        System.out.println(mycalculator.calculate(3,4,5));
    }
}

class MyCalculator {
    // 定义多个相同方法名称但形参列表个数或数据类型不一致
    public int calculate(int n1, int n2) {
        return n1 + n2;
    }

    public double calculate(int n1, double n2) {
        return n1 + n2;
    }

    public double calculate(double n1, int n2) {
        return n1 + n2;
    }

    public int calculate(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
}