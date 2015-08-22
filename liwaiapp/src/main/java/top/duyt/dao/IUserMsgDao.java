package top.duyt.dao;

import top.duyt.domain.UserMsg;

public interface IUserMsgDao extends IBaseDao<UserMsg> {
	
	/**
	 * 删除某个用户的某个接收信息
	 * @param uid
	 * @param msgId
	 */
	public void deleteReceivedMsg(int uid,int msgId); 
	
	/**
	 * 删除指定的某个用户信息关系对象
	 * @param userMsgId 用户关系对象ID
	 */
	public void deleteSendedMsg(int userMsgId);

}
