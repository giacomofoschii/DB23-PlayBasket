package it.unibo.playbasket.db.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unibo.playbasket.db.views.ProprietarioGiovanili;
import it.unibo.playbasket.db.views.SocietaPiuVincente;
import it.unibo.playbasket.db.views.StipendioArbitro;
import it.unibo.playbasket.db.views.StipendioUfficiale;
import it.unibo.playbasket.db.views.Top10Assist;
import it.unibo.playbasket.db.views.Under21;
import it.unibo.playbasket.db.views.VittoriaOspite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeaturesMoreStats{

    private Connection connection;

    public FeaturesMoreStats(Connection connection){
        this.connection = connection;
    }

    public ObservableList<Under21> viewUnder21() {
        final String query = "SELECT t.Nome, t.Cognome, t.Eta, g.Ruolo, s.Nome_squadra, "
                            + "(sum(p.tiri_2_segnati)*2 + sum(p.tiri_3_segnati)*3 + sum(p.tiri_liberi_segnati)) as Punti_tot "
                            + "FROM Tesserato T, Performance P, Giocatore G, Campionato C, Partita M, Membro_giocatore S "
                            + "WHERE c.nome_campionato not like 'Under%' AND c.idcampionato=m.idcampionato "
                            + "AND c.anno_campionato=m.anno_campionato AND m.data_ora=p.data_ora AND m.codicepalestra=p.codicepalestra "
                            + "AND p.tesserafip=g.tesserafip AND g.tesserafip=t.tesserafip AND g.tesserafip=s.tesserafip "
                            + "AND t.eta <= 21 group by s.nome_squadra, t.tesserafip order by Punti_tot desc limit 1";
        try(PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Under21> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Under21(rs.getString("Nome"), rs.getString("Cognome"), rs.getInt("Eta"),
                                     rs.getString("Ruolo"), rs.getString("Nome_squadra"), rs.getInt("Punti_tot")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<ProprietarioGiovanili> viewProprietarioGiovanili() {
        final String query = "SELECT p.nome, p.cognome, count(c.CodiceMeccanografico) as Titoli, s.nome as Nome_societa "
                            + "from proprietario p, societa s, campionato c where p.cf=s.CF_proprietario "
                            + "and s.CodiceMeccanografico=c.CodiceMeccanografico and c.nome_campionato like 'Under%' "
                            + "group by c.CodiceMeccanografico limit 1";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<ProprietarioGiovanili> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new ProprietarioGiovanili(rs.getString("Nome"), rs.getString("Cognome"), rs.getInt("Titoli"), 
                                                    rs.getString("Nome_societa")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<SocietaPiuVincente> viewSocietaPiuVincente() {
        final String query = "Select S.Nome,  S.Titoli from Societa S order by S.Titoli desc limit 1" ;
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<SocietaPiuVincente> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new SocietaPiuVincente(rs.getString("Nome"), rs.getInt("Titoli")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<VittoriaOspite> viewVittoriaOspite(String idCampionato, int anno) {
        final String query = "Select S.Nome_squadra, S.Num_Vittorie_Ospiti "
                            + "from Squadra S where S.IDCampionato=? and S.anno_campionato=? "
                            + "order by S.Num_Vittorie_Ospiti desc";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setInt(2, anno);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<VittoriaOspite> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new VittoriaOspite(rs.getString("Nome_squadra"), rs.getInt("num_Vittorie_ospiti")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Top10Assist> viewTop10Assist(String idCampionato, int anno) {
        final String query = "SELECT t.Nome, t.Cognome, t.Eta, g.Ruolo, s.Nome_squadra, "
                            + "sum(p.Assist) as Assist_Tot, cast(avg(p.Assist) as decimal(3,1)) as APG "
                            + "FROM Tesserato T, Performance P, Giocatore G, Campionato C, Partita M, Membro_giocatore S "
                            + "WHERE c.idcampionato=? AND c.anno_campionato=? AND c.idcampionato=m.idcampionato "
                            + "AND c.anno_campionato=m.anno_campionato AND m.data_ora=p.data_ora AND m.codicepalestra=p.codicepalestra "
                            + "AND S.stipendio<(SELECT avg(m.stipendio) FROM membro_giocatore m where idcampionato=? and anno_campionato=?) "
                            + "AND p.tesserafip=g.tesserafip AND g.tesserafip=t.tesserafip AND g.tesserafip=s.tesserafip "
                            + "group by s.nome_squadra, t.tesserafip order by sum(p.assist) desc limit 10";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, idCampionato);
            stmt.setInt(2, anno);
            stmt.setString(3, idCampionato);
            stmt.setInt(4, anno);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<Top10Assist> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new Top10Assist(rs.getString("Nome"), rs.getString("Cognome"), rs.getInt("Eta"),
                                          rs.getString("Ruolo"), rs.getString("Nome_squadra"), rs.getInt("Assist_Tot"),
                                          rs.getFloat("APG")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<StipendioArbitro> viewStipendioArbitro(String tesseraFip) {
        final String query = "Select T.Nome, T.Cognome, A.Grado, A.Sezione, "
                            + "count(d.tesserafip) as Partite_dirette, A.Stipendio_totale as Guadagno "
                            + "from Tesserato T, Arbitro A, Direzione D where A.TesseraFIP=? "
                            + "and A.TesseraFIP=D.tesseraFIP and T.TesseraFIP=A.TesseraFIP";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, tesseraFip);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<StipendioArbitro> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new StipendioArbitro(rs.getString("Nome"), rs.getString("Cognome"), rs.getInt("Grado"),
                                              rs.getString("Sezione"), rs.getInt("Partite_dirette"), rs.getInt("Guadagno")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<StipendioUfficiale> viewStipendioUfficiale(String tesseraFip) {
        final String query = "Select T.Nome, T.Cognome, U.Cronometrista, U.Refertista, U.Segnapunti, "
                            + "count(c.tesserafip) as Partite_codirette, U.Stipendio_totale as Guadagno "
                            + "from Tesserato T, Ufficiale_di_campo U, Codirezione C where U.TesseraFIP=? "
                            +" and U.tesseraFIP=C.tesseraFIP and T.TesseraFIP=U.TesseraFIP";
        try (PreparedStatement stmt = this.connection.prepareStatement(query)) {
            stmt.setString(1, tesseraFip);
            final ResultSet rs = stmt.executeQuery();

            final ObservableList<StipendioUfficiale> list = FXCollections.observableArrayList();
            while(rs.next()){
                list.add(new StipendioUfficiale(rs.getString("Nome"), rs.getString("Cognome"), rs.getBoolean("cronometrista"),
                                                 rs.getBoolean("refertista"), rs.getBoolean("segnapunti"),
                                                 rs.getInt("Partite_codirette"), rs.getInt("Guadagno")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
