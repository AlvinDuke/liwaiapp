package top.duyt.service;


import top.duyt.domain.DepDoc;
import top.duyt.util.Pager;

public interface IDepDocService {
	
	/**
	 * 获取指定部门的已发送公文
	 * @param depId
	 * @param param
	 * @return
	 */
	public Pager<DepDoc> findSendDocByDepId(int depId,String param);

}
