package it.unibo.playbasket.db.views;

public class Valutazione {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String nome_squadra;
    private float valutazione_media;

    public Valutazione(String nome, String cognome, int eta, String ruolo, String nome_squadra, float valutazione_media) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.nome_squadra = nome_squadra;
        this.valutazione_media = valutazione_media;
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

    public float getValutazione_media() {
        return valutazione_media;
    }
}
