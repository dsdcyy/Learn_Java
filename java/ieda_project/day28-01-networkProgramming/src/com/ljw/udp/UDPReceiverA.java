package com.ljw.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author ljw
 * @version 1.0
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        // 实例化DatagramSocket对象，等待发送和接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        // 准备字节数组 不能大于64kb
        byte[] buf = new byte[1024];
        // 准备空DatagramPacket对象
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        // 调用接收方法,将通过网络传输的DatagramPacket对象填充到datagramPacket
        // 有数据发送过来就会接收到数据，否则会阻塞等待
        datagramSocket.receive(datagramPacket);
        // 对datagramPacket进行拆包，获取数据
        int length = datagramPacket.getLength(); // getLength() 实际接收到的数据长度
        byte[] data = datagramPacket.getData(); // getData() 数据包
        // 将数据包转换为字符串
        String s = new String(data, 0, length);
        // 输出数据
        System.out.println(s);
        // 准备字节数组 不能大于64kb
        byte[] buf2 = "UDPReceiverA: 好的，明天见...".getBytes();
        // DatagramPacket类包装数据并指定发送地址和端口号
        DatagramPacket datagramPacket1 = new DatagramPacket(buf2, buf2.length, InetAddress.getByName("192.168.0.105"), 10000);
        // 回复消息
        datagramSocket.send(datagramPacket1);
        // 关闭资源
        datagramSocket.close();

    }
}
