package com.ljw.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ljw
 * @version 1.0
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws Exception {
        // 开启服务端监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        // 等待客户端连接
        Socket socket = serverSocket.accept();
        // 获取socket的输入流
        InputStream inputStream = socket.getInputStream();
        // 使用BufferedInputStream处理socket的输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        // 将输入流转为byte数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        // 结束读取标志
        socket.shutdownInput();
        // 存入文件路径
        String file = "/home/Ljw/Desktop/java/ieda_project/day28-01-networkProgramming/src/images/id-63c42f672f0c8-0002-2.jpg";
        // 使用bufferedOutputStream处理文件输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        // 写入输入流的数据到本地
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        // 发送数据到客户端，输出流
        OutputStream outputStream = socket.getOutputStream();
        // 写入发送数据
        outputStream.write("Server: 接收图片".getBytes());
        // 写入数据完成标志
        socket.shutdownOutput();
        outputStream.flush();
        outputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
