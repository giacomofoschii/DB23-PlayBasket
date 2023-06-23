package it.unibo.playbasket.view.impl;

import it.unibo.playbasket.view.api.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * Class that implements the view.
 */
public class FxView implements View {

    private Stage primaryStage;

    public FxView(final Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("PlayBasket");
        primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("images/Logo.png").toExternalForm()));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        this.setOpeningView();
        primaryStage.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOpeningView() {
        try {
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/OpeningView.fxml"));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
