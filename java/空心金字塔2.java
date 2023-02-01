public class 空心金字塔2 {
    public static void main(String[] args) {
        int hs = 10;
        for (int i = 1; i <= hs; i++) {

            for (int k = 1; k <= hs - i; k++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || i == hs  || j == 2 * i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");

                }
            }
            System.out.println();

        }
    }
}
