package it.unibo.playbasket;

import it.unibo.playbasket.db.ConnectionManager;
import it.unibo.playbasket.view.AppLauncher;
import javafx.application.Application;

/**
 * Main class.
 */
public final class PlayBasket {

    /**
     * Main application method.
     *
     * @param args
     */
    public static void main(final String[] args) {
        final ConnectionManager connectClass = new ConnectionManager();
        connectClass.getSQLConnection();
        Application.launch(AppLauncher.class, args);
    }
}
