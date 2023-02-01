import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;


/**
 * @author ljw
 * @version 1.0
 */
public class Date_ {
    public static void main(String[] args) throws ParseException {
        // 获取当前系统时间
        Date date = new Date();
        System.out.println(date);
        // 指定毫秒输出对应时间
        Date date1 = new Date(430594645);
        System.out.println(date1);
        // 输出指定格式时间 yyyy年 MM月 dd日 HH:mm:ss 时分秒 E 周几
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        // 转换为文本 将日期对象传入SimpleDateFormat类的对象的format方法内
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        // 将字符串转为时间 parse 使用的对象需要与指定格式一致
        Date date2 = simpleDateFormat.parse(format);
        System.out.println(date2);
    }
}
