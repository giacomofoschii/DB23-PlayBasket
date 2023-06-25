package it.unibo.playbasket.db.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import it.unibo.playbasket.db.views.Palestra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeaturesPalestra{

    private Connection connection;

    public FeaturesPalestra(Connection connection){
        this.connection = connection;
    }

    public ObservableList<Palestra> viewPalestre() {
        final String query= "SELECT  L.Nome_Palestra, concat(L.Via, ' ' , L.Civico) as Indirizzo, "
                            + "L.codicepalestra, L.superficie, L.capienza "
                            + "FROM palestra L;";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Palestra> palestre = FXCollections.observableArrayList();
            while (rs.next()) {
                palestre.add(new Palestra(rs.getString("Nome_Palestra"), rs.getString("Indirizzo"),
                                         rs.getString("codicepalestra"), rs.getString("superficie"), rs.getInt("capienza")));
            }
            return palestre;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addPalestra(String nome, String id, String via, int civico, String superficie, int capienza) 
                            throws SQLIntegrityConstraintViolationException, SQLException {
        final String query = "INSERT INTO Palestra (via, civico, nome_palestra, codicepalestra, superficie, capienza) "
                             + "VALUES (?, ?, ?, ?, ?, ?)";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, via);
            stmt.setInt(2, civico);
            stmt.setString(3, nome);
            stmt.setString(4, id);
            stmt.setString(5, superficie);
            stmt.setInt(6, capienza);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new IllegalArgumentException("Palestra già presente");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removePalestra(String id) throws SQLException {
        final String query = "DELETE FROM Palestra WHERE codicepalestra = ?";
        try (final PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
