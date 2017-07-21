package scott.entity.product;

import com.base.entity.BaseEntity;
import java.util.Date;
/**
 * 库存
 */
public class Repertory extends BaseEntity {
	
		private String id;//   库存ID	private String productid;//   产品ID	private Integer productcount;//   库存总数	private Integer workoffcount;//   售出总数	private Integer surpluscount;//   库存剩余总数	private String adduser;//   添加人账号	private Date addtime;//   添加时间	private String lastupdateuser;//   最后修改人账号	private Date lastupdatetime;//   最后修改时间
	private Integer offsign;//   产品下架标记，0否，1是	private Integer deletesign;//   删除标记，0否，1是
	
	public Integer getOffsign() {
	    return this.offsign;
	}
	public void setOffsign(Integer offsign) {
	    this.offsign=offsign;
	}
		public String getId() {	    return this.id;	}	public void setId(String id) {	    this.id=id;	}	public String getProductid() {	    return this.productid;	}	public void setProductid(String productid) {	    this.productid=productid;	}	public Integer getProductcount() {	    return this.productcount;	}	public void setProductcount(Integer productcount) {	    this.productcount=productcount;	}	public Integer getWorkoffcount() {	    return this.workoffcount;	}	public void setWorkoffcount(Integer workoffcount) {	    this.workoffcount=workoffcount;	}	public Integer getSurpluscount() {	    return this.surpluscount;	}	public void setSurpluscount(Integer surpluscount) {	    this.surpluscount=surpluscount;	}	public String getAdduser() {	    return this.adduser;	}	public void setAdduser(String adduser) {	    this.adduser=adduser;	}	public Date getAddtime() {	    return this.addtime;	}	public void setAddtime(Date addtime) {	    this.addtime=addtime;	}	public String getLastupdateuser() {	    return this.lastupdateuser;	}	public void setLastupdateuser(String lastupdateuser) {	    this.lastupdateuser=lastupdateuser;	}	public Date getLastupdatetime() {	    return this.lastupdatetime;	}	public void setLastupdatetime(Date lastupdatetime) {	    this.lastupdatetime=lastupdatetime;	}	public Integer getDeletesign() {	    return this.deletesign;	}	public void setDeletesign(Integer deletesign) {	    this.deletesign=deletesign;	}
}

