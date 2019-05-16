package cn.com.yajiaotong.wface.message;

import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.TextMessage;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.util.C;


/**
 * 消息驱动bean
 * @author meizhiwen
 *
 */
@Service
public class EmailMessageHandler {

	private Logger logger=LoggerFactory.getLogger(EmailMessageHandler.class);
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	public void handleMessage(Map message) throws JMSException{
		logger.info("============EmailMessageHandler receive message:"+message);
		
		String destmails = "a@qq.com,b@qq.com";
		String mailfrom = "c@qq.com";
		String sendIp = "127.0.0.1";
		String sendPort = "8888";
		String senderUName = "uName";
		String senderPass = "uPass";
		
		String[] emails=StringUtils.split(destmails,",");
		
		SimpleMailMessage m=new SimpleMailMessage();
		m.setFrom(mailfrom);
		m.setTo(emails);
		m.setSubject(message.get(C.TITLE).toString());
		m.setText(message.get(C.CONTENT).toString());
		
		mailSender.setHost(sendIp);
		mailSender.setPort(Integer.parseInt(sendPort));
		mailSender.setUsername(senderUName);
		mailSender.setPassword(senderPass);
		mailSender.send(m);
	}

}
