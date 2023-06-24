package it.unibo.playbasket.db.views;

public class CalendarioSocieta {

    private String nome_squadra1;
    private String nome_squadra2;
    private String nome_palestra;
    private String indirizzo;
    private String data_ora;
    private String nome_campionato;
    private String nome_girone;

    public CalendarioSocieta(String nome_squadra1, String nome_squadra2, String nome_palestra, String indirizzo, String data_ora, String nome_campionato, String nome_girone) {
        this.nome_squadra1 = nome_squadra1;
        this.nome_squadra2 = nome_squadra2;
        this.nome_palestra = nome_palestra;
        this.indirizzo = indirizzo;
        this.data_ora = data_ora;
        this.nome_campionato = nome_campionato;
        this.nome_girone = nome_girone;
    }

    public String getNome_squadra1() {
        return nome_squadra1;
    }

    public String getNome_squadra2() {
        return nome_squadra2;
    }

    public String getNome_palestra() {
        return nome_palestra;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getData_ora() {
        return data_ora;
    }

    public String getNome_campionato() {
        return nome_campionato;
    }

    public String getNome_girone() {
        return nome_girone;
    }
}
