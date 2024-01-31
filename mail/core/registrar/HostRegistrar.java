package pers.os467.support.core.mail.core.registrar;




import javax.mail.Authenticator;
import java.util.Properties;

/**
 * ����ע����������һ���ʼ�����ע��淶��
 * author: os467
 */
public interface HostRegistrar {
    /**
     * ��ȡ�����ʼ������Ựע����Ϣ
     * @return
     */
    Properties getProperties();

    /**
     * ��ȡ�ʼ�����������
     * @return
     */
    String getHost();

    /**
     * ��ȡ�ʼ����������˿�
     * @return
     */
    int getPort();

    Authenticator getAuthenticator();
}
