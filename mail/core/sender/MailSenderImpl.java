package pers.os467.support.core.mail.core.sender;


import pers.os467.support.core.mail.core.connection.*;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSenderImpl implements MailSender {

	//绑定的连接
	private Connection connection;

	@Override
	public void bind(Connection connection) {
		this.connection = connection;
	}

	public void send(String subject, String context, String receiver) throws MessagingException {

		MimeMessage message = new MimeMessage(connection.getSession());

		try {
			message.setSubject(subject);
			message.setText(context);

		} catch (MessagingException e) {
			throw e;
		}
		try {
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiver));
		} catch (MessagingException e) {
			throw e;
		}

		//发送
		try {
			connection.send(message);
		} catch (MessagingException e) {
			throw e;
		}
	}


}