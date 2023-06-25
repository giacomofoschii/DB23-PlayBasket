package it.unibo.playbasket.db.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.playbasket.db.views.Giocatore;
import it.unibo.playbasket.db.views.MembroGiocatore;
import it.unibo.playbasket.db.views.Proprietario;
import it.unibo.playbasket.db.views.Schema;
import it.unibo.playbasket.db.views.Societa;
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

    public void addSocieta(String codiceMeccanografico, String sponsor, String nome, int telefono,
                            String email, String via, int civico, String cf_proprietario) 
                            throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO SOCIETA "
                            + "(CODICEMECCANOGRAFICO, TITOLI, SPONSOR, NOME, TELEFONO, EMAIL, VIA, CIVICO, CF_PROPRIETARIO) "
                            + "VALUES (?, 0, ?, ?, ?, ?, ?, ?, ?)";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, codiceMeccanografico);
            stmt.setString(2, sponsor);
            stmt.setString(3, nome);
            stmt.setInt(4, telefono);
            stmt.setString(5, email);
            stmt.setString(6, via);
            stmt.setInt(7, civico);
            stmt.setString(8, cf_proprietario);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Società già presente");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeSocieta(String codiceMeccanografico) {
        final String query = "DELETE FROM SOCIETA WHERE CODICEMECCANOGRAFICO = ?";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, codiceMeccanografico);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Societa> viewSocieta() {
        final String query = "SELECT  S.Nome, S.CODICEMECCANOGRAFICO, S.TITOLI, S.SPONSOR, S.TELEFONO, "
                            + "S.EMAIL, concat(S.Via, ' ' , S.Civico) as Indirizzo, concat(P.NOME, ' ' , P.COGNOME) as PROPRIETARIO "
                            + "FROM SOCIETA S, PROPRIETARIO P WHERE P.CF=S.CF_PROPRIETARIO";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Societa> societa = FXCollections.observableArrayList();
            while (rs.next()) {
                societa.add(new Societa(rs.getString("nome"), rs.getString("codicemeccanografico"),
                                        rs.getInt("titoli"), rs.getString("sponsor"), rs.getInt("telefono"),
                                        rs.getString("email"), rs.getString("indirizzo"), rs.getString("proprietario")));
            }
            return societa;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addProprietario(String nome, String cognome, String cf) throws SQLIntegrityConstraintViolationException, SQLException{
        final String query = "INSERT INTO PROPRIETARIO (NOME, COGNOME, CF) "
                            + "VALUES (?, ?, ?)" ;
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, cf);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Proprietario già presente");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeProprietario(String cf) throws SQLException {
        final String query = "DELETE FROM PROPRIETARIO WHERE CF = ?";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, cf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Proprietario> viewProprietari() {
        final String query = "SELECT * FROM PROPRIETARIO";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Proprietario> proprietari = FXCollections.observableArrayList();
            while (rs.next()) {
                proprietari.add(new Proprietario(rs.getString("nome"), rs.getString("cognome"), rs.getString("cf")));
            }
            return proprietari;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addGiocatore(String tesseraFIP, int stipendio, boolean capitano, String idCampionato,
                            int annoCampionato, String nomeGirone, String nomeSquadra) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO membro_giocatore (TESSERAFIP, STIPENDIO, CAPITANO, IDCAMPIONATO, "
                            + "ANNO_CAMPIONATO, NOME_GIRONE, NOME_SQUADRA) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, tesseraFIP);
            stmt.setInt(2, stipendio);
            stmt.setBoolean(3, capitano);
            stmt.setString(4, idCampionato);
            stmt.setInt(5, annoCampionato);
            stmt.setString(6, nomeGirone);
            stmt.setString(7, nomeSquadra);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Giocatore già presente");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGiocatore(String tesseraFIP, String idCampionato,
                            int annoCampionato, String nomeGirone, String nomeSquadra) throws SQLException {
        final String query = "DELETE FROM membro_giocatore WHERE tesseraFIP = ? AND idcampionato = ? "
                            + "AND anno_campionato = ? AND nome_girone = ? AND nome_squadra = ?";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, tesseraFIP);
            stmt.setString(2, idCampionato);
            stmt.setInt(3, annoCampionato);
            stmt.setString(4, nomeGirone);
            stmt.setString(5, nomeSquadra);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<MembroGiocatore> viewGiocatori(String nomeSquadra, String idCampionato,
                            int annoCampionato, String nomeGirone) {
        final String query = "SELECT T.NOME, T.COGNOME, G.RUOLO, T.ETA, G.ALTEZZA, g.peso, G.APERTURA_ALARE, M.STIPENDIO, M.CAPITANO "
                            + "FROM GIOCATORE G, membro_giocatore M, Tesserato T "
                            + "WHERE G.TESSERAFIP=M.TESSERAFIP AND T.TESSERAFIP=G.TESSERAFIP "
                            + "AND M.NOME_SQUADRA=? AND IDCampionato=? "
                            + "AND ANNO_CAMPIONATO=? AND NOME_GIRONE=? order by g.ruolo";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, nomeSquadra);
            stmt.setString(2, idCampionato);
            stmt.setInt(3, annoCampionato);
            stmt.setString(4, nomeGirone);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<MembroGiocatore> membrogiocatore = FXCollections.observableArrayList();
            while (rs.next()) {
                membrogiocatore.add(new MembroGiocatore(rs.getString("nome"), rs.getString("cognome"),
                                                        rs.getString("ruolo"), rs.getString("eta"),
                                                        rs.getInt("altezza"), rs.getInt("peso"), rs.getInt("apertura_alare"),
                                                        rs.getInt("stipendio"), rs.getBoolean("capitano")));
            }
            return membrogiocatore;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addStaff(String ruolo, String tesseraFip, int stipendio, int annoCampionato, String idCampionato,
                        String nomeGirone, String nomeSquadra) throws SQLException, SQLIntegrityConstraintViolationException {
        final String query = "INSERT INTO ?  (STIPENDIO, TESSERAFIP, ANNO_CAMPIONATO, IDCAMPIONATO, NOME_GIRONE, NOME_SQUADRA) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, ruolo);
            stmt.setInt(2, stipendio);
            stmt.setString(3, tesseraFip);
            stmt.setInt(4, annoCampionato);
            stmt.setString(5, idCampionato);
            stmt.setString(6, nomeGirone);
            stmt.setString(7, nomeSquadra);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Staff già presente");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeStaff(String ruolo, String tesseraFip, int annoCampionato, String idCampionato,
                        String nomeGirone, String nomeSquadra) throws SQLException {
        final String query = "DELETE FROM ? WHERE tesseraFIP = ? AND idcampionato = ? "
                            + "AND anno_campionato = ? AND nome_girone = ? AND nome_squadra = ?";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, ruolo);
            stmt.setString(2, tesseraFip);
            stmt.setString(3, idCampionato);
            stmt.setInt(4, annoCampionato);
            stmt.setString(5, nomeGirone);
            stmt.setString(6, nomeSquadra);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
