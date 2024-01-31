package pers.os467.support.core.mail.core.builder;

import pers.os467.support.core.mail.core.registrar.HostRegistrar;

import javax.mail.Session;

/**
 * �Ự������
 * author: os467
 */
public interface SessionBuilder {

    /**
     * ����һ���ʼ��Ự
     * @param hostRegistrar
     * @return
     */
    Session buildSession(HostRegistrar hostRegistrar);
}
