package top.duyt.util;

public class ActionUtil {
	
	public static final String REDIRECT = "redirect";
	
	/**
	 * ∑«ø’—È÷§
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj){
		if (obj == null) {
			return true;
		}
		else{
			if ("".equals(obj.toString())) {
				return true;
			}
			return false;
		}
	}

}
