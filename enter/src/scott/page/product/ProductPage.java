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
	

		private String id;//   产品ID	private String productname;//   产品名称	private String productnumber;//   物品编号	private Double buyingprice;//   进货价格，单位人民币（￥）	private Double riseprice;//   起标价,单位美元（US$）	private Double sellprice;//   出售价格，单位美元（US$）	private Date saleendtime;//   拍卖结束时间	private Double publishprice;//   刊登费用	private String releaseuser;//   产品发布人账号	private  Date releasetime;//   产品发布时间	private  String updateuser;//   修改人账号	private  Date updatetime;//   修改时间	private  Integer deletemark;//   删除标记，0否，1是	private  Integer imagtype;//   图片类型，0标题小图片，1页面展示大图	private  Object images;//   产品标题小图图片	private  String imagespath;//   产品大图图片路径	private  String supplierid;//   供货商Id	private  Integer offsign;//   产品下架标记，0否，1是	private  String p_describe;//   产品描述	private  Integer sourcesign;//   数据来源标记，0是扫描邮箱，1是手动添加	private  String brand;//   商标，牌子	private  String features;//   产品特点，特征	private  String p_color;//   产品颜色	private  Double p_weight;//   产品重量（单位：克 K）	private  Double p_width;//   产品宽度（单位：毫米 mm）	private  Double p_height;//   产品高度（单位：毫米 mm）	private  Double p_length;//   产品长度（单位：毫米 mm）	private  String country;//   生产地址
	private String url;//产品URL 连接地址
	private String mailId;
	private String mailboxAccount;//发送者邮箱账号
		public  String getId() {
		return id;
	}
	public void setId( String id) {
		this.id = id;
	}
	public  String getProductname() {	    return this.productname;	}	public void setProductname( String productname) {	    this.productname=productname;	}	public  String getProductnumber() {	    return this.productnumber;	}	public void setProductnumber( String productnumber) {	    this.productnumber=productnumber;	}	public  Double getBuyingprice() {	    return this.buyingprice;	}	public void setBuyingprice( Double buyingprice) {	    this.buyingprice=buyingprice;	}	public  Double getRiseprice() {	    return this.riseprice;	}	public void setRiseprice( Double riseprice) {	    this.riseprice=riseprice;	}	public  Double getSellprice() {	    return this.sellprice;	}	public void setSellprice( Double sellprice) {	    this.sellprice=sellprice;	}	public  Date getSaleendtime() {	    return this.saleendtime;	}	public void setSaleendtime( Date saleendtime) {	    this.saleendtime=saleendtime;	}	public  Double getPublishprice() {	    return this.publishprice;	}	public void setPublishprice( Double publishprice) {	    this.publishprice=publishprice;	}	public  String getReleaseuser() {	    return this.releaseuser;	}	public void setReleaseuser( String releaseuser) {	    this.releaseuser=releaseuser;	}	public  Date getReleasetime() {	    return this.releasetime;	}	public void setReleasetime( Date releasetime) {	    this.releasetime=releasetime;	}	public  String getUpdateuser() {	    return this.updateuser;	}	public void setUpdateuser( String updateuser) {	    this.updateuser=updateuser;	}	public  Date getUpdatetime() {	    return this.updatetime;	}	public void setUpdatetime( Date updatetime) {	    this.updatetime=updatetime;	}	public  Integer getDeletemark() {	    return this.deletemark;	}	public void setDeletemark( Integer deletemark) {	    this.deletemark=deletemark;	}	public  Integer getImagtype() {	    return this.imagtype;	}	public void setImagtype( Integer imagtype) {	    this.imagtype=imagtype;	}	public  Object getImages() {	    return this.images;	}	public void setImages( Object images) {	    this.images=images;	}	public  String getImagespath() {	    return this.imagespath;	}	public void setImagespath( String imagespath) {	    this.imagespath=imagespath;	}	public  String getSupplierid() {	    return this.supplierid;	}	public void setSupplierid( String supplierid) {	    this.supplierid=supplierid;	}	public  Integer getOffsign() {	    return this.offsign;	}	public void setOffsign( Integer offsign) {	    this.offsign=offsign;	}		public  String getP_describe() {
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
	public  Integer getSourcesign() {	    return this.sourcesign;	}	public void setSourcesign( Integer sourcesign) {	    this.sourcesign=sourcesign;	}	public  String getBrand() {	    return this.brand;	}	public void setBrand( String brand) {	    this.brand=brand;	}	public  String getFeatures() {	    return this.features;	}	public void setFeatures( String features) {	    this.features=features;	}		public  String getCountry() {	    return this.country;	}	public void setCountry( String country) {	    this.country=country;	}
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
