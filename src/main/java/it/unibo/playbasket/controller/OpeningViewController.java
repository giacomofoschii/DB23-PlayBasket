package it.unibo.playbasket.controller;

import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

public class OpeningViewController{

    private FxView view;

    public OpeningViewController(FxView view){
        this.view = view;
    }

    @FXML
    public void enterMainPage(){
        view.setMainView();
    }
}