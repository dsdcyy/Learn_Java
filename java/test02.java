public class test02 {
    public static void main(String[] args) {
        int s = 153;
        int bai = s / 100;
        int shi = (s - bai * 100) / 10; // s % 100 / 10
        int ge = s - bai * 100 - shi * 10;// s % 10;
        if (Math.pow(bai, 3) + Math.pow(shi, 3) + Math.pow(ge, 3) == s) {
            System.out.println(s + "是水仙花数");
        } else {
            System.out.println(s + "不是水仙花数");

        }
    }
}
