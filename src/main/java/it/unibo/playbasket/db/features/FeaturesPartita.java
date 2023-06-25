package it.unibo.playbasket.db.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Timestamp;

import it.unibo.playbasket.db.views.Partita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeaturesPartita{

    private Connection connection;

    public FeaturesPartita(Connection connection) {
        this.connection = connection;
    }

    private void addSquadraCasa(String codicePalestra, Timestamp dataOra, int puntiFatti, int annoCampioanto,
            String nomeGirone, String nomeSquadra, String idCampionato) throws SQLException{
        final String query = "INSERT INTO PARTECIPAZIONE_CASA "
                + "(CODICEPALESTRA, DATA_ORA, PUNTI_FATTI, IDCAMPIONATO, ANNO_CAMPIONATO, NOME_GIRONE, NOME_SQUADRA) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codicePalestra);
            statement.setTimestamp(2, dataOra);
            statement.setInt(3, puntiFatti);
            statement.setString(4, idCampionato);
            statement.setInt(5, annoCampioanto);
            statement.setString(6, nomeGirone);
            statement.setString(7, nomeSquadra);
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Squadra Casa già presente");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    
    private void addSquadraOspite(String codicePalestra, Timestamp dataOra, int puntiFatti, int annoCampioanto,
            String nomeGirone, String nomeSquadra, String idCampionato) throws SQLException{
        final String query = "INSERT INTO PARTECIPAZIONE_OSPITI "
                             + "(CODICEPALESTRA, DATA_ORA, PUNTI_FATTI, IDCAMPIONATO, ANNO_CAMPIONATO, NOME_GIRONE, NOME_SQUADRA)"
                             + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codicePalestra);
            statement.setTimestamp(2, dataOra);
            statement.setInt(3, puntiFatti);
            statement.setString(4, idCampionato);
            statement.setInt(5, annoCampioanto);
            statement.setString(6, nomeGirone);
            statement.setString(7, nomeSquadra);
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Squadra Ospite già presente");
        }  catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    
    public void addPartita(String codicePalestra, Timestamp dataOra, String idCampionato, int annoCampionato,
            String nomeGirone, String nomeCasa, int puntiCasa, String nomeOspiti, int puntiOspiti) throws SQLException {
        final String query = "INSERT INTO PARTITA "
                + "(CODICEPALESTRA, DATA_ORA, IDCAMPIONATO, ANNO_CAMPIONATO, NOME_GIRONE) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codicePalestra);
            statement.setTimestamp(2, dataOra);
            statement.setString(3, idCampionato);
            statement.setInt(4, annoCampionato);
            statement.setString(5, nomeGirone);
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Partita già presente");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        try {
            addSquadraCasa(codicePalestra, dataOra, puntiCasa, annoCampionato, nomeGirone, nomeCasa, idCampionato);
            addSquadraOspite(codicePalestra, dataOra, puntiOspiti, annoCampionato, nomeGirone, nomeOspiti, idCampionato);
        } catch (SQLException e) {
            removePartita(codicePalestra, dataOra);
            throw new IllegalStateException(e);
        }
        


    }
    
    public void addPerformance(String codicePalestra, Timestamp dataOra, String tesseraFIP, int rimb, int assist,
            int falliFatti, int falliSubiti, int min, int tiri2, int tiri3, int tiriLiberi, int tiri2_segnati,
            int tiri3_segnati, int tiriLiberi_segnati, int palleRubate, int pallePerse, int stoppate) throws SQLException {
        
        final String query = "INSERT INTO PERFORMANCE "
                             + "(codicePalestra, data_ora, tesseraFIP, rimbalzi, assist, "
                             + "falli_fatti, falli_subiti, minuti, tiri_2, tiri_3, tiri_liberi, tiri_2_segnati, "
                             + "tiri_3_segnati, tiri_liberi_segnati, palle_rubate, palle_perse, stoppate) "
                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codicePalestra);
            statement.setTimestamp(2, dataOra);
            statement.setString(3, tesseraFIP);
            statement.setInt(4, rimb);
            statement.setInt(5, assist);
            statement.setInt(6, falliFatti);
            statement.setInt(7, falliSubiti);
            statement.setInt(8, min);
            statement.setInt(9, tiri2);
            statement.setInt(10, tiri3);
            statement.setInt(11, tiriLiberi);
            statement.setInt(12, tiri2_segnati);
            statement.setInt(13, tiri3_segnati);
            statement.setInt(14, tiriLiberi_segnati);
            statement.setInt(15, palleRubate);
            statement.setInt(16, pallePerse);
            statement.setInt(17, stoppate);
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            removePerformance(codicePalestra, dataOra, tesseraFIP);
            throw new IllegalArgumentException("Partita già presente");
        } catch (SQLException e) {
            removePerformance(codicePalestra, dataOra, tesseraFIP);
            throw new IllegalStateException(e);
        }
    }

    /*private void removeSquadraOspite(String codicePalestra, String dataOra) throws SQLException {
        final String query = "DELETE FROM PARTECIPAZIONE_CASA WHERE CODICEPALESTRA=? AND DATA_ORA=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codicePalestra);
            statement.setString(2, dataOra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private void removeSquadraCasa(String codicePalestra, String dataOra) throws SQLException {
        final String query = "DELETE FROM PARTECIPAZIONE_OSPITI WHERE CODICEPALESTRA=? AND DATA_ORA=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codicePalestra);
            statement.setString(2, dataOra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }*/

    public void removePartita(String codicePalestra, Timestamp dataOra) throws SQLException {
        final String query = "DELETE PARTITA WHERE CODICE_PALESTRA=? AND DATA_ORA=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codicePalestra);
            statement.setTimestamp(2, dataOra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removePerformance(String codicePalestra, Timestamp dataOra, String tesseraFIP) throws SQLException {
        final String query = "DELETE PERFORMANCE WHERE  CODICEPALESTRA=? AND TESSERAFIP=? AND DATA_ORA=?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codicePalestra);
            statement.setString(2, tesseraFIP);
            statement.setTimestamp(3, dataOra);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Partita> viewPartite() {
        final String query = "SELECT C.NOME_SQUADRA AS NOME1 ,O.NOME_SQUADRA AS NOME2, C.PUNTI_FATTI AS PUNTI1, O.PUNTI_FATTI AS PUNTI2, P.CODICEPALESTRA, P.DATA_ORA, P.IDCAMPIONATO, P.ANNO_CAMPIONATO, P.NOME_GIRONE "
                             + "FROM PARTITA P, PARTECIPAZIONE_CASA C, PARTECIPAZIONE_OSPITI O "
                             + "WHERE C.DATA_ORA=P.DATA_ORA "
                             + "AND C.CODICEPALESTRA=P.CODICEPALESTRA "
                             + "AND C.DATA_ORA=O.DATA_ORA "
                             + "AND C.CODICEPALESTRA=O.CODICEPALESTRA";
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);

            final ObservableList<Partita> data = FXCollections.observableArrayList();
            while (result.next()) {
                data.add(new Partita(result.getString("NOME1"), result.getString("NOME2"), result.getInt("PUNTI1"), result.getInt("PUNTI2"),
                        result.getString("CODICEPALESTRA"), result.getString("DATA_ORA"), result.getString("IDCAMPIONATO"), result.getInt("ANNO_CAMPIONATO"),
                        result.getString("NOME_GIRONE")));
            }

            return data;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        
    }
}
