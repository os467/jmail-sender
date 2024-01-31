package pers.os467.support.core.mail.core.factory;

import pers.os467.support.core.mail.core.registrar.HostRegistrar;
import pers.os467.support.core.mail.core.sender.MailSender;

/**
 * �ʼ�����
 */
public interface MailFactoryI {

    /**
     * ��ȡһ���ʼ�����������Ҫ�ṩһ���ʼ�����ע������Ĭ�ϲ������Զ���������
     * @param hostRegistrar
     * @return
     */
    MailSender getSender(HostRegistrar hostRegistrar);

    /**
     * ѡ���Ƿ����Զ���������ѡ��
     * @param hostRegistrar
     * @param autoReconnect
     * @return
     */
    MailSender getSender(HostRegistrar hostRegistrar,Boolean autoReconnect);
}
