package pers.os467.support.core.mail.core.registrar;


import pers.os467.support.core.mail.core.connection.SmtpAuthenticator;

import javax.mail.Authenticator;
import java.util.Properties;

public class SmtpHostRegistrarImpl implements SmtpHostRegistrar {

    private Properties props = new Properties();

    private boolean stdCheck = true;

    private SmtpAuthenticator authenticator;

    public static final String STANDARD_SMTP_PORT = "^(25|587|465|2525)$";
    public static final String STANDARD_SMTP_HOST = "^(smtp.)?([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";


    public static final String SMTP_HOST = "mail.smtp.host";
    public static final String SMTP_PORT = "mail.smtp.port";
    public static final String SMTP_AUTH = "mail.smtp.auth";
    public static final String SMTP_STARTTLS = "mail.smtp.starttls.enable";


    public SmtpHostRegistrar setHost(String host){
        // 检查host是否为smtp标准主机名
        if (stdCheck && !isStandardSmtpHost(host)) {
            throw new RuntimeException("Invalid SMTP host: " + host);
        }
        props.put(SMTP_HOST, host);
        return this;
    }

    private boolean isStandardSmtpHost(String host) {
        // 正则表达式用于匹配标准的SMTP主机名
        return host.matches(STANDARD_SMTP_HOST);
    }


    public SmtpHostRegistrar setPort(String port){
        // 检查port是否为smtp标准端口号
        if (stdCheck && !isStandardSmtpPort(port)) {
            throw new RuntimeException("Invalid SMTP port: " + port);
        }
        props.put(SMTP_PORT, port);
        return this;
    }

    private boolean isStandardSmtpPort(String port) {
        return port.matches(STANDARD_SMTP_PORT);
    }

    public SmtpHostRegistrar setAuth(SmtpAuthenticator authenticator){
        this.authenticator = authenticator;
        props.put(SMTP_AUTH, true);
        return this;
    }

    public SmtpHostRegistrar setUseTLS(boolean useTLS){
        props.put(SMTP_STARTTLS, useTLS);
        return this;
    }

    @Override
    public Properties getProperties() {
        return this.props;
    }

    @Override
    public String getHost() {
        return props.getProperty(SMTP_HOST);
    }

    @Override
    public int getPort() {
        return Integer.parseInt(props.getProperty(SMTP_PORT));
    }

    @Override
    public Authenticator getAuthenticator() {
        return authenticator;
    }

    public void enableStandardCheck(boolean enable){
        this.stdCheck = enable;
    }

}
