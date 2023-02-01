public class Interface01 {
    public static void main(String[] args) {
//        // 创建手机对象
//        Phone phone = new Phone();
        // 创建电脑对象
        Computer computer = new Computer();
//        // 创建相机对象
//        Camera camera = new Camera();
//        // 手机通过usb接口接入电脑
//        computer.work(phone);
//        //  相机通过usb接口接入电脑
//        computer.work(camera);

        UsbInterface[] usbs = new UsbInterface[2];
        usbs[0] = new Phone();
        usbs[1] = new Camera();

        for (UsbInterface usb : usbs) {
            if (usb instanceof Phone) {
                ((Phone) usb).call();
            }
            computer.work(usb);
        }


    }
}
