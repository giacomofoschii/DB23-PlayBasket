package it.unibo.playbasket.db.views;

public class VittoriaOspite {

    private String nome_squadra;
    private int num_vittorie_ospiti;

    public VittoriaOspite(String nome_squadra, int num_vittorie_ospiti) {
        this.nome_squadra = nome_squadra;
        this.num_vittorie_ospiti = num_vittorie_ospiti;
    }

    public String getNome_squadra() {
        return nome_squadra;
    }

    public int getNum_vittorie_ospiti() {
        return num_vittorie_ospiti;
    }
}