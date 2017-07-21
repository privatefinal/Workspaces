package com.jeecg.mail;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.base.util.FXMTool;
@Service
public class StartMail implements ApplicationListener<ContextRefreshedEvent> {
	private Resource resource;
	private final static Logger log = Logger.getLogger(StartMail.class);
	public void onApplicationEvent(ContextRefreshedEvent ev) {
		if(ev.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")){
			if(FXMTool.m == 0){
				log.warn("读取邮件配置文件...");
				ReadMailProperties.readProp(resource);
				log.warn("读取邮件配置文件成功...");
//				log.warn("定时器开始启动...");
//				new MyMailTimer().staerTimer();
				FXMTool.m =+ 1;
				
			}
		}
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
}
