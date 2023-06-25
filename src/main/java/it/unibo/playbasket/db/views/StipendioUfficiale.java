package it.unibo.playbasket.db.views;

public class StipendioUfficiale {

    private String nome;
    private String cognome;
    private boolean cronometrista;
    private boolean refertista;
    private boolean segnapunti;
    private int partite_codirette;
    private int guadagno;

    public StipendioUfficiale(String nome, String cognome, boolean cronometrista, boolean refertista, boolean segnapunti,
            int partite_codirette, int guadagno) {
        this.nome = nome;
        this.cognome = cognome;
        this.cronometrista = cronometrista;
        this.refertista = refertista;
        this.segnapunti = segnapunti;
        this.partite_codirette = partite_codirette;
        this.guadagno = guadagno;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public boolean isCronometrista() {
        return cronometrista;
    }

    public boolean isRefertista() {
        return refertista;
    }

    public boolean isSegnapunti() {
        return segnapunti;
    }

    public int getPartite_codirette() {
        return partite_codirette;
    }

    public int getGuadagno() {
        return guadagno;
    }
}
