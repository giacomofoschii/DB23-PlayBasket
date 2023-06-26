package it.unibo.playbasket.db.views;

public class Campionato {

    private String nome;
    private int anno;
    private String regione;
    private String vinto_da;

    public Campionato(String nome, int anno, String regione, String vinto_da) {
        this.nome = nome;
        this.anno = anno;
        this.regione = regione;
        this.vinto_da = vinto_da;
    }

    public String getNome() {
        return nome;
    }

    public int getAnno() {
        return anno;
    }

    public String getRegione() {
        return regione;
    }

    public String getVinto_da() {
        return vinto_da;
    }
}
