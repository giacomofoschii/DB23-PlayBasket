package it.unibo.playbasket.db.views;

public class Partita {

    private String nomeCasa;
    private String nomeOspiti;
    private int puntiCasa;
    private int puntiOspiti;
    private String dataOra;
    private String codicePalestra;
    private String idCampionato;
    private int annoCampionato;
    private String nomeGirone;

    public Partita(String nomeCasa, String nomeOspiti, int puntiCasa, int puntiOspiti, String dataOra,
            String codicePalestra, String idCampionato, int annoCampionato, String nomeGirone) {
        this.nomeCasa = nomeCasa;
        this.nomeOspiti = nomeOspiti;
        this.puntiCasa = puntiCasa;
        this.puntiOspiti = puntiOspiti;
        this.dataOra = dataOra;
        this.codicePalestra = codicePalestra;
        this.idCampionato = idCampionato;
        this.annoCampionato = annoCampionato;
        this.nomeGirone = nomeGirone;
    }

    public String getNomeCasa() {
        return nomeCasa;
    }

    public String getNomeOspiti() {
        return nomeOspiti;
    }

    public int getPuntiCasa() {
        return puntiCasa;
    }

    public int getPuntiOspiti() {
        return puntiOspiti;
    }

    public String getDataOra() {
        return dataOra;
    }

    public String getCodicePalestra() {
        return codicePalestra;
    }

    public String getIdCampionato() {
        return idCampionato;
    }

    public int getAnnoCampionato() {
        return annoCampionato;
    }

    public String getNomeGirone() {
        return nomeGirone;
    }
    

}
