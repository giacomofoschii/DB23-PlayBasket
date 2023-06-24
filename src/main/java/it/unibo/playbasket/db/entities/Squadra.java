package it.unibo.playbasket.db.entities;

public class Squadra {

    private String nomeSquadra;
    private String idCampionato;
    private int anno;
    private char nomeGirone;
    private String codiceMeccanografico;
    private String codicePalestra;

    public Squadra(String nomeSquadra, String idCampionato, int anno, char nomeGirone, String codiceMeccanografico, String codicePalestra) {
        this.nomeSquadra = nomeSquadra;
        this.idCampionato = idCampionato;
        this.anno = anno;
        this.nomeGirone = nomeGirone;
        this.codiceMeccanografico = codiceMeccanografico;
        this.codicePalestra = codicePalestra;
    }

    public String getNomeSquadra() {
        return nomeSquadra;
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

    public String getCodiceMeccanografico() {
        return codiceMeccanografico;
    }

    public String getCodicePalestra() {
        return codicePalestra;
    }
}
