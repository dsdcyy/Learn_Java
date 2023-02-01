package com.ljw.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ljw
 * @version 1.0
 * // 服务端 字符流
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        // 在本机9999端口开启监听服务，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器监听9999端口，等待连接");
        // 通过ServerSocket的accept()可以获得多个socket对象
        // 没有程序连接时，程序会阻塞accept()
        // 如果有连接会返回一个socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务器端socket返回: " + socket.getClass());
        // 通过socket.getInputStream()获取输入流对象,将对象通过InputStreamReader转换流处理，在交由BufferedReader处理
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // 读取数据
        String data = "";
        while ((data = bufferedReader.readLine()) != null){
            System.out.println(data);
        }
        // 结束标记
        socket.shutdownInput();
        // 发送数据到客户端
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        // 写入数据
        bufferedWriter.write("Server: Hello Client!");

        // 结束标记
//        socket.shutdownOutput();
        bufferedWriter.newLine();
        // 手动刷新数据
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();

    }
}
