package pers.os467.support.core.mail.core.factory;

import pers.os467.support.core.mail.core.registrar.HostRegistrar;
import pers.os467.support.core.mail.core.sender.MailSender;

/**
 * 邮件工厂
 */
public interface MailFactoryI {

    /**
     * 获取一个邮件发送器，需要提供一个邮件主机注册器，默认不开启自动重新连接
     * @param hostRegistrar
     * @return
     */
    MailSender getSender(HostRegistrar hostRegistrar);

    /**
     * 选择是否开启自动重新连接选项
     * @param hostRegistrar
     * @param autoReconnect
     * @return
     */
    MailSender getSender(HostRegistrar hostRegistrar,Boolean autoReconnect);
}
