package pers.os467.support.core.mail.core.connection;

import pers.os467.support.core.mail.core.registrar.HostRegistrar;

/**
 * 邮件服务连接管理器
 * author: os467
 */
public interface ConnectionManager {

    /**
     * 创建一个服务连接实例
     * @param hostRegistrar 连接主机注册信息
     * @return
     */
    Connection createConnection(HostRegistrar hostRegistrar);

    /**
     * 根据连接名获取对应连接
     * @param connectionName
     * @return
     */
    Connection getConnection(String connectionName);
}
