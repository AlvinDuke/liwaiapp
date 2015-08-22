package top.duyt.service;

import java.io.IOException;

import top.duyt.domain.Document;
import top.duyt.dto.AttachmentDto;
import top.duyt.util.Pager;

public interface IDocumentService {
	
	/**
	 * 给一组部门添加一个公文信息
	 * @param doc 要保存的公文对象
	 * @param depids 发送的部门ID
	 * @param adto null为没有附件
	 * @return
	 * @throws IOException 
	 */
	public int add(Document doc,Integer[] depids,AttachmentDto adto) throws IOException;
	
	/**
	 * 删除一个指定的公文
	 * @param docId
	 * @param depId
	 */
	public void delete(int docId,int depId);
	
	/**
	 * 查找指定公文对象并设置为已读
	 * @param docId
	 * @return
	 */
	public Document updateReadStateAndReturn(int docId);
	
	/**
	 * 查找用户已接收的公文
	 * @param uid 用户ID
	 * @param param 查询条件
	 * @param isRead 1:已读，0:未读,null:全查询
	 * @return
	 */
	public Pager<Document> findDocByUid(int uid,String param,Integer isRead);
	
	/**
	 * 查询用户已发送的公文
	 * @param uid
	 * @param param
	 * @return
	 */
	public Pager<Document> findSendDocByUid(int uid,String param);
	
	/**
	 * 查询部门已发送的公文
	 * @param did
	 * @param param
	 * @return
	 */
	public Pager<Document> findSendDocByDid(int did,String param);

}
