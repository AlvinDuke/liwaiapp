package top.duyt.service;

import java.io.IOException;

import top.duyt.domain.Document;
import top.duyt.dto.AttachmentDto;
import top.duyt.util.Pager;

public interface IDocumentService {
	
	/**
	 * ��һ�鲿�����һ��������Ϣ
	 * @param doc Ҫ����Ĺ��Ķ���
	 * @param depids ���͵Ĳ���ID
	 * @param adto nullΪû�и���
	 * @return
	 * @throws IOException 
	 */
	public int add(Document doc,Integer[] depids,AttachmentDto adto) throws IOException;
	
	/**
	 * ɾ��һ��ָ���Ĺ���
	 * @param docId
	 * @param depId
	 */
	public void delete(int docId,int depId);
	
	/**
	 * ����ָ�����Ķ�������Ϊ�Ѷ�
	 * @param docId
	 * @return
	 */
	public Document updateReadStateAndReturn(int docId);
	
	/**
	 * �����û��ѽ��յĹ���
	 * @param uid �û�ID
	 * @param param ��ѯ����
	 * @param isRead 1:�Ѷ���0:δ��,null:ȫ��ѯ
	 * @return
	 */
	public Pager<Document> findDocByUid(int uid,String param,Integer isRead);
	
	/**
	 * ��ѯ�û��ѷ��͵Ĺ���
	 * @param uid
	 * @param param
	 * @return
	 */
	public Pager<Document> findSendDocByUid(int uid,String param);
	
	/**
	 * ��ѯ�����ѷ��͵Ĺ���
	 * @param did
	 * @param param
	 * @return
	 */
	public Pager<Document> findSendDocByDid(int did,String param);

}
