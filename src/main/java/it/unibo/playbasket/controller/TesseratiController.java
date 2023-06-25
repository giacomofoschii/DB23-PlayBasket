package it.unibo.playbasket.controller;

import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.ResourceBundle;

import it.unibo.playbasket.db.features.FeaturesTesserato;
import it.unibo.playbasket.db.views.Arbitro;
import it.unibo.playbasket.db.views.Giocatore;
import it.unibo.playbasket.db.views.Staff;
import it.unibo.playbasket.db.views.Ufficiale;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TesseratiController implements Initializable{

    private FxView view;
    private FeaturesTesserato featuresTesserato;
    @FXML private TextField nomeGiocatore;
    @FXML private TextField cognomeGiocatore;
    @FXML private TextField cfGiocatore;
    @FXML private TextField tesseraGiocatore;
    @FXML private TextField etaGiocatore;
    @FXML private TextField nomeArbitro;
    @FXML private TextField cognomeArbitro;
    @FXML private TextField cfArbitro;
    @FXML private TextField etaArbitro;
    @FXML private TextField tesseraArbitro;
    @FXML private TextField nomeUfficiale;
    @FXML private TextField cognomeUfficiale;
    @FXML private TextField cfUfficiale;
    @FXML private TextField etaUfficiale;
    @FXML private TextField tesseraUfficiale;
    @FXML private TextField nomeStaff;
    @FXML private TextField cognomeStaff;
    @FXML private TextField cfStaff;
    @FXML private TextField tesseraStaff;
    @FXML private TextField etaStaff;
    @FXML private TextField peso;
    @FXML private TextField altezza;
    @FXML private ChoiceBox<String> ruolo;
    @FXML private TextField aperturaAlare;
    @FXML private CheckBox refertista;
    @FXML private CheckBox cronometrista;
    @FXML private CheckBox segnapunti;
    @FXML private TextField sezione;
    @FXML private TextField grado;
    @FXML private CheckBox preparatoreFisico;
    @FXML private CheckBox medico;
    @FXML private CheckBox accompagnatore;
    @FXML private CheckBox allenatore;
    @FXML private CheckBox aiutoAllenatore;
    @FXML private CheckBox massaggiatore;
    @FXML private CheckBox addettoArbitri;
    @FXML private CheckBox scorer;
    @FXML private TextField annoPatentino;
    @FXML private TextField specializzazione;
    @FXML private TextField tesseraRimozione;
    @FXML private TableView<Arbitro> arbitriView;
    @FXML private TableView<Giocatore> giocatoriView;
    @FXML private TableView<Ufficiale> ufficialiView;
    @FXML private TableView<Staff> staffView;

    private String[] ruoli = {"Playmaker", "Guardia", "Ala_p", "Ala_g", "Centro"};

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public TesseratiController(FxView view, FeaturesTesserato featuresTesseratoTesserato){
        this.view = view;
        this.featuresTesserato = featuresTesseratoTesserato;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ruolo.getItems().addAll(ruoli);
        this.viewPlayers();
        this.viewArbitri();
        this.viewUfficiali();
        this.viewStaff();
    }

    @FXML
    public void goManagement(){
        this.view.setAdminView();
    }

    @FXML
    public void addGiocatore() {
        try{
            if(aperturaAlare.getText().equals("")) {
                featuresTesserato.addGiocatore(nomeGiocatore.getText(), cognomeGiocatore.getText(),
                                        cfGiocatore.getText(), Integer.parseInt(etaGiocatore.getText()), tesseraGiocatore.getText(),
                                        Integer.parseInt(peso.getText()), Integer.parseInt(altezza.getText()), ruolo.getValue(), 0);
            } else {
                featuresTesserato.addGiocatore(nomeGiocatore.getText(), cognomeGiocatore.getText(),
                                        cfGiocatore.getText(), Integer.parseInt(etaGiocatore.getText()), tesseraGiocatore.getText(),
                                        Integer.parseInt(peso.getText()), Integer.parseInt(altezza.getText()), 
                                        ruolo.getValue(), Integer.parseInt(aperturaAlare.getText()));
            }
            nomeGiocatore.clear();
            cognomeGiocatore.clear();
            cfGiocatore.clear();
            etaGiocatore.clear();
            tesseraGiocatore.clear();
            peso.clear();
            altezza.clear();
            ruolo.setValue(null);
            aperturaAlare.clear();
            this.viewPlayers();
        } catch (SQLIntegrityConstraintViolationException e) {
            nomeGiocatore.clear();
            nomeGiocatore.setPromptText("Errore di inserimento");
            nomeGiocatore.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            nomeGiocatore.clear();
            nomeGiocatore.setPromptText("Errore di inserimento");
            nomeGiocatore.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addArbitro() {
        try{
            featuresTesserato.addArbitro(nomeArbitro.getText(), cognomeArbitro.getText(),
                                    cfArbitro.getText(), Integer.parseInt(etaArbitro.getText()), tesseraArbitro.getText(),
                                    sezione.getText(), Integer.parseInt(grado.getText()));
            nomeArbitro.clear();
            cognomeArbitro.clear();
            cfArbitro.clear();
            etaArbitro.clear();
            tesseraArbitro.clear();
            sezione.clear();
            grado.clear();
            this.viewArbitri();
        } catch (SQLIntegrityConstraintViolationException e) {
            nomeArbitro.clear();
            nomeArbitro.setPromptText("Errore di inserimento");
            nomeArbitro.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            nomeArbitro.clear();
            nomeArbitro.setPromptText("Errore di inserimento");
            nomeArbitro.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addUfficiale() {
        try{
            featuresTesserato.addUfficiale(nomeUfficiale.getText(), cognomeUfficiale.getText(),
                                    cfUfficiale.getText(), Integer.parseInt(etaUfficiale.getText()), tesseraUfficiale.getText(),
                                    refertista.isSelected(), cronometrista.isSelected(), segnapunti.isSelected());
            nomeUfficiale.clear();
            cognomeUfficiale.clear();
            cfUfficiale.clear();
            etaUfficiale.clear();
            tesseraUfficiale.clear();
            refertista.setSelected(false);
            cronometrista.setSelected(false);
            segnapunti.setSelected(false);
            this.viewUfficiali();
        } catch (SQLIntegrityConstraintViolationException e) {
            nomeUfficiale.clear();
            nomeUfficiale.setPromptText("Errore di inserimento");
            nomeUfficiale.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            nomeUfficiale.clear();
            nomeUfficiale.setPromptText("Errore di inserimento");
            nomeUfficiale.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addStaff(){
        try{
            if(annoPatentino.getText().equals("")) {
                featuresTesserato.addTesseratoStaff(nomeStaff.getText(), cognomeStaff.getText(),
                                        cfStaff.getText(), tesseraStaff.getText(), Integer.parseInt(etaStaff.getText()),
                                        preparatoreFisico.isSelected(), medico.isSelected(), accompagnatore.isSelected(),
                                        allenatore.isSelected(), aiutoAllenatore.isSelected(), massaggiatore.isSelected(),
                                        addettoArbitri.isSelected(), scorer.isSelected(),
                                        specializzazione.getText(), 0);
            } else {
                featuresTesserato.addTesseratoStaff(nomeStaff.getText(), cognomeStaff.getText(),
                                        cfStaff.getText(), tesseraStaff.getText(), Integer.parseInt(etaStaff.getText()),
                                        preparatoreFisico.isSelected(), medico.isSelected(), accompagnatore.isSelected(),
                                        allenatore.isSelected(), aiutoAllenatore.isSelected(), massaggiatore.isSelected(),
                                        addettoArbitri.isSelected(), scorer.isSelected(),
                                        specializzazione.getText(), Integer.parseInt(annoPatentino.getText()));
            }
            nomeStaff.clear();
            cognomeStaff.clear();
            cfStaff.clear();
            tesseraStaff.clear();
            etaStaff.clear();
            preparatoreFisico.setSelected(false);
            medico.setSelected(false);
            accompagnatore.setSelected(false);
            allenatore.setSelected(false);
            aiutoAllenatore.setSelected(false);
            massaggiatore.setSelected(false);
            addettoArbitri.setSelected(false);
            scorer.setSelected(false);
            annoPatentino.clear();
            specializzazione.clear();
            this.viewStaff();
        } catch (SQLIntegrityConstraintViolationException e) {
            nomeStaff.clear();
            nomeStaff.setPromptText("Errore di inserimento");
            nomeStaff.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            nomeStaff.clear();
            nomeStaff.setPromptText("Errore di inserimento");
            nomeStaff.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeTesserato() {
        try{
            featuresTesserato.removeTesserato(tesseraRimozione.getText());
            tesseraRimozione.clear();
            this.viewArbitri();
            this.viewPlayers();
            this.viewStaff();
            this.viewUfficiali();
        } catch (SQLException e) {
            tesseraRimozione.clear();
            tesseraRimozione.setPromptText("Errore di rimozione");
            tesseraRimozione.setStyle("-fx-prompt-text-fill: red;");
            throw new IllegalStateException(e);
        }
    }

    private void viewPlayers() {
        giocatoriView.getColumns().clear();
        TableColumn<Giocatore,String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Giocatore,String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Giocatore,String> CF = new TableColumn<>("CF");
        CF.setCellValueFactory(new PropertyValueFactory<>("CF"));
        TableColumn<Giocatore,String> tesseraFip = new TableColumn<>("Tessera FIP");
        tesseraFip.setCellValueFactory(new PropertyValueFactory<>("tesseraFip"));
        TableColumn<Giocatore,Integer> eta = new TableColumn<>("Eta");
        eta.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<Giocatore,Integer> peso = new TableColumn<>("Peso");
        peso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        TableColumn<Giocatore,Integer> altezza = new TableColumn<>("Altezza");
        altezza.setCellValueFactory(new PropertyValueFactory<>("altezza"));
        TableColumn<Giocatore,String> ruolo = new TableColumn<>("Ruolo");
        ruolo.setCellValueFactory(new PropertyValueFactory<>("ruolo"));
        TableColumn<Giocatore,Integer> aperturaAlare = new TableColumn<>("Apertura alare");
        aperturaAlare.setCellValueFactory(new PropertyValueFactory<>("apertura_Alare"));
        giocatoriView.getColumns().addAll(Arrays.asList(nome, cognome, CF, tesseraFip, eta, peso, altezza, ruolo, aperturaAlare));
        giocatoriView.setItems(featuresTesserato.viewPlayers());
    }

    private void viewArbitri() {
        arbitriView.getColumns().clear();
        TableColumn<Arbitro,String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Arbitro,String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Arbitro,String> CF = new TableColumn<>("CF");
        CF.setCellValueFactory(new PropertyValueFactory<>("CF"));
        TableColumn<Arbitro,String> tesseraFip = new TableColumn<>("Tessera FIP");
        tesseraFip.setCellValueFactory(new PropertyValueFactory<>("tesseraFip"));
        TableColumn<Arbitro,Integer> eta = new TableColumn<>("Eta");
        eta.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<Arbitro,String> sezione = new TableColumn<>("Sezione");
        sezione.setCellValueFactory(new PropertyValueFactory<>("sezione"));
        TableColumn<Arbitro,Integer> grado = new TableColumn<>("Grado");
        grado.setCellValueFactory(new PropertyValueFactory<>("grado"));
        TableColumn<Arbitro,Integer> stipendioTotale = new TableColumn<>("Stipendio totale");
        stipendioTotale.setCellValueFactory(new PropertyValueFactory<>("stipendio_totale"));
        arbitriView.getColumns().addAll(Arrays.asList(nome, cognome, CF, tesseraFip, eta, sezione, grado, stipendioTotale));
        arbitriView.setItems(featuresTesserato.viewArbitri());
    }

    private void viewUfficiali() {
        ufficialiView.getColumns().clear();
        TableColumn<Ufficiale,String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Ufficiale,String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Ufficiale,String> CF = new TableColumn<>("CF");
        CF.setCellValueFactory(new PropertyValueFactory<>("CF"));
        TableColumn<Ufficiale,String> tesseraFip = new TableColumn<>("Tessera FIP");
        tesseraFip.setCellValueFactory(new PropertyValueFactory<>("tesseraFip"));
        TableColumn<Ufficiale,Integer> eta = new TableColumn<>("Eta");
        eta.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<Ufficiale,Boolean> refertista = new TableColumn<>("Refertista");
        refertista.setCellValueFactory(new PropertyValueFactory<>("refertista"));
        TableColumn<Ufficiale,Boolean> cronometrista = new TableColumn<>("Cronometrista");
        cronometrista.setCellValueFactory(new PropertyValueFactory<>("cronometrista"));
        TableColumn<Ufficiale,Boolean> segnapunti = new TableColumn<>("Segnapunti");
        segnapunti.setCellValueFactory(new PropertyValueFactory<>("segnapunti"));
        TableColumn<Ufficiale,Integer> stipendioTotale = new TableColumn<>("Stipendio totale");
        stipendioTotale.setCellValueFactory(new PropertyValueFactory<>("stipendio_totale"));
        ufficialiView.getColumns().addAll(Arrays.asList(nome, cognome, CF, tesseraFip, eta, refertista, cronometrista, segnapunti, stipendioTotale));
        ufficialiView.setItems(featuresTesserato.viewUfficiali());
    }

    private void viewStaff() {
        staffView.getColumns().clear();
        TableColumn<Staff,String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Staff,String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Staff,String> CF = new TableColumn<>("CF");
        CF.setCellValueFactory(new PropertyValueFactory<>("CF"));
        TableColumn<Staff,String> tesseraFip = new TableColumn<>("Tessera FIP");
        tesseraFip.setCellValueFactory(new PropertyValueFactory<>("tesseraFip"));
        TableColumn<Staff,Integer> eta = new TableColumn<>("Eta");
        eta.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<Staff,Boolean> preparatoreFisico = new TableColumn<>("Preparatore fisico");
        preparatoreFisico.setCellValueFactory(new PropertyValueFactory<>("preparatore_fisico"));
        TableColumn<Staff,Boolean> allenatore = new TableColumn<>("Allenatore");
        allenatore.setCellValueFactory(new PropertyValueFactory<>("allenatore"));
        TableColumn<Staff,Boolean> aiutoAllenatore = new TableColumn<>("Aiuto allenatore");
        aiutoAllenatore.setCellValueFactory(new PropertyValueFactory<>("aiuto_allenatore"));
        TableColumn<Staff,Boolean> medico = new TableColumn<>("Medico");
        medico.setCellValueFactory(new PropertyValueFactory<>("medico"));
        TableColumn<Staff,Boolean> massaggiatore = new TableColumn<>("Massaggiatore");
        massaggiatore.setCellValueFactory(new PropertyValueFactory<>("massaggiatore"));
        TableColumn<Staff,Boolean> accompagnatore = new TableColumn<>("Accompagnatore");
        accompagnatore.setCellValueFactory(new PropertyValueFactory<>("accompagnatore"));
        TableColumn<Staff, Boolean> scorer = new TableColumn<>("Scorer");
        scorer.setCellValueFactory(new PropertyValueFactory<>("scorer"));
        TableColumn<Staff,Boolean> addettoArbitri = new TableColumn<>("Addetto arbitri");
        addettoArbitri.setCellValueFactory(new PropertyValueFactory<>("addetto_arbitro"));
        TableColumn<Staff,Integer> annoPatentino = new TableColumn<>("Anno patentino");
        annoPatentino.setCellValueFactory(new PropertyValueFactory<>("anno_patentino"));
        TableColumn<Staff,String> specializzazione = new TableColumn<>("Specializzazione");
        specializzazione.setCellValueFactory(new PropertyValueFactory<>("specializzazione"));
        staffView.getColumns().addAll(Arrays.asList(nome, cognome, CF, tesseraFip, eta, preparatoreFisico, allenatore,
                                        aiutoAllenatore, medico, massaggiatore, accompagnatore, scorer,
                                        addettoArbitri, annoPatentino, specializzazione));
        staffView.setItems(featuresTesserato.viewStaff());
    }
}
