package it.unibo.playbasket.controller;

import com.google.protobuf.Value;

import it.unibo.playbasket.db.features.FeaturesMainPage;
import it.unibo.playbasket.db.views.Classifica;
import it.unibo.playbasket.db.views.MigliorAttacco;
import it.unibo.playbasket.db.views.MigliorDifesa;
import it.unibo.playbasket.db.views.PallePerse;
import it.unibo.playbasket.db.views.PalleRubate;
import it.unibo.playbasket.db.views.Punti;
import it.unibo.playbasket.db.views.Rimbalzi;
import it.unibo.playbasket.db.views.Valutazione;
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
        viewBestAttack();
        viewBestDefense();
        viewRank();
        viewValutazione();
        viewPunti();
        viewPallePerse();
        viewPalleRubate();
        viewRimbalzi();
        viewAssist();
        /*viewFalli();
        viewStoppate();
        viewMinuti();*/
    }

    private void viewBestAttack(){
        this.bestAttack.getColumns().clear();
        TableColumn<MigliorAttacco, String> nomeSquadra = new TableColumn<>("Nome squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra"));
        TableColumn<MigliorAttacco, Integer> puntiFatti = new TableColumn<>("Punti fatti");
        puntiFatti.setCellValueFactory(new PropertyValueFactory<>("punti_fatti"));
        TableColumn<MigliorAttacco, Integer> numeroVittorie = new TableColumn<>("Numero vittorie");
        numeroVittorie.setCellValueFactory(new PropertyValueFactory<>("numero_vittorie"));
        TableColumn<MigliorAttacco, Integer> numeroSconfitte = new TableColumn<>("Numero sconfitte");
        numeroSconfitte.setCellValueFactory(new PropertyValueFactory<>("numero_sconfitte"));
        TableColumn<MigliorAttacco, Integer> partiteGiocate = new TableColumn<>("Partite giocate");
        partiteGiocate.setCellValueFactory(new PropertyValueFactory<>("partite_giocate"));
        this.bestAttack.getColumns().addAll(nomeSquadra, puntiFatti, numeroVittorie, numeroSconfitte, partiteGiocate);
        this.bestAttack.setItems(this.features.viewBestAttack(this.idCampionato.getText(), Integer.parseInt(this.anno.getText()), this.nomeGirone.getText()));
    }

    private void viewBestDefense(){
        this.bestDefense.getColumns().clear();
        TableColumn<MigliorDifesa, String> nomeSquadra = new TableColumn<>("Nome squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra"));
        TableColumn<MigliorDifesa, Integer> puntiFatti = new TableColumn<>("Punti subiti");
        puntiFatti.setCellValueFactory(new PropertyValueFactory<>("punti_subiti"));
        TableColumn<MigliorDifesa, Integer> numeroVittorie = new TableColumn<>("Numero vittorie");
        numeroVittorie.setCellValueFactory(new PropertyValueFactory<>("numero_vittorie"));
        TableColumn<MigliorDifesa, Integer> numeroSconfitte = new TableColumn<>("Numero sconfitte");
        numeroSconfitte.setCellValueFactory(new PropertyValueFactory<>("numero_sconfitte"));
        TableColumn<MigliorDifesa, Integer> partiteGiocate = new TableColumn<>("Partite giocate");
        partiteGiocate.setCellValueFactory(new PropertyValueFactory<>("partite_giocate"));
        this.bestDefense.getColumns().addAll(nomeSquadra, puntiFatti, numeroVittorie, numeroSconfitte, partiteGiocate);
        this.bestDefense.setItems(this.features.viewBestDefense(this.idCampionato.getText(), Integer.parseInt(this.anno.getText()), this.nomeGirone.getText()));
    }

    private void viewRank(){
        this.rank.getColumns().clear();
        TableColumn<Classifica, String> nomeSquadra = new TableColumn<>("Nome squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra"));
        TableColumn<Classifica, Integer> punti = new TableColumn<>("Punti");
        punti.setCellValueFactory(new PropertyValueFactory<>("punti"));
        TableColumn<Classifica, Integer> numeroVittorie = new TableColumn<>("Numero vittorie");
        numeroVittorie.setCellValueFactory(new PropertyValueFactory<>("numero_vittorie"));
        TableColumn<Classifica, Integer> partiteGiocate = new TableColumn<>("Partite giocate");
        partiteGiocate.setCellValueFactory(new PropertyValueFactory<>("partite_giocate"));
        TableColumn<Classifica, Float> percentualeVittoria = new TableColumn<>("Percentuale vittoria");
        percentualeVittoria.setCellValueFactory(new PropertyValueFactory<>("percentuale_vittoria"));
        TableColumn<Classifica, Integer> differenzaPunti = new TableColumn<>("Differenza punti");
        differenzaPunti.setCellValueFactory(new PropertyValueFactory<>("differenza_punti"));
        this.rank.getColumns().addAll(nomeSquadra, punti, numeroVittorie, partiteGiocate, percentualeVittoria, differenzaPunti);
        this.rank.setItems(this.features.viewRank(this.idCampionato.getText(), Integer.parseInt(this.anno.getText()), this.nomeGirone.getText()));
    }

    private void viewValutazione() {
        this.valutazione.getColumns().clear();
        TableColumn<Valutazione, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Valutazione, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Valutazione, Integer> eta = new TableColumn<>("Eta");
        eta.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<Valutazione, String> ruolo = new TableColumn<>("Ruolo");
        ruolo.setCellValueFactory(new PropertyValueFactory<>("ruolo"));
        TableColumn<Valutazione, String> nomeSquadra = new TableColumn<>("Nome squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra"));
        TableColumn<Valutazione, Float> valutazioneMedia = new TableColumn<>("Valutazione media");
        valutazioneMedia.setCellValueFactory(new PropertyValueFactory<>("valutazione_media"));
        this.valutazione.getColumns().addAll(nome, cognome, eta, ruolo, nomeSquadra, valutazioneMedia);
        this.valutazione.setItems(this.features.viewValutazione(this.idCampionato.getText(), Integer.parseInt(this.anno.getText())));
    }

    private void viewPunti() {
        this.punti.getColumns().clear();
        TableColumn<Punti, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Punti, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Punti, Integer> eta = new TableColumn<>("Eta");
        eta.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<Punti, String> ruolo = new TableColumn<>("Ruolo");
        ruolo.setCellValueFactory(new PropertyValueFactory<>("ruolo"));
        TableColumn<Punti, String> nomeSquadra = new TableColumn<>("Nome squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra"));
        TableColumn<Punti, Integer> puntiTot = new TableColumn<>("Punti totali");
        puntiTot.setCellValueFactory(new PropertyValueFactory<>("punti_tot"));
        TableColumn<Punti, Float> ppg = new TableColumn<>("PPG");
        ppg.setCellValueFactory(new PropertyValueFactory<>("ppg"));
        TableColumn<Punti, Float> percentuale2 = new TableColumn<>("%2");
        percentuale2.setCellValueFactory(new PropertyValueFactory<>("percentuale_2"));
        TableColumn<Punti, Float> percentuale3 = new TableColumn<>("%3");
        percentuale3.setCellValueFactory(new PropertyValueFactory<>("percentuale_3"));
        TableColumn<Punti, Float> percentualeFt = new TableColumn<>("%FT");
        percentualeFt.setCellValueFactory(new PropertyValueFactory<>("percentuale_ft"));
        this.punti.getColumns().addAll(nome, cognome, eta, ruolo, nomeSquadra, puntiTot, ppg, percentuale2, percentuale3, percentualeFt);
        this.punti.setItems(this.features.viewPunti(this.idCampionato.getText(), Integer.parseInt(this.anno.getText())));
    }

    private void viewPallePerse() {
        this.pallePerse.getColumns().clear();
        TableColumn<PallePerse, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<PallePerse, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<PallePerse, Integer> eta = new TableColumn<>("Eta");
        eta.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<PallePerse, String> ruolo = new TableColumn<>("Ruolo");
        ruolo.setCellValueFactory(new PropertyValueFactory<>("ruolo"));
        TableColumn<PallePerse, String> nomeSquadra = new TableColumn<>("Nome squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra"));
        TableColumn<PallePerse, Integer> pallePerse = new TableColumn<>("Palle perse");
        pallePerse.setCellValueFactory(new PropertyValueFactory<>("palle_perse"));
        TableColumn<PallePerse, Float> pallePersePg = new TableColumn<>("Palle perse PG");
        pallePersePg.setCellValueFactory(new PropertyValueFactory<>("palle_perse_pg"));
        this.pallePerse.getColumns().addAll(nome, cognome, eta, ruolo, nomeSquadra, pallePerse, pallePersePg);
        this.pallePerse.setItems(this.features.viewPallePerse(this.idCampionato.getText(), Integer.parseInt(this.anno.getText())));
    }

    private void viewPalleRubate() {
        this.palleRubate.getColumns().clear();
        TableColumn<PalleRubate, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<PalleRubate, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<PalleRubate, Integer> eta = new TableColumn<>("Eta");
        eta.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<PalleRubate, String> ruolo = new TableColumn<>("Ruolo");
        ruolo.setCellValueFactory(new PropertyValueFactory<>("ruolo"));
        TableColumn<PalleRubate, String> nomeSquadra = new TableColumn<>("Nome squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra"));
        TableColumn<PalleRubate, Integer> palleRubate = new TableColumn<>("Palle rubate");
        palleRubate.setCellValueFactory(new PropertyValueFactory<>("palle_rubate"));
        TableColumn<PalleRubate, Float> palleRubatePg = new TableColumn<>("Palle rubate PG");
        palleRubatePg.setCellValueFactory(new PropertyValueFactory<>("palle_rubate_pg"));
        this.palleRubate.getColumns().addAll(nome, cognome, eta, ruolo, nomeSquadra, palleRubate, palleRubatePg);
        this.palleRubate.setItems(this.features.viewPalleRubate(this.idCampionato.getText(), Integer.parseInt(this.anno.getText())));
    }

    private void viewRimbalzi() {
        this.rimbalzi.getColumns().clear();
        TableColumn<Rimbalzi, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Rimbalzi, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Rimbalzi, Integer> eta = new TableColumn<>("Eta");
        eta.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<Rimbalzi, String> ruolo = new TableColumn<>("Ruolo");
        ruolo.setCellValueFactory(new PropertyValueFactory<>("ruolo"));
        TableColumn<Rimbalzi, String> nomeSquadra = new TableColumn<>("Nome squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra"));
        TableColumn<Rimbalzi, Integer> rimbalzi = new TableColumn<>("Rimbalzi");
        rimbalzi.setCellValueFactory(new PropertyValueFactory<>("rimbalzi"));
        TableColumn<Rimbalzi, Float> rimbalziPg = new TableColumn<>("Rimbalzi PG");
        rimbalziPg.setCellValueFactory(new PropertyValueFactory<>("rimbalzi_pg"));
        this.rimbalzi.getColumns().addAll(nome, cognome, eta, ruolo, nomeSquadra, rimbalzi, rimbalziPg);
        this.rimbalzi.setItems(this.features.viewRimbalzi(this.idCampionato.getText(), Integer.parseInt(this.anno.getText())));
    }

    private void viewAssist() {
        
    }
}
