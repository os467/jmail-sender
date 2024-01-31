package pers.os467.support.core.mail.core.connection;

import pers.os467.support.core.mail.core.registrar.HostRegistrar;

/**
 * �ʼ��������ӹ�����
 * author: os467
 */
public interface ConnectionManager {

    /**
     * ����һ����������ʵ��
     * @param hostRegistrar ��������ע����Ϣ
     * @return
     */
    Connection createConnection(HostRegistrar hostRegistrar);

    /**
     * ������������ȡ��Ӧ����
     * @param connectionName
     * @return
     */
    Connection getConnection(String connectionName);
}
