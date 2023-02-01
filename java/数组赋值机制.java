/*
 * jvm内存
 * 栈
 * 基本数据类型 直接赋值
 * 数组指向一个内存地址，它指向堆里面对应的数据空间
 * 堆
 * 数组空间，空间里面有每个数组元素的值
 * 方法区
 */



public class 数组赋值机制 {
    public static void main(String[] args) {
        // 基本数据类型赋值，复制方式为值拷贝
        int n1 = 10;
        int n2 = n1;
        n2 = 80;
        System.out.println("n1=" + n1);
        System.out.println("n2=" + n2);
        // 数组在默认情况下是引用传递，赋的是地址，赋值方式为引用复制
        int[] arr1 = {1,2,3,4};
        int[] arr2 = arr1;
        // 是一个地址，所以更改arr2会影响到arr1
        arr2[0] = 10;
        System.out.println(arr1);
        System.out.println(arr2);

    }
}
