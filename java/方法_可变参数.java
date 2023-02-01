public class 方法_可变参数 {
    public static void main(String[] args){
        // 基本概念：java允许将同一个类中多个同名同功能但参数个数不同的方法，封装成一个方法。
        // 基本语法：访问修饰符 返回类型 方法名(数据类型...形参名)
        // 注意事项和细节
        /*
         * 1.可变参数的实参可以为0个或任意多个
         * 可变参数的实参可以为数组
         * 可变参数的本质就是数组
         * 4.可变参数可以和普通类型的参数一起放在形参列表，但必须保证可变参数在最后
         * 5.一个形参列表中只能出现一个可变参数
         */
        int[] arr = {1,2,3,4,5};
        HspMethod hspmethod = new HspMethod();
        System.out.println(hspmethod.sum(1,2,3,4));
        System.out.println(hspmethod.sum(1,2));
        // 可以直接传入数组
        System.out.println(hspmethod.sum(arr));
        hspmethod.stu_score("张三",10,20,30);
    }
}
class HspMethod{
    // ...args可变长参数，可以看做是一个数组
    public int sum(int ...args){
        int sum = 0;
        for(int i=0; i<args.length; i++){
            sum+=args[i];
        }
        return sum;
    }
    public void stu_score(String name,double ...args){
            int sum = 0;
            for(int i=0; i<args.length; i++){
                sum+=args[i];
            }
            System.out.println(name+args.length+"门课总分为:"+sum);
    }
}