package it.unibo.playbasket.controller;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import it.unibo.playbasket.db.features.FeaturesSocieta;
import it.unibo.playbasket.db.views.MembroGiocatore;
import it.unibo.playbasket.db.views.Proprietario;
import it.unibo.playbasket.db.views.Schema;
import it.unibo.playbasket.db.views.Societa;
import it.unibo.playbasket.db.views.Squadra;
import it.unibo.playbasket.db.views.Staff;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    @FXML private ChoiceBox<String> tipoSchema;
    @FXML private ChoiceBox<String> membriStaff;
    @FXML private TableView<Squadra> squadraView;
    @FXML private TableView<MembroGiocatore> giocatoreView;
    @FXML private TableView<Schema> schemaView;
    @FXML private TableView<Proprietario> proprietarioview;
    @FXML private TableView<Staff> staffView;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void removeSquadra() {
        try {
            this.featuresSocieta.removeSquadra(idCampionatoSquadra.getText(), nomeGironeSquadra.getText(), nomeSquadra.getText(),
                                                Integer.parseInt(annoCampionatoSquadra.getText()));
            this.viewSquadre();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addSchema() {
        try {
            this.featuresSocieta.addSchema(nomeSchema.getText(), squadraSchema.getText(), idSchema.getText(),
                                        Integer.parseInt(annoSchema.getText()), gironeSchema.getText(), tipoSchema.getValue());
            this.viewSquadre();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void removeSchema() {
        try {
            this.featuresSocieta.removeSchema(nomeSchema.getText(), squadraSchema.getText(), idSchema.getText(),
                                            Integer.parseInt(annoSchema.getText()), gironeSchema.getText());
            this.viewSquadre();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addSocieta() {}

    @FXML
    public void removeSocieta() {}

    @FXML
    public void addProprietario() {}

    @FXML
    public void removeProprietario() {}

    @FXML
    public void addGiocatore() {}

    @FXML
    public void removeGiocatore() {}

    @FXML
    public void addStaff() {}

    @FXML
    public void removeStaff() {

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
    public void viewGiocatori() {}

    @FXML
    public void viewStaff() {

    }

    private void viewSocieta() {

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

    private void viewProprietari() {}
}
