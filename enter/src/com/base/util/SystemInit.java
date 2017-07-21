package com.base.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class SystemInit implements ServletContextListener{
	private final static Logger log = Logger.getLogger(SystemInit.class);
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		/**
		 * 项目启动时初始化线程池参数
		 * @author ZhuanGe
		 *
		 */
		try {
			log.warn("线程池初始化启动");
			ThreadPool.ThreadPoolInit();
		} catch (Exception e) {
			log.error("线程池初始化错误");
			e.printStackTrace();
		}
	}

}
