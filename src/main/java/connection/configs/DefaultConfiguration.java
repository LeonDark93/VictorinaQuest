package connection.configs;

import connection.ConnectionConfig;

public class DefaultConfiguration implements ConnectionConfig {

    private final String dbUserName = "user_leonid_db";
    private final String dbPassword = "root1993";
    private final String dbURL = "jdbc:mysql://127.0.0.1:3306/victorina_test_db";


    @Override
    public String getUserName() {
        return this.dbUserName;
    }

    @Override
    public String getPassword() {
        return this.dbPassword;
    }

    @Override
    public String getUrl() {
        return this.dbURL;
    }
}
