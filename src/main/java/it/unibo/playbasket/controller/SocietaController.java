package it.unibo.playbasket.controller;

import java.util.Arrays;

import it.unibo.playbasket.db.features.FeaturesSocieta;
import it.unibo.playbasket.db.views.Palestra;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
