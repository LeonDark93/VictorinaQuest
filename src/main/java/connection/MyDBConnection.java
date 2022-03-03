package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDBConnection {

    private static Connection connection;

    public static Connection getConnectionBy(ConnectionConfig config) throws Exception{
        if(config == null){
            return null;

        }
        if(connection == null){
            connection = DriverManager.getConnection(config.getUrl(),config.getUserName(),config.getPassword());
        }
        return connection;

    }

}
