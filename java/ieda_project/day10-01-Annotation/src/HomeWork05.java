/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork05 {
    public static void main(String[] args) {
        A05 a05 = new A05();
        a05.test();


    }
}

class A05 {
    private String name = "2";

    public void test() {
        class B05 {
            private String name = "1";

            public void show() {
                System.out.println("内部类的name " + name + " 外部类的name " + A05.this.name);
            }
        }
        B05 b05 = new B05();
        b05.show();
    }

    ;
}