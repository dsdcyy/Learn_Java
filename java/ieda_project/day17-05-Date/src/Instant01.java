
import java.time.Instant;
import java.util.Date;

/**
 * @author ljw
 * @version 1.0
 */
public class Instant01 {
    public static void main(String[] args) {
        //Instant时间戳
        //类似于Date
        //提供了一系列和Date类转换的方式
        //Instant ---> Date:
        // Date date = Date.from(instant);
        //Date ---> Instant：
        //Instant instant = date.toInstant();
        // 获取当前时间戳对象
        Instant now = Instant.now();
        System.out.println("当前时间戳: "+now);
        // 时间戳转换为时间
        Date from = Date.from(now);
        System.out.println("时间戳转时间: " + from);
        // 时间转时间戳
        Instant instant = from.toInstant();
        System.out.println("时间转时间戳: " + instant);
    }
}
