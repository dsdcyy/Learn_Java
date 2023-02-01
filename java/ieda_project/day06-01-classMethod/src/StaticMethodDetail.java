public class StaticMethodDetail {
}
class B{
    private int num = 0;
    private static int sum = 0;

    public static void test01() {
        System.out.println(sum);
//        test02();
    }
    public void test02() {
        System.out.println(num+sum);
        test01();
    }
}