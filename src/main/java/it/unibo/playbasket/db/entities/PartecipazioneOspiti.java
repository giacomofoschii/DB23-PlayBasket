package it.unibo.playbasket.db.entities;

import java.util.Date;

public class PartecipazioneOspiti {

    private String codicePalestra;
    private Date daraOra;
    private String idCampionato;
    private int anno;
    private char nomeGirone;
    private String nomeSquadra;
    private int puntiFatti;

    public PartecipazioneOspiti(String codicePalestra, Date daraOra, String idCampionato, int anno, char nomeGirone, String nomeSquadra, int puntiFatti) {
        this.codicePalestra = codicePalestra;
        this.daraOra = daraOra;
        this.idCampionato = idCampionato;
        this.anno = anno;
        this.nomeGirone = nomeGirone;
        this.nomeSquadra = nomeSquadra;
        this.puntiFatti = puntiFatti;
    }

    public String getCodicePalestra() {
        return codicePalestra;
    }
    public Date getDaraOra() {
        return daraOra;
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
    public String getNomeSquadra() {
        return nomeSquadra;
    }
    public int getPuntiFatti() {
        return puntiFatti;
    }
}
