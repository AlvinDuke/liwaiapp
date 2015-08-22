package top.duyt.test;

import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.duyt.domain.User;
import top.duyt.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestUser {
	Random ran = new Random();
	
	@Resource(name="userService")
	private IUserService userService;
	

	@Test
	public void initUser() {
		int[] depIds = {1,2,3,4,5,6};
		for(int i=0;i<100;i++) {
			User u = new User();
			u.setEmail("user"+i+"@duyt.com");
			u.setNickname(getName());
			u.setUsername("user"+i);
			u.setPassword("123");
			userService.add(u, depIds[ran.nextInt(depIds.length)]);
		}
	}
	
	private String getName() {
		String[] name1 = new String[]{"��","��","Ҷ","��","Ҷ��","����",
				"����","��","��","ţ","�ĺ�","��","���","��","ĸ","��","��",
				"����","��","��","��","��־","����","��","��","��","��"};
		
		String[] name2 = new String[]{"��","��","ӱ","ҳ","Դ","��",
				"��","�","��","��","��","��","��","�","��","��","��",
				"��","��","��","��","��","��","��","��","��","��","��","��","��"};
		
		String[] name3 = new String[]{"��","��","��","��","��","ΰ",
				"Ψ","��","��","ڹ","��","��","��","��","��","��","��",
				"ΰ","��","��","��","��","��","��","��","��"};
		
		boolean two = ran.nextInt(50)>=45?false:true;
		if(two) {
			String n1 = name1[ran.nextInt(name1.length)];
			String n2;
			int n = ran.nextInt(10);
			if(n>5) {
				n2 = name2[ran.nextInt(name2.length)];
			} else {
				n2 = name3[ran.nextInt(name3.length)];
			}
			return n1+n2;
		} else {
			String n1 = name1[ran.nextInt(name1.length)];
			String n2 = name2[ran.nextInt(name2.length)];
			String n3 = name3[ran.nextInt(name3.length)];
			return n1+n2+n3;
		}
	}
	
	
}
