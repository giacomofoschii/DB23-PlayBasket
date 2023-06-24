package it.unibo.playbasket.db.entities;

public class MembroGiocatore {

    private String tesseraFip;
    private String idCampionato;
    private String nomeSquadra;
    private int anno;
    private char nomeGirone;
    private int stipendio;
    private boolean capitano;

    public MembroGiocatore(String tesseraFip, String idCampionato, String nomeSquadra, int anno, char nomeGirone, int stipendio, boolean capitano) {
        this.tesseraFip = tesseraFip;
        this.idCampionato = idCampionato;
        this.nomeSquadra = nomeSquadra;
        this.anno = anno;
        this.nomeGirone = nomeGirone;
        this.stipendio = stipendio;
        this.capitano = capitano;
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

    public boolean isCapitano() {
        return capitano;
    }
}
