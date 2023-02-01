public interface UsbInterface {
    public void start();
    public void stop();

    // 需要使用方法体需加上default关键字
    default public void connect(){
        System.out.println("连接成功...");
    }
    // 使用静态方法也可去具体实现
    public static void cry(){
        System.out.println("cry...");
    }
}
