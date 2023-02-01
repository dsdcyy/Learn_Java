/**
 * @author ljw
 * @version 1.0
 */
public class EnumExercise02 {
    public static void main(String[] args) {
        Week[] days = Week.values();
        for (Week day : days) {
            System.out.println(day.getDesc());
        }
    }

}
/* 1）声明Week枚举类，其中包含星期一至星期日的定义
        MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAYS */
    /*
    2）使用values返回所有的枚举数组，并遍历
    */
enum Week {
    MONDAY(1,"星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期天");
    private int num;
    private String desc;

    Week(int num, String desc) {
        this.num = num;
        this.desc = desc;
    }

    public int getNum() {
        return num;
    }

    public String getDesc() {
        return desc;
    }
}