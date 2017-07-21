package com.jeecg.mail;

import org.apache.log4j.Logger;

import scott.entity.product.Product;
import scott.service.product.ProductService;

import com.base.util.StringUtil;
import com.base.web.BaseAction;

public class ProductSaveMail extends BaseAction{
	
	private final static Logger log = Logger.getLogger(ProductSaveMail.class);
	private ProductService<Product> productService ;
       
	public ProductSaveMail() {
	}
	public ProductSaveMail(ProductService<Product> productService) {
		this.productService = productService;
	}
    public ProductService<Product> getProductService() {
		return productService;
	}

	public void setProductService(ProductService<Product> productService) {
		this.productService = productService;
	}
	
	public void save(Product product){
		try {
			if(StringUtil.isValid(product.getProductnumber())){
				Product pro = productService.getProductNumberId(product.getProductnumber());
				if(pro !=  null){
					System.out.println("======"+pro.getProductname());
				}else{
					productService.add(product);
					log.warn("产品数据="+product.getProductname()+",产品id="+product.getProductnumber());
				}
			}else{
				log.warn("产品数据为空Product");
			}
		} catch (Exception e) {
			log.error("保存数据失败");
			e.printStackTrace();
		}
	}
	
}
