package it.unibo.playbasket.db.entities;

public class UfficialeDiCampo {

    private String tesseraFip;
    private boolean cronometrista;
    private boolean refertista;
    private boolean segnapunti;
    private int stipendioTotale;

    public UfficialeDiCampo(String tesseraFip, boolean cronometrista, boolean refertista, boolean segnapunti) {
        this.tesseraFip = tesseraFip;
        this.cronometrista = cronometrista;
        this.refertista = refertista;
        this.segnapunti = segnapunti;
    }

    public UfficialeDiCampo(String tesseraFip, boolean cronometrista, boolean refertista, boolean segnapunti, int stipendioTotale) {
        super();
        this.stipendioTotale = stipendioTotale;
    }

    public String getTesseraFip() {
        return tesseraFip;
    }

    public boolean isCronometrista() {
        return cronometrista;
    }

    public boolean isRefertista() {
        return refertista;
    }

    public boolean isSegnapunti() {
        return segnapunti;
    }

    public int getStipendioTotale() {
        return stipendioTotale;
    }
}
