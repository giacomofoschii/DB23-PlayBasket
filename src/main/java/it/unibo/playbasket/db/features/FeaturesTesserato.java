package it.unibo.playbasket.db.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.playbasket.db.views.Arbitro;
import it.unibo.playbasket.db.views.Giocatore;
import it.unibo.playbasket.db.views.Staff;
import it.unibo.playbasket.db.views.Ufficiale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeaturesTesserato{

    private Connection connection;

    public FeaturesTesserato(Connection connection){
        this.connection = connection;
    }

    public void addTesseratoStaff(String nome, String cognome, String CF, String tesseraFip, int eta, boolean preparatoreFisico,
                                    boolean medico, boolean accompagnatore, boolean allenatore, boolean aiutoAllenatore,
                                    boolean massaggiatore, boolean addettoArbitro, boolean scorer, String specializzazione, int annoPatentino) throws SQLException{
        if(specializzazione.equals("")) {
            if(aiutoAllenatore || allenatore) {
                final String query = "INSERT INTO Tesserato "
                                    + "(nome, cognome, CF, tesseraFip, eta, preparatore_fisico, medico, accompagnatore, "
                                    + "allenatore, aiuto_allenatore, massaggiatore, addetto_arbitro, scorer, anno_patentino) "
                                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, nome);
                    statement.setString(2, cognome);
                    statement.setString(3, CF);
                    statement.setString(4, tesseraFip);
                    statement.setInt(5, eta);
                    statement.setBoolean(6, preparatoreFisico);
                    statement.setBoolean(7, medico);
                    statement.setBoolean(8, accompagnatore);
                    statement.setBoolean(9, allenatore);
                    statement.setBoolean(10, aiutoAllenatore);
                    statement.setBoolean(11, massaggiatore);
                    statement.setBoolean(12, addettoArbitro);
                    statement.setBoolean(13, scorer);
                    statement.setInt(14, annoPatentino);
                    statement.executeUpdate();
                } catch (SQLIntegrityConstraintViolationException e) {
                    throw new IllegalArgumentException("Tesserato già presente");
                } catch (SQLException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                final String query = "INSERT INTO Tesserato "
                                    + "(nome, cognome, CF, tesseraFip, eta, preparatore_fisico, medico, accompagnatore, "
                                    + "allenatore, aiuto_allenatore, massaggiatore, addetto_arbitro, scorer) "
                                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, nome);
                    statement.setString(2, cognome);
                    statement.setString(3, CF);
                    statement.setString(4, tesseraFip);
                    statement.setInt(5, eta);
                    statement.setBoolean(6, preparatoreFisico);
                    statement.setBoolean(7, medico);
                    statement.setBoolean(8, accompagnatore);
                    statement.setBoolean(9, allenatore);
                    statement.setBoolean(10, aiutoAllenatore);
                    statement.setBoolean(11, massaggiatore);
                    statement.setBoolean(12, addettoArbitro);
                    statement.setBoolean(13, scorer);
                    statement.executeUpdate();
                } catch (SQLIntegrityConstraintViolationException e) {
                    throw new IllegalArgumentException("Tesserato già presente");
                } catch (SQLException e) {
                    throw new IllegalStateException(e);
                }
            }
        } else {
            final String query = "INSERT INTO Tesserato "
                                + "(nome, cognome, CF, tesseraFip, eta, preparatore_fisico, medico, accompagnatore, "
                                + "allenatore, aiuto_allenatore, massaggiatore, addetto_arbitro, scorer, specializzazione) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nome);
                statement.setString(2, cognome);
                statement.setString(3, CF);
                statement.setString(4, tesseraFip);
                statement.setInt(5, eta);
                statement.setBoolean(6, preparatoreFisico);
                statement.setBoolean(7, medico);
                statement.setBoolean(8, accompagnatore);
                statement.setBoolean(9, allenatore);
                statement.setBoolean(10, aiutoAllenatore);
                statement.setBoolean(11, massaggiatore);
                statement.setBoolean(12, addettoArbitro);
                statement.setBoolean(13, scorer);
                statement.setString(14, specializzazione);
                statement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                throw new IllegalArgumentException("Tesserato già presente");
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        }
    }


    private void addTesseratoNotStaff(String nome, String cognome, String CF, String tesseraFip, int eta) 
                                    throws SQLException, SQLIntegrityConstraintViolationException{
        final String query = "INSERT INTO Tesserato " +
                            "(nome, cognome, CF, tesseraFip, eta, preparatore_fisico, medico, accompagnatore, allenatore, aiuto_allenatore, massaggiatore, addetto_arbitro, scorer) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nome);
            statement.setString(2, cognome);
            statement.setString(3, CF);
            statement.setString(4, tesseraFip);
            statement.setInt(5, eta);
            statement.setBoolean(6, false);
            statement.setBoolean(7, false);
            statement.setBoolean(8, false);
            statement.setBoolean(9, false);
            statement.setBoolean(10, false);
            statement.setBoolean(11, false);
            statement.setBoolean(12, false);
            statement.setBoolean(13, false);
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Tesserato già presente");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addGiocatore(String nome, String cognome, String cf, int eta, String tesseraFip, int peso, int altezza,
                            String ruolo, int aperturaAlare) throws SQLIntegrityConstraintViolationException, SQLException {
        addTesseratoNotStaff(nome, cognome, cf, tesseraFip, eta);
        if(aperturaAlare==0) {
            final String query = "INSERT INTO Giocatore " +
                                "(tesseraFip, peso, altezza, ruolo) " +
                                "VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, tesseraFip);
            statement.setInt(2, peso);
            statement.setInt(3, altezza);
            statement.setString(4, ruolo);
            statement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                removeTesserato(tesseraFip);
                throw new IllegalArgumentException("Giocatore già presente");
            } catch (SQLException e) {
                removeTesserato(tesseraFip);
                throw new IllegalStateException(e);
            }
        } else {
            final String query = "INSERT INTO Giocatore " +
                                "(tesseraFip, peso, altezza, ruolo, Apertura_alare) " +
                                "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, tesseraFip);
            statement.setInt(2, peso);
            statement.setInt(3, altezza);
            statement.setString(4, ruolo);
            statement.setInt(5, aperturaAlare);
            statement.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                removeTesserato(tesseraFip);
                throw new IllegalArgumentException("Giocatore già presente");
            } catch (SQLException e) {
                removeTesserato(tesseraFip);
                throw new IllegalStateException(e);
            }
        }
    }

    public void addArbitro(String nome, String cognome, String cf, int eta, String tesseraFip, String sezione, int grado)
                            throws SQLIntegrityConstraintViolationException, SQLException {
        addTesseratoNotStaff(nome, cognome, cf, tesseraFip, eta);
        final String query = "INSERT INTO Arbitro " +
                            "(tesseraFip, sezione, grado, stipendio_totale) " +
                            "VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, tesseraFip);
        statement.setString(2, sezione);
        statement.setInt(3, grado);
        statement.setInt(4, 0);
        statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            removeTesserato(tesseraFip);
            throw new IllegalArgumentException("Arbitro già presente");
        } catch (SQLException e) {
            removeTesserato(tesseraFip);
            throw new IllegalStateException(e);
        }
    }

    public void addUfficiale(String nome, String cognome, String cf, int eta, String tesseraFip,
                            boolean refertista, boolean cronometrista, boolean segnapunti) throws SQLIntegrityConstraintViolationException, SQLException {
        addTesseratoNotStaff(nome, cognome, cf, tesseraFip, eta);
        final String query = "INSERT INTO Ufficiale_di_campo " +
                            "(tesseraFip, refertista, cronometrista, segnapunti, stipendio_totale) " +
                            "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, tesseraFip);
        statement.setBoolean(2, refertista);
        statement.setBoolean(3, cronometrista);
        statement.setBoolean(4, segnapunti);
        statement.setInt(5, 0);
        statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            removeTesserato(tesseraFip);
            throw new IllegalArgumentException("Ufficiale di campo già presente");
        } catch (SQLException e) {
            removeTesserato(tesseraFip);
            throw new IllegalStateException(e);
        }
    }

    public void removeTesserato(String tesseraFip) throws SQLException {
        final String query = "DELETE FROM Tesserato WHERE tesseraFip = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, tesseraFip);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Giocatore> viewPlayers() {
        final String query = "SELECT t.Nome, t.Cognome, t.Eta, t.CF, g.* " + 
                            "FROM Giocatore g, Tesserato t " + 
                            "WHERE t.tesserafip=g.tesserafip ";
        try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
            final ResultSet result = statement.executeQuery();
            
            final ObservableList<Giocatore> data = FXCollections.observableArrayList();
            while (result.next()) {
                    data.add(new Giocatore(result.getString("Nome"), result.getString("Cognome"), result.getString("CF"),
                            result.getString("tesseraFip"), result.getInt("Eta"), result.getInt("Peso"),
                            result.getInt("Altezza"), result.getString("Ruolo"), result.getInt("Apertura_alare")));
            }

            return data;

        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Arbitro> viewArbitri() {
        final String query = "SELECT t.Nome, t.Cognome, t.Eta, t.CF, a.* " + 
                            "FROM Arbitro A, Tesserato t " + 
                            "WHERE t.tesserafip=a.tesserafip ";
        try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
            final ResultSet result = statement.executeQuery();
            
            final ObservableList<Arbitro> data = FXCollections.observableArrayList();
            while (result.next()) {
                data.add(new Arbitro(result.getString("Nome"), result.getString("Cognome"), result.getString("CF"),
                        result.getString("tesseraFip"), result.getInt("Eta"), result.getString("Sezione"),
                        result.getInt("Grado"), result.getInt("Stipendio_totale")));
            }

            return data;

        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Ufficiale> viewUfficiali() {
        final String query = "SELECT t.Nome, t.Cognome, t.Eta, t.CF, u.* " + 
                            "FROM Ufficiale_di_campo u, Tesserato t " + 
                            "WHERE t.tesserafip=u.tesserafip ";
        try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
            final ResultSet result = statement.executeQuery();
            
            final ObservableList<Ufficiale> data = FXCollections.observableArrayList();
            while (result.next()) {
                data.add(new Ufficiale(result.getString("Nome"), result.getString("Cognome"), result.getString("CF"),
                        result.getString("tesseraFip"), result.getInt("Eta"), result.getBoolean("Refertista"),
                        result.getBoolean("Cronometrista"), result.getBoolean("Segnapunti"), result.getInt("Stipendio_totale")));
            }
            return data;

        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public ObservableList<Staff> viewStaff() {
        final String query = "SELECT DISTINCT t.* " +
                            "FROM Tesserato t " +
                            "where t.TesseraFIP not in (select t.tesserafip from tesserato t, giocatore g where t.tesserafip=g.tesserafip) " +
                            "and t.TesseraFIP not in (select t.tesserafip from tesserato t, arbitro a where t.tesserafip=a.tesserafip) " +
                            "and t.TesseraFIP not in (select t.tesserafip from tesserato t, ufficiale_di_campo u where t.tesserafip=u.tesserafip)";
        try (final PreparedStatement statement = this.connection.prepareStatement(query)) {
            final ResultSet result = statement.executeQuery();
            
            final ObservableList<Staff> data = FXCollections.observableArrayList();
            while (result.next()) {
                data.add(new Staff(result.getString("Nome"), result.getString("Cognome"), result.getString("CF"),
                        result.getString("tesseraFip"), result.getInt("Eta"), result.getBoolean("Preparatore_fisico"),
                        result.getBoolean("Allenatore"), result.getBoolean("Aiuto_allenatore"), result.getBoolean("Medico"),
                        result.getBoolean("Massaggiatore"), result.getBoolean("Accompagnatore"), result.getBoolean("Scorer"),
                        result.getBoolean("Addetto_arbitro"), result.getInt("Anno_patentino"), result.getString("Specializzazione")));
            }
            return data;

        } catch (final SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
