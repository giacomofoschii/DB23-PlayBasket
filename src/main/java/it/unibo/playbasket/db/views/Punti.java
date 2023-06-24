package it.unibo.playbasket.db.views;

public class Punti {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String nome_squadra;
    private int punti_tot;
    private float ppg;
    private float percentuale_2;
    private float percentuale_3;
    private float percentuale_ft;

    public Punti(String nome, String cognome, int eta, String ruolo, String nome_squadra, int punti_tot, float ppg,
            float percentuale_2, float percentuale_3, float percentuale_ft) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.punti_tot = punti_tot;
        this.ppg = ppg;
        this.percentuale_2 = percentuale_2;
        this.percentuale_3 = percentuale_3;
        this.percentuale_ft = percentuale_ft;
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

    public int getPunti_tot() {
        return punti_tot;
    }

    public float getPpg() {
        return ppg;
    }

    public float getPercentuale_2() {
        return percentuale_2;
    }

    public float getPercentuale_3() {
        return percentuale_3;
    }

    public float getPercentuale_ft() {
        return percentuale_ft;
    }
}
