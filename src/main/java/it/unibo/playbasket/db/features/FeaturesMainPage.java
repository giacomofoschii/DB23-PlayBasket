package it.unibo.playbasket.db.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeaturesMainPage{

    private Connection connection;

    public FeaturesMainPage(Connection connection){
        this.connection = connection;
    }

    /*public ObservableList<Squadra> viewBestAttack(String idCampionato, int anno, String nomeGirone) {
        final String query = "SELECT S.Nome_squadra, S.Anno_campionato, S.punti_segnati "
                            + "FROM Squadra S "
                            + "WHERE S.IDCampionato = ? "
                            + "AND S.nome_girone = ? "
                            + "AND S.anno_campionato = ? "
                            + "ORDER BY  S.Punti_segnati desc";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setString(2, nomeGirone);
            stmt.setInt(3, anno);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Squadra> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Squadra(rs.getString("Nome_squadra"), rs.getString("IDCampionato"), rs.getInt("Anno_campionato"), rs.getString("Nome_girone").charAt(0), rs.getString("Codice_meccanografico"), rs.getString("Codice_palestra")));
            }
            return list;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }
    }*/
}
