/*
    好处
 * 1.成员方法可以多次调用，提高代码复用性。
 * 2.可以将实现方法的细节封装起来，供其它用户来调用即可
 * 细节
 * 1.形参列表，表示成员方法输入get_sum(int n,int m)
 * 2.返回数据类型 表示成员方法输出，viod表示没有返回值
 * 3.方法主体 表示为了实现某一功能的代码快
 * 4.return语句不是必须的
 * 5.一个方法最多可以返回一个值(可以返回数组)
 * 6.返回类型可以为任何类型
 * 7.如果方法要求有返回值，则执行语句必须为return，且return的返回值必须与要求的返回值数据类型一致或兼容
 * 8.如果方法void，则方法中可以没有return语句，或只写return;
 * 9.遵循驼峰命名法，知名见义
 * 方法调用
 * 1.同一个类中的方法调用：方法名()即可
 * 2.不同类中的调用：对象.方法名()
 */

public class 面向对象_成员方法 {
    public static void main(String[] args) {
        // 调用方法
        // 实例化类对象
        Person p1 = new Person();
        p1.age = 20;
        p1.name = "John";
        // p1.gender = "male";
        // 对象.方法名()调用
        p1.speak();
        p1.cal01();
        p1.cal02(20);
        p1.cal02(40);
        // 打印计算返回值
        System.out.println(p1.get_sum(4, 8));
        // 将返回值值赋给一个变量
        int res = p1.get_sum(10, 20);
        // 打印这个变量
        System.out.println(res);
        int[][] arr = { { 1, 2, 3, 4, 5 }, { 1, 2, 3, 5, 4 } };
        for_arr(arr, "\t");

    }

    public static void for_arr(int[][] map, String split) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + split);
            }
            System.out.println();
        }
    }
}

class Person {
    String name;
    int age;

    // String gender;
    /*
     * public 表示方法是公开
     * void 表示此方法没有返回值,int表示返回int类型的值
     * speak() 表示方法名,()形参列表
     * {} 方法体 写我们需要执行的代码
     */
    // 输出一句话的方法
    public void speak() {
        System.out.println("我是一个好人！");
    }

    // 计算1-1000和的方法
    public void cal01() {
        int sum = 0;
        for (int i = 1; i < 1001; i++) {
            sum += i;
        }
        System.out.println("1-1000和为:" + sum);
    }

    // 带参数n,的计算1-n的方法
    public void cal02(int n) {
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += i;
        }
        System.out.println("1-" + n + "的和为:" + sum);
    }

    // 计算多个参数的和的方法
    public int get_sum(int n, int m) {
        int res = n + m;
        return res;
    }
    
}