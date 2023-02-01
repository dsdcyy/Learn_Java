/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Computer() {
            @java.lang.Override
            public double work(double x, double y) {
                return x + y;
            }
        },10,8);

    }
}

interface Computer {
    double work(double x, double y);

}

class Cellphone {
    public void testWork(Computer computer,double x,double y){
        double res = computer.work(x,y);
        System.out.println("结果: " + res);
    }
}