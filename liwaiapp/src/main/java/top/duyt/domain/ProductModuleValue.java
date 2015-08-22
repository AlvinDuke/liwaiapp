package top.duyt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_pro_module_values")
public class ProductModuleValue {

	private int id;
	private int conkey;
	private String conval;

	public ProductModuleValue() {
		super();
	}

	public ProductModuleValue(int id, int conkey, String conval) {
		super();
		this.id = id;
		this.conkey = conkey;
		this.conval = conval;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConkey() {
		return conkey;
	}

	public void setConkey(int conkey) {
		this.conkey = conkey;
	}

	public String getConval() {
		return conval;
	}

	public void setConval(String conval) {
		this.conval = conval;
	}

}
