package it.unibo.playbasket.db.features;

import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

public class SocietaController {

    private FxView view;
    private FeaturesSocieta featuresSocieta;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public SocietaController(FxView view, FeaturesSocieta featuresSocieta){
        this.view = view;
        this.featuresSocieta = featuresSocieta;
    }

    @FXML
    public void goManagement(){
        this.view.setAdminView();
    }
}
