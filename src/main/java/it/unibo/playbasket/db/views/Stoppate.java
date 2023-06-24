package it.unibo.playbasket.db.views;

public class Stoppate {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String nome_squadra;
    private int stoppate;
    private float stoppate_pg;

    public stoppate(String nome, String cognome, int eta, String ruolo, String nome_squadra, int stoppate,
            float stoppate_pg) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.stoppate = stoppate;
        this.stoppate_pg = stoppate_pg;
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

    public int getStoppate() {
        return stoppate;
    }

    public float getStoppate_pg() {
        return stoppate_pg;
    }
}
