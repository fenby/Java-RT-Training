package com.fenby.day15.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 提供了自定义邮件发送功能, 用户通过console读取邮件接收地址，邮件标题和邮件内容。
 * 功能列表：1. 发送邮件
 *          2. 接收邮件
 *          9. 退出
 *
 * 测试gmail的帐户为:
 * 用户名: fenby.javacourse@gmail.com
 * 密码:   Pwd123456
 */
public class MailerV2 {
	private static final String username = "fenby.javacourse@gmail.com";
	private static final String password = "Pwd123456";

	public static void main(String[] args) throws IOException {
		do {
			int option = promptMessage();
			if (option == '1') {
				sendMail();
			} else if (option == '2') {
				receiveMail();
			} else {
				break;
			}
		} while (true);

		System.out.println("谢谢使用Fenby Mail客户端");
	}

	/**
	 * 显示提示信息。
	 *
	 * @return
	 * @throws IOException
	 */
	private static int promptMessage() throws IOException {
		System.out.println("欢迎使用Fenby Mail客户端, 请输入下列选项值(1, 2, 9)");
		System.out.println("1. 发送邮件");
		System.out.println("2, 接收邮件");
		System.out.println("9, 退出");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.read();
	}

	/**
	 * 接收邮件。
	 */
	private static void receiveMail() {
		// 创建一个gmail对象
		IMail myMail = new IMailGmail();

		// 读取邮件列表
		myMail.receiveMail(username, password);
	}

	/**
	 * 发送邮件。
	 */
	private static void sendMail() {
		// 创建一个gmail对象
		IMail sender = new IMailGmail();

		// 设置用户验证信息
		sender.setAuthenticator(username, password);

		// 从console中读取邮件内容
		MailContent mailContent = null;
		try {
			mailContent = readFromConsole();
		} catch (IOException e) {
			System.out.println("读取信息异常, " + e.getMessage());
		}

		// 发送邮件内容
		sender.sendMail(username, mailContent.getTo(),
				mailContent.getSubject(), mailContent.getContent());
	}

	/**
	 * 从终端读取邮件内容（发送地址、标题、内容）
	 *
	 * @return
	 * @throws IOException
	 */
	private static MailContent readFromConsole() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		MailContent mailContent = new MailContent();
		System.out.print("请输入发送的邮件地址: ");
		mailContent.setTo(br.readLine());

		System.out.print("请输入邮件标题: ");
		mailContent.setSubject(br.readLine());

		System.out.print("请输入邮件内容(在首行中输入quit退出): ");
		String content = br.readLine();
		while (!content.equalsIgnoreCase("quit")) {
			mailContent.setContent(mailContent.getContent() + content);
			content = br.readLine();
		}

		return mailContent;
	}
}

class MailContent {
	private String to;
	private String subject;
	private String content = "";

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

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
}
