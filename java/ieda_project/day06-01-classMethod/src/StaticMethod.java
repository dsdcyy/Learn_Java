public class StaticMethod {
    public static void main(String[] args) {
        Stu tom = new Stu("tom");
//        tom.payFee(100);
        Stu.payFee(100);
        Stu marry = new Stu("marry");
//        marry.payFee(200);
        Stu.payFee(200);
        Stu.showFee();
    }
}
class Stu{
    private String name;
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }
    public static void payFee(double fee) {
        Stu.fee += fee;
    }
    public static void showFee() {
        System.out.println("当前所交的学费共有"+Stu.fee+"元");
    }
}