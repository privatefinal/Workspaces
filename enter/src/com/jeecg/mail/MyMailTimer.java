package com.jeecg.mail;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import scott.entity.product.Product;
import scott.service.product.ProductService;


import com.base.util.FXMTool;
import com.base.util.ThreadPool;
import com.jeecg.entity.Mailbox;
/**
 * 扫描邮箱定时器
 * @author ZhuanGe
 *
 */
public class MyMailTimer extends TimerTask{
	private final static Logger log = Logger.getLogger(MyMailTimer.class);
	private ProductService<Product> productService;
	private Mailbox entity;
	
	public MyMailTimer(){
		
	}
	
	public MyMailTimer(ProductService<Product> productService, Mailbox entity){
		this.productService = productService;
		this.entity = entity;
	}
	
	@Override
	public void run() {
		log.warn("邮件读取服务开始启动...");
		ReadMail rm = new ReadMail();
		rm.setProductService(productService);
		rm.staerApp(entity);
		log.warn("邮件读取服务启动成功...");
	}
/**
 * 启动
 */
	public void staerTimer(ProductService<Product> productService,Mailbox entity){
		Timer timer = new Timer();
		ThreadPool.timerMap.put(entity.getId(), timer);
		MyMailTimer mytimer = new MyMailTimer(productService,entity);
		timer.scheduleAtFixedRate(mytimer, FXMTool.delay, 1000*60);
	}
	
	public static boolean destroyed(Mailbox entity){  
        System.out.println("定时任务销毁............................");  
        //终止此计时器，丢弃所有当前已安排的任务。(不但结束当前schedule，连整个Timer的线程(即当前的定时任务)都会结束掉)  
        ThreadPool.timerMap.get(entity.getId()).cancel();  
        return true;  
    }  
	
	public ProductService<Product> getProductService() {
		return productService;
	}
	
	public void setProductService(ProductService<Product> productService) {
		this.productService = productService;
	}
	
	public Mailbox getEntity() {
		return entity;
	}
	
	public void setEntity(Mailbox entity) {
		this.entity = entity;
	}
	 
}
