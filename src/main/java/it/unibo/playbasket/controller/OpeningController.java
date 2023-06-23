package it.unibo.playbasket.controller;

import it.unibo.playbasket.db.ConnectionManager;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

public class OpeningController{

    private FxView view;

    public OpeningController(FxView view){
        this.view = view;
    }

    @FXML
    public void enterMainPage(){
        final ConnectionManager connectClass = new ConnectionManager();
        connectClass.getSQLConnection();
        this.view.setMainView();
    }
}