package it.unibo.playbasket.controller;

import com.google.protobuf.Value;

import it.unibo.playbasket.db.features.FeaturesMainPage;
import it.unibo.playbasket.view.impl.FxView;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller for the main page.
 */
public class MainController {

    private FxView view;
    private FeaturesMainPage features;
    @FXML private TextField anno;
    @FXML private TextField idCampionato;
    @FXML private TextField nomeGirone;
    @FXML private TableView bestAttack;
    @FXML private TableView bestDefense;
    @FXML private TableView rank;
    @FXML private TableView valutazione;
    @FXML private TableView pallePerse;
    @FXML private TableView palleRubate;
    @FXML private TableView punti;
    @FXML private TableView rimbalzi;
    @FXML private TableView assist;
    @FXML private TableView falli;
    @FXML private TableView stoppate;
    @FXML private TableView minuti;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public MainController(FxView view, FeaturesMainPage featuresMainPage){
        this.view = view;
        this.features = featuresMainPage;
    }

    @FXML
    public void enterLoginPage(){
        this.view.setLoginView();
    }

    @FXML
    public void enterMoreStatsPage(){
        this.view.setMoreStatsView();
    }

    @FXML
    public void viewAll(){
        //viewBestAttack();
        /*viewBestDefense();
        viewRank();
        viewValutazione();
        viewPallePerse();
        viewPalleRubate();
        viewPunti();
        viewRimbalzi();
        viewAssist();
        viewFalli();
        viewStoppate();
        viewMinuti();*/
    }

/* 
    private void viewBestAttack(){
        this.bestAttack.getColumns().clear();
        TableColumn<Squadra, String> nomeSquadra = new TableColumn<>("Nome Squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nomeSquadra"));
        TableColumn<Squadra, Integer> anno = new TableColumn<>("Anno Campionato");
        anno.setCellValueFactory(new PropertyValueFactory<>("anno"));
        TableColumn<Squadra, Integer> puntiSegnati = new TableColumn<>("Punti Segnati");
        puntiSegnati.setCellValueFactory(new PropertyValueFactory<>("puntiSegnati"));
        this.bestAttack.getColumns().addAll(nomeSquadra, anno, puntiSegnati);
        this.bestAttack.setItems(features.viewBestAttack(this.idCampionato.getText(), Integer.parseInt(this.anno.getText()), this.nomeGirone.getText()));
    }
    */
}
