package it.unibo.playbasket.controller;

import it.unibo.playbasket.db.features.FeaturesCampionato;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

public class CampionatiController {

    private FxView view;
    private FeaturesCampionato featuresCampionato;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public CampionatiController(FxView view, FeaturesCampionato featuresCampionato){
        this.view = view;
        this.featuresCampionato = featuresCampionato;
    }

    @FXML
    public void goManagement(){
        this.view.setAdminView();
    }
}
