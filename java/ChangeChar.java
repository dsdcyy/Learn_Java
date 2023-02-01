// 演示转义字符的使用
// javadoc标签
/**
 * @author ljw
 * @version 1.0
 */
public class ChangeChar {
    public static void main(String[] args){
        // \t:一个制表位，实现对齐的功能
        System.out.println("北京\t上海\t天津");
        // \n:换行符
        System.out.println("西游记\n三国演义");
        // 输出\ \\ \ ' "都需要转义
        System.out.println("\\n");
        System.out.println("老韩说:\"要好好学习java\"！");
        // \r:一个回车
        // 解读
        // 1. 输出 return null
        // 2. 按下回车，将光标定位到开头
        // 3. 输出null，会覆盖retu字符
        System.out.println("return null\rnull");
        System.out.println("书名\t作者\t价格\t销量\n三国\t罗贯中\t120\t1000");
    }
}
