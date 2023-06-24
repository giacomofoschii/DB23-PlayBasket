package it.unibo.playbasket.db.views;

public class Rimbalzi {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String nome_squadra;
    private int rimbalzi;
    private float rimbalzi_pg;

    public Rimbalzi(String nome, String cognome, int eta, String ruolo, String nome_squadra, int rimbalzi,
            float rimbalzi_pg) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.rimbalzi = rimbalzi;
        this.rimbalzi_pg = rimbalzi_pg;
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

    public int getRimbalzi() {
        return rimbalzi;
    }

    public float getRimbalzi_pg() {
        return rimbalzi_pg;
    }
}
