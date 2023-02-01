public class test03 {
    public static void main(String[] args) {
        // 输出1-100之间不能被5整除的数。，每行5个
        for (int i = 1, j = 0; i < 101; i++) {
            if (i % 5 != 0) {
                if (j % 5 == 0) {
                    System.out.println();

                }
                System.out.print(i + "\t");
                j++;
            }
        }
    }
}
