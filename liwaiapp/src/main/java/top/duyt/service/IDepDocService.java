package top.duyt.service;


import top.duyt.domain.DepDoc;
import top.duyt.util.Pager;

public interface IDepDocService {
	
	/**
	 * ��ȡָ�����ŵ��ѷ��͹���
	 * @param depId
	 * @param param
	 * @return
	 */
	public Pager<DepDoc> findSendDocByDepId(int depId,String param);

}
