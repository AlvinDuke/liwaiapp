package top.duyt.service;

import top.duyt.domain.Product;
import top.duyt.dto.ProInfoDto;

public interface IProService {
	
	public int add(Product p);
	public void delete(int pid);
	public void update(Product p);
	public Product load(int pid);
	public Product get(int pid);
	public ProInfoDto loadProInfo(int pid);
}
