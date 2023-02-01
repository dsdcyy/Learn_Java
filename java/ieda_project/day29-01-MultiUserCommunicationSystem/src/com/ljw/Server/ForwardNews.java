package com.ljw.Server;

import com.ljw.service.Message;
import com.ljw.service.MessageType;
import com.ljw.utility.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author ljw
 * @version 1.0
 * 用于推送消息的服务
 */
public class ForwardNews implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.print("请输入推送内容(exit退出推送服务):");
            Message message = new Message();
            message.setMessType(MessageType.MESSAGE_GROUP_MESSAGE);
            message.setSender("服务器");
            String content = Utility.readString(100);
            if ("exit".equals(content)) {
                break;
            }
            message.setContent(content);
            String[] users = MangerServerConnectClientThread.getOnlineUser().split(" ");
            for (String user : users) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(MangerServerConnectClientThread.get(user).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("\n服务器推送消息给所有人说：" + content);
        }
    }
}
