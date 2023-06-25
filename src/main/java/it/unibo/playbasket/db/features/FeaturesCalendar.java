package it.unibo.playbasket.db.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unibo.playbasket.db.views.CalendarioGirone;
import it.unibo.playbasket.db.views.CalendarioPalestra;
import it.unibo.playbasket.db.views.CalendarioSocieta;
import it.unibo.playbasket.db.views.CalendarioSquadra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeaturesCalendar {

    private Connection connection;

    public FeaturesCalendar(Connection connection) {
        this.connection = connection;
    }

    public ObservableList<CalendarioSquadra> viewCalendarSquadra(String idCampionato, int anno, String nome_girone, String nome_squadra) {
        final String query = "SELECT C.Nome_Squadra as Nome_squadra1, O.Nome_Squadra as Nome_squadra2, L.Nome_Palestra as Palestra, "
                             +"concat(L.Via, ' ', L.Civico) as Indirizzo, P.Data_Ora as Data_ora "
                             + "FROM partecipazione_casa C, partecipazione_ospiti O, Partita P, Palestra L, Campionato S, Girone G "
                             + "WHERE S.idcampionato=? AND S.anno_campionato=? AND S.idcampionato=G.idcampionato "
                             + "AND G.anno_campionato=s.anno_campionato AND G.anno_campionato=P.anno_campionato AND G.nome_girone=? "
                             + "AND P.idcampionato=G.idcampionato AND P.nome_girone=G.nome_girone AND P.codicepalestra=C.codicepalestra "
                             + "AND P.codicepalestra=O.codicepalestra AND P.codicepalestra=L.codicepalestra AND P.data_ora=C.data_ora "
                             + "AND P.data_ora=O.data_ora AND (C.nome_squadra=? OR O.nome_squadra=?)";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setInt(2, anno);
            stmt.setString(3, nome_girone);
            stmt.setString(4, nome_squadra);
            stmt.setString(5, nome_squadra);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<CalendarioSquadra> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new CalendarioSquadra(rs.getString("Nome_squadra1"), rs.getString("Nome_squadra2"),
                                               rs.getString("Palestra"), rs.getString("Indirizzo"), rs.getString("Data_ora")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<CalendarioGirone> viewCalendarGirone(String idCampionato, int anno, String nome_girone) {
        final String query = "SELECT C.Nome_Squadra as Nome_squadra1, O.Nome_Squadra as Nome_squadra2, L.Nome_Palestra as Palestra, "
                             + "concat(L.Via, ' ', L.Civico) as Indirizzo, P.Data_Ora as Data_ora "
                             + "FROM partecipazione_casa C, partecipazione_ospiti O, Partita P, Palestra L, Campionato S, Girone G "
                             + "WHERE S.idcampionato=? AND S.anno_campionato=? AND S.idcampionato=G.idcampionato "
                             + "AND G.anno_campionato=s.anno_campionato AND G.anno_campionato=P.anno_campionato AND G.nome_girone=? "
                             + "AND P.idcampionato=G.idcampionato AND P.nome_girone=G.nome_girone "
                             + "AND P.codicepalestra=C.codicepalestra AND P.codicepalestra=O.codicepalestra "
                             + "AND P.codicepalestra=L.codicepalestra AND P.data_ora=C.data_ora AND P.data_ora=O.data_ora";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setInt(2, anno);
            stmt.setString(3, nome_girone);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<CalendarioGirone> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new CalendarioGirone(rs.getString("Nome_squadra1"), rs.getString("Nome_squadra2"),
                                               rs.getString("Palestra"), rs.getString("Indirizzo"), rs.getString("Data_ora")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<CalendarioPalestra> viewCalendarPalestra(String idPalestra, int anno) {
        final String query = "SELECT C.Nome_Squadra as Nome_squadra1, O.Nome_Squadra as Nome_squadra2, L.Nome_Palestra as Palestra, "
                            + "concat(L.Via, ' ' , L.Civico) as Indirizzo, P.Data_Ora as Data_ora "
                            + "FROM partecipazione_casa C, partecipazione_ospiti O, Partita P, Palestra L, Campionato S, Girone G "
                            + "WHERE  S.anno_campionato=? AND G.idcampionato=s.idcampionato AND G.anno_campionato=s.anno_campionato "
                            + "AND G.anno_campionato=P.anno_campionato AND P.idcampionato=G.idcampionato AND P.nome_girone=G.nome_girone "
                            + "AND P.codicepalestra=C.codicepalestra AND P.codicepalestra=O.codicepalestra AND P.codicepalestra=L.codicepalestra "
                            + "AND P.data_ora=C.data_ora AND P.data_ora=O.data_ora AND P.codicepalestra = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setInt(1, anno);
            stmt.setString(2, idPalestra);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<CalendarioPalestra> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new CalendarioPalestra(rs.getString("Nome_squadra1"), rs.getString("Nome_squadra2"),
                                                 rs.getString("Palestra"), rs.getString("Indirizzo"), rs.getString("Data_ora")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<CalendarioSocieta> viewCalendarSocieta(int anno, String codiceMeccanografico) {
        final String query = "SELECT C.Nome_Squadra as Nome_squadra1, O.Nome_Squadra as nome_squadra2, L.Nome_Palestra as Palestra, "
                            + "concat(L.Via, ' ' , L.Civico) as Indirizzo, "
                            + "P.Data_Ora as Data_ora, S.nome_campionato, G.nome_girone "
                            + "FROM partecipazione_casa C, partecipazione_ospiti O, Partita P, Palestra L, Campionato S, Girone G, Squadra T "
                            + "WHERE T.Codicemeccanografico=? AND S.anno_campionato=? "
                            + "AND G.idcampionato=s.idcampionato AND G.anno_campionato=s.anno_campionato "
                            + "AND G.anno_campionato=P.anno_campionato AND P.idcampionato=G.idcampionato AND P.nome_girone=G.nome_girone "
                            + "AND P.codicepalestra=C.codicepalestra AND P.codicepalestra=O.codicepalestra AND P.codicepalestra=L.codicepalestra "
                            + "AND P.data_ora=C.data_ora AND P.data_ora=O.data_ora";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, codiceMeccanografico);
            stmt.setInt(2, anno);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<CalendarioSocieta> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new CalendarioSocieta(rs.getString("Nome_squadra1"),
                                                rs.getString("Nome_squadra2"), rs.getString("Palestra"), rs.getString("Indirizzo"),
                                                rs.getString("Data_ora"), rs.getString("Nome_campionato"), rs.getString("Nome_girone")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
