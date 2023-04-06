package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public interface ReplyService {
    List<Reply> getReplyListByTopicId(Integer topicId);
    void addReply(Reply reply);
    void delReply(Integer replyId);
    void delReplayList(Topic topic);
}
