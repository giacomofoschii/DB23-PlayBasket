package it.unibo.playbasket.db.views;

public class Classifica {

    private String nome_squadra;
    private int punti;
    private int numero_vittorie;
    private int partite_giocate;
    private float percentuale_vittoria;
    private int differenza_punti;

    public Classifica(String nome_squadra, int punti, int numero_vittorie, int partite_giocate, float percentuale_vittoria, int differenza_punti) {
        this.nome_squadra = nome_squadra;
        this.punti = punti;
        this.numero_vittorie = numero_vittorie;
        this.partite_giocate = partite_giocate;
        this.percentuale_vittoria = percentuale_vittoria;
        this.differenza_punti = differenza_punti;
    }

    public String getNome_squadra() {
        return nome_squadra;
    }

    public int getPunti() {
        return punti;
    }

    public int getNumero_vittorie() {
        return numero_vittorie;
    }

    public int getPartite_giocate() {
        return partite_giocate;
    }

    public float getPercentuale_vittoria() {
        return percentuale_vittoria;
    }

    public int getDifferenza_punti() {
        return differenza_punti;
    }
}
