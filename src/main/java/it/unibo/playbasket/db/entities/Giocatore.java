package it.unibo.playbasket.db.entities;

public class Giocatore {

    private String tesseraFip;
    private int peso;
    private int altezza;
    private String ruolo;
    private int apertura_alare;

    public Giocatore(String tesseraFip, int peso, int altezza, String ruolo) {
        this.tesseraFip = tesseraFip;
        this.peso = peso;
        this.altezza = altezza;
        this.ruolo = ruolo;
        this.apertura_alare = 0;
    }

    public Giocatore(String tesseraFip, int peso, int altezza, String ruolo, int apertura_alare) {
        super();
        this.apertura_alare = 0;
    }

    public String getTesseraFip() {
        return tesseraFip;
    }

    public int getPeso() {
        return peso;
    }

    public int getAltezza() {
        return altezza;
    }

    public String getRuolo() {
        return ruolo;
    }

    public int getApertura_alare() {
        return apertura_alare;
    }
}
