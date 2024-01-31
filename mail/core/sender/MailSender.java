package pers.os467.support.core.mail.core.sender;

import pers.os467.support.core.mail.core.exception.NoSuchConnectionException;
import pers.os467.support.core.mail.core.connection.Connection;

import javax.mail.MessagingException;

/**
 * �ʼ������������Ŷ����ʼ���Ϣ�ķ��ͷ�������Ҫ��һ���ʼ��������Ӷ��������߼���
 * author: os467
 */
public interface MailSender {
    /**
     * ���ʼ���������
     * @param connection
     */
    void bind(Connection connection);

    /**
     * �����ʼ���Ϣ
     * @param subject
     * @param context
     * @param receiver
     * @throws NoSuchConnectionException
     */
    void send(String subject, String context, String receiver) throws NoSuchConnectionException, MessagingException;
}
