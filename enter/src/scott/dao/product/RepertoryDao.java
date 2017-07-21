package scott.dao.product;


import scott.entity.product.Repertory;

import com.base.dao.BaseDao;
/**
 * 
 * <br>
 * <b>功能：</b>RepertoryDao<br>
 * <b>作者：</b>www.jeecg.org<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 * <b>版权所有：<b>版权所有(C) 2013，www.jeecg.org<br>
 */
public interface RepertoryDao<T> extends BaseDao<T> {
	/**
	 * 根据产品编号查询
	 * @return
	 */
	public Repertory getProductId(String productId);
}
