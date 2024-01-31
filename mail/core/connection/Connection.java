package pers.os467.support.core.mail.core.connection;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 * 邮件服务连接
 * author: os467
 */
public interface Connection {

    /**
     * 是否开启线程监听连接事件，并在断开连接后自动重新连接
     * 通常会因为远程主机主动释放连接而断开连接，因此需要循环监听连接是否开启
     * @param enable
     */
    void enableReconnect(boolean enable);

    /**
     * 创建一个连接到远程邮件服务器，在此之后可以调用发送消息方法
     * @throws MessagingException
     */
    void createConnection() throws MessagingException;

    /**
     * 连接断开方法
     * @throws MessagingException
     */
    void disconnect() throws MessagingException;

    /**
     * 返回连接识别名，用于在连接管理器中获取相关连接对象使用
     * @return
     */
    String getConnectionName();

    /**
     * 获取java mail传输对象
     * @return
     */
    Transport getTransport();

    /**
     * 获取连接绑定的会话
     * @return
     */
    Session getSession();

    /**
     * 发送消息，若未创建连接就调用此方法则会抛出异常
     * @param message
     * @throws MessagingException
     */
    void send(MimeMessage message) throws MessagingException;
}
