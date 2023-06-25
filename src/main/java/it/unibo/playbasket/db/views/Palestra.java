package it.unibo.playbasket.db.views;

public class Palestra {

    private String nome_palestra;
    private String codicePalestra;
    private String indirizzo;
    private String superficie;
    private int capienza;

    public Palestra(String nome_palestra, String indirizzo, String codicePalestra, String superficie, int capienza) {
        this.nome_palestra = nome_palestra;
        this.codicePalestra = codicePalestra;
        this.indirizzo = indirizzo;
        this.superficie = superficie;
        this.capienza = capienza;
    }

    public String getNome_palestra() {
        return nome_palestra;
    }

    public String getCodicePalestra() {
        return codicePalestra;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getSuperficie() {
        return superficie;
    }

    public int getCapienza() {
        return capienza;
    }
}
