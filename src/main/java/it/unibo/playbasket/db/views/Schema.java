package it.unibo.playbasket.db.views;

public class Schema {

    private String nomeSchema;
    private String tipoSchema;
    private String nomeSquadra;
    private String nomeCampionato;
    private int anno;

    public Schema(String nomeSchema, String tipoSchema, String nomeSquadra, String nomeCampionato, int anno) {
        this.nomeSchema = nomeSchema;
        this.tipoSchema = tipoSchema;
        this.nomeSquadra = nomeSquadra;
        this.nomeCampionato = nomeCampionato;
        this.anno = anno;
    }

    public String getNomeSchema() {
        return nomeSchema;
    }

    public String getTipoSchema() {
        return tipoSchema;
    }

    public String getNomeSquadra() {
        return nomeSquadra;
    }

    public String getNomeCampionato() {
        return nomeCampionato;
    }

    public int getAnno() {
        return anno;
    }
}
