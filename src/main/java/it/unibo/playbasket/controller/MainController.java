package it.unibo.playbasket.controller;

import it.unibo.playbasket.view.impl.FxView;

import javafx.fxml.FXML;

/**
 * Controller for the main page.
 */
public class MainController {

    private FxView view;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public MainController(FxView view){
        this.view = view;
    }

    @FXML
    public void enterLoginPage(){
        this.view.setLoginView();
    }
}
