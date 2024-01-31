package pers.os467.support.core.mail.core.builder;



import pers.os467.support.core.mail.core.exception.HostRegistrarUninitializedException;
import pers.os467.support.core.mail.core.registrar.HostRegistrar;

import javax.mail.Authenticator;
import javax.mail.Session;
import java.util.Properties;

public class SessionBuilderImpl implements SessionBuilder {

    private Session session;

    @Override
    public Session buildSession(HostRegistrar hostRegistrar) {
        Properties properties = hostRegistrar.getProperties();
        if (properties == null){
            throw new HostRegistrarUninitializedException();
        }
        Authenticator authenticator = hostRegistrar.getAuthenticator();
        if (authenticator == null){
            session = Session.getInstance(properties);
        }else {
            session = Session.getInstance(properties,authenticator);
        }

        return session;
    }
}
