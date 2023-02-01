import java.util.Scanner;

public class 多重循环控制 {
    public static void main(String[] args) {

        int sum1 = 0, sum2 = 0, sum3 = 0, jgrs1 = 0, jgrs2 = 0, jgrs3 = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 4; i++) {
            System.out.println(i + "班");
            for (int j = 1; j <= 5; j++) {
                System.out.println("请输入同学" + j + "成绩：");
                double score = scanner.nextDouble();
                switch (i) {
                    case 1:
                        sum1 += score;
                        if (score >= 60) {
                            jgrs1++;
                        }
                        break;
                    case 2:
                        sum2 += score;
                        if (score >= 60) {
                            jgrs2++;
                        }
                        break;
                    case 3:
                        sum3 += score;
                        if (score >= 60) {
                            jgrs3++;
                        }
                }
            }
        }
        System.out.println(1 + "班平均成绩为：" + sum1 / 5.0 + "\t" + "总分:" + sum1 + "\t" + "及格人数:" + jgrs1);
        System.out.println(2 + "班平均成绩为：" + sum2 / 5.0 + "\t" + "总分:" + sum2 + "\t" + "及格人数:" + jgrs2);
        System.out.println(3 + "班平均成绩为：" + sum3 / 5.0 + "\t" + "总分:" + sum3 + "\t" + "及格人数:" + jgrs3);
        System.out.println("总及格人数为:"+(jgrs1+jgrs2+jgrs3));

    }
}
