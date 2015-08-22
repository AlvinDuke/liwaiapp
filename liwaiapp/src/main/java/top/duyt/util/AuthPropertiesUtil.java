package top.duyt.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class AuthPropertiesUtil {
	
	private static Properties properties;
	
	public static List<String> getAuth(String authType) throws IOException{
		
		if (properties == null) {
			properties = new Properties();
			properties.load(AuthPropertiesUtil.class.getClassLoader().getResourceAsStream("auth.properties"));
			return Arrays.asList(properties.get(authType).toString().split(","));
		}
		return Arrays.asList(properties.get(authType).toString().split(","));
	}
}
