public class Main01 {
    private static String name = "张三";
    private double salary = 1000;
    public static void main(String[] args) {
        System.out.println(name);
//        System.out.println(salary);// 无法访问
        new Main01().test02();
        System.out.println(new Main01().salary); //通过对象调用
        test01();
//        test02(); // 无法调用
    }
    public static void test01() {
        System.out.println("test01...");
    }
    public void test02() {
        System.out.println("test02...");

    }
}
