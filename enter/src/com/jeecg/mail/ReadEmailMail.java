package com.jeecg.mail;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;

/**
 * @类说明:讀取電子郵件
 * @author hfz
 * @createTime 2015-6-27 上午10:17:52
 */
public class ReadEmailMail {
	/**
	 * @author:	hfz
	 * @方法說明: 構建Properties對象
	 * @createTime 2015-6-27 上午11:23:08
	 * @return 返回类型  Properties
	 * @throws
	 * imap 邮件协议 
	 * 测试读取 mail.126.com 邮箱
	 */
	private String user = "18813907332@126.com";
	private String password = "zhuange888";
//	private String host = "imap.qq.com";
	private String host = "mail.126.com";
//	private MimeMessage mimeMessage = null;    
    private StringBuffer bodytext = new StringBuffer();//存放邮件内容    
    private String dateformat = "yyyy-MM-dd HH:mm"; //默认的日前显示格式 
    private List<MailBean> list = new ArrayList<MailBean>();
    private String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory"; 
    
    
	public ReadEmailMail() {
		
	}
	
	public Properties newProperties() {
		 Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		 Properties props = System.getProperties();  
		 props.put("mail.imap.socketFactory.class", SSL_FACTORY);
		 props.put("mail.smtp.ssl.enable", "true");
		 props.put("mail.imap.socketFactory.fallback", "false");
		 props.put("mail.store.protocol","imap");
		 props.put("mail.imap.host",host);
		 props.put("mail.imap.port", "993");
		 props.put("mail.imap.socketFactory.port","993");
		 props.put("mail.imap.auth.plain.disable","true");
		 Store store = null;
		 Folder folder = null;
		 Session mailsession = Session.getInstance(props,null);
//	     mailsession.setDebug(false); //是否启用debug模式
	     URLName urln = new URLName("imap",host,993,null,user, password);
		 try {
			// 使用imap会话机制，连接服务器
			store = mailsession.getStore(urln);
			// 帐号密码登录
			store.connect();
			//读取收件箱
			folder = store.getFolder("INBOX");
			// 以读写模式打开收件箱 
			folder.open(Folder.READ_WRITE);
			// 只讀
//			folder.open(Folder.READ_ONLY); 
			FetchProfile profile = new FetchProfile();
			profile.add(FetchProfile.Item.ENVELOPE);
			Message[] messages = folder.getMessages();
			folder.fetch(messages, profile);
			//未读邮件数
			int unreadcount = folder.getUnreadMessageCount();
			//新邮件数
			int newmailcount = folder.getNewMessageCount();
			//总邮件数
			int total = folder.getMessageCount();		
			System.out.println("未读邮件数：" + unreadcount);
			System.out.println("新邮件数：" + newmailcount);
			System.out.println("总邮件数：" + total);
			
			// 得到收件箱文件夹信息，获取邮件列表  
			
			for (Message message : messages) {
				MimeMessage mimeMessage = (MimeMessage) message;
				MailBean mailBean = new MailBean();
				//邮件标题
				String subject = MimeUtility.decodeText(message.getSubject());
				//邮件内容
				String content = getMailContent((Part) message, "");
//				getMailContent((Part) message);
				//发送邮箱地址帐号
				InternetAddress[] addresss = (InternetAddress[]) message.getFrom();
				String from = addresss[0].getAddress();
				// 发送日期
				String dataStr = getSentDate(mimeMessage);
				//判断邮件是否已读
				boolean g = isNew(mimeMessage);
				//判断此邮件是否需要回执
				boolean r = getReplySign(mimeMessage);
				//获得此邮件的Message-ID 
				String i = getMessageId(mimeMessage);
				System.out.println("接收時間："+dataStr);
				System.out.println(content);
				System.out.println("-------------------------------");
				mailBean.setContent(content);
				mailBean.setEmailAddress(from);
				mailBean.setSubject(subject);
				mailBean.setSentdate(dataStr);
				mailBean.setYidu(g);
				mailBean.setReplysign(r);
				mailBean.setMessageId(i);
				list.add(mailBean);
			}
			
		} catch (NoSuchProviderException e) {
			System.out.println("--使用imap会话机制，连接服务器异常--"+e.getMessage());
			e.printStackTrace();
		} catch (MessagingException e) {
			System.out.println("--store.connect()方法异常--");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("--获取邮件标题异常--");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("--读取邮件内容异常--");
			e.printStackTrace();
		}finally{
			if (folder != null) {
				try {
					folder.close(false);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
			if (store != null) {
				try {
					store.close();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}
		return props; 
	}
	
	 /**   
     * 获得邮件发送日期   
     */   
    public String getSentDate(MimeMessage mimeMessage) throws Exception {    
        Date sentdate = mimeMessage.getSentDate();    
        SimpleDateFormat format = new SimpleDateFormat(dateformat);    
        return format.format(sentdate);    
    }  
    /**   
     * 获得发件人的地址和姓名   
     */   
    public String getFrom(MimeMessage mimeMessage) throws Exception {    
        InternetAddress address[] = (InternetAddress[]) mimeMessage.getFrom();    
        String from = address[0].getAddress();    
        if (from == null)    
            from = "";    
        String personal = address[0].getPersonal();    
        if (personal == null)    
            personal = "";    
        String fromaddr = personal + "<" + from + ">";    
        return fromaddr;    
    }    
    /**   
     * 判断此邮件是否已读，如果未读返回返回false,反之返回true
     */   
    public boolean isNew(MimeMessage mimeMessage) throws MessagingException {    
        boolean isnew = false;    
        Flags flags = ((Message) mimeMessage).getFlags();    
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
    public boolean getReplySign(MimeMessage mimeMessage) throws MessagingException {    
        boolean replysign = false;    
        String needreply[] = mimeMessage.getHeader("Disposition-Notification-To");    
        if (needreply != null) {    
            replysign = true;    
        }    
        return replysign;    
    }    
   
    /**   
     * 获得此邮件的Message-ID   
     */   
    public String getMessageId(MimeMessage mimeMessage) throws MessagingException {    
        return mimeMessage.getMessageID();    
    }    
    
    /**   
     * 获得邮件主题   
     */   
    public String getSubject(MimeMessage mimeMessage) throws MessagingException {    
        String subject = "";    
        try {    
            subject = MimeUtility.decodeText(mimeMessage.getSubject());    
            if (subject == null)    
                subject = "";    
        } catch (Exception exce) {}    
        return subject;    
    }    
   
    /**   
     * 获得邮件正文内容   
     */   
    public String getBodyText() {    
        return bodytext.toString();    
    }    
   
    /**   
     * 解析邮件，把得到的邮件内容保存到一个StringBuffer对象中，解析邮件 主要是根据MimeType类型的不同执行不同的操作，一步一步的解析  
     * 方法一 
     */   
    public void getMailContent(Part part)   {    
        try {
			String contenttype = part.getContentType();    
			int nameindex = contenttype.indexOf("name");    
			boolean conname = false;    
			if (nameindex != -1)    
			    conname = true;   
			if (part.isMimeType("text/plain") && !conname) {    
			    bodytext.append((String) part.getContent());    
			} else if (part.isMimeType("text/html") && !conname) {    
			    bodytext.append((String) part.getContent());    
			} else if (part.isMimeType("multipart/*")) {    
			    Multipart multipart = (Multipart) part.getContent();    
			    int counts = multipart.getCount();    
			    for (int i = 0; i < counts; i++) {    
			        getMailContent(multipart.getBodyPart(i));    
			    }    
			} else if (part.isMimeType("message/rfc822")) {    
			    getMailContent((Part) part.getContent());    
			} else {}
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("hansj写_类（）：方法（）：发生异常");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("hansj写_类（）：方法（）：发生异常");
		}    
    }    
   //方法二 
    public String getMailContent(Part part, String content)
			throws Exception {
		String contenttype = part.getContentType();
		int nameindex = contenttype.indexOf("name");
		boolean conname = false;
		if (nameindex != -1)
			conname = true;
		if (part.isMimeType("text/plain") && !conname) {
			content += (String) part.getContent();
		} else if (part.isMimeType("text/html") && !conname) {
			content += (String) part.getContent();
		} else if (part.isMimeType("multipart/*")) {
			Multipart multipart = (Multipart) part.getContent();
			content += getMailContent(multipart.getBodyPart(0), content);
		} else if (part.isMimeType("message/rfc822")) {
			content += getMailContent((Part) part.getContent(), content);
		} else {
		}
		return content;
	}
    /**   
     * 获得邮件的收件人，抄送，和密送的地址和姓名，根据所传递的参数的不同 "to"----收件人 "cc"---抄送人地址 "bcc"---密送人地址   
     */   
    public String getMailAddress(String type,MimeMessage mimeMessage) throws Exception {    
        String mailaddr = "";    
        String addtype = type.toUpperCase();    
        InternetAddress[] address = null;    
        if (addtype.equals("TO") || addtype.equals("CC")|| addtype.equals("BCC")) {    
            if (addtype.equals("TO")) {    
                address = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.TO);    
            } else if (addtype.equals("CC")) {    
                address = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.CC);    
            } else {    
                address = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.BCC);    
            }    
            if (address != null) {    
                for (int i = 0; i < address.length; i++) {    
                    String email = address[i].getAddress();    
                    if (email == null)    
                        email = "";    
                    else {    
                        email = MimeUtility.decodeText(email);    
                    }    
                    String personal = address[i].getPersonal();    
                    if (personal == null)    
                        personal = "";    
                    else {    
                        personal = MimeUtility.decodeText(personal);    
                    }    
                    String compositeto = personal + "<" + email + ">";    
                    mailaddr += "," + compositeto;    
                }    
                mailaddr = mailaddr.substring(1);    
            }    
        } else {    
            throw new Exception("Error emailaddr type!");    
        }    
        return mailaddr;    
    }    
    
	public static void main(String[] args) {
		ReadEmailMail readEmailMail = new ReadEmailMail();
		readEmailMail.newProperties();
	}
	
}
