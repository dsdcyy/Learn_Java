import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author ljw
 * @version 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入一个整数: ");
            try {
                int num = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的数不是整数...");
            }
        }
    }
}
