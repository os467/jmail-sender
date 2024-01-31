package pers.os467.support.core.mail.core.connection;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 * �ʼ���������
 * author: os467
 */
public interface Connection {

    /**
     * �Ƿ����̼߳��������¼������ڶϿ����Ӻ��Զ���������
     * ͨ������ΪԶ�����������ͷ����Ӷ��Ͽ����ӣ������Ҫѭ�����������Ƿ���
     * @param enable
     */
    void enableReconnect(boolean enable);

    /**
     * ����һ�����ӵ�Զ���ʼ����������ڴ�֮����Ե��÷�����Ϣ����
     * @throws MessagingException
     */
    void createConnection() throws MessagingException;

    /**
     * ���ӶϿ�����
     * @throws MessagingException
     */
    void disconnect() throws MessagingException;

    /**
     * ��������ʶ���������������ӹ������л�ȡ������Ӷ���ʹ��
     * @return
     */
    String getConnectionName();

    /**
     * ��ȡjava mail�������
     * @return
     */
    Transport getTransport();

    /**
     * ��ȡ���Ӱ󶨵ĻỰ
     * @return
     */
    Session getSession();

    /**
     * ������Ϣ����δ�������Ӿ͵��ô˷�������׳��쳣
     * @param message
     * @throws MessagingException
     */
    void send(MimeMessage message) throws MessagingException;
}
