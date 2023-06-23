package it.unibo.playbasket.controller;

import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

/**
 * Controller for more-stats page.
 */
public class MoreStatsController {

    private FxView view;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public MoreStatsController(FxView view){
        this.view = view;
    }

    @FXML
    public void goHome(){
        this.view.setMainView();
    }
}
