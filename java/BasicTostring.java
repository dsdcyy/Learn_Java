public class BasicTostring {
    public static void main(String[] args){
       
        int n = 2;
        float n2 = 1.0f;
        double n3 = 3.23;
        boolean b1 = true;
         // 基本数据类型转字符串
        String s1 = n2 + "";
        String s2 = n3 + "";
        String s3 = n + "";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        // String 转对应的基本数据类型
        // 使用基本数据类型的包装类的相应方法，得到基本数据类型
        String s5 = "123";
        int num1 = Integer.parseInt(s5);
        double num2 = Double.parseDouble(s5);
        float num3 = Float.parseFloat(s5);
        long  num4 = Long.parseLong(s5);
        byte  num5 = Byte.parseByte(s5);
        boolean bool = Boolean.parseBoolean("true");
        short num6 = Short.parseShort(s5);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
        System.out.println(num6);
        System.out.println(bool);
        //将字符串转换为char s5.charAt(0)得到字符串的第一个字符'1'
        System.out.println(s5.charAt(0));
    }
}
