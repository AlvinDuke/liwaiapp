package top.duyt.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.duyt.domain.Attachment;
import top.duyt.domain.Message;
import top.duyt.domain.User;
import top.duyt.domain.UserMsg;
import top.duyt.dto.AttachmentDto;
import top.duyt.service.IAttachmentService;
import top.duyt.service.IMessageService;
import top.duyt.service.IUserMsgService;
import top.duyt.service.IUserService;
import top.duyt.util.ActionUtil;
import top.duyt.util.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("messageAction")
@Scope("prototype")
public class MessageAction extends ActionSupport implements
		ModelDriven<Message> {

	private static final long serialVersionUID = -993634438980453534L;

	private Message message;
	//是否已读标记
	private int isRead;
	//查询参数
	private String param;
	//用户信息关系对象ID
	private int userMsgid;
	//接收信息的用户列表
	private List<User> receiversUser;
	//选定的收信者ID
	private Integer[] selectedReceiversId;
	//上传的附件
	private File[] attachments;
	//上传文件的名称
	private String[] attachmentsFileName;
	//上传文件的类型
	private String[] attachmentsContentType;

	@Resource
	private IUserMsgService userMsgService;
	@Resource
	private IMessageService messageService;
	@Resource
	private IUserService userService;
	@Resource
	private IAttachmentService attachmentService;
	
	/**
	 * 新建一个私信
	 * @return
	 * @throws IOException 
	 */
	public String add() throws IOException{
		int uid = ((User) ActionContext.getContext().getSession()
				.get("loginUser")).getId();
		
		//新增私信内容
		User tempUser = new User();
		tempUser.setId(uid);
		message.setUser(tempUser);
		message.setCredate(new Date());
		//保存私信
		messageService.add(message);
		//保存收件人和私信关系
		userMsgService.addMsg(message, selectedReceiversId);
		//当前私信含有附件，保存并上传附件
		if (attachments.length > 0) {
			String uploadPath = ServletActionContext.getServletContext().getRealPath("upload");
			attachmentService.addAtts(new AttachmentDto(attachments, attachmentsFileName, attachmentsContentType) ,message,uploadPath);
		}
		
		ActionContext.getContext().put("url", "msg_listSendedMsg");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 新增跳转页面
	 * @return
	 */
	public String addInput(){
		
		int uid = ((User) ActionContext.getContext().getSession()
				.get("loginUser")).getId();
		
		//查询可收信部门中的所有用户
		//receiversUser = userService.listReceiversByCurUid(uid);
		receiversUser = userService.listRecsByCurUidOriSql(uid);
		ActionContext.getContext().put("url", "addInput");
		return SUCCESS;
	}

	/**
	 * 获取当前用户接收到的信息
	 * 
	 * @return;
	 */
	public String listRevMsg() {
		int uid = ((User) ActionContext.getContext().getSession()
				.get("loginUser")).getId();
		ActionContext.getContext().put("pager",
				userMsgService.findReceivedMsg(uid, isRead, param));
		ActionContext.getContext().put("url", "listRevMsg");
		return SUCCESS;
	}

	/**
	 * 获取当前用户的已发送信息
	 * 
	 * @return
	 */
	public String listSendedMsg() {
		int uid = ((User) ActionContext.getContext().getSession()
				.get("loginUser")).getId();

		Pager<UserMsg> pager = userMsgService.findSendedMsg(uid, param);

		ActionContext.getContext().put("pager", pager);
		ActionContext.getContext().put("url", "listSendedMsg");
		return SUCCESS;
	}

	/**
	 * 删除登陆用户的某个已接收信息
	 * 
	 * @return
	 */
	public String deleteReceived() {
		int uid = ((User) ActionContext.getContext().getSession()
				.get("loginUser")).getId();
		userMsgService.deleteReceivedMsg(uid, message.getId());
		ActionContext.getContext().put("url", "msg_listRevMsg");
		return ActionUtil.REDIRECT;
	}

	/**
	 * 某个已发送的信息
	 * 
	 * @return
	 */
	public String deleteSended() {
		userMsgService.deleteSendedMsg(userMsgid);
		ActionContext.getContext().put("url", "msg_listSendedMsg");
		return ActionUtil.REDIRECT;
	}

	/**
	 * 查询某个收件箱信息
	 * 
	 * @return
	 */
	public String showReceivedMsg() {
		int uid = ((User) ActionContext.getContext().getSession()
				.get("loginUser")).getId();
		message = messageService.load(message.getId());

		UserMsg tempUm = userMsgService.load(message.getId(), uid);

		// 更新阅读状态，未读->已读
		if (tempUm.getIsread() == 0) {
			tempUm.setIsread(1);
			userMsgService.update(tempUm);
		}
		
		//查看当前信息是否含有附件
		List<Attachment> attachs = attachmentService.listAttachInMsg(message.getId());
		
		ActionContext.getContext().put("attachs", attachs);
		ActionContext.getContext().put("url", "show");
		return SUCCESS;
	}
	
	
	/**
	 * 查询某个发件箱信息
	 * 
	 * @return
	 */
	public String showSendedMsg() {
		message = userMsgService.load(userMsgid).getMsg();
		ActionContext.getContext().put("url", "show");
		return SUCCESS;
	}
	

	public Message getModel() {
		if (message == null) {
			message = new Message();
		}
		return message;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public List<User> getReceiversUser() {
		return receiversUser;
	}

	public void setReceiversUser(List<User> receiversUser) {
		this.receiversUser = receiversUser;
	}

	public Integer[] getSelectedReceiversId() {
		return selectedReceiversId;
	}

	public void setSelectedReceiversId(Integer[] selectedReceiversId) {
		this.selectedReceiversId = selectedReceiversId;
	}

	public int getUserMsgid() {
		return userMsgid;
	}

	public void setUserMsgid(int userMsgid) {
		this.userMsgid = userMsgid;
	}

	public File[] getAttachments() {
		return attachments;
	}

	public void setAttachments(File[] attachments) {
		this.attachments = attachments;
	}

	public String[] getAttachmentsFileName() {
		return attachmentsFileName;
	}

	public void setAttachmentsFileName(String[] attachmentsFileName) {
		this.attachmentsFileName = attachmentsFileName;
	}

	public String[] getAttachmentsContentType() {
		return attachmentsContentType;
	}

	public void setAttachmentsContentType(String[] attachmentsContentType) {
		this.attachmentsContentType = attachmentsContentType;
	}


}
