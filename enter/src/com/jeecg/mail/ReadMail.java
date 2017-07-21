package com.jeecg.mail;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import scott.entity.product.Product;
import scott.service.product.ProductService;

import com.base.util.DateUtil;
import com.base.util.MyBase64;
import com.base.util.StringUtil;
import com.base.web.BaseAction;
import com.jeecg.entity.Mailbox;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
@Controller
public class ReadMail extends BaseAction {
	
	private StringBuffer bodytext = new StringBuffer();//存放邮件内容    
	private String dateformat = "yyyy-MM-dd HH:mm"; //默认的日前显示格式 
//    private List<MailBean> list = new ArrayList<MailBean>();
    private MimeMessage mimeMessage = null;
    private final static Logger log= Logger.getLogger(ReadMail.class);
    
    private ProductService<Product> productService = new ProductService<Product>();
       
    
    public ProductService<Product> getProductService() {
		return productService;
	}

	public void setProductService(ProductService<Product> productService) {
		this.productService = productService;
	}
	
	public ReadMail(){}
    
    public ReadMail(MimeMessage mimeMessage,ProductService<Product> productService){
    	this.mimeMessage = mimeMessage;
    	this.productService = productService;
    }
    
    public void setMimeMessage(MimeMessage mimeMessage) {
		this.mimeMessage = mimeMessage;
	}
    
	/**   
     * 判断此邮件是否已读，如果未读返回返回false,反之返回true
     */   
    public boolean isNew() throws MessagingException {    
        boolean isnew = false;    
        Flags flags =  ((Message) mimeMessage).getFlags();    
        Flags.Flag[] flag = flags.getSystemFlags();    
        for (int i = 0; i < flag.length; i++) {    
            if (flag[i] == Flags.Flag.SEEN) {    
                isnew = true;    
                break;    
            }    
        }   
      //  System.out.println("是否已读："+isnew);
        return isnew;    
    }   
    
    /**   
     * 判断此邮件是否已读，如果未读返回返回false,反之返回true
     */   
    public boolean isNew(Message message) throws MessagingException {    
        boolean isnew = false;    
        Flags flags =  message.getFlags();    
        Flags.Flag[] flag = flags.getSystemFlags();    
        for (int i = 0; i < flag.length; i++) {    
            if (flag[i] == Flags.Flag.SEEN) {    
                isnew = true;    
                break;    
            }    
        }   
      //  System.out.println("是否已读："+isnew);
        return isnew;    
    }
    
    /**    
     * 判断此邮件是否需要回执，如果需要回执返回"true",否则返回"false"   
     */    
//    public boolean getReplySign(MimeMessage mimeMessage) throws MessagingException {    
//        boolean replysign = false;    
//        String needreply[] = mimeMessage.getHeader("Disposition-Notification-To");    
//        if (needreply != null) {    
//            replysign = true;    
//        }    
//        return replysign;    
//    } 
    
    /**   
     * 获得此邮件的Message-ID   
     */   
    public String getMessageId() throws MessagingException {    
        return mimeMessage.getMessageID();    
    }    
    
    /**   
     * 获得邮件主题   
     */   
    public String getSubject() throws MessagingException {    
        String subject = "";    
        try {    
            subject = MimeUtility.decodeText(mimeMessage.getSubject());    
            if (subject == null)    
                subject = "";    
        } catch (Exception exce) {}    
        return subject;    
    } 
    
    /**
	 * 　*　获得发件人的地址和姓名 　
	 */
	public String getFrom() throws Exception {
		InternetAddress address[] = (InternetAddress[]) mimeMessage.getFrom();
		String from = address[0].getAddress();
		if (from == null) {
			from = "";
			System.out.println("无法知道发送者.");
		}
		String personal = address[0].getPersonal();

		if (personal == null) {
			personal = "";
			System.out.println("无法知道发送者的姓名.");
		}

		String fromAddr = null;
		if (personal != null || from != null) {
			fromAddr = personal + "<" + from + ">";
		} else {
			System.out.println("无法获得发送者信息.");
		}
		return fromAddr;
	}
	
	/**
	 * 　*　获得邮件的收件人，抄送，和密送的地址和姓名，根据所传递的参数的不同
	 * 　*　"to"----收件人　"cc"---抄送人地址　"bcc"---密送人地址 　
	 */
	public String getMailAddress(MimeMessage mimeMessage,String type) throws Exception {
		String mailAddr = "";
		String addType = type.toUpperCase();

		InternetAddress[] address = null;
		if (addType.equals("TO") || addType.equals("CC")
				|| addType.equals("BCC")) {

			if (addType.equals("TO")) {
				address = (InternetAddress[]) mimeMessage
						.getRecipients(Message.RecipientType.TO);
			} else if (addType.equals("CC")) {
				address = (InternetAddress[]) mimeMessage
						.getRecipients(Message.RecipientType.CC);
			} else {
				address = (InternetAddress[]) mimeMessage
						.getRecipients(Message.RecipientType.BCC);
			}

			if (address != null) {
				for (int i = 0; i < address.length; i++) {
					String emailAddr = address[i].getAddress();
					if (emailAddr == null) {
						emailAddr = "";
					} else {
						System.out.println("转换之前的emailAddr: " + emailAddr);
						emailAddr = MimeUtility.decodeText(emailAddr);
						System.out.println("转换之后的emailAddr: " + emailAddr);
					}
					String personal = address[i].getPersonal();
					if (personal == null) {
						personal = "";
					} else {
						System.out.println("转换之前的personal: " + personal);
						personal = MimeUtility.decodeText(personal);
						System.out.println("转换之后的personal: " + personal);
					}
					String compositeto = personal + "<" + emailAddr + ">";
					System.out.println("完整的邮件地址：" + compositeto);
					mailAddr += "," + compositeto;
				}
				mailAddr = mailAddr.substring(1);
			}
		} else {
			throw new Exception("错误的电子邮件类型!");
		}
		return mailAddr;
	}
	
	/**
	 * 　*　获得邮件发送日期 　
	 */
	public String getSentDate() throws Exception {
		Date sentDate = mimeMessage.getSentDate();
		SimpleDateFormat format = new SimpleDateFormat(dateformat);
		String strSentDate = format.format(sentDate);
//		System.out.println("发送日期 可读类型: " + strSentDate);
		return strSentDate;
	}
	
	/**
	 * 　*　获得邮件正文内容 　
	 */
	public String getBodyText() {
		return bodytext.toString();
	}
	
	/**
	 * 　　*　解析邮件，把得到的邮件内容保存到一个StringBuffer对象中，解析邮件
	 * 　　*　主要是根据MimeType类型的不同执行不同的操作，一步一步的解析 　　
	 */

	public void getMailContent(Part part) throws Exception {

		String contentType = part.getContentType();
		// 获得邮件的MimeType类型
//		System.out.println("邮件的MimeType类型: " + contentType);

		int nameIndex = contentType.indexOf("name");

		boolean conName = false;

		if (nameIndex != -1) {
			conName = true;
		}

//		System.out.println("邮件内容的类型:　" + contentType);

		if (part.isMimeType("text/plain") && conName == false) {
			// text/plain 类型
			bodytext.append((String) part.getContent());
		} else if (part.isMimeType("text/html") && conName == false) {
			// text/html 类型
			bodytext.append((String) part.getContent());
		} else if (part.isMimeType("multipart/*")) {
			// multipart/*
			Multipart multipart = (Multipart) part.getContent();
			int counts = multipart.getCount();
			for (int i = 0; i < counts; i++) {
				getMailContent(multipart.getBodyPart(i));
			}
		} else if (part.isMimeType("message/rfc822")) {
			// message/rfc822
			getMailContent((Part) part.getContent());
		} else {

		}
	}
	
	/**
	 * 　　*　判断此邮件是否需要回执，如果需要回执返回"true",否则返回"false" 　
	 */
	public boolean getReplySign(MimeMessage mimeMessage) throws MessagingException {

		boolean replySign = false;

		String needReply[] = mimeMessage.getHeader("Disposition-Notification-To");

		if (needReply != null) {
			replySign = true;
		}
		if (replySign) {
			System.out.println("该邮件需要回复");
		} else {
			System.out.println("该邮件不需要回复");
		}
		return replySign;
	}
	
	/**
	 * 判断此邮件是否包含附件
	 */
	public boolean isContainAttach(Part part) throws Exception {
		boolean attachFlag = false;
		// String contentType = part.getContentType();
		if (part.isMimeType("multipart/*")) {
			Multipart mp = (Multipart) part.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				BodyPart mPart = mp.getBodyPart(i);
				String disposition = mPart.getDisposition();
				if ((disposition != null) && ((disposition.equals(Part.ATTACHMENT)) || (disposition.equals(Part.INLINE))))
					attachFlag = true;
				else if (mPart.isMimeType("multipart/*")) {
					attachFlag = isContainAttach((Part) mPart);
				} else {
					String conType = mPart.getContentType();
					if (conType.toLowerCase().indexOf("application") != -1)
						attachFlag = true;
					if (conType.toLowerCase().indexOf("name") != -1)
						attachFlag = true;
				}
			}
		} else if (part.isMimeType("message/rfc822")) {
			attachFlag = isContainAttach((Part) part.getContent());
		}
		return attachFlag;
	}
	
	/**
	 * 　*　保存附件 　
	 */
	public void saveAttachMent(Part part) throws Exception {
		String fileName = "";
		if (part.isMimeType("multipart/*")) {
			Multipart mp = (Multipart) part.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				BodyPart mPart = mp.getBodyPart(i);
				String disposition = mPart.getDisposition();
				if ((disposition != null) && ((disposition.equals(Part.ATTACHMENT)) || (disposition.equals(Part.INLINE)))){
						fileName = mPart.getFileName();
					if (fileName.toLowerCase().indexOf("utf-8") != -1) {
						fileName = MimeUtility.decodeText(fileName);
					}
					new SaveMailFile().saveFile(fileName, mPart.getInputStream());
				} else if (mPart.isMimeType("multipart/*")) {
					saveAttachMent(mPart);
				} else {
					fileName = mPart.getFileName();
					if ((fileName != null) && (fileName.toLowerCase().indexOf("utf-8") != -1)){
						fileName = MimeUtility.decodeText(fileName);
						new SaveMailFile().saveFile(fileName, mPart.getInputStream());
					}
				}
			}
		} else if (part.isMimeType("message/rfc822")) {
			saveAttachMent((Part) part.getContent());
		}
	}
	
	/**
	 * 初始化读邮件参数
	 */
	public void staerApp(Mailbox entity){
		log.warn("初始化读邮件参数");
		IMAPFolder folder = null;
        IMAPStore store = null;
        int total = 0;
        
        Properties props = new Properties();
        // 获取默认会话
        Properties prop = System.getProperties();
        prop.put("mail.imap.host",entity.getHost());
//        prop.put("mail.imap.host","imap.126.com");
        prop.put("mail.imap.auth.plain.disable","true");
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(false); //是否启用debug模式
		try {
			store=(IMAPStore)session.getStore("imap");
			// 使用imap会话机制，连接服务器
			System.out.println(entity.getHost()+ ","+ entity.getMailaccount()+ ","+  MyBase64.getFromBase64(entity.getMaillicense()));
			store.connect(entity.getHost(), entity.getMailaccount(), MyBase64.getFromBase64(entity.getMaillicense()));
//			store.connect("imap.126.com", "18813907332@126.com", "zhuange888");
			// 收件箱
			folder =  (IMAPFolder)store.getFolder("INBOX");
			/**
			 * READ_WRITE 允许读取和修改
			 * READ_ONLY 只能读取
			 */
			folder.open(Folder.READ_WRITE);
			//获取所有邮件
			Message message[] = folder.getMessages();
			//获取邮件总数
			total = folder.getMessageCount();
			System.out.println("邮件总数===="+total);
			System.out.println("未读邮件数====" + folder.getUnreadMessageCount());  
			//获取未读邮件  
			int wdyj = folder.getUnreadMessageCount();
			Message [] unread = new Message[wdyj];
			if(wdyj > 0){
			int n = 0;
            for(int j = 0 ;j < message.length; j++){
            	if(!isNew(message[j])){
            		unread[n] = message[j];
            		n = n + 1;
            		}
            	}
			}
            ReadMail mm = null;
            for (int i = 0; i < unread.length; i++) {
            	mm = new ReadMail((MimeMessage) unread[i],productService);
            	boolean isnew = mm.isNew();
            	if(!isnew){
            		String fromAddr = mm.getFrom();
//            		System.out.println("发送者是：" + fromAddr);
            		if("eBay<ebay@ebay.com.hk>".equals(fromAddr)){
            			String subject = mm.getSubject();
//                		System.out.println("标题===="+subject);
            			String subjectstb = "";
                		if(subject != null && subject.length() > 7){
                			subjectstb = subject.substring(0, 7);
                		}
                		if("你的刊登已確認".equals(subjectstb)){
                			String senDate = mm.getSentDate();
//                    		System.out.println("发送时间==="+senDate);
                    		boolean iscont = mm.isContainAttach((Part) unread[i]);
//                    		System.out.println("是否有附件==="+iscont);
                    		
                    		String mailId = mm.getMessageId();
//                    		System.out.println("邮件ID==="+mailId);
                    		mm.getMailContent((Part) unread[i]);
//                    		System.out.println("正文内容=="+getBodyText());
                    		Product mb = new ResolveMailContent().resolve(mm.getBodyText());
//                    		System.out.println("=================="+DateUtil.stringToDate(senDate, "yyyy-MM-dd hh24:mi"));
                    		mb.setReleasetime(DateUtil.stringToDate(senDate, "yyyy-MM-dd hh24:mi"));
                    		
                    		
                    		mb.setDeletemark(0);
                    		mb.setImagtype(0);
                    		mb.setOffsign(0);
                    		mb.setSourcesign(0);
                    		mb.setMailboxAccount(fromAddr);
                    		if(iscont){
                    			mm.saveAttachMent((Part) unread[i]);
                    		}
    						//设置邮件已读
                    		unread[i].setFlag(Flags.Flag.SEEN, true);
                    		//保存数据
                    		ProductSaveMail pd = new ProductSaveMail(productService);
                    		pd.save(mb);
                		}
            		}
            	}
            }
			
		} catch (NoSuchProviderException e) {
			log.warn("初始化读邮件错误:"+e.getMessage());
			e.printStackTrace();
		} catch (MessagingException e) {
			log.warn("初始化读邮件错误:"+e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			log.warn("初始化读邮件错误:"+e.getMessage());
			e.printStackTrace();
		}finally{
		 	try{
                if(folder != null)
                    folder.close(true); //退出收件箱时,删除做了删除标识的邮件
               if (store != null)
                  store.close();
              }catch(Exception bs){
            	  log.warn("初始化读邮件关闭流错误:"+bs.getMessage());
             	 bs.printStackTrace();
              } 
		}
	}
	/**
	 * 添加数据或者修改数据
	 * @param product
	 */
	
	
	public static void main(String[] args) {
//		new ReadMail().staerApp();
		String url = "http://rover.ebay.com/rover/0/e12000.m43.l1123/7?euid=c6de709831ba4135bc7dc990ada14453&loc=http%3A%2F%2Fcgi.ebay.com%2Fws%2FeBayISAPI.dll%3FViewItem%26item%3D142167919197%26ssPageName%3DADME%3AL%3ALCA%3AUS%3A1123";
		try {
			String urls = URLDecoder.decode(url, "UTF-8");
			System.out.println("urls====="+urls);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}
