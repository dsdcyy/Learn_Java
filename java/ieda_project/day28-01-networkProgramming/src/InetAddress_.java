import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ljw
 * @version 1.0
 * 演示InetAddress类使用
 */
public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        // 获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost); // Ljw-PC/192.168.0.105
        // 根据指定主机名 获取InetAddress对象
        InetAddress host1 = InetAddress.getByName("Ljw-PC");
        System.out.println(localHost); // Ljw-PC/192.168.0.105
        // 根据域名 获取InetAddress对象
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2); // www.baidu.com/14.215.177.38
        // 通过InetAddress对象获取主机地址
        String address = host2.getHostAddress();
        System.out.println(address);

    }
}
