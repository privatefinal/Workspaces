package com.jeecg.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;
import com.jeecg.dao.MailboxDao;
import com.jeecg.entity.Mailbox;

/**
 * 邮箱管理
 * <br>
 * <b>功能：</b>MailboxService<br>
 */
@Service("mailboxService")
public class MailboxService<T> extends BaseService<T> {
	private final static Logger log= Logger.getLogger(MailboxService.class);
	
	/**
	 * 修改不为空的字段
	 */
	public void updateBySelective(Mailbox mailbox){
		dao.updateBySelective(mailbox);
	}

	public void deleteUndo(Mailbox entity){
		dao.deleteUndo(entity);
	}
	
	@Autowired
    private MailboxDao<T> dao;

		
	public MailboxDao<T> getDao() {
		return dao;
	}

}
