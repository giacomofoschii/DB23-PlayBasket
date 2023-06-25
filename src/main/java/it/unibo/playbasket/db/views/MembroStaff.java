package it.unibo.playbasket.db.views;

public class MembroStaff {

    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private String specializzazione;
    private int annoPatentino;

    public MembroStaff(String nome, String cognome, int eta, String ruolo, String specializzazione, int annoPatentino) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.specializzazione = specializzazione;
        this.annoPatentino = annoPatentino;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public String getRuolo() {
        return ruolo;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public int getAnnoPatentino() {
        return annoPatentino;
    }

}
