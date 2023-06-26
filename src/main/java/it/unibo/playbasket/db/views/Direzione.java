package it.unibo.playbasket.db.views;

public class Direzione {
    
    private String nome;
    private String cognome;
    private String nomeSquadra1;
    private String nomeSquadra2;
    private String dataOra;
    private int rimborso;

    public Direzione(String nome, String cognome, String nomeSquadra1, String nomeSquadra2, String dataOra,
            int rimborso) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeSquadra1 = nomeSquadra1;
        this.nomeSquadra2 = nomeSquadra2;
        this.dataOra = dataOra;
        this.rimborso = rimborso;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNomeSquadra1() {
        return nomeSquadra1;
    }

    public String getNomeSquadra2() {
        return nomeSquadra2;
    }

    public String getDataOra() {
        return dataOra;
    }

    public int getRimborso() {
        return rimborso;
    }
    
}
