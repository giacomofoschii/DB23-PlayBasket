package it.unibo.playbasket.db.entities;

public class MembroPF {

    private String tesseraFip;
    private String idCampionato;
    private String nomeSquadra;
    private int anno;
    private char nomeGirone;
    private int stipendio;

    public MembroPF(String tesseraFip, String idCampionato, String nomeSquadra, int anno, char nomeGirone, int stipendio) {
        this.tesseraFip = tesseraFip;
        this.idCampionato = idCampionato;
        this.nomeSquadra = nomeSquadra;
        this.anno = anno;
        this.nomeGirone = nomeGirone;
        this.stipendio = stipendio;
    }

    public String getTesseraFip() {
        return tesseraFip;
    }

    public String getIdCampionato() {
        return idCampionato;
    }

    public String getNomeSquadra() {
        return nomeSquadra;
    }

    public int getAnno() {
        return anno;
    }

    public char getNomeGirone() {
        return nomeGirone;
    }

    public int getStipendio() {
        return stipendio;
    }
}
