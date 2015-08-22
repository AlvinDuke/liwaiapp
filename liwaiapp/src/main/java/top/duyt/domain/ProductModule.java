package top.duyt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_pro_module")
public class ProductModule {

	private int id;
	private int pid;
	private int sizekey;
	private int colourkey;
	private int stock;
	private int sales;
	private int retailprice;
	private int purchaseprice;

	public ProductModule() {
		super();
	}

	public ProductModule(int id, int pid, int sizekey, int colourkey,
			int stock, int sales, int retailprice, int purchaseprice) {
		super();
		this.id = id;
		this.pid = pid;
		this.sizekey = sizekey;
		this.colourkey = colourkey;
		this.stock = stock;
		this.sales = sales;
		this.retailprice = retailprice;
		this.purchaseprice = purchaseprice;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getSizekey() {
		return sizekey;
	}

	public void setSizekey(int sizekey) {
		this.sizekey = sizekey;
	}

	public int getColourkey() {
		return colourkey;
	}

	public void setColourkey(int colourkey) {
		this.colourkey = colourkey;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getRetailprice() {
		return retailprice;
	}

	public void setRetailprice(int retailprice) {
		this.retailprice = retailprice;
	}

	public int getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(int purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

}
