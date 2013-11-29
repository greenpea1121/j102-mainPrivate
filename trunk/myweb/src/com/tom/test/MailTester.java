package com.tom.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailTester {

	public static void main(String[] args) throws MessagingException {
		Properties props = System.getProperties();
		props.put("mail.host", "mail.pccu.edu.tw");
		props.put("mail.transport.protocol", "smtp");
		Session session = Session.getDefaultInstance(props);
		InternetAddress from = new InternetAddress("test@com.tw");
		InternetAddress to = new InternetAddress("tom@snpy.org");
		Message msg = new MimeMessage(session);
		msg.setFrom(from);
		msg.setRecipient(RecipientType.TO, to);
		msg.setSubject("測試用");
		msg.setText("測試12345abc");
		Transport.send(msg);
	}
}
