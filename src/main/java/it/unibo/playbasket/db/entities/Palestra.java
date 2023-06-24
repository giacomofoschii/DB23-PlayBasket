package it.unibo.playbasket.db.entities;

public class Palestra {

    private String codicePalestra;
    private String nome;
    private String via;
    private int numeroCivico;
    private int capienza;
    private String superficie;

    public Palestra(String codicePalestra, String nome, String via, int numeroCivico, int capienza, String superficie) {
        this.codicePalestra = codicePalestra;
        this.nome = nome;
        this.via = via;
        this.numeroCivico = numeroCivico;
        this.capienza = capienza;
        this.superficie = superficie;
    }

    public String getCodicePalestra() {
        return codicePalestra;
    }

    public String getNome() {
        return nome;
    }

    public String getVia() {
        return via;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public int getCapienza() {
        return capienza;
    }

    public String getSuperficie() {
        return superficie;
    }
}
