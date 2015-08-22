package top.duyt.dao.impl;

import org.springframework.stereotype.Repository;

import top.duyt.dao.IMessageDao;
import top.duyt.domain.Message;

@Repository("messageDao")
public class MessageDao extends BaseDao<Message> implements IMessageDao{

}
