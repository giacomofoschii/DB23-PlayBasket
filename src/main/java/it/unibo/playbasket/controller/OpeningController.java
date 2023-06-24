package it.unibo.playbasket.controller;

import java.sql.Connection;

import it.unibo.playbasket.db.ConnectionManager;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

/**
 * Controller for the opening page.
 */
public class OpeningController{

    private FxView view;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public OpeningController(FxView view){
        this.view = view;
    }

    @FXML
    public void enterMainPage(){
        this.view.setMainView();
        final ConnectionManager connectClass = new ConnectionManager();
        Connection connection = connectClass.getSQLConnection();
        this.view.addConnection(connection);
    }
}