package it.unibo.playbasket.db.entities;

import java.util.Date;

public class Direzione {

    private String codicePalestra;
    private String tesseraFip;
    private Date dataOra;
    private int rimborso;

    public Direzione(String codicePalestra, String tesseraFip, Date dataOra, int rimborso) {
        this.codicePalestra = codicePalestra;
        this.tesseraFip = tesseraFip;
        this.dataOra = dataOra;
        this.rimborso = rimborso;
    }

    public String getCodicePalestra() {
        return codicePalestra;
    }

    public String getTesseraFip() {
        return tesseraFip;
    }

    public Date getDataOra() {
        return dataOra;
    }

    public int getRimborso() {
        return rimborso;
    }
}
