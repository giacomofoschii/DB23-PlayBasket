package it.unibo.playbasket.db.entities;

public class Schemi {

    private String nome;
    private String tipo;
    private String nomesquadra;
    private String idCampionato;
    private int anno;
    private char nomeGirone;

    public Schemi(String nome, String tipo, String nomesquadra, String idCampionato, int anno, char nomeGirone) {
        this.nome = nome;
        this.tipo = tipo;
        this.nomesquadra = nomesquadra;
        this.idCampionato = idCampionato;
        this.anno = anno;
        this.nomeGirone = nomeGirone;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNomesquadra() {
        return nomesquadra;
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
}
