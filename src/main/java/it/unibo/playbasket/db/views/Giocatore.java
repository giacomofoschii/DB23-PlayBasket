package it.unibo.playbasket.db.views;

public class Giocatore {

    private String nome;
    private String cognome;
    private String CF;
    private String tesseraFip;
    private int eta;
    private int peso;
    private int altezza;
    private String ruolo;
    private int apertura_alare;

    public Giocatore(String nome, String cognome, String CF, String tesseraFip, int eta, int peso,
                    int altezza, String ruolo, int apertura_alare) {
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
        this.tesseraFip = tesseraFip;
        this.eta = eta;
        this.peso = peso;
        this.altezza = altezza;
        this.ruolo = ruolo;
        this.apertura_alare = apertura_alare;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCF() {
        return CF;
    }

    public String getTesseraFip() {
        return tesseraFip;
    }

    public int getEta() {
        return eta;
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

    public int getApertura_Alare() {
        return apertura_alare;
    }
}
