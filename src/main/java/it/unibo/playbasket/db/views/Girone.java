package it.unibo.playbasket.db.views;

public class Girone {

    private String nome;
    private String nomeCampionato;
    private String provincia;

    public Girone(String nome, String nomeCampionato, String provincia) {
        this.nome = nome;
        this.nomeCampionato = nomeCampionato;
        this.provincia = provincia;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeCampionato() {
        return nomeCampionato;
    }

    public String getProvincia() {
        return provincia;
    }

}
