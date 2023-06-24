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
    private float falli_subiti_pg;

    public Falli(String nome, String cognome, int eta, String ruolo, String nome_squadra, int falli_fatti, 
                    float falli_fatti_pg, int falli_subiti, float falli_subiti_pg) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.falli_fatti = falli_fatti;
        this.falli_fatti_pg = falli_fatti_pg;
        this.falli_subiti = falli_subiti;
        this.falli_subiti_pg = falli_subiti_pg;
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

    public int getFalli_fatti() {
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
