package it.unibo.playbasket.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

import it.unibo.playbasket.db.features.FeaturesPalestra;
import it.unibo.playbasket.db.views.Palestra;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PalestreController implements Initializable{

    private FxView view;
    private FeaturesPalestra featuresPalestra;
    @FXML private TextField nome;
    @FXML private TextField id;
    @FXML private TextField via;
    @FXML private TextField civico;
    @FXML private TextField superficie;
    @FXML private TextField capienza;
    @FXML private TableView<Palestra> palestreView;

    /**
     * Constructor for the controller.
     * @param view the view.
     */
    public PalestreController(FxView view, FeaturesPalestra featuresPalestra){
        this.view = view;
        this.featuresPalestra = featuresPalestra;
    }

     @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.viewPalestre();
    }

    @FXML
    public void goManagement(){
        this.view.setAdminView();
    }

    private void viewPalestre() {
        this.palestreView.getColumns().clear();
        TableColumn<Palestra, String> nomePalestra = new TableColumn<>("Nome Palestra");
        nomePalestra.setCellValueFactory(new PropertyValueFactory<>("nome_palestra"));
        TableColumn<Palestra, String> indirizzo = new TableColumn<>("Indirizzo");
        indirizzo.setCellValueFactory(new PropertyValueFactory<>("indirizzo"));
        TableColumn<Palestra, String> codicePalestra = new TableColumn<>("Codice Palestra");
        codicePalestra.setCellValueFactory(new PropertyValueFactory<>("codicePalestra"));
        TableColumn<Palestra, String> superficie = new TableColumn<>("Superficie");
        superficie.setCellValueFactory(new PropertyValueFactory<>("superficie"));
        TableColumn<Palestra, Integer> capienza = new TableColumn<>("Capienza");
        capienza.setCellValueFactory(new PropertyValueFactory<>("capienza"));
        this.palestreView.getColumns().addAll(Arrays.asList(nomePalestra, codicePalestra, indirizzo, superficie, capienza));
        this.palestreView.setItems(this.featuresPalestra.viewPalestre());
    }

    @FXML
    public void addPalestra() {
        try {
            featuresPalestra.addPalestra(nome.getText(), id.getText(), via.getText(), Integer.parseInt(civico.getText()),
                                         superficie.getText(), Integer.parseInt(capienza.getText()));
            nome.clear();
            id.clear();
            via.clear();
            civico.clear();
            superficie.clear();
            capienza.clear();
            this.viewPalestre();
        } catch (SQLException e) {
            id.clear();
            id.setPromptText("Errore di inserimento");
            id.setStyle("-fx-prompt-text-fill: red");
        }
    }

    @FXML
    public void removePalestra() {
        try {
            featuresPalestra.removePalestra(id.getText());
            nome.clear();
            id.clear();
            via.clear();
            civico.clear();
            superficie.clear();
            capienza.clear();
            this.viewPalestre();
        } catch (SQLException e) {
            id.clear();
            id.setPromptText("Errore di rimozione");
            id.setStyle("-fx-prompt-text-fill: red");
        }
    }
}
