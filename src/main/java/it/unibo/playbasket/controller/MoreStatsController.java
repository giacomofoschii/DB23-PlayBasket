package it.unibo.playbasket.controller;

import javax.xml.catalog.CatalogFeatures.Feature;

import it.unibo.playbasket.db.features.FeaturesMoreStats;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;

/**
 * Controller for more-stats page.
 */
public class MoreStatsController {

    private FxView view;
    private FeaturesMoreStats featuresMoreStats;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public MoreStatsController(FxView view, FeaturesMoreStats featuresMoreStats){
        this.view = view;
        this.featuresMoreStats = featuresMoreStats;
    }

    @FXML
    public void goHome(){
        this.view.setMainView();
    }
}
