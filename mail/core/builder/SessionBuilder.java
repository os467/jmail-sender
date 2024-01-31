package pers.os467.support.core.mail.core.builder;

import pers.os467.support.core.mail.core.registrar.HostRegistrar;

import javax.mail.Session;

/**
 * 会话构建器
 * author: os467
 */
public interface SessionBuilder {

    /**
     * 构建一个邮件会话
     * @param hostRegistrar
     * @return
     */
    Session buildSession(HostRegistrar hostRegistrar);
}
