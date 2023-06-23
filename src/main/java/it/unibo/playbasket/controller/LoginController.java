package it.unibo.playbasket.controller;


import java.util.Set;

import it.unibo.playbasket.utils.Pair;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    private FxView view;
    private String username;
    private String pass;
    private Set<Pair<String,String>> credentials;

    @FXML
    private TextField user;
    @FXML
    private TextField password;

    public LoginController(FxView view){
        this.view = view;
        this.username = "admin";
        this.pass = "admin";
        setCredentials(username, pass);
    }

    public void setCredentials(final String user, final String password) {
        this.credentials.add(new Pair<>(user, password));
    }

    @FXML
    public void checkCredentials(){
        if(credentials.contains(new Pair<>(this.user, this.password))){
            this.view.setAdminView();
        }
    }
}
