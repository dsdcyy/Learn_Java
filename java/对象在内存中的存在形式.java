public class 对象在内存中的存在形式 {
    public static void main(String[] args){
        /*
         * 栈
         * 变量（Cat）-> 内存地址 ->指向堆里的数据空间
         * 堆
         * 数据空间 -> 包含多个内存地址 ->指向方法区的数据空间|基本数据类型
         * 方法区
         * 常量池 >内存地址 ->小白
         * 创建类对象时会把类的信息加载到方法区
         */
        
    }
}
class Cat{
    // 属性
    String name;
    int age;
    String color;
}