/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 1.Java提供了正则表达式技术，专门用于处理类似文本处理问题
        // 2.简单的说：正则表达式是对字符串执行模式匹配的技术。

        // 介绍
        /*
        * 1.一个正则表达式，就是用某种模式去匹配字符串的一个公式。很多人因为它们看上去比较古怪而且复杂所以不敢去使用，
        * 不过，经过练习后，就觉得这些复杂的表达式写起来还是相当简单的，而且，一旦你弄懂它们，
        * 你就能把数小时辛苦而且易错的文本处理工作缩短在几分钟（甚至几秒钟）内完成
        * 2.老韩这里要特别强调，正则表达式不是只有java才有，实际上很多编程语言都支持正则表达式进行字符串操作！如图所示。
        * */
        /*
        * 如果要想灵活的运用正则表达式，必须了解其中各种元字符的功能，元字符从功能上大致分为：
        * 1.限定符
        * 2.选择匹配符
        * 3.分组组合和反向引用符
        * 4.特殊字符
        * 5.字符匹配符
        * 6.定位符
        * */

        /*
        * ·元字符(Metacharacter)-转义号 \\
        * \\ 符号说明：在我们使用正则表达式去检索某些特殊字符的时候，需要用到转义符号，否
        * 则检索不到结果，甚至会报错的。案例：用$去匹配"abc$("会怎样？用（ 去匹配"abc$(”会怎样？
        * 再次提示：在Java的正则表达式中，两个11代表其他语言中的一个！
        * */

        /*
        * 元字符-字符匹配符
        * []  可接收的字符列表 [efgh] e、f、9、h中的任意1个字符
        * [^] 不接收的字符列表 [^abc] 除a、b、c之外的任意1个字符包括数字和特殊符号
        * - 连字符 A-Z 任意单个大写字母
        * . 匹配除\n以外的任何字符
        * a..b 以a开头，b结尾，中间包括2个任意字符的长度为4的字符串 aaab a#*b aefb a35b
        * \\ d 匹配单个数字字符，相当于[0-9]  \\{3}(\\d)？ 包含3个或4个数字的字符串 123、9876
        * \\D 匹配单个非数字字符，相当于［^0-9] \\D(\\Id)* 以单个非数字字符开头，后接任意个数字字符串 a A342
        * \\w 匹配单个数字、大小写字母字符,相当于[0-9a-ZA-Z]
        * \\d{3}\\w{4} 以3个数字字符开头的长度为7的数字字母字符串 234abcd 12345Pe
        * \\W  匹配单个非数字、大小写字母字符，相当于[^0-9a-ZA-Z]
        * \\W+\\d{2} 以至少1个非数字字母字符开头，2个数字字符结尾的字符串 #29、#@10
        * */

        /*
        * java正则表达式默认是区分字母大小写的，如何实现不区分大小写 Regexp2_.java
        * (?i)abc 表示abc都不区分大小写
        * a(?i)bc 表示bc不区分大小写
        * a((?i)b)c表示只有b不区分大小写
        * Pattern pat = Pattern.compile(regEx, Pattern.CASE INSENSITIVE):
        * */

        // 元字符-选择匹配符
        //在匹配某个字符串的时候是选择性的，即：既可以匹配这个，又可以匹配那个，这时你需
        //要用到选择匹配符号 |

        // 元字符-限定符
        //用于指定其前面的字符和组合项连续出现多少次
        /*
        * * 指定字符重复0次或n次(无要求) (abc)* 仅包含任意个abc的字符串，等效于\w*
        * . 指定字符重复1次或n次（至少一次） m+(abc)* 以至少1个m开头，后接任意个abc的字符串 m mabc
        * ? 指定字符重复0次或1次，后接ab或 abc的字符串 mab mabc
        * // java默认是贪婪匹配，即尽可能匹配多的次数
        * {n} 出现n次 [a-d]{3} a-d 内的字符，出现3次 abc bcd aaa
        * {n,} 至少出现n次 [a-d]{3,} a-d 内的字符，至少出现3次 abca bcd aaab
        * {n,m} 出现n-m次 [a-d]{3,6} a-d 内的字符，出现3-6次 abc bcd aaabab
        * {,m} 出现n-m次 [a-d]{,6} a-d 内的字符，出现0-m次 abc bcd aaabab  a
        * */

        // 元字符-定位符  Regexp3_.java
        //定位符，规定要匹配的字符串出现的位置，比如在字符串的开始还是在结束的位置，这个也是相当有用的，必须掌握
        /*
        * ^ 指定起始字符 ^[0-9]+[a-z]+ 以至少1个数字开又，后接任意个小写字母的字符串 123 6aa 555def
        * $ 指定结束字符 ^[O-9]\\-[a-]+$ 以1个数字开头后接连字符“一”，并以至少1个小写字母结尾的字符串 1-a
        * \\b 匹配目标字符的边界 han\\b 这里说的字符串的边界指的是子串间有空格，或者是目标字符串的结束位置  sphan
        * \B 匹配目标字符的非边界 han\\B hanshuping
        * */

        // 分组 Regexp_.java
        /*
        * 常用分组构造形式 说明
        * 1.(pattern) 非命名捕获。捕获匹配的子字符串。编号为零的第一个捕获是由整个正则表达式模式匹配的文本，其它捕获结果则根据左括号的顺序从1开始自动编号。
        * 2.(?<name> pattern) 命名捕获，将匹配的子字符串捕获到一个组名称或编号名称中。用于name的字符串不能包含任何标点符号，并且不能以数字开头。
        * 可以使用单引号替代尖括号，例如（?"name"）
        * */
        // 特别分组
        /*
        * 常用分组构造形式 说明
        * 1.(?:PATTERN)  匹配pattern但不捕获该匹配的子表达式，即它是一个非捕获匹配，
        * 不存储供以后使用的匹配。这对于用"or"字符（|）组合模式部件的情况很有用。
        * 例如 "industr(?:y|ies）是比"industry|industries'更经济的表达式。
        * 2.(?=pattern) 它是一个非捕获匹配。例如，"Windows（?=95|98|NT|2000)匹配"Windows2000"中的"Windows"，
        * 但不匹配"Windows3.1"中的Windows"。
        * 3.(?!pattern)  该表达式匹配不处于匹配pattern的字符串的起始点的搜索字符串。
        * 它是一个非捕获匹配。例如，"Windows（?=95|98INTI2000)匹配
        *'Windows3.1"中的“Windows"，但不匹配"Windows2000"中的"Windows"。
        * */

        // ？紧跟任何其它限定符，表达使用非贪心匹配
        // []里面的限定符都是普通字符

        // 正则表达式的三个常用类
        // java.util.regex包主要包括以下三个类Pattern类、Matcher类和PatternSyntaxExceptionOPattern类
        /*
        * 1.pattern对象是一个正则表达式对象。Pattern类没有公共构造方法。要创建一个Pattern对象，调用其公共静态方法，
        * 它返回一个Pattern对象。该方法接受一个正则表达式作为它的第一个参数，比：Patternr= Pattern.compile(pattern)
        * 2.Matcher 类Matcher对象是对输入字符串进行解释和匹配的引擎。与Pattern类一样，Matcher也没有公共构造方法。
        * 你需要调用Pattern对象的matcher方法来获得一个Matcher对象
        * 3.PatternSyntaxException PatternSyntaxException是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
        * */

        // Pattern Pattern_.java
        /*
        * Pattern.compile(String pattern)
        * Pattern.matches(String pattern, CharSequence content)
        * */

        //
        /* Matcher Matcher_.java
        * public int start()  返回以前匹配的初始索引。
        * public int start（int group） 返回在以前的匹配操作期间，由给定组所捕获的子序列的初始索引
        * public int end()  返回最后匹配字符之后的偏移量。
        * public int end(int group)  返回在以前的匹配操作期间，由给定组所捕获子序列的最后字符之后的偏移量
        * public boolean lookingAt()  尝试将从区域开头开始的输入序列与该模式匹配。
        * public boolean find()  尝试查找与该模式匹配的输入序列的下一个子序列。
        * public boolean find(int start） 重置此匹配器，然后尝试查找匹配该模式、）从指定索引开始的输入序列的下个子序列
        * public boolean matches()尝试将整个区域与模式匹配。
        * */

        // 反向引用
        /*
        * 圆括号的内容被捕获后，可以在这个括号后被使用，从而写出一个比较实用的匹配模式，
        * 这个我们称为反向引用，这种引用既可以是在正则表达式内部，也可以是
        *在正则表达式外部，内部反向引用\\分组号，外部反向引用$分组号
        * */

        // 结巴案例 JieBa.java 外部反向引用替换内部反向引用

        // String类使用正则表达式 StringReg.java
        /*
        * 1. 替换功能
        * public String replaceAll(String regex,String replacement)
        * 2.判断功能
        * public boolean matches(String regex)
        * 3.分隔功能
        * public String[] split(String regex)
        * */
        System.out.println("Hello world!");
    }
}