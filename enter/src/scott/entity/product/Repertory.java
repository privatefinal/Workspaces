package scott.entity.product;

import com.base.entity.BaseEntity;
import java.util.Date;
/**
 * 库存
 */
public class Repertory extends BaseEntity {
	
	
	private Integer offsign;//   产品下架标记，0否，1是
	
	public Integer getOffsign() {
	    return this.offsign;
	}
	public void setOffsign(Integer offsign) {
	    this.offsign=offsign;
	}
	
}
