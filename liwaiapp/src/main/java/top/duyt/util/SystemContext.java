package top.duyt.util;

import top.duyt.domain.User;

public class SystemContext {
	
	private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
	private static ThreadLocal<String> uploadFilePath = new ThreadLocal<String>();
	private static ThreadLocal<User> loginUser = new ThreadLocal<User>();
	
	public static int getPageIndex(){
		return pageIndex.get();
	}
	
	public static void setPageIndex(int _pageIndex){
		pageIndex.set(_pageIndex);
	}
	
	public static void removePageIndex(){
		pageIndex.remove();
	}
	
	public static int getPageSize(){
		return pageSize.get();
	}
	
	public static void setPageSize(int _pageSize){
		pageSize.set(_pageSize);
	}
	
	public static void removePageSize(){
		pageSize.remove();
	}
	
	public static int getPageOffset(){
		return pageOffset.get();
	}
	
	public static void setPageOffset(int _pageOffset){
		pageOffset.set(_pageOffset);
	}
	
	public static void removePageOffset(){
		pageOffset.remove();
	}
	
	public static String getUploadFilePath(){
		return uploadFilePath.get();
	}
	
	public static void setUploadFilePath(String _uploadFilePath){
		uploadFilePath.set(_uploadFilePath);
	}
	
	public static void removeUploadFilePath(){
		uploadFilePath.remove();
	}
	
	public static User getLoginUser(){
		return loginUser.get();
	}
	
	public static void setLoginUser(User _loginUser){
		loginUser.set(_loginUser);
	}
	
	public static void removeloginUser(){
		loginUser.remove();
	}
	
}
