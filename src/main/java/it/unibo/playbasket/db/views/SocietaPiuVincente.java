package it.unibo.playbasket.db.views;

public class SocietaPiuVincente {

    private String nome;
    private int titoli;

    public SocietaPiuVincente(String nome, int titoli) {
        this.nome = nome;
        this.titoli = titoli;
    }

    public String getNome() {
        return nome;
    }

    public int getTitoli() {
        return titoli;
    }
}
