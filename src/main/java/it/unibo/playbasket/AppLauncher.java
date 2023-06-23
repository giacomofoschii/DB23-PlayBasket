package it.unibo.playbasket;


import it.unibo.playbasket.view.impl.FxView;
import javafx.application.Application;
import javafx.stage.Stage;



/**
 * Class that launches JavaFX application.
 */
public class AppLauncher extends Application{

    /**
     * Starts the JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        new FxView(primaryStage);
    }
}
