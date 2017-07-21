package scott.entity.product;

import com.base.entity.BaseEntity;
import java.util.Date;
/**
 * 产品
 */
public class Product extends BaseEntity {
	
	
	private String url;//产品URL 连接地址
	private String mailId;
	private String mailboxAccount;//发送者邮箱账号
	private Repertory repertory; //库存
	
	
	public Integer getOffsign() {
	    return this.offsign;
	}
	public void setOffsign(Integer offsign) {
	    this.offsign=offsign;
	}
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductname() {
		return p_describe;
	}
	public void setP_describe(String pDescribe) {
		p_describe = pDescribe;
	}
	public String getP_color() {
		return p_color;
	}
	public void setP_color(String pColor) {
		p_color = pColor;
	}
	public Double getP_weight() {
		return p_weight;
	}
	public void setP_weight(Double pWeight) {
		p_weight = pWeight;
	}
	public Double getP_width() {
		return p_width;
	}
	public void setP_width(Double pWidth) {
		p_width = pWidth;
	}
	public Double getP_height() {
		return p_height;
	}
	public void setP_height(Double pHeight) {
		p_height = pHeight;
	}
	public Double getP_length() {
		return p_length;
	}
	public void setP_length(Double pLength) {
		p_length = pLength;
	}
	public String getCountry() {
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
	public Repertory getRepertory() {
		return repertory;
	}
	public void setRepertory(Repertory repertory) {
		this.repertory = repertory;
	}
	
}
