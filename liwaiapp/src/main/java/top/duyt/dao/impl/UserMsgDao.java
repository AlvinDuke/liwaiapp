package top.duyt.dao.impl;

import org.springframework.stereotype.Repository;

import top.duyt.dao.IUserMsgDao;
import top.duyt.domain.UserMsg;

@Repository("userMsgDao")
public class UserMsgDao extends BaseDao<UserMsg> implements IUserMsgDao{
	
	public void deleteReceivedMsg(int uid,int msgId) {
		this.executeByHql("delete UserMsg um where um.user.id = ? and um.msg.id = ?", new Object[]{uid,msgId});
	}

	public void deleteSendedMsg(int userMsgId) {
		this.executeByHql("delete UserMsg um where um.id = ?", userMsgId);
		
	}

}
