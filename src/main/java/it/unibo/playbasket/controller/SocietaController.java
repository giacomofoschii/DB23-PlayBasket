package it.unibo.playbasket.controller;

import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.ResourceBundle;

import it.unibo.playbasket.db.features.FeaturesSocieta;
import it.unibo.playbasket.db.views.MembroGiocatore;
import it.unibo.playbasket.db.views.MembroStaff;
import it.unibo.playbasket.db.views.Proprietario;
import it.unibo.playbasket.db.views.Schema;
import it.unibo.playbasket.db.views.Societa;
import it.unibo.playbasket.db.views.Squadra;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SocietaController implements Initializable{

    private FxView view;
    private FeaturesSocieta featuresSocieta;
    @FXML private TextField idCampionatoSquadra;
    @FXML private TextField annoCampionatoSquadra;
    @FXML private TextField nomeGironeSquadra;
    @FXML private TextField nomeSquadra;
    @FXML private TextField codicePalestra;
    @FXML private TextField codiceMeccanograficoSquadra;
    @FXML private TextField idSchema;
    @FXML private TextField annoSchema;
    @FXML private TextField gironeSchema;
    @FXML private TextField squadraSchema;
    @FXML private TextField nomeSchema;
    @FXML private TextField nomeSocieta;
    @FXML private TextField cfSocieta;
    @FXML private TextField telefono;
    @FXML private TextField email;
    @FXML private TextField via;
    @FXML private TextField civico;
    @FXML private TextField sponsor;
    @FXML private TextField codiceMeccanografico;
    @FXML private TextField nomeProprietario;
    @FXML private TextField cognomeProprietario;
    @FXML private TextField cf;
    @FXML private TextField idGiocatore;
    @FXML private TextField squadraGiocatore;
    @FXML private TextField annoGiocatore;
    @FXML private TextField gironeGiocatore;
    @FXML private TextField tesseraGiocatore;
    @FXML private TextField stipendioGiocatore;
    @FXML private TextField tesseraRimozioneGiocatore;
    @FXML private TextField idRimozioneGiocatore;
    @FXML private TextField squadraRimozioneGiocatore;
    @FXML private TextField annoRimozioneGiocatore;
    @FXML private TextField gironeRimozioneGiocatore;
    @FXML private TextField idCampionatoStaff;
    @FXML private TextField annoCampionatoStaff;
    @FXML private TextField gironeStaff;
    @FXML private TextField squadraStaff;
    @FXML private TextField tesseraStaff;
    @FXML private TextField stipendioStaff;
    @FXML private CheckBox capitano;
    @FXML private ChoiceBox<String> tipoSchema;
    @FXML private ChoiceBox<String> membriStaff;
    @FXML private TableView<Squadra> squadraView;
    @FXML private TableView<MembroGiocatore> giocatoreView;
    @FXML private TableView<Schema> schemaView;
    @FXML private TableView<Proprietario> proprietarioView;
    @FXML private TableView<MembroStaff> staffView;
    @FXML private TableView<Societa> societaView;

    private String[] ruoliStaff = {"medico", "allenatore", "preparatore fisico", "scorer",
                                    "addetto arbitri", "aiuto allenatore", "accompagnatore", "massaggiatore" };
    private String[] tipiSchema = {"attacco", "difesa"};

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public SocietaController(FxView view, FeaturesSocieta featuresSocieta){
        this.view = view;
        this.featuresSocieta = featuresSocieta;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.membriStaff.getItems().addAll(ruoliStaff);
        this.tipoSchema.getItems().addAll(tipiSchema);
        this.viewSquadre();
        this.viewSocieta();
        this.viewProprietari();
    }

    @FXML
    public void goManagement(){
        this.view.setAdminView();
    }

    
    @FXML
    public void addSquadra() {
        try {
            this.featuresSocieta.addSquadra(nomeSquadra.getText(), idCampionatoSquadra.getText(), Integer.parseInt(annoCampionatoSquadra.getText()),
                                             nomeGironeSquadra.getText(), codicePalestra.getText(), codiceMeccanograficoSquadra.getText());
            this.viewSquadre();
            this.nomeSquadra.clear();
            this.idCampionatoSquadra.clear();
            this.annoCampionatoSquadra.clear();
            this.nomeGironeSquadra.clear();
            this.codicePalestra.clear();
            this.codiceMeccanograficoSquadra.clear();
        } catch (SQLIntegrityConstraintViolationException e) {
            this.nomeSquadra.clear();
            this.nomeSquadra.setPromptText("Errore di inserimento");
            this.nomeSquadra.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        } catch (SQLException e) {
            this.nomeSquadra.clear();
            this.nomeSquadra.setPromptText("Errore di inserimento");
            this.nomeSquadra.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeSquadra() {
        try {
            this.featuresSocieta.removeSquadra(idCampionatoSquadra.getText(), nomeGironeSquadra.getText(), nomeSquadra.getText(),
                                                Integer.parseInt(annoCampionatoSquadra.getText()));
            this.viewSquadre();
            this.nomeSquadra.clear();
            this.idCampionatoSquadra.clear();
            this.annoCampionatoSquadra.clear();
            this.nomeGironeSquadra.clear();
        } catch (SQLException e) {
            this.nomeSquadra.clear();
            this.nomeSquadra.setPromptText("Errore di inserimento");
            this.nomeSquadra.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addSchema() {
        try {
            this.featuresSocieta.addSchema(nomeSchema.getText(), squadraSchema.getText(), idSchema.getText(),
                                        Integer.parseInt(annoSchema.getText()), gironeSchema.getText(), tipoSchema.getValue());
            this.viewSquadre();
            this.nomeSchema.clear();
            this.squadraSchema.clear();
            this.idSchema.clear();
            this.annoSchema.clear();
            this.gironeSchema.clear();
            this.tipoSchema.setValue(null);
        } catch (SQLIntegrityConstraintViolationException e) {
            this.nomeSchema.clear();
            this.nomeSchema.setPromptText("Errore di inserimento");
            this.nomeSchema.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        } catch (SQLException e) {
            this.nomeSchema.clear();
            this.nomeSchema.setPromptText("Errore di inserimento");
            this.nomeSchema.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }

    }

    @FXML
    public void removeSchema() {
        try {
            this.featuresSocieta.removeSchema(nomeSchema.getText(), squadraSchema.getText(), idSchema.getText(),
                                            Integer.parseInt(annoSchema.getText()), gironeSchema.getText());
            this.viewSquadre();
            this.nomeSchema.clear();
            this.squadraSchema.clear();
            this.idSchema.clear();
            this.annoSchema.clear();
            this.gironeSchema.clear();
            this.tipoSchema.setValue(null);
        } catch (SQLException e) {
            this.nomeSchema.clear();
            this.nomeSchema.setPromptText("Errore di inserimento");
            this.nomeSchema.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addSocieta() {
        try {
            this.featuresSocieta.addSocieta(codiceMeccanografico.getText(), sponsor.getText(), nomeSocieta.getText(),
                                            Integer.parseInt(telefono.getText()), email.getText(), via.getText(),
                                            Integer.parseInt(civico.getText()), cfSocieta.getText());
            this.viewSocieta();
            this.codiceMeccanografico.clear();
            this.sponsor.clear();
            this.nomeSocieta.clear();
            this.telefono.clear();
            this.email.clear();
            this.via.clear();
            this.civico.clear();
            this.cfSocieta.clear();
        } catch (SQLIntegrityConstraintViolationException e) {
            this.nomeSocieta.clear();
            this.nomeSocieta.setPromptText("Errore di inserimento");
            this.nomeSocieta.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        } catch (SQLException e) {
            this.nomeSocieta.clear();
            this.nomeSocieta.setPromptText("Errore di inserimento");
            this.nomeSocieta.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeSocieta() {
        try {
            this.featuresSocieta.removeSocieta(codiceMeccanografico.getText());
            this.viewSocieta();
            this.codiceMeccanografico.clear();
        } catch (Exception e) {
            this.nomeSocieta.clear();
            this.nomeSocieta.setPromptText("Errore di inserimento");
            this.nomeSocieta.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addProprietario() {
        try {
            this.featuresSocieta.addProprietario(nomeProprietario.getText(), cognomeProprietario.getText(), cf.getText());
            this.viewProprietari();
            this.nomeProprietario.clear();
            this.cognomeProprietario.clear();
            this.cf.clear();
        } catch (SQLIntegrityConstraintViolationException e) {
            this.nomeProprietario.clear();
            this.nomeProprietario.setPromptText("Errore di inserimento");
            this.nomeProprietario.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        } catch (SQLException e) {
            this.nomeProprietario.clear();
            this.nomeProprietario.setPromptText("Errore di inserimento");
            this.nomeProprietario.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeProprietario() {
        try {
            this.featuresSocieta.removeProprietario(cf.getText());
            this.viewProprietari();
            this.cf.clear();
        } catch (SQLException e) {
            this.nomeProprietario.clear();
            this.nomeProprietario.setPromptText("Errore di inserimento");
            this.nomeProprietario.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addGiocatore() {
        try {
            this.featuresSocieta.addGiocatore(tesseraGiocatore.getText(), Integer.parseInt(stipendioGiocatore.getText()), capitano.isSelected(),
                                                idGiocatore.getText(), Integer.parseInt(annoGiocatore.getText()),
                                                gironeGiocatore.getText(), squadraGiocatore.getText());
            this.viewSquadre();
            this.idGiocatore.clear();
            this.squadraGiocatore.clear();
            this.annoGiocatore.clear();
            this.gironeGiocatore.clear();
            this.tesseraGiocatore.clear();
            this.stipendioGiocatore.clear();
            this.capitano.setSelected(false);
        } catch (SQLIntegrityConstraintViolationException e) {
            this.idGiocatore.clear();
            this.idGiocatore.setPromptText("Errore di inserimento");
            this.idGiocatore.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        } catch (SQLException e) {
            this.idGiocatore.clear();
            this.idGiocatore.setPromptText("Errore di inserimento");
            this.idGiocatore.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeGiocatore() {
        try {
            this.featuresSocieta.removeGiocatore(tesseraGiocatore.getText(), idGiocatore.getText(),
                                                    Integer.parseInt(annoGiocatore.getText()),
                                                    gironeGiocatore.getText(), squadraGiocatore.getText());
            this.viewGiocatori();
            this.idGiocatore.clear();
            this.squadraGiocatore.clear();
            this.annoGiocatore.clear();
            this.gironeGiocatore.clear();
            this.tesseraGiocatore.clear();
            this.stipendioGiocatore.clear();
            this.capitano.setSelected(false);
        } catch (SQLException e) {
            this.idGiocatore.clear();
            this.idGiocatore.setPromptText("Errore di inserimento");
            this.idGiocatore.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void addStaff() {
        try {
            this.featuresSocieta.addStaff(assignRole(membriStaff.getValue()), tesseraStaff.getText(), Integer.parseInt(stipendioStaff.getText()),
                                            Integer.parseInt(annoCampionatoStaff.getText()), idCampionatoStaff.getText(),
                                            gironeStaff.getText(), squadraStaff.getText());
            this.viewSquadre();
            this.idCampionatoStaff.clear();
            this.annoCampionatoStaff.clear();
            this.tesseraStaff.clear();
            this.gironeStaff.clear();
            this.squadraStaff.clear();
            this.stipendioStaff.clear();
            this.membriStaff.setValue(null);
        } catch (SQLIntegrityConstraintViolationException e) {
            this.tesseraStaff.clear();
            this.tesseraStaff.setPromptText("Errore di inserimento");
            this.tesseraStaff.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            this.tesseraStaff.clear();
            this.tesseraStaff.setPromptText("Errore di inserimento");
            this.tesseraStaff.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }
    }

    @FXML
    public void removeStaff() {
        try {
            this.featuresSocieta.removeStaff(assignRole(membriStaff.getValue()), tesseraStaff.getText(), Integer.parseInt(annoCampionatoStaff.getText()),
                                            idCampionatoStaff.getText(), gironeStaff.getText(), squadraStaff.getText());
            this.viewStaff();
            this.idCampionatoStaff.clear();
            this.annoCampionatoStaff.clear();
            this.tesseraStaff.clear();
            this.gironeStaff.clear();
            this.squadraStaff.clear();
            this.stipendioStaff.clear();
            this.membriStaff.setValue(null);
        } catch (SQLException e) {
            this.tesseraStaff.clear();
            this.tesseraStaff.setPromptText("Errore di inserimento");
            this.tesseraStaff.setStyle("-fx-prompt-text-fill: red");
            throw new IllegalStateException(e);
        }

    }

    @FXML
    public void viewSchemi() {
        this.schemaView.getColumns().clear();
        TableColumn<Schema, String> nomeSchema = new TableColumn<>("Nome Schema");
        nomeSchema.setCellValueFactory(new PropertyValueFactory<>("nomeSchema"));
        TableColumn<Schema, String> tipoSchema = new TableColumn<>("Tipo Schema");
        tipoSchema.setCellValueFactory(new PropertyValueFactory<>("tipoSchema"));
        TableColumn<Schema, String> nomeSquadra = new TableColumn<>("Nome Squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nomeSquadra"));
        TableColumn<Schema, String> nomeCampionato = new TableColumn<>("Nome Campionato");
        nomeCampionato.setCellValueFactory(new PropertyValueFactory<>("nomeCampionato"));
        TableColumn<Schema, Integer> annoCampionato = new TableColumn<>("Anno Campionato");
        annoCampionato.setCellValueFactory(new PropertyValueFactory<>("anno"));
        this.schemaView.getColumns().addAll(Arrays.asList(nomeSchema, tipoSchema, nomeSquadra, nomeCampionato, annoCampionato));
        this.schemaView.setItems(this.featuresSocieta.viewSchemi());
    }

    @FXML
    public void viewGiocatori() {
        this.giocatoreView.getColumns().clear();
        TableColumn<MembroGiocatore, String> nomeGiocatore = new TableColumn<>("Nome Giocatore");
        nomeGiocatore.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<MembroGiocatore, String> cognomeGiocatore = new TableColumn<>("Cognome Giocatore");
        cognomeGiocatore.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<MembroGiocatore, String> ruoloGiocatore = new TableColumn<>("Ruolo");
        ruoloGiocatore.setCellValueFactory(new PropertyValueFactory<>("ruolo"));
        TableColumn<MembroGiocatore, String> etaGiocatore = new TableColumn<>("Eta");
        etaGiocatore.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<MembroGiocatore, Integer> altezzaGiocatore = new TableColumn<>("Altezza");
        altezzaGiocatore.setCellValueFactory(new PropertyValueFactory<>("altezza"));
        TableColumn<MembroGiocatore, Integer> pesoGiocatore = new TableColumn<>("Peso");
        pesoGiocatore.setCellValueFactory(new PropertyValueFactory<>("peso"));
        TableColumn<MembroGiocatore, Integer> aperturaAlareGiocatore = new TableColumn<>("Apertura Alare");
        aperturaAlareGiocatore.setCellValueFactory(new PropertyValueFactory<>("aperturaAlare"));
        TableColumn<MembroGiocatore, Integer> stipendioGiocatore = new TableColumn<>("Stipendio");
        stipendioGiocatore.setCellValueFactory(new PropertyValueFactory<>("stipendio"));
        TableColumn<MembroGiocatore, Boolean> capitanoGiocatore = new TableColumn<>("Capitano");
        capitanoGiocatore.setCellValueFactory(new PropertyValueFactory<>("capitano"));
        this.giocatoreView.getColumns().addAll(Arrays.asList(nomeGiocatore, cognomeGiocatore, ruoloGiocatore,
                                                            etaGiocatore, altezzaGiocatore, pesoGiocatore, aperturaAlareGiocatore,
                                                            stipendioGiocatore, capitanoGiocatore));
        this.giocatoreView.setItems(this.featuresSocieta.viewGiocatori(squadraGiocatore.getText(), idGiocatore.getText(),
                                                                        Integer.parseInt(annoGiocatore.getText()),
                                                                        gironeGiocatore.getText()));
    }

    @FXML
    public void viewStaff() {
        this.staffView.getColumns().clear();
        TableColumn<MembroStaff, String> nomeStaff = new TableColumn<>("Nome");
        nomeStaff.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<MembroStaff, String> cognomeStaff = new TableColumn<>("Cognome");
        cognomeStaff.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<MembroStaff, String> ruoloStaff = new TableColumn<>("Ruolo");
        ruoloStaff.setCellValueFactory(new PropertyValueFactory<>("ruolo"));
        TableColumn<MembroStaff, Integer> etaStaff = new TableColumn<>("Eta");
        etaStaff.setCellValueFactory(new PropertyValueFactory<>("eta"));
        TableColumn<MembroStaff, Integer> stipendioStaff = new TableColumn<>("Stipendio");
        stipendioStaff.setCellValueFactory(new PropertyValueFactory<>("stipendio"));
        TableColumn<MembroStaff, String> specializzazioneStaff = new TableColumn<>("Specializzazione");
        specializzazioneStaff.setCellValueFactory(new PropertyValueFactory<>("specializzazione"));
        TableColumn<MembroStaff, Integer> annoPatentinoStaff = new TableColumn<>("Anno Patentino");
        annoPatentinoStaff.setCellValueFactory(new PropertyValueFactory<>("annoPatentino"));
        this.staffView.getColumns().addAll(Arrays.asList(nomeStaff, cognomeStaff, ruoloStaff, etaStaff, stipendioStaff,
                                                        specializzazioneStaff, annoPatentinoStaff));
        this.setStaffRole();
    }

    private void viewSocieta() {
        this.societaView.getColumns().clear();
        TableColumn<Societa, String> nomeSocieta = new TableColumn<>("Nome Societa");
        nomeSocieta.setCellValueFactory(new PropertyValueFactory<>("nomeSocieta"));
        TableColumn<Societa, String> codiceMeccanografico = new TableColumn<>("Codice Meccanografico");
        codiceMeccanografico.setCellValueFactory(new PropertyValueFactory<>("codiceMeccanografico"));
        TableColumn<Societa, Integer> titoli = new TableColumn<>("Titoli");
        titoli.setCellValueFactory(new PropertyValueFactory<>("titoli"));
        TableColumn<Societa, String> sponsor = new TableColumn<>("Sponsor");
        sponsor.setCellValueFactory(new PropertyValueFactory<>("sponsor"));
        TableColumn<Societa, Integer> telefono = new TableColumn<>("Telefono");
        telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        TableColumn<Societa, String> email = new TableColumn<>("Email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Societa, String> indirizzo = new TableColumn<>("Indirizzo");
        indirizzo.setCellValueFactory(new PropertyValueFactory<>("indirizzo"));
        TableColumn<Societa, String> nomeProprietario = new TableColumn<>("Nome Proprietario");
        nomeProprietario.setCellValueFactory(new PropertyValueFactory<>("nomeProprietario"));
        this.societaView.getColumns().addAll(Arrays.asList(nomeSocieta, codiceMeccanografico, titoli, sponsor, telefono, email, indirizzo, nomeProprietario));
        this.societaView.setItems(this.featuresSocieta.viewSocieta());
    }

    private void viewSquadre(){
        this.squadraView.getColumns().clear();
        TableColumn<Squadra, String> nomeSquadra = new TableColumn<>("Nome Squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nomeSquadra"));
        TableColumn<Squadra, String> nomePalestra = new TableColumn<>("Nome Palestra");
        nomePalestra.setCellValueFactory(new PropertyValueFactory<>("nomePalestra"));
        TableColumn<Squadra, String> nomeSocieta = new TableColumn<>("Nome Societa");
        nomeSocieta.setCellValueFactory(new PropertyValueFactory<>("nomeSocieta"));
        TableColumn<Squadra, String> nomeGirone = new TableColumn<>("Nome Girone");
        nomeGirone.setCellValueFactory(new PropertyValueFactory<>("nomeGirone"));
        TableColumn<Squadra, String> nomeCampionato = new TableColumn<>("Nome Campionato");
        nomeCampionato.setCellValueFactory(new PropertyValueFactory<>("nomeCampionato"));
        TableColumn<Squadra, Integer> annoCampionato = new TableColumn<>("Anno Campionato");
        annoCampionato.setCellValueFactory(new PropertyValueFactory<>("annoCampionato"));
        this.squadraView.getColumns().addAll(Arrays.asList(nomeSquadra, nomePalestra, nomeSocieta, nomeGirone, nomeCampionato, annoCampionato));
        this.squadraView.setItems(this.featuresSocieta.viewSquadra());
    }

    private void viewProprietari() {
        this.proprietarioView.getColumns().clear();
        TableColumn<Proprietario, String> nomeProprietario = new TableColumn<>("Nome Proprietario");
        nomeProprietario.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Proprietario, String> cognomeProprietario = new TableColumn<>("Cognome Proprietario");
        cognomeProprietario.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Proprietario, String> cfProprietario = new TableColumn<>("Codice Fiscale Proprietario");
        cfProprietario.setCellValueFactory(new PropertyValueFactory<>("codiceFiscale"));
        this.proprietarioView.getColumns().addAll(Arrays.asList(nomeProprietario, cognomeProprietario, cfProprietario));
        this.proprietarioView.setItems(this.featuresSocieta.viewProprietari());
    }

    private String assignRole(String valore) {
        String ruolo = null;
        switch (valore.toString()) {
            case "medico":
                ruolo = "membro_med";
                break;
            case "allenatore":
                ruolo = "membro_all";
                break;
            case "preparatore fisico":
                ruolo = "membro_pf";
                break;
            case "scorer":
                ruolo = "membro_scorer";
                break;
            case "addetto arbitri":
                ruolo = "membro_addarb";
                break;
            case "aiuto allenatore":
                ruolo = "membro_aiutoall";
                break;
            case "accompagnatore":
                ruolo = "membro_acc";
                break;
            case "massaggiatore":
                ruolo = "membro_mass";
                break;
        }
        return ruolo;
    }

    private void setStaffRole() {
        for (final String role : ruoliStaff) {
            this.staffView.getItems().addAll(this.featuresSocieta.viewStaff(assignRole(role), squadraStaff.getText(), 
                                                                idCampionatoStaff.getText(), Integer.parseInt(annoCampionatoStaff.getText()),
                                                                gironeStaff.getText()));
        }
    }
}
