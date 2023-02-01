public class 空心金字塔 {
    public static void main(String[] args) {
        int hs = 10;
        for (int i = 0; i < hs; i++) {
            if (i == 0 || i == hs-1) {
                for (int k = 1; k < hs - i; k++) {
                    System.out.print(" ");

                }
                for (int j = 0; j <= 2 * i; j++) {
                    System.out.print("*");
                }
                for (int k = 1; k < hs - i; k++) {
                    System.out.print(" ");

                }

            } else {
                for (int k = 1; k < hs - i; k++) {
                    System.out.print(" ");

                }
                System.out.print("*");
                for (int k = 1; k < 2 * i; k++) {
                    System.out.print(" ");

                }
                System.out.print("*");

                for (int k = 1; k < hs - i; k++) {
                    System.out.print(" ");

                }
            }
            System.out.println();

        }
    }
}
