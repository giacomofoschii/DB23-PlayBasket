package it.unibo.playbasket.controller;

import it.unibo.playbasket.db.features.FeaturesPartita;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

public class PartiteController {

    private FxView view;
    private FeaturesPartita featuresPartita;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public PartiteController(FxView view, FeaturesPartita featuresPartita){
        this.view = view;
        this.featuresPartita = featuresPartita;
    }

    @FXML
    public void goManagement(){
        this.view.setAdminView();
    }
}
