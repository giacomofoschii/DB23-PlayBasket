package it.unibo.playbasket.db.entities;

public class Proprietario {

    private String CF;
    private String nome;
    private String cognome;

    public Proprietario(String CF, String nome, String cognome) {
        this.CF = CF;
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getCF() {
        return CF;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}
