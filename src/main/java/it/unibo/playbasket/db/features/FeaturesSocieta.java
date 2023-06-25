package it.unibo.playbasket.db.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import it.unibo.playbasket.db.views.Schema;
import it.unibo.playbasket.db.views.Squadra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeaturesSocieta{

    private Connection connection;

    public FeaturesSocieta(Connection connection){
        this.connection = connection;
    }

    public void addSquadra(String nome_squadra, String idCampionato, int anno_campionato, String nome_girone,
                                                String codicePalestra, String codiceMeccanografico) throws SQLException {
        final String query = "INSERT INTO squadra (codicepalestra, codicemeccanografico, nome_squadra, idcampionato, "
                            + "anno_campionato, nome_girone, numero_vittorie, numero_sconfitte, num_vittorie_ospiti, "
                            + "punti_segnati, punti_subiti) "
                            + "VALUES (?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0)";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, codicePalestra);
            stmt.setString(2, codiceMeccanografico);
            stmt.setString(3, nome_squadra);
            stmt.setString(4, idCampionato);
            stmt.setInt(5, anno_campionato);
            stmt.setString(6, nome_girone);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Squadra già presente");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeSquadra(String idCampionato, String nomeGirone, String nomeSquadra,
                                int annoCampionato) throws SQLException {
        final String query = "DELETE FROM squadra WHERE idcampionato = ? AND nome_girone = ? AND nome_squadra = ? AND anno_campionato = ?";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setString(2, nomeGirone);
            stmt.setString(3, nomeSquadra);
            stmt.setInt(4, annoCampionato);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Squadra> viewSquadra() {
        final String query = "SELECT S.ANNO_CAMPIONATO, S.NOME_GIRONE, S.NOME_SQUADRA, "
                            + "P.NOME_PALESTRA, A.NOME, C.NOME_CAMPIONATO "
                            + "FROM SOCIETA A, SQUADRA S, PALESTRA P, CAMPIONATO C, GIRONE G "
                            + "WHERE S.IDCAMPIONATO=G.IDCAMPIONATO AND S.ANNO_CAMPIONATO=G.ANNO_CAMPIONATO "
                            + "AND S.NOME_GIRONE=G.NOME_GIRONE AND C.IDCAMPIONATO=G.IDCAMPIONATO "
                            + "AND C.ANNO_CAMPIONATO=G.ANNO_CAMPIONATO AND S.CODICEPALESTRA=P.CODICEPALESTRA "
                            + "AND A.CODICEMECCANOGRAFICO=S.CODICEMECCANOGRAFICO";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Squadra> squadre = FXCollections.observableArrayList();
            while (rs.next()) {
                squadre.add(new Squadra(rs.getString("nome_squadra"), rs.getString("nome_palestra"),
                                        rs.getString("nome"), rs.getString("nome_girone"),
                                        rs.getString("nome_campionato"), rs.getInt("anno_campionato")));
            }
            return squadre;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addSchema(String nomeSchema, String nomeSquadra, String idCampionato, int annoCampionato,
                         String nomeGirone, String tipoSchema) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO schemi (nome, nome_squadra, idcampionato, anno_campionato, nome_girone, tipo) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, nomeSchema);
            stmt.setString(2, nomeSquadra);
            stmt.setString(3, idCampionato);
            stmt.setInt(4, annoCampionato);
            stmt.setString(5, nomeGirone);
            stmt.setString(6, tipoSchema);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Schema già presente");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeSchema(String nomeSchema, String nomeSquadra, String idCampionato, int annoCampionato,
                         String nomeGirone) throws SQLException {
        final String query = "DELETE FROM schema WHERE nome = ? AND nome_squadra = ? "
                            + "AND idcampionato = ? AND anno_campionato = ? AND nome_girone = ?";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, nomeSchema);
            stmt.setString(2, nomeSquadra);
            stmt.setString(3, idCampionato);
            stmt.setInt(4, annoCampionato);
            stmt.setString(5, nomeGirone);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Schema> viewSchemi() {
        final String query = "SELECT DISTINCT S.ANNO_CAMPIONATO, S.NOME_SQUADRA, C.NOME_CAMPIONATO, X.NOME, X.TIPO "
                            + "FROM SOCIETA A, SQUADRA S, PALESTRA P, CAMPIONATO C, GIRONE G, SCHEMI X "
                            + "WHERE S.IDCAMPIONATO=G.IDCAMPIONATO "
                            + "AND S.ANNO_CAMPIONATO=G.ANNO_CAMPIONATO AND S.NOME_GIRONE=G.NOME_GIRONE "
                            + "AND C.IDCAMPIONATO=G.IDCAMPIONATO AND C.ANNO_CAMPIONATO=G.ANNO_CAMPIONATO "
                            + "AND S.IDCAMPIONATO=X.IDCAMPIONATO AND S.ANNO_CAMPIONATO=X.ANNO_CAMPIONATO "
                            + "AND S.NOME_GIRONE=X.NOME_GIRONE AND S.NOME_SQUADRA=X.NOME_SQUADRA "
                            + "ORDER BY NOME_SQUADRA";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Schema> schemi = FXCollections.observableArrayList();
            while (rs.next()) {
                schemi.add(new Schema(rs.getString("nome"), rs.getString("tipo"), rs.getString("nome_squadra"),
                                        rs.getString("nome_campionato"), rs.getInt("anno_campionato")));
            }
            return schemi;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addSocieta(String codiceMeccanografico, int titoli, String sponsor, String nome, int telefono,
                            String email, String via, int civico, String cf_proprietario) throws SQLException {
    
    }
}
