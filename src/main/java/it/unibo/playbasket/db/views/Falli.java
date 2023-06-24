package it.unibo.playbasket.db.views;

public class Falli {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String nome_squadra;
    private int falli_fatti;
    private float falli_fatti_pg;
    private int falli_subiti;
    private int falli_subiti_pg;

    public Falli(String nome, String cognome, int eta, String ruolo, String nome_squadra, int Falli,
            float falli_pg, int falli_subiti, int falli_subiti_pg) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.falli = falli;
        this.falli_pg = falli_pg;
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

    public int getFalli_Fatti() {
        return falli_fatti;
    }

    public float getFalli_fatti_pg() {
        return falli_fatti_pg;
    }

    public int getFalli_subiti() {
        return falli_subiti;
    }

    public float getFalli_subiti_pg() {
        return falli_subiti_pg;
    }
}
