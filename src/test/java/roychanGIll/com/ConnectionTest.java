package roychanGIll.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import roychanGIll.com.connections.HikariConnections;

import java.sql.SQLException;

public class ConnectionTest {

    @Test
    void testConnections() throws SQLException {

        HikariConnections hikariConnections = new HikariConnections();
        Assertions.assertNotNull( hikariConnections.getConnect());
    }
}
