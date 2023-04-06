package com.ljw.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author ljw
 * @version 1.0
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        // 准备DatagramSocket对象，监听10000端口接收和发送数据
        DatagramSocket datagramSocket = new DatagramSocket(10000);
        // 准备发送的数据
        byte[] buf = "UDPSenderB: hello,明天去吃火锅...".getBytes();
        // 将数据放入到datagramPacket对象内 字节数组 长度 目标ip地址(InetAddress)对象 对方端口
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 9999);
        // send 发送数据
        datagramSocket.send(datagramPacket);
        // 接收回复消息
        // 准备字节数组
        byte[] bytes = new byte[1024];
        // 准备DatagramPacket空对象
        DatagramPacket datagramPacket1 = new DatagramPacket(bytes,bytes.length);
        datagramSocket.receive(datagramPacket1);
        int length = datagramPacket1.getLength();
        byte[] data = datagramPacket1.getData();
        String s = new String(data,0,length);
        System.out.println(s);
        // 关闭DatagramSocket资源
        datagramSocket.close();
    }
}
