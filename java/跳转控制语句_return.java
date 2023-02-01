public class 跳转控制语句_return {
    public static void main(String[] args){
        // return 表示跳出所在的方法，写在main方法中则退出程序
        for(int i=0;i<5;i++){
            if(i==3){
                return;
            }
            System.out.println("i="+i);
        }
        System.out.println("for循环结束，程序继续执行！");

    }
}
