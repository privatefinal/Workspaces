package com.jeecg.entity;

import com.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 邮箱管理
 * <br>
 * <b>功能：</b>MailboxEntity<br>
 */
public class Mailbox extends BaseEntity {
	
	
	private String host;//邮箱服务器地址
	
	public Mailbox(){
		
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
}
