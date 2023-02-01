package com.ljw.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author ljw
 * @version 1.0
 */
public class SocketTcP03Client {
    public static void main(String[] args) throws Exception {
        // 文件路径
        String file = "/home/Ljw/Desktop/java/ieda_project/day28-01-networkProgramming/src/images/id-63c42f672f0c8-0002.jpg";
        // 通过BufferedInputStream对象处理输入字节流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        // 将输入流转为byte数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        // 建立客户端连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        // 将客户端的输出流交给BufferedOutputStream处理
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        // 将字节数组写入到客户端的输出流
        bufferedOutputStream.write(bytes);
        // 刷新数据
        bufferedOutputStream.flush();
        // 结束写入标志
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        String data = StreamUtils.streamToString(inputStream);
        System.out.println(data);
        socket.shutdownInput();
//        OutputStream outputStream2 = socket.getOutputStream();
//        // 将客户端的输出流交给BufferedOutputStream处理
//        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStream);
//        bufferedOutputStream2.write("发送图片".getBytes());
//        // 刷新数据
//        bufferedOutputStream2.flush();
//        // 结束写入标志
//        socket.shutdownOutput();
        inputStream.close();
        bufferedOutputStream.close();
//        bufferedOutputStream2.close();
        bufferedInputStream.close();
        socket.close();

    }
}
