package scott.controller.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.base.web.BaseAction;
import com.base.util.HtmlUtil;
import com.base.entity.BaseEntity.DELETED;
import scott.entity.product.Product;
import scott.entity.product.Repertory;
import scott.page.product.ProductPage;
import scott.service.product.ProductService;
import scott.service.product.RepertoryService;
 
/**
 * 产品action
 * <br>
 * <b>功能：</b>ProductController<br>
 */ 
@Controller
@RequestMapping("/product") 
public class ProductController extends BaseAction{
	
	private final static Logger log= Logger.getLogger(ProductController.class);
	
	// Servrice start
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private ProductService<Product> productService; 
	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private RepertoryService<Repertory> repertoryService; 
	
	
	/**
	 * 
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list") 
	public ModelAndView  list(ProductPage page,HttpServletRequest request) throws Exception{
		Map<String,Object>  context = getRootMap();
		
		return forword("scott/product/product",context); 
	}
	
	
	/**
	 * ilook 首页
	 * @param url
	 * @param classifyId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/dataList") 
	public void  datalist(ProductPage page,HttpServletResponse response) throws Exception{
		List<Product> dataList = productService.queryByList(page);
//		for (Product product : dataList) {
//			System.out.println("url==="+product.getUrl());
//		}
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
	public void save(Product entity,Integer[] typeIds,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = new HashMap<String,Object>();
		if(entity.getId()== null||StringUtils.isBlank(entity.getId().toString())){
			productService.add(entity);
		}else{
			productService.update(entity);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	
	@RequestMapping("/getId")
	public void getId(String id,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = new HashMap<String, Object>();
		Product entity  = productService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", entity);
		HtmlUtil.writerJson(response, context);
	}
	
	@RequestMapping("/delete")
	public void delete(String[] id,HttpServletResponse response) throws Exception{
		productService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}
	
	/**
	 * 产品详细
	 * @throws Exception 
	 */
	@RequestMapping("/detail")
	public void getDetail(String id,HttpServletResponse response) throws Exception{
//		Map<String,Object>  context = new HashMap<String, Object>();
		Product entity  = productService.queryById(id);
		if(entity  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		Repertory repertory = repertoryService.getProductId(entity.getId());
		entity.setRepertory(repertory);
//		context.put(SUCCESS, true);
//		context.put("data", entity);
		List<Product> list = new ArrayList<Product>();
		list.add(entity);
		HtmlUtil.writerJson(response, list);
		
		
	}

}
