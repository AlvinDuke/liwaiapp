package top.duyt.action;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.duyt.domain.Attachment;
import top.duyt.domain.DepDoc;
import top.duyt.domain.DepScope;
import top.duyt.domain.Document;
import top.duyt.dto.AttachmentDto;
import top.duyt.service.IAttachmentService;
import top.duyt.service.IDepDocService;
import top.duyt.service.IDepScopeService;
import top.duyt.service.IDepartmentService;
import top.duyt.service.IDocumentService;
import top.duyt.util.ActionUtil;
import top.duyt.util.Pager;
import top.duyt.util.SystemContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller("documentAction")
@Scope("prototype")
public class DocumentAction extends ActionSupport implements
		ModelDriven<Document> {

	private static final long serialVersionUID = 3683355828814245562L;
	private Document doc;
	@Resource
	private IDocumentService documentService;
	@Resource
	private IDepDocService depDocService;
	@Resource
	private IAttachmentService attachmentService;
	@Resource
	private IDepartmentService departmentService;
	@Resource
	private IDepScopeService depScopeService;

	//�ϴ��ĸ���
	private File[] attachments;
	//�ϴ��ļ�������
	private String[] attachmentsFileName;
	//�ϴ��ļ�������
	private String[] attachmentsContentType;
	
	private Integer[] selectedDepsId;
	private Integer isRead;
	private String param = "";
	private Integer depId;
	
	/**
	 * ����һ������
	 * @return
	 * @throws IOException 
	 */
	public String add() throws IOException{
		AttachmentDto adto = new AttachmentDto();
		adto.setFiles(attachments);
		adto.setFilesName(attachmentsFileName);
		adto.setFilesContentType(attachmentsContentType);
		documentService.add(doc, selectedDepsId, adto);
		ActionContext.getContext().put("url", "doc_listSendedDoc");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 
	 * @return
	 */
	public String addInput(){
		int depId = SystemContext.getLoginUser().getDepartment().getId();
		//��ȡ��ǰ�û��Ŀɷ����Ĳ���
		List<DepScope> deps =  depScopeService.list(depId);
		ActionContext.getContext().put("deps", deps);
		ActionContext.getContext().put("url", "addInput");
		return SUCCESS;
	}

	/**
	 * �����ѽ��յĹ���
	 * 
	 * @return
	 */
	public String listRevDoc() {
		// �û�ID
		int uid = SystemContext.getLoginUser().getId();
		Pager<Document> page = documentService.findDocByUid(uid, param, isRead);
		ActionContext.getContext().put("page", page);
		ActionContext.getContext().put("url", "listRevDoc");
		return SUCCESS;
	}
	
	/**
	 * �����ѷ��͵Ĺ���
	 * @return
	 */
	public String listSendedDoc(){
		int did = SystemContext.getLoginUser().getDepartment().getId();
		Pager<DepDoc> page = depDocService.findSendDocByDepId(did,param);
		ActionContext.getContext().put("page", page);
		ActionContext.getContext().put("url", "listSendedDoc");
		return SUCCESS;
	}
	
	/**
	 * ɾ��һ�����͵Ĺ���
	 * @return
	 */
	public String deleteSended(){
		documentService.delete(doc.getId(),depId);
		ActionContext.getContext().put("url", "doc_listSendedDoc");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * �鿴�ܹ�������
	 * @return
	 */
	public String showDoc(){
		doc = documentService.updateReadStateAndReturn(doc.getId());
		List<Attachment> attachs = attachmentService.listAttachInDoc(doc.getId());
		ActionContext.getContext().put("url", "show");
		ActionContext.getContext().put("attachs", attachs);
		return SUCCESS;
	}

	public Document getModel() {
		if (doc == null) {
			doc = new Document();
		}
		return doc;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
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

	public Integer[] getSelectedDepsId() {
		return selectedDepsId;
	}

	public void setSelectedDepsId(Integer[] selectedDepsId) {
		this.selectedDepsId = selectedDepsId;
	}

}
