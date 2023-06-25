package it.unibo.playbasket.controller;

import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.ResourceBundle;

import it.unibo.playbasket.db.features.FeaturesPartita;
import it.unibo.playbasket.db.views.Partita;
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
    private TableView<Partita> performance;


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
            this.featuresPartita.addPerformance(codicePalestraPerformance.getText(), dataOraPerformance.getText(),
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
    public void removePerformance() {}

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
        this.partite.getItems().addAll(this.featuresPartita.viewPartite());

    }
    
    private void viewPerformance() {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.viewPartite();
    }

    
}
