package it.unibo.playbasket.controller;

import java.sql.Connection;

import it.unibo.playbasket.db.ConnectionManager;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller for the opening page.
 */
public class OpeningController{

    private FxView view;
    @FXML TextField username;
    @FXML TextField password;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public OpeningController(FxView view){
        this.view = view;
    }

    @FXML
    public void enterMainPage(){
        final ConnectionManager connectClass = new ConnectionManager(this.username.getText(), this.password.getText());
        Connection connection = connectClass.getSQLConnection();
        this.view.addConnection(connection);
        this.view.setMainView();
    }
}