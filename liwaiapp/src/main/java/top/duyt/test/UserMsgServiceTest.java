package top.duyt.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.duyt.domain.Message;
import top.duyt.domain.User;
import top.duyt.domain.UserMsg;
import top.duyt.service.IUserMsgService;
import top.duyt.service.IUserService;
import top.duyt.util.Pager;
import top.duyt.util.SystemContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class UserMsgServiceTest {

	@Resource
	private IUserMsgService userMsgService;
	
	@Resource
	private IUserService userService;
	
	@Test
	public void test01(){
		
		Message msg = new Message();
		msg.setTitle("duyt great TILTE");
		msg.setContent("duyt great CONTENT");
		msg.setCredate(new Date());
		
		User u = new User();
		u.setId(6);
		msg.setUser(u);
		userMsgService.addMsg(msg, new Integer[]{11,12});		
		
	}
	
	@Test
	public void test02(){
		userMsgService.deleteReceivedMsg(11, 9);
	}
	
	@Test
	public void test03(){
		userMsgService.deleteSendedMsg(10);
	}
	
	@Test
	public void test04(){
		SystemContext.setPageSize(15);
		SystemContext.setPageOffset(0);
		Pager<Message> msgs = userMsgService.findReceivedMsg(12, 0, "");
		System.out.println(msgs.getDatas().size());
	}
	
	@Test
	public void test05(){
		SystemContext.setPageSize(15);
		SystemContext.setPageOffset(0);
		Pager<UserMsg> msgs = userMsgService.findSendedMsg(6, "");
		System.out.println(msgs.getDatas().size());
	}
	
	@Test
	public void test06(){
		List<User> receivers =  userService.listReceiversByCurUid(12);
		System.out.println(receivers.size());
	}

}
