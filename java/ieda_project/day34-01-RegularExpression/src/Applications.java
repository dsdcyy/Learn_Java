import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljw
 * @version 1.0
 */
public class Applications {
    public static void main(String[] args) {
        // 查找汉字
//        String content = "教育";
//        String pattern = "[\u0391-\uffe5]+";
        //邮政编码 1-9k开头的6位数字
//        String content = "123456";
//        String pattern = "^[1-9]\\d{5}$";
        //qq号码 1-9开头的5-10位数字
//        String content = "123456789";
//        String pattern = "^[1-9]\\d{4,8}[1-9]$";
        // 手机号 13 14 15 18开头的11尾位数
//        String content = "13456789367";
//        String pattern = "^1[3458]\\d{9}$";
        String content = "https://www.bilibili.com/video/BV1fh411y7R8?p=894&spm_id_from=pageDriver&vd_source=653a31f93a7075414c3d8d0c358c8529";
        String pattern = "^(https?://)?([\\w-]+\\.)+([\\w-])+(/[\\w-&?=%./#]*)?$";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }

}
