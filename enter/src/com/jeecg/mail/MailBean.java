package com.jeecg.mail;


/**
 * @类说明: 邮件实体类
 * @author hfz
 * @createTime 2015-6-27 下午2:49:21
 * @copyright 深圳大金來科技有限公司 
 */
public class MailBean {
	// 邮件标题
	private String subject;
	// 邮件内容
	private String content;
	//发邮件的帐号
	private String emailAddress;
	// 发送邮件的日期
	private String sentdate;
	//是否有附件
	private boolean falg;
	//判断此邮件是否已读，如果未读返回返回false,反之返回true
	private boolean yidu;
	// 判断此邮件是否需要回执，如果需要回执返回"true",否则返回"false" 
	private boolean replysign;
	// 获得此邮件的Message-ID 
	private String messageId;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getSentdate() {
		return sentdate;
	}
	public void setSentdate(String sentdate) {
		this.sentdate = sentdate;
	}
	public boolean isFalg() {
		return falg;
	}
	public void setFalg(boolean falg) {
		this.falg = falg;
	}
	public boolean isYidu() {
		return yidu;
	}
	public void setYidu(boolean yidu) {
		this.yidu = yidu;
	}
	public boolean isReplysign() {
		return replysign;
	}
	public void setReplysign(boolean replysign) {
		this.replysign = replysign;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
	
	
}
