package it.unibo.playbasket.db.views;

public class Ufficiale {

    private String nome;
    private String cognome;
    private String CF;
    private String tesseraFip;
    private int eta;
    private boolean cronometrista;
    private boolean refertista;
    private boolean segnapunti;
    private int stipendio_totale;

    public Ufficiale(String nome, String cognome, String CF, String tesseraFip, int eta, boolean cronometrista,
                     boolean refertista, boolean segnapunti, int stipendio_totale) {
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
        this.tesseraFip = tesseraFip;
        this.eta = eta;
        this.cronometrista = cronometrista;
        this.refertista = refertista;
        this.segnapunti = segnapunti;
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

    public boolean isCronometrista() {
        return cronometrista;
    }

    public boolean isRefertista() {
        return refertista;
    }

    public boolean isSegnapunti() {
        return segnapunti;
    }

    public int getStipendio_totale() {
        return stipendio_totale;
    }
}
