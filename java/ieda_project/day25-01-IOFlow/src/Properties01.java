import java.io.*;
import java.util.Properties;

/**
 * @author ljw
 * @version 1.0
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        // 1. 传统方法
        // 读取mysql.properties文件，得到ip,user,pwd
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/mysql.properties";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//        String data = "";
//        while ((data = bufferedReader.readLine()) != null){
//            // 传统方法通过=进行切割，获得等号右边
//            System.out.println(data.split("=")[1]);
//        }
//        bufferedReader.close();
        // 2.通过Properties类进行读取
        // 创建Properties对象
        Properties properties = new Properties();
        // 加载配置文件
        properties.load(new FileReader(file));
        // 显示key-value到屏幕
        properties.list(System.out);
        // 根据key获取值
        System.out.println("pwd: " + properties.get("pwd"));
        // 通过key修改value,添加获取修改键值对
        properties.setProperty("pwd", "12345678");
        properties.setProperty("charset", "utf-8");
        // 存储数据
        properties.store(new FileWriter(file), "MySQL Properties");


    }
}
