package pers.os467.support.core.mail.core.registrar;




import javax.mail.Authenticator;
import java.util.Properties;

/**
 * 主机注册器定义了一组邮件主机注册规范。
 * author: os467
 */
public interface HostRegistrar {
    /**
     * 获取电子邮件主机会话注册信息
     * @return
     */
    Properties getProperties();

    /**
     * 获取邮件服务主机名
     * @return
     */
    String getHost();

    /**
     * 获取邮件服务主机端口
     * @return
     */
    int getPort();

    Authenticator getAuthenticator();
}
