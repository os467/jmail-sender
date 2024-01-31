package pers.os467.support.core.mail.core.connection;



import lombok.extern.slf4j.Slf4j;
import pers.os467.support.core.mail.core.exception.AuthenticatorCastException;
import pers.os467.support.core.mail.core.registrar.HostRegistrar;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Slf4j
public class ConnectionImpl implements Connection {

    private String host;
    private int port;
    private String username;
    private String password;
    private Session session;
    private Transport transport;
    private boolean reconnect;
    private boolean keepListen;
    private Thread connectListener;
    private InternetAddress from;

    public ConnectionImpl(HostRegistrar hostRegistrar, Session session) {
        this.host = hostRegistrar.getHost();
        this.port = hostRegistrar.getPort();
        Authenticator var1 = hostRegistrar.getAuthenticator();

        SmtpAuthenticator var2;
        if (var1 instanceof SmtpAuthenticator){
            var2 = (SmtpAuthenticator) var1;
        }else {
            throw new AuthenticatorCastException("plz use "+ SmtpAuthenticator.class.getTypeName()+" as authenticator");
        }
        PasswordAuthentication var3 = var2.getPasswordAuthentication();
        this.username = var3.getUserName();
        this.password = var3.getPassword();
        this.session = session;

        try {
            this.from = new InternetAddress(this.username);
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            this.transport = session.getTransport();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Transport getTransport() {
        return transport;
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public void send(MimeMessage message) throws MessagingException {
        try {
            message.setFrom(from);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            transport.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException e) {
            if (transport.isConnected()){
                throw e;
            }else {
                //reconnect
                connect();
                transport.sendMessage(message, message.getAllRecipients());
            }
        }
    }


    @Override
    public void enableReconnect(boolean enable) {
        reconnect = enable;
        keepListen = reconnect;
    }

    private void setConnectListener() {
        if (connectListener == null){
            connectListener = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (keepListen){
                        if (!transport.isConnected()){
                            //reconnect
                            try {
                                connect();
                            } catch (MessagingException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void disconnect() throws MessagingException {
        if (reconnect){
            keepListen = false;
        }
        try {
            transport.close();
        } catch (MessagingException e) {
            throw e;
        }
    }

    //创建连接
    public void createConnection() throws MessagingException {
        connect();
        if (reconnect){
            synchronized (this){
                setConnectListener();
                connectListener.start();
            }
        }
    }

    private void connect() throws MessagingException {
        try {
            transport.connect(host, port, username,password);
            log.info("Email service thread connection completed");
        } catch (MessagingException e) {
            throw e;
        }
    }

    public String getConnectionName() {
        return getHost();
    }
}
