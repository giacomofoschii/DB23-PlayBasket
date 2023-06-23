package it.unibo.playbasket.controller;

import it.unibo.playbasket.view.impl.FxView;

import javafx.fxml.FXML;

public class MainController {

    private FxView view;

    public MainController(FxView view){
        this.view = view;
    }

    @FXML
    public void enterLoginPage(){
        this.view.setLoginView();
    }
}
