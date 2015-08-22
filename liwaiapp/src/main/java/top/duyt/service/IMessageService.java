package top.duyt.service;

import top.duyt.domain.Message;

public interface IMessageService {
	
	/**
	 * 新增一个私信
	 * @param msg
	 * @return
	 */
	public int add(Message msg);
	
	/**
	 * 获取一条指定的信息
	 * @param msg
	 * @return
	 */
	public Message load(int msgId);
	

}
