package top.duyt.test;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.duyt.domain.Document;
import top.duyt.domain.User;
import top.duyt.service.IDocumentService;
import top.duyt.util.SystemContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class DocumentServiceTest {

	@Resource
	private IDocumentService documentService;
	
	@Test
	public void test01() throws IOException{
		Document doc = new Document();
		User u = new User();
		u.setId(99);
		doc.setTitle("########");
		doc.setContent("%%%%%%%%%%%%%");
		doc.setUser(u);
		doc.setCredate(new Date());
		documentService.add(doc, new Integer[]{1,2,3}, null);
	}
	
	@Test
	public void test02() throws IOException{
		documentService.delete(4,1);
	}
	
	@Test
	public void test03() throws IOException{
		Document doc = documentService.updateReadStateAndReturn(4);
		System.out.println(doc);
	}
	
	@Test
	public void test04(){
		
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(0);
		
		documentService.findDocByUid(1, "", null);
		documentService.findDocByUid(1, "", 1);
		documentService.findDocByUid(1, "", 0);
	}
	
	
}
