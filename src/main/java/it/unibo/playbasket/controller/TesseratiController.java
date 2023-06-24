package it.unibo.playbasket.controller;

import it.unibo.playbasket.db.features.FeaturesTesserato;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

public class TesseratiController {

    private FxView view;
    private FeaturesTesserato featuresTesserato;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public TesseratiController(FxView view, FeaturesTesserato featuresTesserato){
        this.view = view;
        this.featuresTesserato = featuresTesserato;
    }

    @FXML
    public void goManagement(){
        this.view.setAdminView();
    }
}
