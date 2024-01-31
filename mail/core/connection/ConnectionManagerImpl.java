package pers.os467.support.core.mail.core.connection;

import pers.os467.support.core.mail.core.builder.SessionBuilder;
import pers.os467.support.core.mail.core.builder.SessionBuilderImpl;
import pers.os467.support.core.mail.core.registrar.HostRegistrar;

import javax.mail.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionManagerImpl implements ConnectionManager {

    private SessionBuilder sessionBuilder = new SessionBuilderImpl();

    //Á¬½Ó³Ø
    private Map<String, Connection> pool = new LinkedHashMap<>();


    public Connection createConnection(HostRegistrar hostRegistrar){
        Session session = sessionBuilder.buildSession(hostRegistrar);
        Authenticator authenticator = hostRegistrar.getAuthenticator();
        Connection connection = null;
        if (authenticator != null){
            connection = new ConnectionImpl(hostRegistrar,session);
            pool.put(connection.getConnectionName(), connection);
        }
        //without authenticator...
        return connection;
    }

    @Override
    public Connection getConnection(String connectionName) {
        return pool.get(connectionName);
    }


}
