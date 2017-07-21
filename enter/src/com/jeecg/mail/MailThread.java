package com.jeecg.mail;

import com.base.util.ThreadPool;
import com.jeecg.entity.Mailbox;

import scott.entity.product.Product;
import scott.service.product.ProductService;

public class MailThread implements Runnable{
	private ProductService<Product> productService ;
	private Mailbox entity;
	
	public MailThread(){
		
	}
	
   public MailThread(ProductService<Product> productService,Mailbox entity){
	    this.entity = entity;
		this.productService = productService;
	}
	
	public void run() {
		MyMailTimer mm  =new MyMailTimer();
		mm.staerTimer(productService,entity);
		ThreadPool.threadMap.put(entity.getId(),Thread.currentThread());
	}

}
