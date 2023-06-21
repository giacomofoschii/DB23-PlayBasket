package it.unibo.playbasket;

import java.sql.SQLException;

import it.unibo.playbasket.sql.ConnectClass;

/**
 * Main class.
 */
public final class PlayBasket {

    public static void main(final String[] args) throws SQLException, ClassNotFoundException {
        final ConnectClass connectClass = new ConnectClass();
        connectClass.getConnection();
    }
}
