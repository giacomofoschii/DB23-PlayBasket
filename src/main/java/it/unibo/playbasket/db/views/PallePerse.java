package it.unibo.playbasket.db.views;

public class PallePerse {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String nome_squadra;
    private int palle_perse;
    private float palle_perse_pg;

    public PallePerse(String nome, String cognome, int eta, String ruolo, String nome_squadra, int palle_perse,
            float palle_perse_pg) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.palle_perse = palle_perse;
        this.palle_perse_pg = palle_perse_pg;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public String getRuolo() {
        return ruolo;
    }

    public String getNome_squadra() {
        return nome_squadra;
    }

    public int getPalle_perse() {
        return palle_perse;
    }

    public float getPalle_perse_pg() {
        return palle_perse_pg;
    }
}
