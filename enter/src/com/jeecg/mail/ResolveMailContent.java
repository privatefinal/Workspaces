package com.jeecg.mail;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.log4j.Logger;

import com.base.util.DateUtil;
import com.jeecg.controller.SysMenuAction;

import scott.entity.product.Product;

/**
 * 解析邮件正文内容
 * @author ZhuanGe
 *
 */
public class ResolveMailContent {
	private final static Logger log= Logger.getLogger(ResolveMailContent.class);
	public Product resolve(String content){
		log.warn("解析邮件正文开始");
		Product mb = new Product();
		content = content.replace("\r\n", "#");
//		System.out.println("content==="+content);
		if(content != null && !"".equals(content.trim())){
			int dyIndex = content.indexOf("電郵參考編號");
			content = content.substring(0, dyIndex+45);
//			content = content.replaceAll("-", "");
			content = content.replaceAll("=", "");
//			content = content.replaceAll("\\s*", ""); 
//			System.out.println("content=="+content);
			
//			System.out.println("dyIndex=="+dyIndex);
			
			int wpIndex = content.indexOf("物品名稱");
			int wpbhIndex = content.indexOf("物品編號");
			int prcbhIndex = content.indexOf("起標價");
			int endDateiIndex = content.indexOf("結束時間");
			int kdfIndex = content.indexOf("刊登費");
			//邮件ID
			String dybh = content.substring(content.lastIndexOf("["),content.lastIndexOf("]")+1);
			//物品名称
			String wbmc = content.substring(wpIndex, wpbhIndex-1).trim();
			
			String wbmc2 = wbmc.substring(wbmc.indexOf("：")+1,wbmc.lastIndexOf("#")).trim();
//			System.out.println("wbmc==="+wbmc);
			
			
			String url = wbmc.substring(wbmc.lastIndexOf("#")+1,wbmc.length()).trim();
			try {
				url = URLDecoder.decode(url, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				log.error("邮件解读url出错");
				e.printStackTrace();
			}
			url = url.substring(url.lastIndexOf("http"),url.length());
			//物品編號
			String wpbh = content.substring(wpbhIndex, prcbhIndex-1);
			wpbh = wpbh.substring(wpbh.indexOf("：")+1,wpbh.length()).trim();
			//起標價
			String qbj = content.substring(prcbhIndex, endDateiIndex-1);
			qbj = qbj.substring(qbj.indexOf("$")+1,qbj.length()).trim();
			//刊登費
			String kdf = content.substring(kdfIndex, content.indexOf("#",kdfIndex)).trim();
			kdf = kdf.substring(kdf.indexOf("：")+1,kdf.length()).trim();
			//店铺帐号
			String eBayUrse = content.substring(content.indexOf("（")+1,content.indexOf("）"));
			//結束時間
			String endDate = content.substring(endDateiIndex, kdfIndex-1);
			endDate = endDate.substring(endDate.indexOf("：")+1,endDate.length()).trim();		
			
//			System.out.println("eBayUrse=="+eBayUrse);
//			System.out.println("dybh="+dybh);
//			System.out.println("wpbh="+wpbh);
//			System.out.println("wbmc="+wbmc2);
//			System.out.println("url=="+url);
//			System.out.println("qbj="+qbj);
//			System.out.println("endDate="+endDate);
//			System.out.println("kdf="+kdf);
//			System.out.println("==============eeeeeeeeeeee======================");
			mb.setReleaseuser(eBayUrse);
			mb.setSaleendtime(DateUtil.stringToDate(endDate, "yyyy-MM-dd hh24:mi:ss"));
			mb.setUrl(url);
			mb.setPublishprice(Double.parseDouble(kdf));
			mb.setProductname(wbmc2);
			mb.setProductnumber(wpbh);
			mb.setRiseprice(Double.parseDouble(qbj));
			mb.setMailId(dybh);
			log.warn("解析邮件正文完成");
			return mb;
		}
		log.warn("解析邮件正文为空");
		return null;
	}
	
	public static void main(String[] args) {
//		String str = "aa"+"\r\n"+"bbwefefbb ";
		String wbmc = "物品名稱：                  RGB Stage Laser Lights Magic Ball Party DJ Disco #Mini LED Lighting Voice-Control#http://rover.ebay.com/rover/0/e12000.m43.l1123/7?euidc6de709831ba4135bc7dc990ada14453&lochttp%3A%2F%2Fcgi.ebay.com%2Fws%2FeBayISAPI.dll%3FViewItem%26item%3D142167919197%26ssPageName%3DADME%3AL%3ALCA%3AUS%3A1123";
//		System.out.println("電郵參考編號：[#c6de709831ba4135bc7dc990ada14453#]#".length());
//		resolve(str);
		String url = wbmc.substring(wbmc.lastIndexOf("#")+1,wbmc.length()).trim();
		System.out.println(url);
//		"--==".replaceAll("-", "aa");
//		System.out.println("--==".replaceAll("-", "a"));
	}
	
}
