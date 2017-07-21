package com.jeecg.page;

import com.base.page.BasePage;
import java.math.BigDecimal;

/**
 * 邮箱管理
 * <br>
 * <b>功能：</b>MailboxPage<br>
 */
public class MailboxPage extends BasePage {
	

	
	private String host;//邮箱服务器地址
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
}