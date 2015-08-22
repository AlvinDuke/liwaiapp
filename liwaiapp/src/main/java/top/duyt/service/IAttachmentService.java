package top.duyt.service;

import java.io.IOException;
import java.util.List;

import top.duyt.domain.Attachment;
import top.duyt.domain.Message;
import top.duyt.dto.AttachmentDto;

public interface IAttachmentService {
	
	/**
	 * 新增一个附件
	 * @param att 附件对象
	 * @return
	 */
	public int add(Attachment att);
	
	/**
	 * 添加一组附件
	 * @param adto 附件参数传输对象
	 * @param msg 所属信息
	 * @param uploadPath 上传路径,例如"c:/XXX/XXX"
	 * @throws IOException
	 */
	public void addAtts(AttachmentDto adto,Message msg,String uploadPath) throws IOException;
	
	/**
	 * 删除一个附件对象
	 * @param attId
	 */
	public void delete(int attId);
	
	/**
	 * 查询某个私信包含的所有附件
	 * @param msgId 私信ID
	 * @return
	 */
	public List<Attachment> listAttachInMsg(int msgId);
	
	/**
	 * 查询某个公文包含的所有附件
	 * @param docId 公文ID
	 * @return
	 */
	public List<Attachment> listAttachInDoc(int docId);

	
	

}
