package scott.dao.product;


import scott.entity.product.Product;

import com.base.dao.BaseDao;
/**
 * @author ZhuanGe
 *
 * @param <T>
 */
public interface ProductDao<T> extends BaseDao<T> {
	/**
	 * 根据物品编号查询
	 * @return
	 */
	public Product getProductNumberId(String productNumber);
}
