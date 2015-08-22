package top.duyt.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import top.duyt.dao.IAttachmentDao;
import top.duyt.dao.IMessageDao;
import top.duyt.dao.IUserDao;
import top.duyt.dao.IUserMsgDao;
import top.duyt.domain.Attachment;
import top.duyt.domain.Message;
import top.duyt.domain.User;
import top.duyt.domain.UserMsg;
import top.duyt.service.IUserMsgService;
import top.duyt.util.ActionUtil;
import top.duyt.util.Pager;
import top.duyt.util.SystemContext;

@Service("userMsgService")
@Scope("singleton")
public class UserMsgService implements IUserMsgService{

	@Resource
	private IMessageDao messageDao;
	@Resource
	private IUserMsgDao userMsgDao;
	@Resource
	private IUserDao userDao;
	@Resource
	private IAttachmentDao attachmentDao;
	
	public void addMsg(Message msg, Integer[] targetUids) {
		//首先保存信息
		messageDao.add(msg);
		
		//之后保存信息和接收用户之间的关系
		UserMsg umsg;
		List<User> userList = userDao.listByIds(targetUids);
		for (User u : userList) {
			umsg = new UserMsg();
			umsg.setIsread(0);
			umsg.setMsg(msg);
			umsg.setUser(u);
			userMsgDao.add(umsg);
		}
		
	}

	public void deleteReceivedMsg(int uid,int msgId) {
		userMsgDao.deleteReceivedMsg(uid, msgId);
	}

	public void deleteSendedMsg(int userMsgId) {
		UserMsg tempUm = userMsgDao.load(userMsgId);
		
		String hql = "select count(um.id) from UserMsg um where um.msg.id = ? ";
		long count = (Long) userMsgDao.queryByHql(hql, tempUm.getMsg().getId());
		//这条信息的收件人只剩下1个，将信息也一并删除
		if (count < 2) {
			messageDao.delete(tempUm.getMsg().getId());
			//信息如果有附件，一并删除附件
			//首先确定附件有无
			hql = "from Attachment att where att.message.id = ? ";
			List<Attachment> tempAtts = attachmentDao.list(hql, tempUm.getMsg().getId());
			//有附件则批量删除
			if (tempAtts.size() > 0) {
				//先删除记录           
				hql = "delete Attachment att where att.message.id = ? ";
				attachmentDao.executeByHql(hql, tempUm.getMsg().getId());
				//之后删除文件
				File tempFile = null;
				for (Attachment att : tempAtts) {
					tempFile = new File(SystemContext.getUploadFilePath() +"/"+ att.getNewname() + "." + att.getType());
					//附件真实存在才删除
					if (tempFile.exists()||!tempFile.isDirectory()) {
						tempFile.delete();
					}
				}
			}
		}
		userMsgDao.deleteSendedMsg(userMsgId);
	}

	public Pager<Message> findReceivedMsg(int uid,int isRead, String param) {
		
		String hql = "select um.msg from UserMsg um left join fetch um.msg.user mu "
				+ "left join fetch mu.department where um.isread = ? and um.user.id = ? ";
		//包含模糊查询的情况
		if (!ActionUtil.isEmpty(param)) {
			hql += " and (um.msg.title like ? or um.msg.content like ?) order by um.msg.credate desc";
			Object[] params = {isRead,uid,param,param};
			return messageDao.find(hql, params);
		}
		hql += "order by um.msg.credate desc";
		
		return messageDao.find(hql, new Object[]{isRead,uid});
	}

	public Pager<UserMsg> findSendedMsg(int uid,String param) {
		
		String hql = "select um from UserMsg um left join fetch um.msg umm left join fetch um.msg.user umu left join fetch umu.department where umu.id = ?";
		
		//String hql = "select msg from Message msg left join fetch msg.user mu left join fetch mu.department where msg.user.id = ?";
		//包含模糊查询的情况
		if (!ActionUtil.isEmpty(param)) {
			hql += " and (umm.title like ? or umm.content like ? ) order by umm.credate desc";
			Object[] params = {uid,param,param};
			return userMsgDao.find(hql, params);
		}
		hql += " order by umm.credate desc";
		return userMsgDao.find(hql, new Object[]{uid});
	}

	public UserMsg load(int mid, int recUid) {
		String hql = "from UserMsg um left join fetch um.msg left join fetch um.user where um.msg.id = ? and um.user.id = ?";
		return (UserMsg) userMsgDao.queryByHql(hql, new Object[]{mid,recUid});
	}

	public void update(UserMsg um) {
		userMsgDao.update(um);
	}

	public UserMsg load(int id) {
		return userMsgDao.load(id);
	}

}
