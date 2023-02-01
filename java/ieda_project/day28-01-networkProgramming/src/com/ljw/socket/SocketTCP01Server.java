package com.ljw.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ljw
 * @version 1.0
 * // 服务端
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        // 在本机9999端口开启监听服务，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器监听9999端口，等待连接");
        // 通过ServerSocket的accept()可以获得多个socket对象
        // 没有程序连接时，程序会阻塞accept()
        // 如果有连接会返回一个socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务器端socket返回: " + socket.getClass());
        // 通过socket.getInputStream()获取输入流对象
        InputStream inputStream = socket.getInputStream();
        // 读取数据
        int data = 0;
        byte[] bytes = new byte[1024];
        while ((data = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,data));
        }
        socket.shutdownInput();
        // 发送数据到客户端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Server: Hello Client!".getBytes());
        // 结束标记
        socket.shutdownOutput();
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();

    }
}
