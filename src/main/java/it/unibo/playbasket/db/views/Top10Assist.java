package it.unibo.playbasket.db.views;

public class Top10Assist {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String nome_squadra;
    private int assist_tot;
    private float apg;

    public Top10Assist(String nome, String cognome, int eta, String ruolo, String nome_squadra, int assist_tot, float apg) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.assist_tot = assist_tot;
        this.apg = apg;
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

    public int getAssist_tot() {
        return assist_tot;
    }

    public float getApg() {
        return apg;
    }
}
