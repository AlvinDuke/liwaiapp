package top.duyt.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.duyt.domain.Product;
import top.duyt.dto.ProInfoDto;
import top.duyt.service.IProService;

@Controller("prosAction")
@Scope("prototype")
@SuppressWarnings("rawtypes")
public class ProsAction extends BaseAction{

	private static final long serialVersionUID = -7984618464553290487L;

	private Product pro;
	
	@Resource
	private IProService proService;
	
	public Map responseJson;  
    public Map getResponseJson() {  
        return responseJson;  
    }  
    public void setResponseJson(Map responseJson) {  
        this.responseJson = responseJson;  
    }  
	
	public String proinfo(){
		/*pro = proService.get(pro.getId());
		JSONObject jb = new JSONObject(pro);*/
			Map<String, Object> map = new HashMap<String, Object>();  
	        /*List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
	        for(int i=0;i<3;i++){  
	            Map<String, Object> m = new HashMap<String, Object>();  
	            m.put("id", i);  
	            m.put("nameÉµ¹þ¹þ", "Mic"+i);  
	            list.add(m);  
	        }  
	        map.put("rows", list);  
	        map.put("totalCont", 3);*/  
	         
			
	        ProInfoDto dto = proService.loadProInfo(pro.getId());
	        map.put("proinfo", dto);
	        this.setResponseJson(map);
	        return "json";
	}

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}
	
}
