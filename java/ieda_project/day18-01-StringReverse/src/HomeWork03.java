import java.util.Locale;

/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork03 {
    public static void main(String[] args) {
        //（1）编写java程序，输入形式为：Han shun Ping的人名，以Ping,Han.S的形式打印
        //出来。其中.S是中间单词的首字母。
        //（2)例如输入“Willian Jefferson Clinton
        //输出形式为：Clinton，Willian.J
        try {
            System.out.println(printName("Li ji Wei"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static String printName(String name) {
        if (!(name != null && name.contains(" "))) {
            throw new RuntimeException("Invalid name: " + name);
        }
        String[] names = name.split(" ");
        if (names.length != 3){
            throw new RuntimeException("Invalid name: " + name);
        }
        return String.format("%s,%s .%c",names[2],names[0],names[1].toUpperCase(Locale.ROOT).charAt(0));

    }
}
