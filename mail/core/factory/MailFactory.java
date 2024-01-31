package pers.os467.support.core.mail.core.factory;

import pers.os467.support.core.mail.core.connection.Connection;
import pers.os467.support.core.mail.core.connection.ConnectionManagerImpl;
import pers.os467.support.core.mail.core.registrar.HostRegistrar;
import pers.os467.support.core.mail.core.sender.MailSender;
import pers.os467.support.core.mail.core.sender.MailSenderImpl;

import javax.mail.MessagingException;

public class MailFactory implements MailFactoryI{

    private ConnectionManagerImpl connectionManager = new ConnectionManagerImpl();

    @Override
    public MailSender getSender(HostRegistrar hostRegistrar){
        Connection connection = connectionManager.createConnection(hostRegistrar);
        connection.enableReconnect(false);
        try {
            connection.createConnection();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        MailSender mailSender = getMailSender(connection);
        return mailSender;
    }

    public MailSender getSender(HostRegistrar hostRegistrar,Boolean autoReconnect){
        Connection connection = connectionManager.createConnection(hostRegistrar);
        connection.enableReconnect(autoReconnect);
        try {
            connection.createConnection();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        MailSender mailSender = getMailSender(connection);
        return mailSender;
    }

    private MailSender getMailSender(Connection connection) {
        MailSender mailSender = new MailSenderImpl();
        mailSender.bind(connection);
        return mailSender;
    }


}
