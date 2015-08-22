package top.duyt.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import top.duyt.dao.IAttachmentDao;
import top.duyt.dao.IDepDocDao;
import top.duyt.dao.IDepartmentDao;
import top.duyt.dao.IDocumentDao;
import top.duyt.dao.IUserReadDocDao;
import top.duyt.domain.Attachment;
import top.duyt.domain.DepDoc;
import top.duyt.domain.Document;
import top.duyt.domain.UserReadDoc;
import top.duyt.dto.AttachmentDto;
import top.duyt.service.IDocumentService;
import top.duyt.util.FileUtil;
import top.duyt.util.Pager;
import top.duyt.util.SystemContext;

@Service("documentService")
@Scope("singleton")
public class DocumentService implements IDocumentService {
	
	@Resource
	private IDocumentDao documentDao;
	@Resource
	private IDepDocDao depDocDao;
	@Resource
	private IDepartmentDao departmentDao;
	@Resource
	private IAttachmentDao attachmentDao;
	@Resource
	private IUserReadDocDao userReadDocDao;

	public int add(Document doc, Integer[] depids, AttachmentDto adto) throws IOException {
		//1:保存公文
		doc.setCredate(new Date());
		doc.setUser(SystemContext.getLoginUser());
		int effectCount = documentDao.add(doc);
		//2:保存该公文和部门的关系
		DepDoc tempdd = null;
		for (int i = 0; i < depids.length; i++) {
			tempdd = new DepDoc();
			tempdd.setDoc(doc);
			tempdd.setDep(departmentDao.load(depids[i]));
			depDocDao.add(tempdd);
		}
		//3：有附件的情况就保存
		if (adto != null) {
		
			//上传路径
			String uploadPath = SystemContext.getUploadFilePath();
			//保存用的临时附件对象
			Attachment att = null;
			//保存使用当前时间定义的新文件名
			List<String> newFileNames = new ArrayList<String>();
			//待保存文件的文件名
			String[] fileNames = adto.getFilesName();
			for (int i = 0 ; i < adto.getFiles().length ;i++) {
				att = new Attachment();
				att.setDocument(doc);
				att.setOldname(fileNames[i]);
				att.setNewname(String.valueOf(new Date().getTime()));
				att.setSize(adto.getFiles()[i].length());
				newFileNames.add(att.getNewname());
				att.setType(FilenameUtils.getExtension(fileNames[i]));
				att.setCredate(new Date());
				attachmentDao.add(att);
			}
		
			//保存附件
			FileUtil.uploadAttachments(adto, uploadPath, newFileNames);
		}
		
		return effectCount;
	}

	public void delete(int docId,int depId) {
		
		//1:删除部门和公文的关系
		String hql = "delete DepDoc dd where dd.doc.id = ? and dd.dep.id = ?";
		depDocDao.executeByHql(hql, new Object[]{docId,depId});
		//2:删除用户和公文的关系
		hql = "delete UserReadDoc urd where urd.doc.id = ? and urd.user.id in (select u.id from User u where u.department.id = ?)";
		userReadDocDao.executeByHql(hql,new Object[]{docId,depId});
		//3:删除附件
		//如果要删除的公文和部门只剩下最后一条关系，才删除附件
		hql = "select count(*) from DepDoc dd where dd.doc.id = ?";
		long count = (Long) depDocDao.queryByHql(hql, docId);
		if (count < 1) {
			
			hql = "from Attachment ach where ach.document.id = ?";
			//删除附件的真实文件
			List<Attachment> attachments =  attachmentDao.list(hql, docId);
			for (Attachment attachment : attachments) {
				new File(SystemContext.getUploadFilePath()+"/"+attachment.getNewname()+"."+attachment.getType()).delete();
			}
			//删除文件记录
			hql = "delete Attachment ach where ach.document.id = ?";
			attachmentDao.executeByHql(hql,docId);
			
			//4:删除公文记录
			documentDao.delete(docId);
		}
	}

	public Document updateReadStateAndReturn(int docId) {
		//查找公文
		Document doc = documentDao.load(docId);
		//设置该公文已读
		UserReadDoc urd = new UserReadDoc();
		urd.setDoc(doc);
		urd.setUser(SystemContext.getLoginUser());
		userReadDocDao.add(urd);
		return doc;
	}

	public Pager<Document> findDocByUid(int uid, String param, Integer isRead) {
		String hql = "";
		//全查找
		if (isRead == null) {
			//查找全部
			hql = "select dd.doc from DepDoc dd where dd.dep.id = "
					+"(select u.department.id from User u where u.id = ?) "
					+ "and (dd.doc.title like '%" + param + "%' or dd.doc.content like '%" + param + "%') "
					+ "order by dd.doc.credate";
			return documentDao.find(hql, uid);
		}else 
		//查找已读
		if (isRead == 1) {
			hql = "select urd.doc from UserReadDoc urd left join fetch urd.doc.user where urd.user.id = ? "
					+ "and (urd.doc.title like '%"+ param +"%' or urd.doc.content like '%" + param + "%') "
					+ "order by urd.doc.credate";
			return documentDao.find(hql, uid);
		}
		//查找未读
		else{
			hql = "select dd.doc from DepDoc dd where dd.dep.id = "
					+"(select u.department.id from User u where u.id = ?) "
					+ "and dd.doc.id not in (select urd.doc.id from UserReadDoc urd) "
					+ "and (dd.doc.title like '%" + param + "%' or dd.doc.content like '%" + param + "%')"
					+ "order by dd.doc.credate";
			return documentDao.find(hql, uid);
		}

		
	}

	public Pager<Document> findSendDocByUid(int uid, String param) {
		String hql = "from Document doc where doc.user.id = ? "
				+ "and (doc.title like " + param + " or doc.content like " + param + ")";
		return documentDao.find(hql, uid);
	}

	public Pager<Document> findSendDocByDid(int did, String param) {
		String hql = "from Document doc where doc.user.department.id = ? "
				+ "and (doc.title like " + param + " or doc.content like " + param + ")";
		return documentDao.find(hql, did);
	}

}
