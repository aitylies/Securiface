package fr.securiface.Securiface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectBDD {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/securiface?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_LOGIN = "securiface";
    private static final String DB_PWD = "Freesteak44";

    private static Connection connection;

    private ConnectBDD() {}

    public static Connection getConnection() throws SQLException {
        if ( null == connection || connection.isClosed() ) {
            connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PWD );
        }

        return connection;
    }

    public static void closeConnection() throws SQLException {
        if ( null != connection && !connection.isClosed() ) {
            connection.close();
        }
    }
}
