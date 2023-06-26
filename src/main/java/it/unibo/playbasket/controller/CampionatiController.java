package it.unibo.playbasket.controller;

import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.ResourceBundle;

import it.unibo.playbasket.db.features.FeaturesCampionato;
import it.unibo.playbasket.db.views.Campionato;
import it.unibo.playbasket.db.views.Girone;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CampionatiController implements Initializable{

    private FxView view;
    private FeaturesCampionato featuresCampionato;
    @FXML private TextField nomeGirone;
    @FXML private TextField annoGirone;
    @FXML private TextField idGirone;
    @FXML private TextField provincia;
    @FXML private TextField idVisualizza;
    @FXML private TextField annoVisualizza;
    @FXML private TextField nomeCampionato;
    @FXML private TextField annoCampionato;
    @FXML private TextField idCampionato;
    @FXML private TextField regione;
    @FXML private TextField codiceMeccanografico;
    @FXML private TextField idVincitore;
    @FXML private TextField annoVincitore;
    @FXML private TableView<Campionato> campionatiView;
    @FXML private TableView<Girone> gironeView;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public CampionatiController(FxView view, FeaturesCampionato featuresCampionato){
        this.view = view;
        this.featuresCampionato = featuresCampionato;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.viewCampionati();
        this.viewGirone();
    }

    @FXML
    public void goManagement(){
        this.view.setAdminView();
    }

    @FXML
    public void addCampionato() {
        try {
            featuresCampionato.addCampionato(nomeCampionato.getText(), idCampionato.getText(), regione.getText(),
                                            Integer.parseInt(annoCampionato.getText()));
            this.viewCampionati();
            this.nomeCampionato.clear();
            this.idCampionato.clear();
            this.regione.clear();
            this.annoCampionato.clear();
        } catch (SQLIntegrityConstraintViolationException e) {
            this.nomeCampionato.clear();
            this.nomeCampionato.setPromptText("Errore di inserimento");
            this.nomeCampionato.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalArgumentException("Campionato già presente", e);
        } catch (SQLException e) {
            this.nomeCampionato.clear();
            this.nomeCampionato.setPromptText("Errore di inserimento");
            this.nomeCampionato.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }

    }

    @FXML
    public void removeCampionato() {
        try {
            featuresCampionato.removeCampionato(idCampionato.getText(), Integer.parseInt(annoCampionato.getText()));
            this.viewCampionati();
            this.idVisualizza.clear();
            this.annoVisualizza.clear();
        } catch (SQLException e) {
            this.idVisualizza.clear();
            this.idVisualizza.setPromptText("Errore di inserimento");
            this.idVisualizza.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addWinner() {
        try {
            featuresCampionato.addWinner(codiceMeccanografico.getText(), idVincitore.getText(), Integer.parseInt(annoVincitore.getText()));
            this.viewCampionati();
            this.idVincitore.clear();
            this.annoVincitore.clear();
            this.codiceMeccanografico.clear();
        } catch (SQLIntegrityConstraintViolationException e) {
            this.idVincitore.clear();
            this.idVincitore.setPromptText("Errore di inserimento");
            this.idVincitore.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalArgumentException("Campionato già presente", e);
        } catch (SQLException e) {
            this.idVincitore.clear();
            this.idVincitore.setPromptText("Errore di inserimento");
            this.idVincitore.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeWinner() {
        try {
            featuresCampionato.removeWinner(idVincitore.getText(), Integer.parseInt(annoVincitore.getText()), codiceMeccanografico.getText());
            this.viewCampionati();
            this.codiceMeccanografico.clear();
            this.idVincitore.clear();
            this.annoVincitore.clear();
        } catch (SQLException e) {
            this.idVincitore.clear();
            this.idVincitore.setPromptText("Errore di inserimento");
            this.idVincitore.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }

    }

    @FXML
    public void addGirone() {
        try {
            featuresCampionato.addGirone(nomeGirone.getText(), idGirone.getText(), Integer.parseInt(annoGirone.getText()),
                                         provincia.getText());
            this.nomeGirone.clear();
            this.idGirone.clear();
            this.annoGirone.clear();
            this.provincia.clear();
        } catch (SQLIntegrityConstraintViolationException e) {
            this.nomeGirone.clear();
            this.nomeGirone.setPromptText("Errore di inserimento");
            this.nomeGirone.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalArgumentException("Girone già presente", e);
        } catch (SQLException e) {
            this.nomeGirone.clear();
            this.nomeGirone.setPromptText("Errore di inserimento");
            this.nomeGirone.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }

    }

    @FXML
    public void removeGirone() {
        try {
            featuresCampionato.removeGirone(nomeGirone.getText(), idGirone.getText(), Integer.parseInt(annoGirone.getText()));
            this.nomeGirone.clear();
            this.idGirone.clear();
            this.annoGirone.clear();
        } catch (SQLException e) {
            this.nomeGirone.clear();
            this.nomeGirone.setPromptText("Errore di inserimento");
            this.nomeGirone.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    private void viewGirone() {
        this.gironeView.getColumns().clear();
        TableColumn<Girone, String> nomeGirone = new TableColumn<>("Nome Girone");
        nomeGirone.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Girone, String> nomeCampionato = new TableColumn<>("Nome Campionato");
        nomeCampionato.setCellValueFactory(new PropertyValueFactory<>("nomeCampionato"));
        TableColumn<Girone, String> provincia = new TableColumn<>("Provincia");
        provincia.setCellValueFactory(new PropertyValueFactory<>("provincia"));
        this.gironeView.getColumns().addAll(Arrays.asList(nomeGirone, nomeCampionato, provincia));
        this.gironeView.setItems(this.featuresCampionato.viewGirone());

    }

    @FXML
    private void viewCampionati() {
        this.campionatiView.getColumns().clear();
        TableColumn<Campionato, String> nomeCampionato = new TableColumn<>("Nome Campionato");
        nomeCampionato.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Campionato, Integer> annoCampionato = new TableColumn<>("Anno Campionato");
        annoCampionato.setCellValueFactory(new PropertyValueFactory<>("anno"));
        TableColumn<Campionato, String> regione = new TableColumn<>("Regione");
        regione.setCellValueFactory(new PropertyValueFactory<>("regione"));
        TableColumn<Campionato, String> vintoDa = new TableColumn<>("Vinto Da");
        vintoDa.setCellValueFactory(new PropertyValueFactory<>("vinto_da"));
        this.campionatiView.getColumns().addAll(Arrays.asList(nomeCampionato, annoCampionato, regione, vintoDa));
        this.campionatiView.setItems(featuresCampionato.viewCampionati());
    }
}
