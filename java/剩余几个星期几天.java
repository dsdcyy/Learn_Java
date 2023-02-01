public class 剩余几个星期几天 {
    public static void main(String[] args){
        int i = 59;
        int week = i / 7;
        int day = i % 7;
        System.out.println(week + " " + day + " " );
        // 华氏温度转摄氏温度 5/9*(华氏温度-100)
        double hs = 134.6;
        double ss = 5.0 / 9.0 * (hs - 100.0);
        System.out.println("华氏温度:" + hs + "\t" + "摄式温度: " + ss);
    }
    
} 