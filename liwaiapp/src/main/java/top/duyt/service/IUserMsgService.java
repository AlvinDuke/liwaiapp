package top.duyt.service;


import top.duyt.domain.Message;
import top.duyt.domain.UserMsg;
import top.duyt.util.Pager;

public interface IUserMsgService {

	/**
	 * ����һ��Ҫ���͵���Ϣ
	 * @param msg ��Ϣ����
	 * @param targetUids Ŀ���û�
	 */
	public void addMsg(Message msg,Integer[] targetUids);
	
	/**
	 * ������ϢID���ռ���ID��ȡ�û���Ϣ��ϵ����
	 * @param mid ��ϢID
	 * @param recUid �����û���ID
	 * @return
	 */
	public UserMsg load(int mid,int recUid);
	
	/**
	 * ����ID�����û���Ϣ��ϵ����
	 * @param id
	 * @return
	 */
	public UserMsg load(int id);
	
	/**
	 * ����ĳ���û���Ϣ����
	 * @param um
	 */
	public void update(UserMsg um);
	
	/**
	 * ɾ��ĳ���û���ĳ��������Ϣ
	 * @param msgId
	 */
	public void deleteReceivedMsg(int uid,int msgId);
	
	/**
	 * ɾ��ָ����ĳ���û���Ϣ��ϵ����<br>
	 * ע��ͬһ��Ϣ����ͬʱ���͸�����û��������ǰɾ�����û���ϵ����Ϊ���һ�������һ��ɾ�����͵�Դ��Ϣ
	 * @param userMsgId �û���ϵ����ID
	 */
	public void deleteSendedMsg(int userMsgId);
	
	/**
	 * ��ȡĳ���û����Ѷ�/δ����Ϣ
	 * @param uid
	 * @param isRead ��Ϣ��ȡ״̬
	 * @param param ��Ϣ��������
	 * @return
	 */
	public Pager<Message> findReceivedMsg(int uid,int isRead,String param);
	
	/**
	 * ��ȡĳ���û����ѷ�����Ϣ
	 * @param uid
	 * @param param ��Ϣ��������
	 * @return
	 */
	public Pager<UserMsg> findSendedMsg(int uid,String param);
	
	
	
}
