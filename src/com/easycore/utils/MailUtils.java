package com.easycore.utils;

import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailUtils {

	// 统一设置host/from/prop
	private static void setBaseInfo(JavaMailSenderImpl javaMailSender,
			SimpleMailMessage simpleMailMessage,
			MimeMessageHelper mimeMessageHelper, Properties properties)
			throws MessagingException {
		// 读取conf
		String props = "config/mail.properties";
		String host = ConfigUtils.getVal(props, "mail.host");
		String port = ConfigUtils.getVal(props, "mail.port");
		String username = ConfigUtils.getVal(props, "mail.username");
		String password = ConfigUtils.getVal(props, "mail.password");
		String from = ConfigUtils.getVal(props, "mail.from");
		// 设置host
		javaMailSender.setHost(host);
		javaMailSender.setPort(Integer.parseInt(port));
		javaMailSender.setUsername(username);
		javaMailSender.setPassword(password);
		javaMailSender.setDefaultEncoding("UTF-8");
		// 设置from
		if (null != simpleMailMessage)
			simpleMailMessage.setFrom(from);
		if (null != mimeMessageHelper)
			mimeMessageHelper.setFrom(from);
		// 设置prop
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", true);
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.timeout", "25000");
		javaMailSender.setJavaMailProperties(properties);
	}

	public static void sendTxtMail(String target, String title, String content)
			throws MessagingException {
		// 创建对象
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		Properties properties = new Properties();

		// 设置对象
		setBaseInfo(javaMailSender, simpleMailMessage, null, properties);
		simpleMailMessage.setTo(target);
		simpleMailMessage.setSubject(title);
		simpleMailMessage.setText(content);

		// 发送
		javaMailSender.send(simpleMailMessage);
		System.out.println("sendTxtMail-ok");
	}

	public static void sendHtmlMail(String target, String title, String content)
			throws MessagingException {
		// 创建对象
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
				mimeMessage, true, "UTF-8");
		Properties properties = new Properties();

		// 设置对象
		setBaseInfo(javaMailSender, null, mimeMessageHelper, properties);
		mimeMessageHelper.setTo(target);
		mimeMessageHelper.setSubject(title);
		mimeMessageHelper.setText("<html><head></head><body>" + content
				+ "</body></html>", true);

		// 发送
		javaMailSender.send(mimeMessage);
		System.out.println("sendHtmlMail-ok");
	}

}