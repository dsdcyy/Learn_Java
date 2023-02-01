public class 循环控制_continue {
    public static void main(String[] args) {
        // continue 语句用于结束本次循环，急需执行下一次循环.
        // 在多层循环中可以通过标签指明需要跳过的是哪层循环。
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                continue;
            } 
            System.out.println("i=" + i);
            
        }
    }
}
