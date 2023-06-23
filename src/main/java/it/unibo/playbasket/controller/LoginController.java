package it.unibo.playbasket.controller;


import java.util.HashSet;
import java.util.Set;

import it.unibo.playbasket.utils.Pair;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginController {

    private FxView view;
    private String user;
    private String pass;
    private Set<Pair<String,String>> credentials;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public LoginController(FxView view){
        this.view = view;
        this.user = "admin";
        this.pass = "admin";
        this.credentials = new HashSet<>();
        this.credentials.add(new Pair<>(this.user, this.pass));
    }

    @FXML
    public void checkCredentials(){
        if(this.credentials.contains(new Pair<>(this.username.getText(), this.password.getText()))){
            this.view.setAdminView();
        } else {
            this.username.clear();
            this.username.setPromptText("Username o password errato");
            this.username.setStyle("-fx-prompt-text-fill: red;");
            this.password.clear();
            this.password.setPromptText("Password errata");
            this.password.setStyle("-fx-prompt-text-fill: red;");
        }
    }

    @FXML
    public void goHome(){
        this.view.setMainView();
    }
}
