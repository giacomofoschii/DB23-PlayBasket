package it.unibo.playbasket.db.entities;

import java.util.Date;

public class Performance {

    private String codicePalestra;
    private Date dataOra;
    private String tesseraFip;
    private int rimbalzi;
    private int assist;
    private int falliFatti;
    private int falliSubiti;
    private int minuti;
    private int tiri2;
    private int tiri3;
    private int tiriLiberi;
    private int tiri2Segnati;
    private int tiri3Segnati;
    private int tiriLiberiSegnati;
    private int pallePerse;
    private int palleRubate;
    private int stoppate;

    public Performance(String codicePalestra, Date dataOra, String tesseraFip, int rimbalzi, int assist, int falliFatti, int falliSubiti, int minuti, int tiri2, int tiri3, int tiriLiberi, int tiri2Segnati, int tiri3Segnati, int tiriLiberiSegnati, int pallePerse, int palleRubate, int stoppate) {
        this.codicePalestra = codicePalestra;
        this.dataOra = dataOra;
        this.tesseraFip = tesseraFip;
        this.rimbalzi = rimbalzi;
        this.assist = assist;
        this.falliFatti = falliFatti;
        this.falliSubiti = falliSubiti;
        this.minuti = minuti;
        this.tiri2 = tiri2;
        this.tiri3 = tiri3;
        this.tiriLiberi = tiriLiberi;
        this.tiri2Segnati = tiri2Segnati;
        this.tiri3Segnati = tiri3Segnati;
        this.tiriLiberiSegnati = tiriLiberiSegnati;
        this.pallePerse = pallePerse;
        this.palleRubate = palleRubate;
        this.stoppate = stoppate;
    }

    public String getCodicePalestra() {
        return codicePalestra;
    }

    public Date getDataOra() {
        return dataOra;
    }

    public String getTesseraFip() {
        return tesseraFip;
    }

    public int getRimbalzi() {
        return rimbalzi;
    }

    public int getAssist() {
        return assist;
    }

    public int getFalliFatti() {
        return falliFatti;
    }

    public int getFalliSubiti() {
        return falliSubiti;
    }

    public int getMinuti() {
        return minuti;
    }

    public int getTiri2() {
        return tiri2;
    }

    public int getTiri3() {
        return tiri3;
    }

    public int getTiriLiberi() {
        return tiriLiberi;
    }

    public int getTiri2Segnati() {
        return tiri2Segnati;
    }

    public int getTiri3Segnati() {
        return tiri3Segnati;
    }

    public int getTiriLiberiSegnati() {
        return tiriLiberiSegnati;
    }

    public int getPallePerse() {
        return pallePerse;
    }

    public int getPalleRubate() {
        return palleRubate;
    }

    public int getStoppate() {
        return stoppate;
    }
}
