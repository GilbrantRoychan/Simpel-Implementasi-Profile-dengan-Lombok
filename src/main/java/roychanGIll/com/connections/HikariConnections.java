package roychanGIll.com.connections;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.SQLException;


public class HikariConnections {


    private static HikariDataSource hikariDataSource;

    static {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(System.getenv("JDBC_URL"));
        hikariConfig.setUsername(System.getenv("user"));
        hikariConfig.setPassword(System.getenv("pass"));


        // change Connection Pool
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setMaximumPoolSize(5);

        hikariConfig.setIdleTimeout(6000L);
        hikariConfig.setMaxLifetime(6000L * 10);

        hikariDataSource = new HikariDataSource(hikariConfig);
    }

    @SneakyThrows
    public  Connection getConnect() throws SQLException {
        return  hikariDataSource.getConnection();
    }


    public HikariConnections() {

    }
}


