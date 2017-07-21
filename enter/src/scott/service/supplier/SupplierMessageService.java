package scott.service.supplier;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import scott.dao.supplier.SupplierMessageDao;

/**
 * 
 * <br>
 * <b>功能：</b>SupplierMessageService<br>
 * <b>作者：</b>www.jeecg.org<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 * <b>版权所有：<b>版权所有(C) 2013，www.jeecg.org<br>
 */
@Service("supplierMessageService")
public class SupplierMessageService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(SupplierMessageService.class);
	

	

	@Autowired
    private SupplierMessageDao<T> dao;

		
	public SupplierMessageDao<T> getDao() {
		return dao;
	}

}
