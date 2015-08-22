package top.duyt.dto;

import java.util.List;

import top.duyt.domain.Product;
import top.duyt.domain.ProductModuleExtention;

public class ProInfoDto {

	private Product pro;
	private List<ProductModuleExtention> moduleExtentions;

	public ProInfoDto() {
		super();
	}

	public ProInfoDto(Product pro, List<ProductModuleExtention> moduleExtentions) {
		super();
		this.pro = pro;
		this.moduleExtentions = moduleExtentions;
	}

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}

	public List<ProductModuleExtention> getModuleExtentions() {
		return moduleExtentions;
	}

	public void setModuleExtentions(
			List<ProductModuleExtention> moduleExtentions) {
		this.moduleExtentions = moduleExtentions;
	}

}
