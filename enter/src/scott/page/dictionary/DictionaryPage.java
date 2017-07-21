package scott.page.dictionary;

import com.base.page.BasePage;
import java.math.BigDecimal;

/**
 * 
 * <br>
 * <b>功能：</b>DictionaryPage<br>
 * <b>作者：</b>hufozhuan<br>
 */
public class DictionaryPage extends BasePage {
	

		private java.lang.Integer id;//   	private java.lang.String keyname;//   名称	private java.lang.String keyvalue;//   key对应的值	private java.sql.Timestamp create_time;//   创建时间	private java.lang.Integer delete_mark;//   删除标记，0表示未删除，1表示已删除	private java.lang.String grouptype;//   组别类型	public java.lang.Integer getId() {	    return this.id;	}	public void setId(java.lang.Integer id) {	    this.id=id;	}	public java.lang.String getKeyname() {	    return this.keyname;	}	public void setKeyname(java.lang.String keyname) {	    this.keyname=keyname;	}	public java.lang.String getKeyvalue() {	    return this.keyvalue;	}	public void setKeyvalue(java.lang.String keyvalue) {	    this.keyvalue=keyvalue;	}	public java.sql.Timestamp getCreate_time() {	    return this.create_time;	}	public void setCreate_time(java.sql.Timestamp create_time) {	    this.create_time=create_time;	}	public java.lang.Integer getDelete_mark() {	    return this.delete_mark;	}	public void setDelete_mark(java.lang.Integer delete_mark) {	    this.delete_mark=delete_mark;	}	public java.lang.String getGrouptype() {	    return this.grouptype;	}	public void setGrouptype(java.lang.String grouptype) {	    this.grouptype=grouptype;	}
	
}
