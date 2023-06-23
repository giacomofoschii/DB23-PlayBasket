package it.unibo.playbasket.controller;

import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

public class TesseratiController {

    private FxView view;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public TesseratiController(FxView view){
        this.view = view;
    }

    @FXML
    public void goManagement(){
        this.view.setAdminView();
    }
}
