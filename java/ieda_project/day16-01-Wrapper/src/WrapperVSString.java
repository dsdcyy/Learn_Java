/**
 * @author ljw
 * @version 1.0
 */
public class WrapperVSString {
    public static void main(String[] args) {
        // Integer -> String
        Integer i = 100;
        // 方式1
        String str1 = i + "";
        System.out.println("i = " + str1);
        // 方式2
        String str2 = i.toString();
        System.out.println("i = " + str2);
        // 方式3
        String str3 = String.valueOf(i);
        System.out.println("i = " + str3);

        // String -> Integer
        // 方式1
        Integer i1 = Integer.parseInt("100");
        System.out.println("i1 = " + i1);
        // 方式2
        Integer integer = new Integer("100");
        System.out.println("i1 = " + integer);

        // Integer类和Character类的常用方法
        /*
        System.out.println(Integer.MINVALUE)://返回最小值
        System.out.println(Integer.MAX_VALUE)://返回最大值
        System.out.println(Character.isDigit（'a））：//判断是不是数字
        System.out.println(Character.isLetter（a）)://判断是不是字母
        System.out.println(Character.isupperCase（'a））：//判断是不是大写
        System.out.println(Character.isLowerCase（'a））//判断是不是小写
        System.out.println(Character.isWhitespace（'a））：//判断是不是空格
        System.out.println(Character.toUpperCase('a））；//转成大
        System.out.println(Character.toLowerCaseC'A2://转成小写
        * */

    }
    
}
