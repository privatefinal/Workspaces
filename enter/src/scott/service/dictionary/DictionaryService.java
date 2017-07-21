package scott.service.dictionary;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import scott.dao.dictionary.DictionaryDao;

/**
 * 
 * <br>
 * <b>功能：</b>DictionaryService<br>
 * <b>作者：</b>hufozhuan<br>
 */
@Service("dictionaryService")
public class DictionaryService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(DictionaryService.class);
	

	

	@Autowired
    private DictionaryDao<T> dao;

		
	public DictionaryDao<T> getDao() {
		return dao;
	}

}
