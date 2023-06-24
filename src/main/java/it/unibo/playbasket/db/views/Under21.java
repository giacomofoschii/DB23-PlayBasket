package it.unibo.playbasket.db.views;

public class Under21 {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String nome_squadra;
    private int punti;

    public Under21(String nome, String cognome, int eta, String ruolo, String nome_squadra, int punti) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.punti = punti;
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

    public int getPunti() {
        return punti;
    }
}
