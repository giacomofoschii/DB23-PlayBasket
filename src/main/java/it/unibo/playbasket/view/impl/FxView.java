package it.unibo.playbasket.view.impl;

import it.unibo.playbasket.controller.AdminController;
import it.unibo.playbasket.controller.LoginController;
import it.unibo.playbasket.controller.MainController;
import it.unibo.playbasket.controller.OpeningController;
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

    /**
     * Constructor for the view.
     * 
     * @param primaryStage the stage.
     */
    public FxView(final Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("PlayBasket");
        primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("images/Logo.png").toExternalForm()));
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
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
            loader.setController(new OpeningController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setMainView() {
        try{
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/MainView.fxml"));
            loader.setController(new MainController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void setLoginView() {
        try{
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/LoginView.fxml"));
            loader.setController(new LoginController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setAdminView() {
        try{
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/AdminView.fxml"));
            loader.setController(new AdminController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}