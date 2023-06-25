package it.unibo.playbasket.view.impl;

import java.sql.Connection;

import it.unibo.playbasket.controller.AdminController;
import it.unibo.playbasket.controller.CalendarController;
import it.unibo.playbasket.controller.CampionatiController;
import it.unibo.playbasket.controller.LoginController;
import it.unibo.playbasket.controller.MainViewController;
import it.unibo.playbasket.controller.MoreStatsController;
import it.unibo.playbasket.controller.OpeningController;
import it.unibo.playbasket.controller.PalestreController;
import it.unibo.playbasket.controller.PartiteController;
import it.unibo.playbasket.controller.TesseratiController;
import it.unibo.playbasket.db.features.FeaturesCalendar;
import it.unibo.playbasket.db.features.FeaturesCampionato;
import it.unibo.playbasket.db.features.FeaturesMainPage;
import it.unibo.playbasket.db.features.FeaturesMoreStats;
import it.unibo.playbasket.db.features.FeaturesPalestra;
import it.unibo.playbasket.db.features.FeaturesPartita;
import it.unibo.playbasket.db.features.FeaturesSocieta;
import it.unibo.playbasket.db.features.FeaturesTesserato;
import it.unibo.playbasket.db.features.SocietaController;
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
    private FeaturesMainPage featuresMain;
    private FeaturesTesserato featuresTesserato;
    private FeaturesSocieta featuresSocieta;
    private FeaturesPalestra featuresPalestra;
    private FeaturesCampionato featuresCampionato;
    private FeaturesPartita featuresPartita;
    private FeaturesMoreStats featuresMoreStats;
    private FeaturesCalendar featuresCalendar;

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
            loader.setController(new MainViewController(this, featuresMain));
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
            loader.setController(new MoreStatsController(this, featuresMoreStats));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setCalendarView() {
        try {
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/CalendarView.fxml"));
            loader.setController(new CalendarController(this, featuresCalendar));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        };
    }

    @Override
    public void setTesseratiView() {
        try{
            final var loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/TesseratiView.fxml"));
            loader.setController(new TesseratiController(this, featuresTesserato));
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
            loader.setController(new SocietaController(this, featuresSocieta));
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
            loader.setController(new PalestreController(this, featuresPalestra));
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
            loader.setController(new CampionatiController(this, featuresCampionato));
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
            loader.setController(new PartiteController(this, featuresPartita));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addConnection(final Connection connection) {
        this.featuresMain = new FeaturesMainPage(connection);
        this.featuresTesserato = new FeaturesTesserato(connection);
        this.featuresSocieta = new FeaturesSocieta(connection);
        this.featuresPalestra = new FeaturesPalestra(connection);
        this.featuresCampionato = new FeaturesCampionato(connection);
        this.featuresPartita = new FeaturesPartita(connection);
        this.featuresMoreStats = new FeaturesMoreStats(connection);
        this.featuresCalendar = new FeaturesCalendar(connection);
    }
}