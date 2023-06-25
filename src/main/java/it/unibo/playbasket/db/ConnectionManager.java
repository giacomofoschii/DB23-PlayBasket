package it.unibo.playbasket.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class that manages the connection to the database.
 */
public class ConnectionManager {

    private final String user, password, dbname;

    /**
     * Constructor.
     */
    public ConnectionManager(String user, String password) {
        this.user = user;
        this.password = password;
        this.dbname = "db23_playbasket";
    }

    /**
     * Creates a connection to the database.
     * 
     * @return the connection to the database.
     * @throws SQLException if the connection cannot be established.
     * @throws ClassNotFoundException if the driver cannot be found.
     */
    public Connection getSQLConnection() {

        final String dbLink = "jdbc:mysql://localhost:3306/" + this.dbname;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    dbLink, this.user, this.password);
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        } catch (final ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
    }
}
