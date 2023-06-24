package it.unibo.playbasket.db.entities;

import java.util.Date;

public class Partita {

    private String codicePalestra;
    private Date dataOra;
    private String idCampionato;
    private int anno;
    private char nomeGirone;

    public Partita(String codicePalestra, Date dataOra, String idCampionato, int anno, char nomeGirone) {
        this.codicePalestra = codicePalestra;
        this.dataOra = dataOra;
        this.idCampionato = idCampionato;
        this.anno = anno;
        this.nomeGirone = nomeGirone;
    }

    public String getCodicePalestra() {
        return codicePalestra;
    }

    public Date getDataOra() {
        return dataOra;
    }

    public String getIdCampionato() {
        return idCampionato;
    }

    public int getAnno() {
        return anno;
    }

    public char getNomeGirone() {
        return nomeGirone;
    }
}
