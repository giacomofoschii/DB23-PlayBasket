package it.unibo.playbasket.db.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unibo.playbasket.db.views.Classifica;
import it.unibo.playbasket.db.views.MigliorAttacco;
import it.unibo.playbasket.db.views.MigliorDifesa;
import it.unibo.playbasket.db.views.PallePerse;
import it.unibo.playbasket.db.views.PalleRubate;
import it.unibo.playbasket.db.views.Punti;
import it.unibo.playbasket.db.views.Rimbalzi;
import it.unibo.playbasket.db.views.Valutazione;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeaturesMainPage{

    private Connection connection;

    public FeaturesMainPage(Connection connection){
        this.connection = connection;
    }

    public ObservableList<MigliorAttacco> viewBestAttack(String idCampionato, int anno, String nomeGirone) {
        final String query = "SELECT S.Nome_squadra, S.punti_segnati, s.numero_vittorie, s.numero_sconfitte "
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

            final ObservableList<MigliorAttacco> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new MigliorAttacco(rs.getString("Nome_squadra"), rs.getInt("punti_segnati"), rs.getInt("numero_vittorie"),
                                             rs.getInt("numero_sconfitte")));
            }
            return list;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }
    }

    public ObservableList<MigliorDifesa> viewBestDefense(String idCampionato, int anno, String nomeGirone) {
        final String query = "SELECT S.Nome_squadra, S.punti_subiti, s.numero_vittorie, s.numero_sconfitte "
                            + "FROM Squadra S "
                            + "WHERE S.IDCampionato = ? "
                            + "AND S.nome_girone = ? "
                            + "AND S.anno_campionato = ? "
                            + "ORDER BY  S.Punti_subiti asc";	
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setString(2, nomeGirone);
            stmt.setInt(3, anno);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<MigliorDifesa> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new MigliorDifesa(rs.getString("Nome_squadra"), rs.getInt("punti_subiti"), rs.getInt("numero_vittorie"),
                                             rs.getInt("numero_sconfitte")));
            }
            return list;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }
    }

    public ObservableList<Classifica> viewRank(String idCampionato, int anno, String nomeGirone) {
        final String query = "Select S.Nome_squadra, S.numero_vittorie*2 as Punti, "
                             + "S.numero_vittorie, S.numero_vittorie+s.numero_sconfitte as partite_giocate, "
                             + "cast((S.numero_vittorie/(S.numero_vittorie+S.numero_sconfitte)*100) as decimal (3,1)) as percentuale_vittoria, "
                             + "S.punti_segnati - s.punti_subiti as differenza_punti "
                             + "from Squadra S where S.IDCampionato=? and S.nome_girone=? and S.anno_campionato=? "
                             + "order by Punti desc, S.numero_vittorie/(S.numero_vittorie+S.numero_sconfitte) desc, s.punti_segnati desc";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setString(2, nomeGirone);
            stmt.setInt(3, anno);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Classifica> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Classifica(rs.getString("nome_squadra"), rs.getInt("punti"), rs.getInt("numero_vittorie"),
                                             rs.getInt("partite_giocate"), rs.getFloat("percentuale_vittoria"), rs.getInt("differenza_punti")));
            }
            return list;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }
    }

    public ObservableList<Valutazione> viewValutazione(String idCampionato, int anno) {
        final String query = "SELECT t.Nome, t.Cognome, t.Eta, g.Ruolo, s.Nome_squadra, "
                             + "cast((avg(Tiri_2_segnati)*2 + avg(Tiri_3_segnati)*3 + avg(Tiri_liberi_segnati) "
                             + "+ avg(Rimbalzi) + avg(Assist) + avg(Palle_rubate) + avg(Stoppate) - avg(Tiri_2) " 
                             + "- avg(Tiri_3)  - avg(Tiri_liberi) - avg(Falli_fatti) + avg(Falli_subiti)) as decimal (3,1)) as Valutazione_media "
                             + "FROM Tesserato T, Performance P, Giocatore G, Campionato C, Partita M, Membro_giocatore S "
                             + "WHERE c.idcampionato=? and c.anno_campionato=? "
                             + "AND c.idcampionato=m.idcampionato AND c.anno_campionato=m.anno_campionato "
                             + "AND m.data_ora=p.data_ora AND m.codicepalestra=p.codicepalestra AND p.tesserafip=g.tesserafip "
                             + "AND g.tesserafip=t.tesserafip AND g.tesserafip=s.tesserafip group by s.nome_squadra, t.tesserafip "
                             + "order by Valutazione_media desc limit 10";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setInt(2, anno);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Valutazione> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Valutazione(rs.getString("nome"), rs.getString("cognome"), rs.getInt("eta"), rs.getString("ruolo"),
                                             rs.getString("nome_squadra"), rs.getInt("valutazione_media")));
            }
            return list;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }
    }

    public ObservableList<Punti> viewPunti(String idCampionato, int anno) {
        final String query = "SELECT t.Nome, t.Cognome, t.Eta, g.Ruolo, s.Nome_squadra, "
                            + "(sum(p.tiri_2_segnati)*2 + sum(p.tiri_3_segnati)*3 + sum(p.tiri_liberi_segnati)) as Punti_tot, "
                            + "cast((avg(tiri_2_segnati)*2 + avg(tiri_3_segnati)*3 + avg(tiri_liberi_segnati)) as decimal(3,1)) as PPG, "
                            + "concat(sum(p.tiri_2_segnati), '/', sum(p.tiri_2)) as Tiri_2, cast((sum(p.tiri_2_segnati)/sum(p.tiri_2)*100) as decimal(4,1)) as percentuale_2, "
                            + "concat(sum(p.tiri_3_segnati), '/', sum(p.tiri_3)) as Tiri_3, cast((sum(p.tiri_3_segnati)/sum(p.tiri_3)*100) as decimal(4,1)) as percentuale_3, "
                            + "concat(sum(p.tiri_liberi_segnati), '/', sum(p.tiri_liberi)) as Tiri_liberi, cast((sum(p.tiri_liberi_segnati)/sum(p.tiri_liberi)*100) as decimal(4,1)) as percentuale_FT "
                            + "FROM Tesserato T, Performance P, Giocatore G, Campionato C, Partita M, Membro_giocatore S "
                            + "WHERE c.idcampionato=? and c.anno_campionato=? "
                            + "AND c.idcampionato=m.idcampionato AND c.anno_campionato=m.anno_campionato "
                            + "AND m.data_ora=p.data_ora AND m.codicepalestra=p.codicepalestra "
                            + "AND p.tesserafip=g.tesserafip AND g.tesserafip=t.tesserafip "
                            + "AND g.tesserafip=s.tesserafip group by s.nome_squadra, t.tesserafip "
                            + "order by Punti_tot desc limit 10";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setInt(2, anno);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Punti> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Punti(rs.getString("nome"), rs.getString("cognome"), rs.getInt("eta"), rs.getString("ruolo"),
                                             rs.getString("nome_squadra"), rs.getInt("punti_tot"), rs.getFloat("ppg"),
                                             rs.getFloat("percentuale_2"), rs.getFloat("percentuale_3"), rs.getFloat("percentuale_ft")));
            }
            return list;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }
    }

    public ObservableList<PallePerse> viewPallePerse(String idCampionato, int anno) {
        final String query = "SELECT t.Nome, t.Cognome, t.Eta, g.Ruolo, s.Nome_squadra, sum(p.palle_perse) as palle_perse, "
                            + "cast(avg(p.palle_perse) as decimal(3,1)) as palle_perse_PG "
                            + "FROM Tesserato T, Performance P, Giocatore G, Campionato C, Partita M, Membro_giocatore S "
                            + "WHERE c.idcampionato=? and c.anno_campionato=? "
                            + "AND c.idcampionato=m.idcampionato AND c.anno_campionato=m.anno_campionato "
                            + "AND m.data_ora=p.data_ora AND m.codicepalestra=p.codicepalestra "
                            + "AND p.tesserafip=g.tesserafip AND g.tesserafip=t.tesserafip AND g.tesserafip=s.tesserafip "
                            + "group by s.nome_squadra, t.tesserafip order by palle_perse desc limit 10";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setInt(2, anno);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<PallePerse> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new PallePerse(rs.getString("nome"), rs.getString("cognome"), rs.getInt("eta"), rs.getString("ruolo"),
                                             rs.getString("nome_squadra"), rs.getInt("palle_perse"), rs.getFloat("palle_perse_pg")));
            }
            return list;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }
    }

    public ObservableList<PalleRubate> viewPalleRubate(String idCampionato, int anno){
        final String query = "SELECT t.Nome, t.Cognome, t.Eta, g.Ruolo, s.Nome_squadra, sum(p.palle_rubate) as palle_rubate, "
                            + "cast(avg(p.palle_rubate) as decimal(3,1)) as palle_rubate_PG "
                            + "FROM Tesserato T, Performance P, Giocatore G, Campionato C, Partita M, Membro_giocatore S "
                            + "WHERE c.idcampionato=? and c.anno_campionato=? "
                            + "AND c.idcampionato=m.idcampionato AND c.anno_campionato=m.anno_campionato "
                            + "AND m.data_ora=p.data_ora AND m.codicepalestra=p.codicepalestra "
                            + "AND p.tesserafip=g.tesserafip AND g.tesserafip=t.tesserafip AND g.tesserafip=s.tesserafip "
                            + "group by s.nome_squadra, t.tesserafip order by palle_rubate desc limit 10";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setInt(2, anno);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<PalleRubate> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new PalleRubate(rs.getString("nome"), rs.getString("cognome"), rs.getInt("eta"), rs.getString("ruolo"),
                                             rs.getString("nome_squadra"), rs.getInt("palle_rubate"), rs.getFloat("palle_rubate_pg")));
            }
            return list;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }
    }

    public ObservableList<Rimbalzi> viewRimbalzi(String idCampionato, int anno){
        final String query = "SELECT t.Nome, t.Cognome, t.Eta, g.Ruolo, s.Nome_squadra, sum(p.rimbalzi) as rimbalzi, "
                            + "cast(avg(p.rimbalzi) as decimal(3,1)) as rimbalzi_PG "
                            + "FROM Tesserato T, Performance P, Giocatore G, Campionato C, Partita M, Membro_giocatore S "
                            + "WHERE c.idcampionato=? and c.anno_campionato=? "
                            + "AND c.idcampionato=m.idcampionato AND c.anno_campionato=m.anno_campionato "
                            + "AND m.data_ora=p.data_ora AND m.codicepalestra=p.codicepalestra "
                            + "AND p.tesserafip=g.tesserafip AND g.tesserafip=t.tesserafip AND g.tesserafip=s.tesserafip "
                            + "group by s.nome_squadra, t.tesserafip order by rimbalzi desc limit 10";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setInt(2, anno);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Rimbalzi> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(new Rimbalzi(rs.getString("nome"), rs.getString("cognome"), rs.getInt("eta"), rs.getString("ruolo"),
                                             rs.getString("nome_squadra"), rs.getInt("rimbalzi"), rs.getFloat("rimbalzi_pg")));
            }
            return list;
        } catch (final SQLException e) {
            throw new IllegalStateException("Cannot execute the query!", e);
        }
    }
}
