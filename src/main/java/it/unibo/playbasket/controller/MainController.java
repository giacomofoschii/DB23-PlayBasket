package it.unibo.playbasket.controller;

import it.unibo.playbasket.db.features.FeaturesMainPage;
import it.unibo.playbasket.view.impl.FxView;

import javafx.fxml.FXML;

/**
 * Controller for the main page.
 */
public class MainController {

    private FxView view;
    private FeaturesMainPage featuresMainPage;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public MainController(FxView view, FeaturesMainPage featuresMainPage){
        this.view = view;
        this.featuresMainPage = featuresMainPage;
    }

    @FXML
    public void enterLoginPage(){
        this.view.setLoginView();
    }

    @FXML
    public void enterMoreStatsPage(){
        this.view.setMoreStatsView();
    }
}
