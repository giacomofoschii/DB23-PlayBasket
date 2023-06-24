package it.unibo.playbasket.controller;

import it.unibo.playbasket.db.features.FeaturesPalestra;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

public class PalestreController {

    private FxView view;
    private FeaturesPalestra featuresPalestra;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public PalestreController(FxView view, FeaturesPalestra featuresPalestra){
        this.view = view;
        this.featuresPalestra = featuresPalestra;
    }

    @FXML
    public void goManagement(){
        this.view.setAdminView();
    }
}
