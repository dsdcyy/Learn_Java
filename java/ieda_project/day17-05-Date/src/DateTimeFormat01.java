import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ljw
 * @version 1.0
 */
public class DateTimeFormat01 {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = dateTimeFormatter.format(localDateTime);
        System.out.println("现在: "+ date);
        // plus 时间计算
        // 加890天 plusDays()
        String date2 = dateTimeFormatter.format(localDateTime.plusDays(890));
        System.out.println("890天后: " + date2);
        // 加26个月 plusMonth()
        String date3 = dateTimeFormatter.format(localDateTime.plusMonths(26));
        System.out.println("26个月后: "+ date3);
        String date4 = dateTimeFormatter.format(localDateTime.plusYears(3));
        System.out.println("3年后: "+ date4);
    }
}
