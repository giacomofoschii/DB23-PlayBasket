package it.unibo.playbasket.db.views;

public class PalleRubate {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String nome_squadra;
    private int palle_rubate;
    private float palle_rubate_pg;

    public PalleRubate(String nome, String cognome, int eta, String ruolo, String nome_squadra, int palle_rubate,
            float palle_rubate_pg) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.palle_rubate = palle_rubate;
        this.palle_rubate_pg = palle_rubate_pg;
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

    public int getPalle_rubate() {
        return palle_rubate;
    }

    public float getPalle_rubate_pg() {
        return palle_rubate_pg;
    }
}
