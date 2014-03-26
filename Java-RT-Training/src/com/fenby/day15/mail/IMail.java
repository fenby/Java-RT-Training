package com.fenby.day15.mail;

import javax.mail.Message;

public interface IMail {
	public void setAuthenticator(String username, String password);
	public void sendMail(String from, String to, String subject, String content);
	public Message[] receiveMail(String username, String password);
}
