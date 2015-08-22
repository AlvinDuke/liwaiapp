package top.duyt.service;

import java.io.IOException;
import java.util.List;

import top.duyt.domain.Attachment;
import top.duyt.domain.Message;
import top.duyt.dto.AttachmentDto;

public interface IAttachmentService {
	
	/**
	 * ����һ������
	 * @param att ��������
	 * @return
	 */
	public int add(Attachment att);
	
	/**
	 * ���һ�鸽��
	 * @param adto ���������������
	 * @param msg ������Ϣ
	 * @param uploadPath �ϴ�·��,����"c:/XXX/XXX"
	 * @throws IOException
	 */
	public void addAtts(AttachmentDto adto,Message msg,String uploadPath) throws IOException;
	
	/**
	 * ɾ��һ����������
	 * @param attId
	 */
	public void delete(int attId);
	
	/**
	 * ��ѯĳ��˽�Ű��������и���
	 * @param msgId ˽��ID
	 * @return
	 */
	public List<Attachment> listAttachInMsg(int msgId);
	
	/**
	 * ��ѯĳ�����İ��������и���
	 * @param docId ����ID
	 * @return
	 */
	public List<Attachment> listAttachInDoc(int docId);

	
	

}
