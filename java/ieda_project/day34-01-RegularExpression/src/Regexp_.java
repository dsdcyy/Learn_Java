import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljw
 * @version 1.0
 */
public class Regexp_ {
    public static void main(String[] args) {
        // 1.先创建一个Pattern对象， 模式对象 可以理解成一个正则表达式对象
//        Pattern compile = Pattern.compile("\\d{4}");
        // ?<name> 给分组取名
        Pattern compile = Pattern.compile("(?<g1>\\w{2})(?<g2>\\w)");
        String content = "Java programming language具有大部分编程语言所共有的一些特征，被特意设计用于互联网的分布式环境。Java具有类似于C++语言的\"形式和感觉\"，但它要比C++语言更易于使用，而且在编程时彻底采用了一种\"以对象为导向\"的方式。使用Java编写的应用程序，既可以在一台单独的电脑上运行，也可以被分布在一个网络的服务器端和客户端运行。另外，Java还可以被用来编写容量很小的应用程序模块或者applet，做为网页的一部分使用。applet可使网页使用者和网页之间进行交互式操作。\n" +
                "Java是Sun微系统公司在1995年推出的，推出之后马上给互联网的交互式应用带来了新面貌。最常用的两种互联网浏览器软件中都包括一个Java虚拟机。几乎所有的操作系统中都增添了Java编译程序。";
        // 2.创建一个匹配容器对象
        Matcher matcher = compile.matcher(content);
        //3.可以开始循环匹配
        while (matcher.find()) {
            // group(0) 所有匹配的文本,group(1) 第一个分组 group(2) 第二个分组 ...
            // (表达式1) （表达式2）（）为进行分组
            System.out.println("找到: " + matcher.group(0));
            System.out.println("找到分组1: " + matcher.group(1));
            System.out.println("找到分组2: " + matcher.group(2));
            System.out.println("找到分组g1: " + matcher.group("g1"));
            System.out.println("找到分组g2: " + matcher.group("g2"));
        }
        // group源码
        /*
        *  public String group(int group) {
        if (first < 0)
            throw new IllegalStateException("No match found");
        if (group < 0 || group > groupCount())
            throw new IndexOutOfBoundsException("No group " + group);
        if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
            return null;
        return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
    }
        * */
    }
}
