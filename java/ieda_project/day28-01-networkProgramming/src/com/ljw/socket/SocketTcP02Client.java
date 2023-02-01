package com.ljw.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author ljw
 * @version 1.0
 * 客户端
 */
public class SocketTcP02Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 连接服务器 InetAddress对象，端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回: " + socket.getClass());
        // 连接上后，生成Socket对象，通过socket.getOutputStream()得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 将字节流转换为字符流再转为bufferWriter
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        // 字符流写入数据（发送数据）
        bufferedWriter.write("Client: Hello Server");
        //  newLine() 可以设置为结束标志，需对方读时用readLine
        bufferedWriter.newLine();
        // 字符流手动刷新
        bufferedWriter.flush();
//        // 结束标志
        socket.shutdownOutput();
        // 接收服务器端的数据
        // 将字节流转换为字符流再转为bufferReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String data = "";
        while ((data = bufferedReader.readLine()) != null){
            System.out.println(data);
        }
            // 结束标记
//        socket.shutdownInput();
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();

    }
}
