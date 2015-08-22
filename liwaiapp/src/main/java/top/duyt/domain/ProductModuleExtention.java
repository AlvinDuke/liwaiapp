package top.duyt.domain;

import top.duyt.domain.ProductModule;

public class ProductModuleExtention extends ProductModule {

	private String sizeValue;
	private String colourValue;

	public ProductModuleExtention() {
		super();
	}

	public ProductModuleExtention(int id, int pid, int sizeKey, int colourKey,
			int stock, int sales, int retailPrice, int purchasePrice,
			String sizeValue, String colourValue) {
		super(id, pid, sizeKey, colourKey, stock, sales, retailPrice,
				purchasePrice);
		this.sizeValue = sizeValue;
		this.colourValue = colourValue;
	}

	public String getSizeValue() {
		return sizeValue;
	}

	public void setSizeValue(String sizeValue) {
		this.sizeValue = sizeValue;
	}

	public String getColourValue() {
		return colourValue;
	}

	public void setColourValue(String colourValue) {
		this.colourValue = colourValue;
	}

}
