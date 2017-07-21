package com.jeecg.entity;

import com.base.entity.BaseEntity;
import java.math.BigDecimal;
/**
 * 邮箱管理
 * <br>
 * <b>功能：</b>MailboxEntity<br>
 */
public class Mailbox extends BaseEntity {
	
		private java.lang.String id;//   主键Id	private java.lang.String mailaccount;//   邮箱账号	private java.lang.String mailpassword;//   邮箱登录密码	private java.lang.String maillicense;//   邮箱授权码	private java.lang.String adduser;//   添加人	private java.util.Date adddate;//   添加时间	private java.util.Date updatetime;//   修改时间	private java.lang.String updateuser;//   修改人	private java.lang.Integer deletesign;//   删除标记，0否，1是	private java.lang.Integer statesign;//   是否在扫描中，0否，1是
	private String host;//邮箱服务器地址
	
	public Mailbox(){
		
	}
		public java.lang.String getId() {	    return this.id;	}	public void setId(java.lang.String id) {	    this.id=id;	}	public java.lang.String getMailaccount() {	    return this.mailaccount;	}	public void setMailaccount(java.lang.String mailaccount) {	    this.mailaccount=mailaccount;	}	public java.lang.String getMailpassword() {	    return this.mailpassword;	}	public void setMailpassword(java.lang.String mailpassword) {	    this.mailpassword=mailpassword;	}	public java.lang.String getMaillicense() {	    return this.maillicense;	}	public void setMaillicense(java.lang.String maillicense) {	    this.maillicense=maillicense;	}	public java.lang.String getAdduser() {	    return this.adduser;	}	public void setAdduser(java.lang.String adduser) {	    this.adduser=adduser;	}	public java.util.Date getAdddate() {	    return this.adddate;	}	public void setAdddate(java.util.Date adddate) {	    this.adddate=adddate;	}	public java.util.Date getUpdatetime() {	    return this.updatetime;	}	public void setUpdatetime(java.util.Date updatetime) {	    this.updatetime=updatetime;	}	public java.lang.String getUpdateuser() {	    return this.updateuser;	}	public void setUpdateuser(java.lang.String updateuser) {	    this.updateuser=updateuser;	}	public java.lang.Integer getDeletesign() {	    return this.deletesign;	}	public void setDeletesign(java.lang.Integer deletesign) {	    this.deletesign=deletesign;	}	public java.lang.Integer getStatesign() {	    return this.statesign;	}	public void setStatesign(java.lang.Integer statesign) {	    this.statesign=statesign;	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
}

