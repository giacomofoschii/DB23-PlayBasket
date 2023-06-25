package it.unibo.playbasket.db.views;

public class ProprietarioGiovanili {

    private String nome;
    private String cognome;
    private int titoli;
    private String nome_societa;

    public ProprietarioGiovanili(String nome, String cognome, int titoli, String nome_societa) {
        this.nome = nome;
        this.cognome = cognome;
        this.titoli = titoli;
        this.nome_societa = nome_societa;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getTitoli() {
        return titoli;
    }

    public String getNome_societa() {
        return nome_societa;
    }
}
