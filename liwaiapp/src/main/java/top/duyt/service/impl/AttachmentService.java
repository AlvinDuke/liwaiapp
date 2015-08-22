package top.duyt.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import top.duyt.dao.IAttachmentDao;
import top.duyt.domain.Attachment;
import top.duyt.domain.Message;
import top.duyt.dto.AttachmentDto;
import top.duyt.service.IAttachmentService;
import top.duyt.util.FileUtil;

@Service("attachmentService")
@Scope("singleton")
public class AttachmentService implements IAttachmentService{

	@Resource
	private IAttachmentDao attachmentDao;
	
	public int add(Attachment att) {
		return attachmentDao.add(att);
	}

	public void delete(int attId) {
		attachmentDao.delete(attId);		
	}

	public List<Attachment> listAttachInMsg(int msgId) {
		String hql = "from Attachment at where at.message.id = ?";
		return attachmentDao.list(hql, msgId);
	}

	public List<Attachment> listAttachInDoc(int docId) {
		String hql = "from Attachment at where at.document.id = ?";
		return attachmentDao.list(hql, docId);
	}

	public void addAtts(AttachmentDto adto, Message msg,String uploadPath) throws IOException {
		//保存用的临时附件对象
		Attachment att = null;
		//保存使用当前时间定义的新文件名
		List<String> newFileNames = new ArrayList<String>();
		//待保存文件的文件名
		String[] fileNames = adto.getFilesName();
		//待保存文件的文件类型
		String[] contentTypes = adto.getFilesContentType();
		
		//保存所有私信
		for (int i = 0 ; i < adto.getFiles().length ;i++) {
			att = new Attachment();
			att.setMessage(msg);
			att.setOldname(fileNames[i]);
			att.setNewname(String.valueOf(new Date().getTime()));
			att.setSize(adto.getFiles()[i].length());
			newFileNames.add(att.getNewname());
			att.setType(FilenameUtils.getExtension(fileNames[i]));
			att.setCredate(new Date());
			attachmentDao.add(att);
		}
		
		//上传附件
		FileUtil.uploadAttachments(adto, uploadPath, newFileNames);
		
	}
}
