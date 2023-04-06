package com.atguigu.qqzone.service.impl;

import com.atguigu.qqzone.dao.ReplyDAO;
import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.HostReplyService;
import com.atguigu.qqzone.service.ReplyService;
import com.atguigu.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO;
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;

    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        List<Reply> replyList = replyDAO.getReplyList(new Topic(topicId));
        for (Reply reply : replyList) {
            // 根据回复找到作者id并设置进replay中的作者中
            Integer id = reply.getAuthor().getId();
            UserBasic userAuthor = userBasicService.getUserBasicById(id);
            reply.setAuthor(userAuthor);
            // 将关联的HostReplay设置进去
            HostReply hostReplyByReplyId = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReplyByReplyId);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReply(Integer id) {
        //1.根据id获取到reply
        Reply reply = replyDAO.getReply(id);
        if (reply != null) {
            //2.如果reply有关联的hostReply，则先删除hostReply
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            if (hostReply != null) {
                hostReplyService.delHostReply(hostReply.getId());
            }
            //3.删除reply
            replyDAO.delReply(id);
        }
    }

    @Override
    public void delReplayList(Topic topic) {
        List<Reply> replyList = replyDAO.getReplyList(topic);
        if (replyList != null) {
            for (Reply reply : replyList) {
                delReply(reply.getId());
            }
        }
    }
}
