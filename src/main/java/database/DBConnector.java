package database;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.Properties;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DBConnector {

    private static final Logger logger = LoggerFactory.getLogger(DBConnector.class);

    private static DBConnector instance = null;
    private final DataSource dataSource;

    private DBConnector() {
        this.dataSource = createDataSource();
    }

    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

    private DataSource createDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(System.getProperty(Properties.DB_USER));
        dataSource.setPassword(System.getProperty(Properties.DB_PASSWORD));
        dataSource.setServerName(System.getProperty(Properties.DB_SERVER_NAME));
        dataSource.setPortNumber(Integer.parseInt(System.getProperty(Properties.DB_SERVER_PORT)));
        dataSource.setDatabaseName(System.getProperty(Properties.DB_SERVER_DATABASE));
        return dataSource;
    }

    public <T> T getQueryResults(String query, ResultSetHandler<T> handler, String... params) throws SQLException {
        QueryRunner run = new QueryRunner(dataSource);
        return run.query(query, handler, params);
    }

    public int executeUpdate(String query, String... params) throws SQLException {
        if ("true".equals(System.getProperty(Properties.DB_ALLOW_UPDATE, "false"))) {
            QueryRunner run = new QueryRunner(dataSource);
            return run.update(query, params);
        } else {
            logger.info("Skipping DB update since it was not allowed for this environment.");
            return 0;
        }
    }

}

