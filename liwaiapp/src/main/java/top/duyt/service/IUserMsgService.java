package top.duyt.service;


import top.duyt.domain.Message;
import top.duyt.domain.UserMsg;
import top.duyt.util.Pager;

public interface IUserMsgService {

	/**
	 * 新增一个要发送的信息
	 * @param msg 信息内容
	 * @param targetUids 目标用户
	 */
	public void addMsg(Message msg,Integer[] targetUids);
	
	/**
	 * 根据信息ID和收件人ID获取用户信息关系对象
	 * @param mid 信息ID
	 * @param recUid 接收用户的ID
	 * @return
	 */
	public UserMsg load(int mid,int recUid);
	
	/**
	 * 根据ID查找用户信息关系对象
	 * @param id
	 * @return
	 */
	public UserMsg load(int id);
	
	/**
	 * 更新某个用户信息对象
	 * @param um
	 */
	public void update(UserMsg um);
	
	/**
	 * 删除某个用户的某个接收信息
	 * @param msgId
	 */
	public void deleteReceivedMsg(int uid,int msgId);
	
	/**
	 * 删除指定的某个用户信息关系对象<br>
	 * 注：同一信息可能同时发送给多个用户，如果当前删除的用户关系对象为最后一个，则会一并删除发送的源消息
	 * @param userMsgId 用户关系对象ID
	 */
	public void deleteSendedMsg(int userMsgId);
	
	/**
	 * 获取某个用户的已读/未读信息
	 * @param uid
	 * @param isRead 信息读取状态
	 * @param param 信息检索条件
	 * @return
	 */
	public Pager<Message> findReceivedMsg(int uid,int isRead,String param);
	
	/**
	 * 获取某个用户的已发送信息
	 * @param uid
	 * @param param 信息检索条件
	 * @return
	 */
	public Pager<UserMsg> findSendedMsg(int uid,String param);
	
	
	
}
