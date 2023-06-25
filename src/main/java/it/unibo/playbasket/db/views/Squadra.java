package it.unibo.playbasket.db.views;

public class Squadra {

    private String nomeSquadra;
    private String nomePalestra;
    private String nomeSocieta;
    private String nomeGirone;
    private String nomeCampionato;
    private int annoCampionato;

    public Squadra(String nomeSquadra, String nomePalestra, String nomeSocieta, String nomeGirone, String nomeCampionato, int annoCampionato) {
        this.nomeSquadra = nomeSquadra;
        this.nomePalestra = nomePalestra;
        this.nomeGirone = nomeGirone;
        this.annoCampionato = annoCampionato;
        this.nomeCampionato = nomeCampionato;
        this.nomeSocieta = nomeSocieta;
    }

    public String getNomeSquadra() {
        return nomeSquadra;
    }

    public String getNomePalestra() {
        return nomePalestra;
    }

    public String getNomeGirone() {
        return nomeGirone;
    }

    public int getAnnoCampionato() {
        return annoCampionato;
    }

    public String getNomeCampionato() {
        return nomeCampionato;
    }

    public String getNomeSocieta() {
        return nomeSocieta;
    }
}
