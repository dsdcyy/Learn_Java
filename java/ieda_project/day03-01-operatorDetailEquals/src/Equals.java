public class Equals {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        System.out.println(a == c);// 引用类型判断，是否为一个对象
        System.out.println(a == b);
        B d = a;
        System.out.println(d == a);
        int num1 = 10;
        double num2 = 10.0;
        System.out.println(num1 == num2); // 基本类型判断，判断值是否相等

    }
}

class A extends B {

}

class B {
}