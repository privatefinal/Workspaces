package scott.page.product;

import com.base.page.BasePage;
import java.math.BigDecimal;

/**
 * 
 * <br>
 * <b>功能：</b>RepertoryPage<br>
 * <b>作者：</b>www.jeecg.org<br>
 * <b>日期：</b> Feb 2, 2013 <br>
 * <b>版权所有：<b>版权所有(C) 2013，www.jeecg.org<br>
 */
public class RepertoryPage extends BasePage {
		private java.lang.String id;//   库存ID	private java.lang.String productid;//   产品ID	private java.lang.Integer productcount;//   库存总数	private java.lang.Integer workoffcount;//   售出总数	private java.lang.Integer surpluscount;//   库存剩余总数	private java.lang.String adduser;//   添加人账号	private java.util.Date addtime;//   添加时间	private java.lang.String lastupdateuser;//   最后修改人账号	private java.util.Date lastupdatetime;//   最后修改时间	private java.lang.Integer deletesign;//   删除标记，0否，1是
	
		public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.String getProductid() {	    return this.productid;	}	public void setProductid(java.lang.String productid) {	    this.productid=productid;	}	public java.lang.Integer getProductcount() {	    return this.productcount;	}	public void setProductcount(java.lang.Integer productcount) {	    this.productcount=productcount;	}	public java.lang.Integer getWorkoffcount() {	    return this.workoffcount;	}	public void setWorkoffcount(java.lang.Integer workoffcount) {	    this.workoffcount=workoffcount;	}	public java.lang.Integer getSurpluscount() {	    return this.surpluscount;	}	public void setSurpluscount(java.lang.Integer surpluscount) {	    this.surpluscount=surpluscount;	}	public java.lang.String getAdduser() {	    return this.adduser;	}	public void setAdduser(java.lang.String adduser) {	    this.adduser=adduser;	}	public java.util.Date getAddtime() {	    return this.addtime;	}	public void setAddtime(java.util.Date addtime) {	    this.addtime=addtime;	}	public java.lang.String getLastupdateuser() {	    return this.lastupdateuser;	}	public void setLastupdateuser(java.lang.String lastupdateuser) {	    this.lastupdateuser=lastupdateuser;	}	public java.util.Date getLastupdatetime() {	    return this.lastupdatetime;	}	public void setLastupdatetime(java.util.Date lastupdatetime) {	    this.lastupdatetime=lastupdatetime;	}	public java.lang.Integer getDeletesign() {	    return this.deletesign;	}	public void setDeletesign(java.lang.Integer deletesign) {	    this.deletesign=deletesign;	}
	
}
