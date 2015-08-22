package top.duyt.dao;

import top.duyt.domain.UserMsg;

public interface IUserMsgDao extends IBaseDao<UserMsg> {
	
	/**
	 * ɾ��ĳ���û���ĳ��������Ϣ
	 * @param uid
	 * @param msgId
	 */
	public void deleteReceivedMsg(int uid,int msgId); 
	
	/**
	 * ɾ��ָ����ĳ���û���Ϣ��ϵ����
	 * @param userMsgId �û���ϵ����ID
	 */
	public void deleteSendedMsg(int userMsgId);

}
