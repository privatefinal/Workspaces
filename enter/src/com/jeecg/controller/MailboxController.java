package com.jeecg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import scott.entity.product.Product;
import scott.service.product.ProductService;

import com.base.util.HtmlUtil;
import com.base.util.MyBase64;
import com.base.util.ThreadPool;
import com.base.web.BaseAction;
import com.jeecg.entity.Mailbox;
import com.jeecg.mail.MailThread;
import com.jeecg.mail.MyMailTimer;
import com.jeecg.page.MailboxPage;
import com.jeecg.service.MailboxService;
 
/**
 * 邮箱管理
 * <br>
 * <b>功能：</b>MailboxController<br>
 */ 
@Controller
@RequestMapping("/mailbox") 
public class MailboxController extends BaseAction{
	
	private final static Logger log= Logger.getLogger(MailboxController.class);
	
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private MailboxService<Mailbox> mailboxService;
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private ProductService<Product> productService ;
	/**
	 * 初始化页面
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(MailboxPage page,HttpServletRequest request) throws Exception{
		Map<String,Object>  context = getRootMap();
		return forword("sys/mailbox",context); 
	}
	/**
	 * ilook 首页 获取数据列表
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(MailboxPage page,HttpServletResponse response) throws Exception{
		List<Mailbox> dataList = mailboxService.queryByList(page);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",page.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 添加或修改数据
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	public void save(Mailbox entity,HttpServletResponse response,HttpServletRequest request) throws Exception{
		Map<String,Object>  context = new HashMap<String,Object>();
		String pass = (entity.getMailpassword() == null || "".equals(entity.getMailpassword().trim())) ? null : MyBase64.getBase64(entity.getMailpassword().trim());
		entity.setMailpassword(pass);
		String licen = (entity.getMaillicense() == null || "".equals(entity.getMaillicense().trim())) ? null : MyBase64.getBase64(entity.getMaillicense().trim());
		entity.setMaillicense(licen);
		if(entity.getId()== null || StringUtils.isBlank(entity.getId().toString())){
			entity.setStatesign(0);
			entity.setAdduser(getUser(request).getEmail());
			entity.setAdddate(new Date());
			entity.setDeletesign(0);
			mailboxService.add(entity);
		}else{
			entity.setUpdatetime(new Date());
			entity.setUpdateuser(getUser(request).getEmail());
			mailboxService.updateBySelective(entity);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	
	@RequestMapping("/getId")
	public void getId(String id,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = new HashMap();
		Mailbox entity  = mailboxService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		HtmlUtil.writerJson(response, context);
	}
	
	
	/**
	 * 物理删除，不可恢复
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(String[] id,HttpServletResponse response) throws Exception{
		mailboxService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
/**
 * 逻辑删除，恢复
 * @param id
 * @param response
 * @throws Exception
 */
	@RequestMapping("/deleteUndo")
	public void deleteUndo(Mailbox entity,HttpServletResponse response) throws Exception{
//		System.out.println("id=="+id+",deletesign=="+deletesign+",statesign="+statesign);
		mailboxService.deleteUndo(entity);
		if(entity.getDeletesign() != null){
			if(entity.getDeletesign() == 1){
				sendSuccessMessage(response, "删除成功");
			}else if(entity.getDeletesign() == 0){
				sendSuccessMessage(response, "恢复成功");
			}
		}else if(entity.getStatesign() != null){
			if(entity.getStatesign() == 1){
				
			}else if(entity.getStatesign() == 0){
				
			}
		}
	}
	/**
	 * 启动读邮箱任务
	 * @param checked
	 * @param response
	 */
	@RequestMapping("/startmail")
	 public void startTimeMail(Mailbox entity,HttpServletResponse response){
		 	Map<String,Object>  context = getRootMap();
//		 	System.out.println("checked==="+checked);
			if(entity.getStatesign() != null && entity.getStatesign() == 1){
				log.warn("定时器开始启动...");
				MailThread mt = new MailThread(productService,entity);
				ThreadPool.addTaskToQueue(mt);//加入线程池
				log.warn("邮件扫描启动成功,"+entity.getMailaccount());
			}else if(entity.getStatesign() != null && entity.getStatesign() == 0){
				if(ThreadPool.threadMap != null && ThreadPool.threadMap.get(entity.getId()) != null && ThreadPool.timerMap != null && ThreadPool.timerMap.get(entity.getId()) != null){
					ThreadPool.threadMap.get(entity.getId()).interrupt() ;//关闭线程
					 System.out.println("定时任务销毁............................");  
				        //终止此计时器，丢弃所有当前已安排的任务。(不但结束当前schedule，连整个Timer的线程(即当前的定时任务)都会结束掉)  
					 	ThreadPool.timerMap.get(entity.getId()).cancel();  
					 	log.warn("邮件扫描定时任务销毁成功,"+entity.getMailaccount());
				}
			}
			//修改表状态 
			mailboxService.deleteUndo(entity);
			sendSuccessMessage(response,"操作成功");
	 }
	
}
