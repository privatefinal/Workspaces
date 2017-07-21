package com.jeecg.dao;


import com.base.dao.BaseDao;
import com.jeecg.entity.Mailbox;
/**
 * 邮箱管理
 * <br>
 * <b>功能：</b>MailboxDao<br>
 */
public interface MailboxDao<T> extends BaseDao<T> {
	/**
	 * 修改不为空的字段
	 */
	public void updateBySelective(Mailbox mailbox);
	/**
	 * 可恢复的删除
	 * @param id
	 */
	public void deleteUndo(Mailbox mailbox);
}
