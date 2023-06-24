package it.unibo.playbasket.db.entities;

public class Arbitro {

    private String tesseraFip;
    private String sezione;
    private int grado;
    private int stipendioTotale;

    public Arbitro(String tesseraFip, String sezione, int grado) {
        this.tesseraFip = tesseraFip;
        this.sezione = sezione;
        this.grado = grado;
        this.stipendioTotale = 0;
    }

    public Arbitro(String tesseraFip, String sezione, int grado, int stipendioTotale) {
        super();
        this.stipendioTotale = stipendioTotale;
    }

    public String getTesseraFip() {
        return tesseraFip;
    }

    public String getSezione() {
        return sezione;
    }

    public int getGrado() {
        return grado;
    }

    public int getStipendioTotale() {
        return stipendioTotale;
    }
}
