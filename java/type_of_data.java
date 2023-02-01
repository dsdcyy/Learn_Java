/**
 * @author ljw
 * @version 1.0
 */

public class type_of_data {
    public static void main(String[] args){
        //1.整数类型
        // 整型 占4字节
        int a = 20;
        //长整形,需要在值后加上"l"或"L" 占8字节
        long b = 100L;
        // byte 字节 占1字节
        byte c = 0;
        short d = 30;
        // System.out.println(a,b,c,d);
        // 浮点类型
        // 浮点位=符号位+指数位+尾数位
        double e = 20.7;
        // float ,需要在值后面加上'f'或'F'
        float f = 1.23f;
        // 十进制形式：如：5.12 512.0f .521(0.512)
        float g = .52f;
        // 科学计数法 5.12e2[5.12*10^2] 5.12E-2[5.12/10^2]
        System.out.println(5.12e2);
        System.out.println(5.12E-2);
        double num1 = 2.7;
        double num2 = 8.1/3;
        System.out.println(num1);
        System.out.println(num2);
        // Math.abs 绝对值
        if(Math.abs(num1-num2)<1E-6){
            System.out.println("相等！");
        }
        else{
            System.out.println("不相等！");
        }
        // 2 字符类型 占2字节
        char c1 = 'a';
        System.out.println(c1);
        char c3 = '李';
        // 输出字符所代表的uncoded编码
        System.out.println((int)c3);
        // 字符类型可以直接存放数字
        char c4 = 97;    
        System.out.println(c4);
        char c5 = 'b' +1;
        System.out.println((int)c5);
        System.out.println(c5);

    }
}
