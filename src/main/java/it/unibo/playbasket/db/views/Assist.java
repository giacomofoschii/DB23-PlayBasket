package it.unibo.playbasket.db.views;

public class Assist {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String nome_squadra;
    private int assist;
    private float assist_pg;

    public Assist(String nome, String cognome, int eta, String ruolo, String nome_squadra, int assist,
            float assist_pg) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.assist = assist;
        this.assist_pg = assist_pg;
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

    public int getAssist() {
        return assist;
    }

    public float getAssist_pg() {
        return assist_pg;
    }
}
