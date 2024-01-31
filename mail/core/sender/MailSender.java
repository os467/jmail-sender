package pers.os467.support.core.mail.core.sender;

import pers.os467.support.core.mail.core.exception.NoSuchConnectionException;
import pers.os467.support.core.mail.core.connection.Connection;

import javax.mail.MessagingException;

/**
 * 邮件发送器，开放多种邮件信息的发送方法，需要绑定一个邮件服务连接对象处理发送逻辑。
 * author: os467
 */
public interface MailSender {
    /**
     * 绑定邮件服务连接
     * @param connection
     */
    void bind(Connection connection);

    /**
     * 发送邮件信息
     * @param subject
     * @param context
     * @param receiver
     * @throws NoSuchConnectionException
     */
    void send(String subject, String context, String receiver) throws NoSuchConnectionException, MessagingException;
}
