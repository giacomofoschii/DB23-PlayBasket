package it.unibo.playbasket.db.entities;

public class Squadra {

    private String nomeSquadra;
    private String idCampionato;
    private int anno;
    private char nomeGirone;
    private String codiceMeccanografico;
    private String codicePalestra;
    private int puntiSegnati;
    private int puntiSubiti;
    private int numeroVittorie;
    private int numeroSconfitte;
    private int numVittorieOspiti;


    public Squadra(String nomeSquadra, String idCampionato, int anno, char nomeGirone, String codiceMeccanografico, String codicePalestra) {
        this.nomeSquadra = nomeSquadra;
        this.idCampionato = idCampionato;
        this.anno = anno;
        this.nomeGirone = nomeGirone;
        this.codiceMeccanografico = codiceMeccanografico;
        this.codicePalestra = codicePalestra;
        this.puntiSegnati = 0;
        this.puntiSubiti = 0;
        this.numeroVittorie = 0;
        this.numeroSconfitte = 0;
        this.numVittorieOspiti = 0;
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

    public int getPuntiSegnati() {
        return puntiSegnati;
    }

    public int getPuntiSubiti() {
        return puntiSubiti;
    }

    public int getNumeroVittorie() {
        return numeroVittorie;
    }

    public int getNumeroSconfitte() {
        return numeroSconfitte;
    }

    public int getNumVittorieOspiti() {
        return numVittorieOspiti;
    }
}
