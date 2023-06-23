package it.unibo.playbasket.view.impl;

import it.unibo.playbasket.controller.AdminController;
import it.unibo.playbasket.controller.CampionatiController;
import it.unibo.playbasket.controller.LoginController;
import it.unibo.playbasket.controller.MainController;
import it.unibo.playbasket.controller.MoreStatsController;
import it.unibo.playbasket.controller.OpeningController;
import it.unibo.playbasket.controller.PalestreController;
import it.unibo.playbasket.controller.PartiteController;
import it.unibo.playbasket.controller.SocietaController;
import it.unibo.playbasket.controller.TesseratiController;
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    @Override
    public void setMoreStatsView() {
        try{
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/MoreStatsView.fxml"));
            loader.setController(new MoreStatsController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setTesseratiView() {
        try{
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/TesseratiView.fxml"));
            loader.setController(new TesseratiController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setSocietaView() {
        try{
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/SocietaView.fxml"));
            loader.setController(new SocietaController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setPalestreView() {
        try{
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/PalestreView.fxml"));
            loader.setController(new PalestreController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setCampionatiView() {
        try{
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/CampionatiView.fxml"));
            loader.setController(new CampionatiController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setPartiteView() {
        try{
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/PartiteView.fxml"));
            loader.setController(new PartiteController(this));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}