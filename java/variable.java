public class variable {
    public static void main(String[] args){
        // 声明变量
        int a = 20;
        System.out.println(a);
        int b = 40;
        System.out.println(b);
        // 把30赋给b
        b = 30;
        System.out.println(b);
        // int占用4字节
        int age = 20;
        // double占用8字节
        double score = 88.5;
        char gender = '男';
        String name = "ljw";
        // 数值类型和字符串类型相加为拼接字符串
        System.out.println(gender + "123");
        System.out.println(score + "123");
        // 数值类型相加为计算
        System.out.println(a + b + "123" + name + age);
        /*
            注意事项和细节
            多种数据类型混合运算时，系统首先自动将所有数据类型转换为容量最大的那种数据类型，再计算。
            容量大的数据类型赋值给容量小的会报错（精度丢失），小赋值给大的可以（自动类型转换）。
            （byte，short）和char之间不会相互自动转换。
            byte，short，char之间可以计算，计算时首先转换为int。
            boolean不参与转换。
            表达式结果中的类型自动提升为操作数最大的类型。
            （byte，short）和char之间不会相互自动转换

         */
        // 强制转换类型
        int num = (int)1.1;
        System.out.println(num);
        /*
            大变小才是
            强转符号只对最近的操作数有效
            char可以保存int范围内的数字，但不能保存int类型的变量。
            byte和short运算时当作int处理
         */

    }
}
