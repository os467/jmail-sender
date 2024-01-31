package pers.os467.support.core.mail.core.registrar;


import pers.os467.support.core.mail.core.connection.SmtpAuthenticator;

/**
 * SmtpЭ���ʼ�����ע��淶
 * author: os467
 */
public interface SmtpHostRegistrar extends HostRegistrar {


    /**
     * ����SMTP����
     * @param host SMTP host
     */
    SmtpHostRegistrar setHost(String host);

    /**
     * ����SMTP�˿�
     * @param port SMTP port
     */
    SmtpHostRegistrar setPort(String port);

    /**
     * ����SMTP�����֤��Ϣ
     * @param auth SMTP authentication
     */
    SmtpHostRegistrar setAuth(SmtpAuthenticator auth);

    /**
     * �����Ƿ���SMTP TLS����
     * @param useTLS SMTP TLS usage
     */
    SmtpHostRegistrar setUseTLS(boolean useTLS);

}
