package com.fenby.day15.mail;

/*
 * 提供了最简单的邮件发送功能
 *
 * 测试gmail的帐户为:
 * 用户名: fenby.javacourse@gmail.com
 * 密码:   Pwd123456
 */
public class MailerV1 {
	public static void main(String[] args) {
		// 创建一个邮件sender对象
		IMail myMail = new IMailGmail();

		// 设置用户验证信息
		myMail.setAuthenticator("fenby.javacourse@gmail.com", "Pwd123456");
		// 发送邮件内容
		myMail.sendMail("fenby.javacourse@gmail.com", "ning.li@fenby.com", "Python好书推荐《Python核心编程》", "赶快到京东去购买吧，链接地址：http://item.jd.com/10062788.html");
	}
}
