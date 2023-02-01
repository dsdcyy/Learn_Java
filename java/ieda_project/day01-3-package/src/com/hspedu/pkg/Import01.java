package com.hspedu.pkg; // 声明类所在的包，需要放在类的最上面，一个类最多只有一句package

import java.util.Arrays;

public class Import01 {
    public static void main(String[] args) {
        int[] arr = {4, 1, 4, 3, 5, 67, 3, 23, 42, 24, 2, 2426, 4, 8};
        // Arrays.sort 使用系统提供的类对数组进行排序
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " " );
        }
    }
}
