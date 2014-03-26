package com.fenby.day15.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class IMailGmail implements IMail {
	private String authUsername;
	private String authPassword;

	public void setAuthenticator(String username, String password) {
		this.authUsername = username;
		this.authPassword = password;
	}

	public void sendMail(String from, String to, String subject, String content) {

		// 关于Gmail属性设置参考 https://support.google.com/mail/answer/13287?hl=en
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(authUsername,
								authPassword);
					}
				});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(content);

			System.out.println("正在发送邮件... <" + subject + ">");
			Transport.send(message);
			System.out.println("您的邮件已发送.");

		} catch (MessagingException e) {
			throw new RuntimeException("发送邮件异常: " + e.getMessage());
		}
	}

	public Message[] receiveMail(String username, String password) {

		// 关于Gmail属性设置参考 https://support.google.com/mail/answer/13287?hl=en
		Properties properties = new Properties();
		properties.put("mail.store.protocol", "pop3");
		properties.put("mail.pop3.host", "pop.gmail.com");
		properties.put("mail.pop3.port", "995");
		properties.put("mail.pop3.starttls.enable", "true");
		Session emailSession = Session.getDefaultInstance(properties);
		// emailSession.setDebug(true);

		Message[] messages = null;
		try {
			// 创建POP3 store对象并连接至pop服务器
			Store store = emailSession.getStore("pop3s");
			System.out.println("正在连接服务器...");
			store.connect("pop.gmail.com", username, password);

			// 创建文件夹并打开
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// 从文件夹中打开邮件列表（数组）
			System.out.println("读取邮件列表...");
			messages = emailFolder.getMessages();

			System.out.println("邮件条数: " + messages.length);
			for (int i = 0; i < messages.length; i++) {
				Message message = messages[i];
				try {
					writeEnvelope(message);
				} catch (Exception e) {
					System.out.println("读取邮件异常: " + e.getMessage());
				}
			}

			// 关闭store和文件夹对象
			emailFolder.close(false);
		} catch (Exception e) {
			System.out.println("读取邮件异常: " + e.getMessage());
		}

		return messages;
	}

	public static void writeEnvelope(Message m) throws Exception {
		Address[] a;

		// 显示标题
		if (m.getSubject() != null)
			System.out.print("标题: <" + m.getSubject() + ">");


		// 显示发送人地址
		if ((a = m.getFrom()) != null) {
			System.out.print(" 来自: ");
			for (int j = 0; j < a.length; j++)
				System.out.print(a[j].toString() + ", ");
			System.out.println();
		}
	}

}