package it.unibo.playbasket.db.views;

public class CalendarioSquadra {

    private String nome_squadra1;
    private String nome_squadra2;
    private String palestra;
    private String Indirizzo;
    private String data_ora;

    public CalendarioSquadra(String nome_squadra1, String nome_squadra2,int punti, int numero_vittorie, int partite_giocate, float percentuale_vittoria, int differenza_punti) {
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
