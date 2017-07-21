package scott.controller.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import scott.entity.product.Product;
import scott.page.product.ProductPage;
import scott.service.product.ProductService;

import com.base.util.HtmlUtil;
import com.base.util.StringUtil;
import com.base.web.BaseAction;
import com.jeecg.mail.MyMailTimer;

@Controller
@RequestMapping("/mail")
public class StartMailController extends BaseAction{
	private final static Logger log = Logger.getLogger(StartMailController.class);
	 @Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	 private ProductService<Product> productService ;
	 
	 @RequestMapping("/startmailhtml")
	 public ModelAndView mailHtml(ProductPage model,HttpServletRequest request){
		 Map<String,Object>  context = getRootMap();
		 return forword("mail/start_mail",context); 
	 }
	 @RequestMapping("/startmail")
	 public void startTimeMail(Boolean checked,HttpServletResponse response){
		 	Map<String,Object>  context = getRootMap();
		 	System.out.println("checked==="+checked);
			if(checked){
				log.warn("定时器开始启动...");
				MyMailTimer mm  =new MyMailTimer();
//				mm.staerTimer(productService);
				context.put(SUCCESS, true);	
			}
			HtmlUtil.writerJson(response, context);
	 }
	 	
}
