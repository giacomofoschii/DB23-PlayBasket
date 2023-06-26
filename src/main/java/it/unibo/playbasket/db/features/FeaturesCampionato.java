package it.unibo.playbasket.db.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import it.unibo.playbasket.db.views.Campionato;
import it.unibo.playbasket.db.views.Girone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeaturesCampionato{

    private Connection connection;

    public FeaturesCampionato(Connection connection){
        this.connection = connection;
    }

    public void addCampionato(String nome, String id, String regione, int anno) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO CAMPIONATO (IDCAMPIONATO, ANNO_CAMPIONATO, NOME_CAMPIONATO, REGIONE) "
                            + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.setInt(2, anno);
            stmt.setString(3, nome);
            stmt.setString(4, regione);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Campionato già presente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCampionato(String id, int anno) throws SQLException {
        final String query = "DELETE FROM CAMPIONATO WHERE IDCAMPIONATO = ? AND ANNO_CAMPIONATO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.setInt(2, anno);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Campionato> viewCampionati() {
        final String query = "SELECT C.NOME_CAMPIONATO, C.ANNO_CAMPIONATO, C.REGIONE, S.NOME AS 'VINTO_DA' "
                            + " FROM CAMPIONATO C "
                            + "LEFT JOIN SOCIETA S ON S.CODICEMECCANOGRAFICO = C.CODICEMECCANOGRAFICO";
        try (Statement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery(query);

            final ObservableList<Campionato> campionati = FXCollections.observableArrayList();
            while (rs.next()) {
                campionati.add(new Campionato(rs.getString("NOME_CAMPIONATO"), rs.getInt("ANNO_CAMPIONATO"),
                                              rs.getString("REGIONE"), rs.getString("VINTO_DA")));
            }
            return campionati;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addWinner(String codiceMeccanografico, String id, int anno) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "UPDATE CAMPIONATO SET CODICEMECCANOGRAFICO=? "
                            + "WHERE IDCAMPIONATO=? AND ANNO_CAMPIONATO=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, codiceMeccanografico);
            stmt.setString(2, id);
            stmt.setInt(3, anno);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLIntegrityConstraintViolationException(e);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        final String query2 = "UPDATE societa "
                            + "SET titoli = (SELECT COUNT(*) FROM campionato "
                            + " WHERE campionato.codicemeccanografico = societa.codicemeccanografico) "
                            + " WHERE codicemeccanografico=?" ;
        try (PreparedStatement stmt = connection.prepareStatement(query2)) {
            stmt.setString(1, codiceMeccanografico);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLIntegrityConstraintViolationException(e);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeWinner(String id, int anno, String codiceMeccanografico) throws SQLException {
        final String query = "UPDATE CAMPIONATO SET CODICEMECCANOGRAFICO=NULL "
                            + "WHERE IDCAMPIONATO=? AND ANNO_CAMPIONATO=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.setInt(2, anno);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        final String query2 = "UPDATE societa "
                            + "SET titoli = (SELECT COUNT(*) FROM campionato "
                            + " WHERE campionato.codicemeccanografico = societa.codicemeccanografico) "
                            + " WHERE codicemeccanografico=?" ;
        try (PreparedStatement stmt = connection.prepareStatement(query2)) {
            stmt.setString(1, codiceMeccanografico);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLIntegrityConstraintViolationException(e);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addGirone(String nome, String id, int anno, String provincia) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO GIRONE (NOME_girone, IDCAMPIONATO, ANNO_CAMPIONATO, PROVINCIA) "
                            + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, id);
            stmt.setInt(3, anno);
            stmt.setString(4, provincia);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLIntegrityConstraintViolationException(e);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGirone(String nome, String id, int anno) throws SQLException {
        final String query = "DELETE FROM GIRONE WHERE NOME_GIRONE = ? AND IDCAMPIONATO = ? AND ANNO_CAMPIONATO = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, id);
            stmt.setInt(3, anno);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Girone> viewGirone() {
        final String query = "SELECT G.nome_girone, C.nome_campionato, G.provincia FROM GIRONE G, Campionato C "
                            + "WHERE G.idcampionato=C.idcampionato AND C.anno_campionato=G.anno_campionato";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery(query);

            final ObservableList<Girone> girone = FXCollections.observableArrayList();
            while (rs.next()) {
                girone.add(new Girone(rs.getString("nome_girone"), rs.getString("nome_campionato"), rs.getString("provincia")));
            }
            return girone;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}