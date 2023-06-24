package it.unibo.playbasket.db.views;

public class MigliorAttacco {

    private String nome_squadra;
    private int punti_fatti;
    private int numero_vittorie;
    private int numero_sconfitte;
    private int partite_giocate;

    public MigliorAttacco(String nome_squadra, int punti_fatti, int numero_vittorie, int numero_sconfitte) {
        this.nome_squadra = nome_squadra;
        this.punti_fatti = punti_fatti;
        this.numero_vittorie = numero_vittorie;
        this.numero_sconfitte = numero_sconfitte;
        this.partite_giocate = numero_vittorie + numero_sconfitte;
    }

    public String getNome_squadra() {
        return nome_squadra;
    }

    public int getPunti_fatti() {
        return punti_fatti;
    }

    public int getNumero_vittorie() {
        return numero_vittorie;
    }

    public int getNumero_sconfitte() {
        return numero_sconfitte;
    }

    public int getPartite_giocate() {
        return partite_giocate;
    }
}
