package it.unibo.playbasket.controller;

import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.ResourceBundle;

import it.unibo.playbasket.db.features.FeaturesPartita;
import it.unibo.playbasket.db.views.Direzione;
import it.unibo.playbasket.db.views.Partita;
import it.unibo.playbasket.db.views.Performance;
import it.unibo.playbasket.utils.DateAdapter;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PartiteController implements Initializable{

    private FxView view;
    private FeaturesPartita featuresPartita;
    //Partite
    @FXML
    private TextField codicePalestra;
    @FXML
    private TextField dataOra;
    @FXML
    private TextField idCampionato;
    @FXML
    private TextField annoCampionato;
    @FXML
    private TextField nomeGirone;
    @FXML
    private TextField nomeCasa;
    @FXML
    private TextField puntiCasa;
    @FXML
    private TextField nomeOspiti;
    @FXML
    private TextField puntiOspiti;
    @FXML
    private TableView<Partita> partite;
    //Performance
    @FXML
    private TextField codicePalestraPerformance;
    @FXML
    private TextField dataOraPerformance;
    @FXML
    private TextField tesseraFIP;
    @FXML
    private TextField rimbalzi;
    @FXML
    private TextField assist;
    @FXML
    private TextField falliFatti;
    @FXML
    private TextField falliSubiti;
    @FXML
    private TextField minuti;
    @FXML
    private TextField tiri2;
    @FXML
    private TextField tiri3;
    @FXML
    private TextField tiriLiberi;
    @FXML
    private TextField tiri2_segnati;
    @FXML
    private TextField tiri3_segnati;
    @FXML
    private TextField tiriLiberi_segnati;
    @FXML
    private TextField palleRubate;
    @FXML
    private TextField pallePerse;
    @FXML
    private TextField stoppate;
    @FXML
    private TableView<Performance> performance;
    //Direzione
    @FXML
    private TextField codicePalestraDirezione;
    @FXML
    private TextField dataOraDirezione;
    @FXML
    private TextField tesseraFIPDirezione;
    @FXML
    private TextField rimborso;
    @FXML
    private TableView<Direzione> direzione;
    @FXML
    private TableView<Direzione> codirezione;



    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public PartiteController(FxView view, FeaturesPartita featuresPartita){
        this.view = view;
        this.featuresPartita = featuresPartita;
    }

    @FXML
    public void goManagement() {
        this.view.setAdminView();
    }
    
    @FXML
    public void addPartita() {
        try {
            this.featuresPartita.addPartita(codicePalestra.getText(), DateAdapter.dateToSqlDate(DateAdapter.buildDate(dataOra.getText()).get()), idCampionato.getText(),
                    Integer.parseInt(annoCampionato.getText()), nomeGirone.getText(), nomeCasa.getText(),
                    Integer.parseInt(puntiCasa.getText()), nomeOspiti.getText(),
                    Integer.parseInt(puntiOspiti.getText()));
            codicePalestra.clear();
            dataOra.clear();
            idCampionato.clear();
            annoCampionato.clear();
            nomeGirone.clear();
            nomeCasa.clear();
            puntiCasa.clear();
            nomeOspiti.clear();
            puntiOspiti.clear();
            this.viewPartite();
        } catch (SQLIntegrityConstraintViolationException e) {
            codicePalestra.clear();
            codicePalestra.setPromptText("Errore di inserimento");
            codicePalestra.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            codicePalestra.clear();
            codicePalestra.setPromptText("Errore di inserimento");
            codicePalestra.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addPerformance() {
        try {
            this.featuresPartita.addPerformance(codicePalestraPerformance.getText(), DateAdapter.dateToSqlDate(DateAdapter.buildDate(dataOraPerformance.getText()).get()),
                    tesseraFIP.getText(), Integer.parseInt(rimbalzi.getText()), Integer.parseInt(assist.getText()),
                    Integer.parseInt(falliFatti.getText()), Integer.parseInt(falliSubiti.getText()),
                    Integer.parseInt(minuti.getText()), Integer.parseInt(tiri2.getText()),
                    Integer.parseInt(tiri3.getText()), Integer.parseInt(tiriLiberi.getText()),
                    Integer.parseInt(tiri2_segnati.getText()), Integer.parseInt(tiri3_segnati.getText()),
                    Integer.parseInt(tiriLiberi_segnati.getText()), Integer.parseInt(palleRubate.getText()),
                    Integer.parseInt(pallePerse.getText()), Integer.parseInt(stoppate.getText()));
            codicePalestraPerformance.clear();
            dataOraPerformance.clear();
            tesseraFIP.clear();
            rimbalzi.clear();
            assist.clear();
            falliFatti.clear();
            falliSubiti.clear();
            minuti.clear();
            tiri2.clear();
            tiri3.clear();
            tiriLiberi.clear();
            tiri2_segnati.clear();
            tiri3_segnati.clear();
            tiriLiberi_segnati.clear();
            palleRubate.clear();
            pallePerse.clear();
            stoppate.clear();
            this.viewPerformance();
        } catch (SQLIntegrityConstraintViolationException e) {
            codicePalestraPerformance.clear();
            codicePalestraPerformance.setPromptText("Errore di inserimento");
            codicePalestraPerformance.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            codicePalestraPerformance.clear();
            codicePalestraPerformance.setPromptText("Errore di inserimento");
            codicePalestraPerformance.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addDirezione() {
        try {
            this.featuresPartita.addDirezione(Integer.parseInt(rimborso.getText()), tesseraFIPDirezione.getText(),
                    codicePalestraDirezione.getText(),
                    DateAdapter.dateToSqlDate(DateAdapter.buildDate(dataOraDirezione.getText()).get()));
            tesseraFIPDirezione.clear();
            dataOraDirezione.clear();
            codicePalestraDirezione.clear();
            rimborso.clear();
            this.viewDirezione();
        } catch (SQLIntegrityConstraintViolationException e) {
            tesseraFIPDirezione.clear();
            tesseraFIPDirezione.setPromptText("Errore di inserimento");
            tesseraFIPDirezione.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            tesseraFIPDirezione.clear();
            tesseraFIPDirezione.setPromptText("Errore di inserimento");
            tesseraFIPDirezione.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addCoDirezione() {
        try {
            this.featuresPartita.addCoDirezione(Integer.parseInt(rimborso.getText()), tesseraFIPDirezione.getText(),
                    codicePalestraDirezione.getText(),
                    DateAdapter.dateToSqlDate(DateAdapter.buildDate(dataOraDirezione.getText()).get()));
            tesseraFIPDirezione.clear();
            dataOraDirezione.clear();
            codicePalestraDirezione.clear();
            rimborso.clear();
            this.viewCoDirezione();
        } catch (SQLIntegrityConstraintViolationException e) {
            tesseraFIPDirezione.clear();
            tesseraFIPDirezione.setPromptText("Errore di inserimento");
            tesseraFIPDirezione.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            tesseraFIPDirezione.clear();
            tesseraFIPDirezione.setPromptText("Errore di inserimento");
            tesseraFIPDirezione.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removePartita() {
        try {
            this.featuresPartita.removePartita(codicePalestra.getText(), DateAdapter.dateToSqlDate(DateAdapter.buildDate(dataOra.getText()).get()));
            codicePalestra.clear();
            dataOra.clear();
            idCampionato.clear();
            annoCampionato.clear();
            nomeGirone.clear();
            nomeCasa.clear();
            puntiCasa.clear();
            nomeOspiti.clear();
            puntiOspiti.clear();
            this.viewPartite();
        } catch (SQLException e) {
            codicePalestra.clear();
            codicePalestra.setPromptText("Errore di rimozione");
            codicePalestra.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removePerformance() {
        try {
            this.featuresPartita.removePerformance(codicePalestraPerformance.getText(),
                    DateAdapter.dateToSqlDate(DateAdapter.buildDate(dataOraPerformance.getText()).get()),
                    tesseraFIP.getText());
            codicePalestraPerformance.clear();
            dataOraPerformance.clear();
            tesseraFIP.clear();
            rimbalzi.clear();
            assist.clear();
            falliFatti.clear();
            falliSubiti.clear();
            minuti.clear();
            tiri2.clear();
            tiri3.clear();
            tiriLiberi.clear();
            tiri2_segnati.clear();
            tiri3_segnati.clear();
            tiriLiberi_segnati.clear();
            palleRubate.clear();
            pallePerse.clear();
            stoppate.clear();
            this.viewPerformance();
        } catch (SQLException e) {
            codicePalestraPerformance.clear();
            codicePalestraPerformance.setPromptText("Errore di rimozione");
            codicePalestraPerformance.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }
    
    @FXML
    public void removeDirezione() {
        try {
            this.featuresPartita.removeDirezione(tesseraFIPDirezione.getText(), codicePalestraDirezione.getText(),
                    DateAdapter.dateToSqlDate(DateAdapter.buildDate(dataOraDirezione.getText()).get()));
            this.viewDirezione();
            codicePalestraDirezione.clear();
            dataOraDirezione.clear();
            tesseraFIPDirezione.clear();
        } catch (SQLException e) {
            codicePalestraDirezione.clear();
            codicePalestraDirezione.setPromptText("Errore di rimozione");
            codicePalestraDirezione.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeCoDirezione() {
        try {
            this.featuresPartita.removeDirezione(tesseraFIPDirezione.getText(), codicePalestraDirezione.getText(),
                    DateAdapter.dateToSqlDate(DateAdapter.buildDate(dataOraDirezione.getText()).get()));
            this.viewCoDirezione();
            codicePalestraDirezione.clear();
            dataOraDirezione.clear();
            tesseraFIPDirezione.clear();
        } catch (SQLException e) {
            codicePalestraDirezione.clear();
            codicePalestraDirezione.setPromptText("Errore di rimozione");
            codicePalestraDirezione.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    private void viewPartite() {
        this.partite.getColumns().clear();
        TableColumn<Partita, String> nomeCasaColum = new TableColumn<>("Nome Casa");
        nomeCasaColum.setCellValueFactory(new PropertyValueFactory<>("nomeCasa"));
        TableColumn<Partita, Integer> puntiCasaColum = new TableColumn<>("Punti Casa");
        puntiCasaColum.setCellValueFactory(new PropertyValueFactory<>("puntiCasa"));
        TableColumn<Partita, String> nomeOspitiColum = new TableColumn<>("Nome Ospiti");
        nomeOspitiColum.setCellValueFactory(new PropertyValueFactory<>("nomeOspiti"));
        TableColumn<Partita, Integer> puntiOspitiColum = new TableColumn<>("Punti Ospiti");
        puntiOspitiColum.setCellValueFactory(new PropertyValueFactory<>("puntiOspiti"));
        TableColumn<Partita, String> dataOraColum = new TableColumn<>("Data Ora");
        dataOraColum.setCellValueFactory(new PropertyValueFactory<>("dataOra"));
        TableColumn<Partita, String> codicePalestraColum = new TableColumn<>("Codice Palestra");
        codicePalestraColum.setCellValueFactory(new PropertyValueFactory<>("codicePalestra"));
        TableColumn<Partita, String> idCampionatoColum = new TableColumn<>("Id Campionato");
        idCampionatoColum.setCellValueFactory(new PropertyValueFactory<>("idCampionato"));
        TableColumn<Partita, Integer> annoCampionatoColum = new TableColumn<>("Anno Campionato");
        annoCampionatoColum.setCellValueFactory(new PropertyValueFactory<>("annoCampionato"));
        TableColumn<Partita, String> nomeGironeColum = new TableColumn<>("Nome Girone");
        nomeGironeColum.setCellValueFactory(new PropertyValueFactory<>("nomeGirone"));
        this.partite.getColumns().addAll(Arrays.asList(nomeCasaColum, puntiCasaColum, nomeOspitiColum, puntiOspitiColum,
                dataOraColum, codicePalestraColum, idCampionatoColum, annoCampionatoColum, nomeGironeColum));
        this.partite.setItems(this.featuresPartita.viewPartite());

    }
    
    private void viewPerformance() {
        this.performance.getColumns().clear();
        TableColumn<Performance, String> codicePalestraColum = new TableColumn<>("Nome");
        codicePalestraColum.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Performance, String> dataOraColum = new TableColumn<>("Cognome");
        dataOraColum.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Performance, String> tesseraFIPColum = new TableColumn<>("Nome squadra");
        tesseraFIPColum.setCellValueFactory(new PropertyValueFactory<>("nomeSquadra"));
        TableColumn<Performance, Integer> rimbalziColum = new TableColumn<>("Rimbalzi");
        rimbalziColum.setCellValueFactory(new PropertyValueFactory<>("rimbalzi"));
        TableColumn<Performance, Integer> assistColum = new TableColumn<>("Assist");
        assistColum.setCellValueFactory(new PropertyValueFactory<>("assist"));
        TableColumn<Performance, Integer> falliFattiColum = new TableColumn<>("Falli Fatti");
        falliFattiColum.setCellValueFactory(new PropertyValueFactory<>("falliFatti"));
        TableColumn<Performance, Integer> falliSubitiColum = new TableColumn<>("Falli Subiti");
        falliSubitiColum.setCellValueFactory(new PropertyValueFactory<>("falliSubiti"));
        TableColumn<Performance, Integer> minutiColum = new TableColumn<>("Minuti");
        minutiColum.setCellValueFactory(new PropertyValueFactory<>("minuti"));
        TableColumn<Performance, Integer> tiri2Colum = new TableColumn<>("Tiri 2");
        tiri2Colum.setCellValueFactory(new PropertyValueFactory<>("tiri2"));
        TableColumn<Performance, Integer> tiri3Colum = new TableColumn<>("Tiri 3");
        tiri3Colum.setCellValueFactory(new PropertyValueFactory<>("tiri3"));
        TableColumn<Performance, Integer> tiriLiberiColum = new TableColumn<>("Tiri Liberi");
        tiriLiberiColum.setCellValueFactory(new PropertyValueFactory<>("tiriLiberi"));
        TableColumn<Performance, Integer> tiri2_segnatiColum = new TableColumn<>("Tiri 2 Segnati");
        tiri2_segnatiColum.setCellValueFactory(new PropertyValueFactory<>("tiri2_segnati"));
        TableColumn<Performance, Integer> tiri3_segnatiColum = new TableColumn<>("Tiri 3 Segnati");
        tiri3_segnatiColum.setCellValueFactory(new PropertyValueFactory<>("tiri3_segnati"));
        TableColumn<Performance, Integer> tiriLiberi_segnatiColum = new TableColumn<>("Tiri Liberi Segnati");
        tiriLiberi_segnatiColum.setCellValueFactory(new PropertyValueFactory<>("tiriLiberi_segnati"));
        TableColumn<Performance, Integer> palleRubateColum = new TableColumn<>("Palle Rubate");
        palleRubateColum.setCellValueFactory(new PropertyValueFactory<>("palle_rubate"));
        TableColumn<Performance, Integer> pallePerseColum = new TableColumn<>("Palle Perse");
        pallePerseColum.setCellValueFactory(new PropertyValueFactory<>("palle_perse"));
        TableColumn<Performance, Integer> stoppateColum = new TableColumn<>("Stoppate");
        stoppateColum.setCellValueFactory(new PropertyValueFactory<>("stoppate"));
        this.performance.getColumns()
                .addAll(Arrays.asList(codicePalestraColum, dataOraColum, tesseraFIPColum, rimbalziColum, assistColum,
                        falliFattiColum, falliSubitiColum, minutiColum, tiri2Colum, tiri3Colum, tiriLiberiColum,
                        tiri2_segnatiColum, tiri3_segnatiColum, tiriLiberi_segnatiColum, palleRubateColum,
                        pallePerseColum, stoppateColum));
        this.performance.setItems(this.featuresPartita.viewPerformance());
    }

    private void viewDirezione() {
        this.direzione.getColumns().clear();
        TableColumn<Direzione, String> nomeColum = new TableColumn<>("Nome");
        nomeColum.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Direzione, String> cognomeColum = new TableColumn<>("Cognome");
        cognomeColum.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Direzione, String> nomaSquadra1 = new TableColumn<>("Nome squadra casa");
        nomaSquadra1.setCellValueFactory(new PropertyValueFactory<>("nomeSquadra1"));
        TableColumn<Direzione, String> nomeSquadra2 = new TableColumn<>("Nome squadra ospite");
        nomeSquadra2.setCellValueFactory(new PropertyValueFactory<>("nomeSquadra2"));
        TableColumn<Direzione, String> dataOraColumn = new TableColumn<>("Data Ora");
        dataOraColumn.setCellValueFactory(new PropertyValueFactory<>("dataOra"));
        TableColumn<Direzione, String> rimborso = new TableColumn<>("Rimborso");
        rimborso.setCellValueFactory(new PropertyValueFactory<>("rimborso"));
        this.direzione.getColumns().addAll(Arrays.asList(nomeColum, cognomeColum, nomaSquadra1, nomeSquadra2,
                dataOraColumn, rimborso));
        this.direzione.setItems(this.featuresPartita.viewDirezione());
    }

    private void viewCoDirezione() {
        this.codirezione.getColumns().clear();
        TableColumn<Direzione, String> nomeColum = new TableColumn<>("Nome");
        nomeColum.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Direzione, String> cognomeColum = new TableColumn<>("Cognome");
        cognomeColum.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Direzione, String> nomaSquadra1 = new TableColumn<>("Nome squadra casa");
        nomaSquadra1.setCellValueFactory(new PropertyValueFactory<>("nomeSquadra1"));
        TableColumn<Direzione, String> nomeSquadra2 = new TableColumn<>("Nome squadra ospite");
        nomeSquadra2.setCellValueFactory(new PropertyValueFactory<>("nomeSquadra2"));
        TableColumn<Direzione, String> dataOraColumn = new TableColumn<>("Data Ora");
        dataOraColumn.setCellValueFactory(new PropertyValueFactory<>("dataOra"));
        TableColumn<Direzione, String> rimborso = new TableColumn<>("Rimborso");
        rimborso.setCellValueFactory(new PropertyValueFactory<>("rimborso"));
        this.codirezione.getColumns().addAll(Arrays.asList(nomeColum, cognomeColum, nomaSquadra1, nomeSquadra2,
                dataOraColumn, rimborso));
        this.codirezione.setItems(this.featuresPartita.viewCoDirezione());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.viewPartite();
        this.viewPerformance();
        this.viewDirezione();
        this.viewCoDirezione();
    }

    
}
