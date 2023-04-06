package com.atguigu.qqzone.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.qqzone.dao.HostReplyDAO;
import com.atguigu.qqzone.pojo.HostReply;

/**
 * @author ljw
 * @version 1.0
 */
public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyID) {
        return super.load("select * from t_host_reply where reply = ? ", replyID);
    }

    @Override
    public void delHostReply(Integer replyID) {
        super.executeUpdate("delete from t_host_reply where replyId=?", replyID);
    }
}
