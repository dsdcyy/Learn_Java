import com.ljw.socket.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork03Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getByName("192.168.0.105"), 9999);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入下载音乐名:");
        String next = scanner.next();
        bos.write(next.getBytes());
        bos.flush();
        socket.shutdownOutput();
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] data = StreamUtils.streamToByteArray(bis);
        socket.shutdownInput();
        String musicPath = next + "2.mp3";
        BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(musicPath));
        bos2.write(data);
        bos2.flush();
        System.out.println("music downloaded finished...");
        bos2.close();
        bos.close();
        bis.close();
        socket.close();

    }
}
