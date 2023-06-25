package it.unibo.playbasket.db.views;

public class StipendioArbitro {

    private String nome;
    private String cognome;
    private int grado;
    private String sezione;
    private int partite_dirette;
    private int guadagno;

    public StipendioArbitro(String nome, String cognome, int grado, String sezione, int partite_dirette, int guadagno) {
        this.nome = nome;
        this.cognome = cognome;
        this.grado = grado;
        this.sezione = sezione;
        this.partite_dirette = partite_dirette;
        this.guadagno = guadagno;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getGrado() {
        return grado;
    }

    public String getSezione() {
        return sezione;
    }

    public int getPartite_dirette() {
        return partite_dirette;
    }

    public int getGuadagno() {
        return guadagno;
    }
}
