package connection.configs;

import connection.ConnectionConfig;

public class CustomConfiguration implements ConnectionConfig {

    private String dbUserName;
    private String dbPassword;
    private String dbURL;

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }


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
