package it.unibo.playbasket.controller;

import java.util.Arrays;

import it.unibo.playbasket.db.features.FeaturesCalendar;
import it.unibo.playbasket.db.views.CalendarioGirone;
import it.unibo.playbasket.db.views.CalendarioPalestra;
import it.unibo.playbasket.db.views.CalendarioSocieta;
import it.unibo.playbasket.db.views.CalendarioSquadra;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CalendarController {

    private FxView view;
    private FeaturesCalendar featuresCalendar;
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
    @FXML private TableView<CalendarioSocieta> societa;
    @FXML private TableView<CalendarioPalestra> palestra;
    @FXML private TableView<CalendarioSquadra> squadra;
    @FXML private TableView<CalendarioGirone> girone;

    public CalendarController(final FxView view, final FeaturesCalendar featuresCalendar) {
        this.view = view;
        this.featuresCalendar = featuresCalendar;
    }

    @FXML
    public void goHome(){
        this.view.setMainView();
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
        this.societa.getColumns().addAll(Arrays.asList(nomeSquadra, nomeSquadra2, nomePalestra, indirizzo, dataOra, nomeCampionato, nomeGirone));
        this.societa.setItems(this.featuresCalendar.viewCalendarSocieta(Integer.parseInt(this.annoSocieta.getText()),
                                                                          this.codiceMeccanografico.getText()));
        this.annoSocieta.clear();
        this.codiceMeccanografico.clear();
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
        this.squadra.getColumns().addAll(Arrays.asList(nomeSquadra, nomeSquadra2, nomePalestra, indirizzo, dataOra));
        this.squadra.setItems(this.featuresCalendar.viewCalendarSquadra(this.idCampionatoSquadra.getText(),
                                                                          Integer.parseInt(this.annoSquadra.getText()),
                                                                          this.nomeGironeSquadra.getText(),
                                                                          this.nomeSquadra.getText()));
        this.idCampionatoSquadra.clear();
        this.annoSquadra.clear();
        this.nomeGironeSquadra.clear();
        this.nomeSquadra.clear();
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
        this.girone.getColumns().addAll(Arrays.asList(nomeSquadra, nomeSquadra2, nomePalestra, indirizzo, dataOra));
        this.girone.setItems(this.featuresCalendar.viewCalendarGirone(this.idCampionato.getText(),
                                                                        Integer.parseInt(this.annoCampionato.getText()),
                                                                        this.nomeGirone.getText()));
        this.idCampionato.clear();
        this.annoCampionato.clear();
        this.nomeGirone.clear();
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
        this.palestra.getColumns().addAll(Arrays.asList(nomeSquadra, nomeSquadra2, nomePalestra, indirizzo, dataOra));
        this.palestra.setItems(this.featuresCalendar.viewCalendarPalestra(this.idPalestra.getText(),
                                                                            Integer.parseInt(this.annoPalestra.getText())));
        this.idPalestra.clear();
        this.annoPalestra.clear();
    }
}
