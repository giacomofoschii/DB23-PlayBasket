package it.unibo.playbasket.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.playbasket.db.features.FeaturesMoreStats;
import it.unibo.playbasket.db.views.ProprietarioGiovanili;
import it.unibo.playbasket.db.views.SocietaPiuVincente;
import it.unibo.playbasket.db.views.StipendioArbitro;
import it.unibo.playbasket.db.views.StipendioUfficiale;
import it.unibo.playbasket.db.views.Top10Assist;
import it.unibo.playbasket.db.views.Under21;
import it.unibo.playbasket.db.views.VittoriaOspite;
import it.unibo.playbasket.view.impl.FxView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    @FXML private TextField tesseraArbitro;
    @FXML private TextField tesseraUfficiale;
    @FXML private TextField annoCampionato;
    @FXML private TextField idCampionato;
    @FXML private TableView stipendioArbitro;
    @FXML private TableView stipendioUfficiale;
    @FXML private TableView top10Assist;
    @FXML private TableView proprietarioGiovanili;
    @FXML private TableView societaPiuVincente;
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
        viewSocietaPiuVincente();
        viewProprietarioGiovanili();
    }

    @FXML
    public void goHome(){
        this.view.setMainView();
    }

    @FXML
    public void viewCampionato() {
        viewVittoriaOspite();
        viewTop10Assist();
    }

    @FXML
    public void calculateStipendioArbitro() {
        this.stipendioArbitro.getColumns().clear();
        TableColumn<StipendioArbitro, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<StipendioArbitro, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<StipendioArbitro, Integer> grado = new TableColumn<>("Grado");
        grado.setCellValueFactory(new PropertyValueFactory<>("grado"));
        TableColumn<StipendioArbitro, String> sezione = new TableColumn<>("Sezione");
        sezione.setCellValueFactory(new PropertyValueFactory<>("sezione"));
        TableColumn<StipendioArbitro, Integer> partiteDirette = new TableColumn<>("Partite dirette");
        partiteDirette.setCellValueFactory(new PropertyValueFactory<>("partite_dirette"));
        TableColumn<StipendioArbitro, Integer> guadagno = new TableColumn<>("Guadagno");
        guadagno.setCellValueFactory(new PropertyValueFactory<>("guadagno"));
        this.stipendioArbitro.getColumns().addAll(nome, cognome, grado, sezione, partiteDirette, guadagno);
        this.stipendioArbitro.setItems(this.featuresMoreStats.viewStipendioArbitro(this.tesseraArbitro.getText()));
        this.tesseraArbitro.clear();
    }

    @FXML
    public void calculateStipendioUfficiale() {
        this.stipendioUfficiale.getColumns().clear();
        TableColumn<StipendioUfficiale, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<StipendioUfficiale, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<StipendioUfficiale, Boolean> cronometrista = new TableColumn<>("Cronometrista");
        cronometrista.setCellValueFactory(new PropertyValueFactory<>("cronometrista"));
        TableColumn<StipendioUfficiale, Boolean> refertista = new TableColumn<>("Refertista");
        refertista.setCellValueFactory(new PropertyValueFactory<>("refertista"));
        TableColumn<StipendioUfficiale, Boolean> segnapunti = new TableColumn<>("Segnapunti");
        segnapunti.setCellValueFactory(new PropertyValueFactory<>("segnapunti"));
        TableColumn<StipendioUfficiale, Integer> partiteCodirette = new TableColumn<>("Partite codirette");
        partiteCodirette.setCellValueFactory(new PropertyValueFactory<>("partite_codirette"));
        TableColumn<StipendioUfficiale, Integer> guadagno = new TableColumn<>("Guadagno");
        guadagno.setCellValueFactory(new PropertyValueFactory<>("guadagno"));
        this.stipendioUfficiale.getColumns().addAll(nome, cognome, cronometrista, refertista, segnapunti, partiteCodirette, guadagno);
        this.stipendioUfficiale.setItems(this.featuresMoreStats.viewStipendioUfficiale(this.tesseraUfficiale.getText()));
        this.tesseraUfficiale.clear();
    }

    private void viewVittoriaOspite() {
        this.vittoriaOspite.getColumns().clear();
        TableColumn<VittoriaOspite, String> nomeSquadra = new TableColumn<>("Nome squadra");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome_squadra"));
        TableColumn<VittoriaOspite, Integer> vittorieOspite = new TableColumn<>("Vittorie ospite");
        vittorieOspite.setCellValueFactory(new PropertyValueFactory<>("num_vittorie_ospiti"));
        this.vittoriaOspite.getColumns().addAll(nomeSquadra, vittorieOspite);
        this.vittoriaOspite.setItems(this.featuresMoreStats.viewVittoriaOspite(this.idCampionato.getText(),
                                                                                Integer.parseInt(this.annoCampionato.getText())));
    }

    private void viewTop10Assist() {
        this.top10Assist.getColumns().clear();
        TableColumn<Top10Assist, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<Top10Assist, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<Top10Assist, Integer> assist = new TableColumn<>("Assist Totali");
        assist.setCellValueFactory(new PropertyValueFactory<>("assist_tot"));
        TableColumn<Top10Assist, Float> apg = new TableColumn<>("APG");
        apg.setCellValueFactory(new PropertyValueFactory<>("apg"));
        this.top10Assist.getColumns().addAll(nome, cognome, assist, apg);
        this.top10Assist.setItems(this.featuresMoreStats.viewTop10Assist(this.idCampionato.getText(),
                                                                          Integer.parseInt(this.annoCampionato.getText())));
        this.idCampionato.clear();
        this.annoCampionato.clear();
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

    private void viewSocietaPiuVincente() {
        this.societaPiuVincente.getColumns().clear();
        TableColumn<SocietaPiuVincente, String> nomeSquadra = new TableColumn<>("Nome societa");
        nomeSquadra.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<SocietaPiuVincente, Integer> titoli = new TableColumn<>("Titoli");
        titoli.setCellValueFactory(new PropertyValueFactory<>("titoli"));
        this.societaPiuVincente.getColumns().addAll(nomeSquadra, titoli);
        this.societaPiuVincente.setItems(this.featuresMoreStats.viewSocietaPiuVincente());
    }

    private void viewProprietarioGiovanili() {
        this.proprietarioGiovanili.getColumns().clear();
        TableColumn<ProprietarioGiovanili, String> nome = new TableColumn<>("Nome");
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        TableColumn<ProprietarioGiovanili, String> cognome = new TableColumn<>("Cognome");
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        TableColumn<ProprietarioGiovanili, Integer> titoli = new TableColumn<>("Titoli");
        titoli.setCellValueFactory(new PropertyValueFactory<>("titoli"));
        TableColumn<ProprietarioGiovanili, String> nomeSocieta = new TableColumn<>("Nome societa");
        nomeSocieta.setCellValueFactory(new PropertyValueFactory<>("nome_societa"));
        this.proprietarioGiovanili.getColumns().addAll(nome, cognome, titoli, nomeSocieta);
        this.proprietarioGiovanili.setItems(this.featuresMoreStats.viewProprietarioGiovanili());
    }
}
