package scott.page.product;

import java.util.Date;

import com.base.page.BasePage;

/**
 * 
 * <br>
 * <b>功能：</b>ProductPage<br>
 * <b>作者：</b>www.jeecg.org<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 * <b>版权所有：<b>版权所有(C) 2013，www.jeecg.org<br>
 */
public class ProductPage extends BasePage {
	

	
	private String url;//产品URL 连接地址
	private String mailId;
	private String mailboxAccount;//发送者邮箱账号
	
		return id;
	}
	public void setId( String id) {
		this.id = id;
	}
	public  String getProductname() {
		return p_describe;
	}
	public void setP_describe( String pDescribe) {
		p_describe = pDescribe;
	}
	public  String getP_color() {
		return p_color;
	}
	public void setP_color( String pColor) {
		p_color = pColor;
	}
	public  Double getP_weight() {
		return p_weight;
	}
	public void setP_weight( Double pWeight) {
		p_weight = pWeight;
	}
	public  Double getP_width() {
		return p_width;
	}
	public void setP_width( Double pWidth) {
		p_width = pWidth;
	}
	public  Double getP_height() {
		return p_height;
	}
	public void setP_height( Double pHeight) {
		p_height = pHeight;
	}
	public  Double getP_length() {
		return p_length;
	}
	public void setP_length( Double pLength) {
		p_length = pLength;
	}
	public  Integer getSourcesign() {
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getMailboxAccount() {
		return mailboxAccount;
	}
	public void setMailboxAccount(String mailboxAccount) {
		this.mailboxAccount = mailboxAccount;
	}
	
}