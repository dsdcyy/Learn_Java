import java.util.Scanner;

/**
 * @author ljw
 * @version 1.0
 */
public class test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入商品名称: ");
        String name = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(name);
        System.out.print("\n请输入商品价格: ");
        String price = scanner.next();
        StringBuffer stringBuffer2 = new StringBuffer(price);
        int end = stringBuffer2.lastIndexOf(".");
        System.out.println();
        if (end != -1) {
            for (int i = end -3 ; i > 0; i -= 3) {
                stringBuffer2 = stringBuffer2.insert(i, ",");
            }
        } else {
            for (int i = stringBuffer2.length() -3 ; i > 0; i -= 3) {
                stringBuffer2 = stringBuffer2.insert(i, ",");
            }
        }
        System.out.println("商品名称 " + "\t商品价格");
        System.out.println(stringBuffer + "\t" + stringBuffer2);
    }
}
