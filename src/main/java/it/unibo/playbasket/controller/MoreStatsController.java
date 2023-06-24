package it.unibo.playbasket.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.playbasket.db.features.FeaturesMoreStats;
import it.unibo.playbasket.db.views.CalendarioGirone;
import it.unibo.playbasket.db.views.CalendarioPalestra;
import it.unibo.playbasket.db.views.CalendarioSocieta;
import it.unibo.playbasket.db.views.CalendarioSquadra;
import it.unibo.playbasket.db.views.Under21;
import it.unibo.playbasket.db.views.VittoriaOspite;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller for more-stats page.
 */
public class MoreStatsController implements Initializable{

    private FxView view;
    private FeaturesMoreStats featuresMoreStats;
    @FXML private TextField annoCampionato;
    @FXML private TextField nomeGirone;
    @FXML private TextField idCampionato;
    @FXML private TextField annoSquadra;
    @FXML private TextField nomeSquadra;
    @FXML private TextField nomeGironeSquadra;
    @FXML private TextField idCampionatoSquadra;
    @FXML private TextField annoPalestra;
    @FXML private TextField idPalestra;
    @FXML private TextField annoSocieta;
    @FXML private TextField codiceMeccanografico;
    @FXML private TextField tesseraArbitro;
    @FXML private TextField annoCampionatoOspite;
    @FXML private TextField idCampionatoOspite;
    @FXML private TableView societa;
    @FXML private TableView palestra;
    @FXML private TableView squadra;
    @FXML private TableView girone;
    @FXML private TableView stipendioArbitro;
    @FXML private TableView under21;
    @FXML private TableView vittoriaOspite;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public MoreStatsController(FxView view, FeaturesMoreStats featuresMoreStats){
        this.view = view;
        this.featuresMoreStats = featuresMoreStats;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewUnder21();
    }

    @FXML
    public void goHome(){
        this.view.setMainView();
    }

    @FXML
    public void viewVittoriaOspite() {
        this.vittoriaOspite.getColumns().clear();
        TableColumn<VittoriaOspite, String> nomeSquadra = new TableColumn<>("Nome squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra"));
        TableColumn<VittoriaOspite, Integer> vittorieOspite = new TableColumn<>("Vittorie ospite");
        vittorieOspite.setCellValueFactory(new PropertyValueFactory<>("num_vittorie_ospiti"));
        this.vittoriaOspite.getColumns().addAll(nomeSquadra, vittorieOspite);
        this.vittoriaOspite.setItems(this.featuresMoreStats.viewVittoriaOspite(this.idCampionatoOspite.getText(),
                                                                                Integer.parseInt(this.annoCampionatoOspite.getText())));
    }

    @FXML
    public void viewCalendarSocieta() {
        this.societa.getColumns().clear();
        TableColumn<CalendarioSocieta, String> nomeSquadra = new TableColumn<>("Nome squadra 1");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra1"));
        TableColumn<CalendarioSocieta, String> nomeSquadra2 = new TableColumn<>("Nome squadra 2");
        nomeSquadra2.setCellValueFactory(new PropertyValueFactory<>("nome_squadra2"));
        TableColumn<CalendarioSocieta, String> nomePalestra = new TableColumn<>("Nome palestra");
        nomePalestra.setCellValueFactory(new PropertyValueFactory<>("nome_palestra"));
        TableColumn<CalendarioSocieta, String> indirizzo = new TableColumn<>("Indirizzo");
        indirizzo.setCellValueFactory(new PropertyValueFactory<>("indirizzo"));
        TableColumn<CalendarioSocieta, String> dataOra = new TableColumn<>("Data ora");
        dataOra.setCellValueFactory(new PropertyValueFactory<>("data_ora"));
        TableColumn<CalendarioSocieta, String> nomeCampionato = new TableColumn<>("Nome campionato");
        nomeCampionato.setCellValueFactory(new PropertyValueFactory<>("nome_campionato"));
        TableColumn<CalendarioSocieta, String> nomeGirone = new TableColumn<>("Nome girone");
        nomeGirone.setCellValueFactory(new PropertyValueFactory<>("nome_girone"));
        this.societa.getColumns().addAll(nomeSquadra, nomeSquadra2, nomePalestra, indirizzo, dataOra, nomeCampionato, nomeGirone);
        this.societa.setItems(this.featuresMoreStats.viewCalendarSocieta(Integer.parseInt(this.annoSocieta.getText()),
                                                                          this.codiceMeccanografico.getText()));
    }

    @FXML
    public void viewCalendarSquadra() {
        this.squadra.getColumns().clear();
        TableColumn<CalendarioSquadra, String> nomeSquadra = new TableColumn<>("Nome squadra 1");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra1"));
        TableColumn<CalendarioSquadra, String> nomeSquadra2 = new TableColumn<>("Nome squadra 2");
        nomeSquadra2.setCellValueFactory(new PropertyValueFactory<>("nome_squadra2"));
        TableColumn<CalendarioSquadra, String> nomePalestra = new TableColumn<>("Nome palestra");
        nomePalestra.setCellValueFactory(new PropertyValueFactory<>("nome_palestra"));
        TableColumn<CalendarioSquadra, String> indirizzo = new TableColumn<>("Indirizzo");
        indirizzo.setCellValueFactory(new PropertyValueFactory<>("indirizzo"));
        TableColumn<CalendarioSquadra, String> dataOra = new TableColumn<>("Data ora");
        dataOra.setCellValueFactory(new PropertyValueFactory<>("data_ora"));
        this.squadra.getColumns().addAll(nomeSquadra, nomeSquadra2, nomePalestra, indirizzo, dataOra);
        this.squadra.setItems(this.featuresMoreStats.viewCalendarSquadra(this.idCampionatoSquadra.getText(),
                                                                          Integer.parseInt(this.annoSquadra.getText()),
                                                                          this.nomeGironeSquadra.getText(),
                                                                          this.nomeSquadra.getText()));
    }

    @FXML
    public void viewCalendarGirone() {
        this.girone.getColumns().clear();
        TableColumn<CalendarioGirone, String> nomeSquadra = new TableColumn<>("Nome squadra 1");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra1"));
        TableColumn<CalendarioGirone, String> nomeSquadra2 = new TableColumn<>("Nome squadra 2");
        nomeSquadra2.setCellValueFactory(new PropertyValueFactory<>("nome_squadra2"));  
        TableColumn<CalendarioGirone, String> nomePalestra = new TableColumn<>("Nome palestra");
        nomePalestra.setCellValueFactory(new PropertyValueFactory<>("nome_palestra"));
        TableColumn<CalendarioGirone, String> indirizzo = new TableColumn<>("Indirizzo");
        indirizzo.setCellValueFactory(new PropertyValueFactory<>("indirizzo"));
        TableColumn<CalendarioGirone, String> dataOra = new TableColumn<>("Data ora");
        dataOra.setCellValueFactory(new PropertyValueFactory<>("data_ora"));
        this.girone.getColumns().addAll(nomeSquadra, nomeSquadra2, nomePalestra, indirizzo, dataOra);
        this.girone.setItems(this.featuresMoreStats.viewCalendarGirone(this.idCampionato.getText(),
                                                                        Integer.parseInt(this.annoCampionato.getText()),
                                                                        this.nomeGirone.getText()));
    }

    @FXML
    public void viewCalendarPalestra(){
        this.palestra.getColumns().clear();
        TableColumn<CalendarioPalestra, String> nomeSquadra = new TableColumn<>("Nome squadra 1");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra1"));
        TableColumn<CalendarioPalestra, String> nomeSquadra2 = new TableColumn<>("Nome squadra 2");
        nomeSquadra2.setCellValueFactory(new PropertyValueFactory<>("nome_squadra2"));
        TableColumn<CalendarioPalestra, String> nomePalestra = new TableColumn<>("Nome palestra");
        nomePalestra.setCellValueFactory(new PropertyValueFactory<>("nome_palestra"));
        TableColumn<CalendarioPalestra, String> indirizzo = new TableColumn<>("Indirizzo");
        indirizzo.setCellValueFactory(new PropertyValueFactory<>("indirizzo"));
        TableColumn<CalendarioPalestra, String> dataOra = new TableColumn<>("Data ora");
        dataOra.setCellValueFactory(new PropertyValueFactory<>("data_ora"));
        this.palestra.getColumns().addAll(nomeSquadra, nomeSquadra2, nomePalestra, indirizzo, dataOra);
        this.palestra.setItems(this.featuresMoreStats.viewCalendarPalestra(this.idPalestra.getText(),
                                                                            Integer.parseInt(this.annoPalestra.getText())));
    }

    @FXML
    public void calculateStipendio() {

    }

    private void viewUnder21() {
        this.under21.getColumns().clear();
        TableColumn<Under21, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Under21, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Under21, Integer> eta = new TableColumn<>("Eta");
        eta.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<Under21, String> ruolo = new TableColumn<>("Ruolo");
        ruolo.setCellValueFactory(new PropertyValueFactory<>("ruolo"));
        TableColumn<Under21, String> nomeSquadra = new TableColumn<>("Nome squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra"));
        TableColumn<Under21, Integer> punti = new TableColumn<>("Punti");
        punti.setCellValueFactory(new PropertyValueFactory<>("punti"));
        this.under21.getColumns().addAll(nome, cognome, eta, ruolo, nomeSquadra, punti);
        this.under21.setItems(this.featuresMoreStats.viewUnder21());
    }
}
