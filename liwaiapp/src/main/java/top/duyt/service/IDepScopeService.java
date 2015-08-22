package top.duyt.service;

import java.util.List;

import top.duyt.domain.DepScope;

public interface IDepScopeService {
	
	/**
	 * 基于对象添加一个部门间收发关系
	 * @param deps
	 * @return
	 */
	public int addDepScope(DepScope deps);
	
	/**
	 * 基于发送部门ID和接收部门ID创建一个部门间收发关系
	 * @param depid 发送部门
	 * @param scpDepId 接收部门
	 * @return
	 */
	public int addDepScope(int depid,int scpDepId);
	
	/**
	 * 基于发送部门ID和接收部门ID创建一组部门间收发关系
	 * @param depid 发送部门
	 * @param scpDepIds 一组接收部门
	 * @return 生效行数
	 */
	public int addDepScope(int depid,int[] scpDepIds);
	
	/**
	 * 更新指定发送部门的接收部门，基于最新的接收部门ID，接收部门已存在的会保留，不存在的会删除
	 * @param depid 发送部门
	 * @param scpDepIds 一组接收部门
	 * @return
	 */
	public int updateDepScope(int depid,int[] scpDepIds);
	
	/**
	 * 指定一个发送部门，解除该发送部门和其所有接收部门间的收发关系
	 * @param depid 发送部门ID
	 */
	public void deleteReceiveDepScope(int depid);
	
	/**
	 * 指定一个接收部门，解除该接收部门和所有部门的收发关系
	 * @param scpDepId 部门id
	 */
	public void deleteDepInDepScope(int scpDepId);
	
	
	/**
	 * 删除一个指定的收发部门关系
	 * @param depid 发送部门
	 * @param scpDepId 接收部门
	 */
	public void deleteDepScope(int depid,int scpDepId);
	
	/**
	 * 列表部门间所有的收发关系
	 * @return
	 */
	public List<DepScope> list();
	
	/**
	 * 列表出指定部门和其他部门间的收发关系
	 * @param depId 指定部门ID
	 * @return
	 */
	public List<DepScope> list(int depId);
	

}
