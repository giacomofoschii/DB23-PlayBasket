package it.unibo.playbasket.db.entities;

public class Campionato {

    private String idCampionato;
    private String nome;
    private int anno;
    private String regione;
    private String codiceVincitori;

    public Campionato(String idCampionato, String nome, int anno) {
        this.idCampionato = idCampionato;
        this.nome = nome;
        this.anno = anno;
        this.regione = "";
        this.codiceVincitori = "";
    }

    public Campionato(String idCampionato, String nome, int anno, String regione) {
        super();
        this.regione = regione;
        this.codiceVincitori = "";
    }

    public Campionato(String idCampionato, String nome, int anno, String regione, String codiceVincitori) {
        super();
        this.codiceVincitori = "";
    }

    public String getIdCampionato() {
        return idCampionato;
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

    public String getCodiceVincitori() {
        return codiceVincitori;
    }
}
