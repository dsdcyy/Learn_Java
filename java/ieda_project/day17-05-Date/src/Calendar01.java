import java.util.Calendar;

/**
 * @author ljw
 * @version 1.0
 */
public class Calendar01 {
    public static void main(String[] args) {
        // 通过getInstance获取对象
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        // 获取日历对象的某个字段
        // 年
        System.out.println(c.get(Calendar.YEAR));
        // 月 需要加1
        System.out.println(c.get(Calendar.MONTH) + 1);
        // 这个月的第几天
        System.out.println(c.get((Calendar.DAY_OF_MONTH)));
        // 小时
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
        // 分
        System.out.println(c.get(Calendar.MINUTE));
        // 秒
        System.out.println(c.get(Calendar.SECOND));
        // 星期的第几天 需减1
        System.out.println(c.get(Calendar.DAY_OF_WEEK) - 1);
        // 没有专门的格式化方法，需要自己组合

    }
}
