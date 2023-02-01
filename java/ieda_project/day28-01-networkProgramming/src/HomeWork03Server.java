import com.ljw.socket.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork03Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器监听在9999端口...");
        Socket socket = serverSocket.accept();
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] buf = new byte[1024];
        int len = 0;
        String musicName = "";
        while ((len = bis.read(buf)) != -1) {
            musicName += new String(buf, 0, len);
        }
        System.out.println("Music: " + musicName);
        socket.shutdownInput();
        String music = "";
        if ("甜甜圈".equals(musicName)) {
            music = "/home/Ljw/Desktop/java/ieda_project/day28-01-networkProgramming/src/甜甜圈.mp3";
            System.out.println("下载甜甜圈...");
        } else {
            music = "/home/Ljw/Desktop/java/ieda_project/day28-01-networkProgramming/src/游戏坦克大战音效.mp3";
            System.out.println("默认下载...");
        }
        BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(music));
        byte[] musicData = StreamUtils.streamToByteArray(bis2);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(musicData);
        bos.flush();
        socket.shutdownOutput();
        System.out.println("music update finished...");
        bos.close();
        bis.close();
        bis2.close();
        socket.close();
        serverSocket.close();

    }
}
