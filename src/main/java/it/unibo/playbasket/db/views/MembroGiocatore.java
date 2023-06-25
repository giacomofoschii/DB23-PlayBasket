package it.unibo.playbasket.db.views;

public class MembroGiocatore {

    private String nome;
    private String cognome;
    private String ruolo;
    private String eta;
    private int altezza;
    private int peso;
    private int aperturaAlare;
    private int stipendio;
    private boolean capitano;

    public MembroGiocatore(String nome, String cognome, String ruolo, String eta, int altezza, int peso, int aperturaAlare, int stipendio, boolean capitano) {
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.eta = eta;
        this.altezza = altezza;
        this.peso = peso;
        this.aperturaAlare = aperturaAlare;
        this.stipendio = stipendio;
        this.capitano = capitano;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getRuolo() {
        return ruolo;
    }

    public String getEta() {
        return eta;
    }

    public int getAltezza() {
        return altezza;
    }

    public int getPeso() {
        return peso;
    }

    public int getAperturaAlare() {
        return aperturaAlare;
    }

    public int getStipendio() {
        return stipendio;
    }

    public boolean getCapitano() {
        return capitano;
    }
}
