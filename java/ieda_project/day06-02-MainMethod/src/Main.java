public class Main {
    public static void main(String[] args) {
        // 深入理解面方法的形式
        /*
        * 解释main方法的形式：public static void main(String[] args){}
        * 1.java虚拟机需要调用类的main方法，所以该方法的访问权限必须是public
        * 2.java虚拟机在执行main方法时不必创建对象，所以方法必须是static
        * 3.该方法接收String类型的数组参数，该数组保存执行java命令时所传递给所运行类的参数
        * 4.java执行的程序 参数1 参数2 参数3 示例 Hello.java
        * */

        // 特别提示
        /*
        * 1.在main()方法中，我没问你可以直接调用main方法所在类的静态方法或静态属性
        * 2.但是不能直接调用该类的非静态成员，必须创建一额该类的一个示例对象才能通过这个对象去访问类中的非静态成员
        * */
        System.out.println("Hello world!");
    }
}