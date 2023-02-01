
// implements 实现接口
public class Phone implements UsbInterface{
    // 实现usb接口

    @Override
    public void start() {
        System.out.println("手机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("手机停止工作");

    }
    public void call() {
        System.out.println("打电话...");
    }
}
