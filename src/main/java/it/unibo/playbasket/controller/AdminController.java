package it.unibo.playbasket.controller;

import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

/**
 * Controller for the admin page.
 */
public class AdminController {

    private FxView view;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public AdminController(FxView view){
        this.view = view;
    }

    @FXML
    public void goHome(){
        this.view.setMainView();
    }

    @FXML
    public void enterTesserati(){
        this.view.setTesseratiView();
    }

    @FXML
    public void enterSocieta(){
        this.view.setSocietaView();
    }

    @FXML
    public void enterPalestre(){
        this.view.setPalestreView();
    }

    @FXML
    public void enterCampionati(){
        this.view.setCampionatiView();
    }

    @FXML
    public void enterPartite(){
        this.view.setPartiteView();
    }
}
