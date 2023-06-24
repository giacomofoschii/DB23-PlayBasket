package it.unibo.playbasket.db.views;

public class MigliorDifesa {

    private String nome_squadra;
    private int punti_subiti;
    private int numero_vittorie;
    private int numero_sconfitte;
    private int partite_giocate;

    public MigliorDifesa(String nome_squadra, int punti_subiti, int numero_vittorie, int numero_sconfitte) {
        this.nome_squadra = nome_squadra;
        this.punti_subiti = punti_subiti;
        this.numero_vittorie = numero_vittorie;
        this.numero_sconfitte = numero_sconfitte;
        this.partite_giocate = numero_vittorie + numero_sconfitte;
    }

    public String getNome_squadra() {
        return nome_squadra;
    }

    public int getPunti_subiti() {
        return punti_subiti;
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
