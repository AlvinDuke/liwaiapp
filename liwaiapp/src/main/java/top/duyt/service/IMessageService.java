package top.duyt.service;

import top.duyt.domain.Message;

public interface IMessageService {
	
	/**
	 * ����һ��˽��
	 * @param msg
	 * @return
	 */
	public int add(Message msg);
	
	/**
	 * ��ȡһ��ָ������Ϣ
	 * @param msg
	 * @return
	 */
	public Message load(int msgId);
	

}
