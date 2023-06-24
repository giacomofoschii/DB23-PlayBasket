package it.unibo.playbasket.db.entities;

public class Girone {

    private String idCampionato;
    private int anno;
    private char nomeGirone;
    private String provincia;

    public Girone(String idCampionato, int anno, char nomeGirone) {
        this.idCampionato = idCampionato;
        this.anno = anno;
        this.nomeGirone = nomeGirone;
        this.provincia = "";
    }

    public Girone(String idCampionato, int anno, char nomeGirone, String provincia) {
        super();
        this.provincia = "";
    }

    public String getIdCampionato() {
        return idCampionato;
    }

    public int getAnno() {
        return anno;
    }

    public char getNomeGirone() {
        return nomeGirone;
    }

    public String getProvincia() {
        return provincia;
    }
}
