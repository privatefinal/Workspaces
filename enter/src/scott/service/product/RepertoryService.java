package scott.service.product;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import scott.dao.product.RepertoryDao;
import scott.entity.product.Repertory;

/**
 * 
 * <br>
 * <b>功能：</b>RepertoryService<br>
 * <b>作者：</b>www.jeecg.org<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 * <b>版权所有：<b>版权所有(C) 2013，www.jeecg.org<br>
 */
@Service("repertoryService")
public class RepertoryService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(RepertoryService.class);
	
	/**
	 * 根据产品编号查询
	 * @return
	 */
	public Repertory getProductId(String productId){
		return getDao().getProductId(productId);
	}

	@Autowired
    private RepertoryDao<T> dao;

		
	public RepertoryDao<T> getDao() {
		return dao;
	}

}
