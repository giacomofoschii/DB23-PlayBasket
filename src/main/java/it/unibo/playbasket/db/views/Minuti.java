package it.unibo.playbasket.db.views;

public class Minuti {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String nome_squadra;
    private int minuti;
    private float minuti_pg;

    public Minuti(String nome, String cognome, int eta, String ruolo, String nome_squadra, int minuti,
            float minuti_pg) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.minuti = minuti;
        this.minuti_pg = minuti_pg;
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

    public int getMinuti() {
        return minuti;
    }

    public float getMinuti_pg() {
        return minuti_pg;
    }
}
