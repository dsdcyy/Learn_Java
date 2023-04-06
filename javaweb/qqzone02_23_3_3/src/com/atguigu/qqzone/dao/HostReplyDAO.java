package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.HostReply;

public interface HostReplyDAO {
    // 根据replayId查询对应主人回复
    HostReply getHostReplyByReplyId(Integer replyID);
    void delHostReply(Integer replyID);
}
