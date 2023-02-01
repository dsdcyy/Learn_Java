import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 * 中文乱码
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/4.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s = "";
        while ((s = bufferedReader.readLine()) != null){
            System.out.println(s);
        }
        bufferedReader.close();
    }
}
