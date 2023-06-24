package it.unibo.playbasket.db.entities;

public class Societa {

    private String codiceMeccanografico;
    private String nomeSocieta;
    private int titoli;
    private String sponsor;
    private int telefono;
    private String email;
    private String via;
    private int numeroCivico;
    private String CFproprietario;

    public Societa(String codiceMeccanografico, String nomeSocieta, int titoli, String sponsor, int telefono, String email, String via, int numeroCivico, String CFproprietario) {
        this.codiceMeccanografico = codiceMeccanografico;
        this.nomeSocieta = nomeSocieta;
        this.titoli = titoli;
        this.sponsor = sponsor;
        this.telefono = telefono;
        this.email = email;
        this.via = via;
        this.numeroCivico = numeroCivico;
        this.CFproprietario = CFproprietario;
    }

    public String getCodiceMeccanografico() {
        return codiceMeccanografico;
    }

    public String getNomeSocieta() {
        return nomeSocieta;
    }

    public int getTitoli() {
        return titoli;
    }

    public String getSponsor() {
        return sponsor;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getVia() {
        return via;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public String getCFproprietario() {
        return CFproprietario;
    }
}
