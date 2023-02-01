public class Hello {
    // java Hello 参数1 参数2 ...
    // 可以在运行的编辑配置中的实参填入自己的参数
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数是:" + args[i]);
        }
    }
}
