public class 九九乘法表 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            String s = "";
            for (int j = 1; j < i + 1; j++) {
                s += j + "*" + i + "=" + i * j + "\t";
            }
            System.out.println(s);
        }
    }
}
