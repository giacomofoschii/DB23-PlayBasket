package it.unibo.playbasket.db.views;

public class Arbitro {

    private String nome;
    private String cognome;
    private String CF;
    private String tesseraFip;
    private int eta;
    private String sezione;
    private int grado;
    private int stipendio_totale;

    public Arbitro(String nome, String cognome, String CF, String tesseraFip, int eta, String sezione, int grado, int stipendio_totale) {
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
        this.tesseraFip = tesseraFip;
        this.eta = eta;
        this.sezione = sezione;
        this.grado = grado;
        this.stipendio_totale = stipendio_totale;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCF() {
        return CF;
    }

    public String getTesseraFip() {
        return tesseraFip;
    }

    public int getEta() {
        return eta;
    }

    public String getSezione() {
        return sezione;
    }

    public int getGrado() {
        return grado;
    }

    public int getStipendio_totale() {
        return stipendio_totale;
    }
}
