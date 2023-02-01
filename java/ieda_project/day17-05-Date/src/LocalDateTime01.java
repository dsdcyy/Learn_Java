import java.time.LocalDateTime;

/**
 * @author ljw
 * @version 1.0
 */
public class LocalDateTime01 {
    public static void main(String[] args) {
        // now() 返回当前时间的对象
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // 年 getYear()
        System.out.println("年： " + localDateTime.getYear());
        // 月 getMonth()
        System.out.println("月: " + localDateTime.getMonth());
        // 月 getMonthValue()
        System.out.println("月: " + localDateTime.getMonthValue());
        // 日 getDayOfMonth()
        System.out.println("日: " + localDateTime.getDayOfMonth());
        // 时 getHour()
        System.out.println("时 :" + localDateTime.getHour());
        // 分 getMinute()
        System.out.println("分 :" + localDateTime.getMinute());
        // 秒 getSecond()
        System.out.println("秒 :" + localDateTime.getSecond());


    }
}
