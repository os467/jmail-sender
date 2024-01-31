package pers.os467.support.core.mail.core.registrar;


import pers.os467.support.core.mail.core.connection.SmtpAuthenticator;

/**
 * Smtp协议邮件主机注册规范
 * author: os467
 */
public interface SmtpHostRegistrar extends HostRegistrar {


    /**
     * 设置SMTP主机
     * @param host SMTP host
     */
    SmtpHostRegistrar setHost(String host);

    /**
     * 设置SMTP端口
     * @param port SMTP port
     */
    SmtpHostRegistrar setPort(String port);

    /**
     * 设置SMTP身份验证信息
     * @param auth SMTP authentication
     */
    SmtpHostRegistrar setAuth(SmtpAuthenticator auth);

    /**
     * 设置是否开启SMTP TLS加密
     * @param useTLS SMTP TLS usage
     */
    SmtpHostRegistrar setUseTLS(boolean useTLS);

}
