package scott.service.product;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.jeecg.entity.SysMenu;

import scott.dao.product.ProductDao;
import scott.entity.product.Product;

/**
 * 
 * <br>
 * <b>功能：</b>ProductService<br>
 * 
 */
@Service("productService")
public class ProductService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(ProductService.class);
	@Autowired
    private ProductDao<T> dao;
		
	public ProductDao<T> getDao() {
		return dao;
	}
/**
 * 添加
 * @param product
 * @throws Exception
 */
	public void add(Product product) throws Exception {
		super.add((T)product);
	}
/**
 * 修改
 * @param product
 * @throws Exception
 */
	public void update(Product product) throws Exception {
		super.update((T)product);
	}

	public Product getProductNumberId(String productNumber){
		return getDao().getProductNumberId(productNumber);
	}

}
