package top.duyt.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import top.duyt.dao.IMessageDao;
import top.duyt.domain.Message;
import top.duyt.service.IMessageService;

@Service("messageService")
@Scope("singleton")
public class MessageService implements IMessageService{

	@Resource
	private IMessageDao messageDao;
	
	public Message load(int msgId) {
		return messageDao.load(msgId);
	}

	public int add(Message msg) {
		return messageDao.add(msg);
	}

}
