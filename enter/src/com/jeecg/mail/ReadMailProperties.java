package com.jeecg.mail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;

/**
 * 读取邮箱配置文件
 * @author ZhuanGe
 *
 */
public class ReadMailProperties{
	private final static Logger log = Logger.getLogger(ReadMailProperties.class);
	public static void readProp(Resource resource){
		InputStream is = null;
		Properties prop = null;
		try {
			 prop = new Properties(); 
			 is = resource.getInputStream();
			 prop.load(is);
			 PropertiesBean.mailUser = prop.getProperty("mailuser");
			 PropertiesBean.mailPassword = prop.getProperty("mailpassword");
			 PropertiesBean.host = prop.getProperty("host");
			 PropertiesBean.saveAttachPath = prop.getProperty("saveAttachPath");
		} catch (FileNotFoundException e) {
			log.error("扫描邮件读取配置文件路径错误:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error("扫描邮件读取配置文件IO出错:"+e.getMessage());
			e.printStackTrace();
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					log.error("扫描邮件读取配置文件关闭流出错:"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
	}
	
//	public static void main(String[] args) {
//		 readProp();
//	}
}
