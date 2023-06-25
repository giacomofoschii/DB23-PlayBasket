package it.unibo.playbasket.db.views;

public class Societa {

    private String nomeSocieta;
    private String codiceMeccanografico;
    private int titoli;
    private String sponsor;
    private int telefono;
    private String email;
    private String indirizzo;
    private String nomeProprietario;

    public Societa(String nomeSocieta, String codiceMeccanografico, int titoli, String sponsor, int telefono, String email,
                    String indirizzo, String nomeProprietario) {
        this.nomeSocieta = nomeSocieta;
        this.codiceMeccanografico = codiceMeccanografico;
        this.sponsor = sponsor;
        this.telefono = telefono;
        this.email = email;
        this.indirizzo = indirizzo;
        this.nomeProprietario = nomeProprietario;
        this.titoli = titoli;
        }

    public String getNomeSocieta() {
        return nomeSocieta;
    }

    public String getCodiceMeccanografico() {
        return codiceMeccanografico;
    }

    public int getTitoli() {
        return titoli;
    }

    public String getSponsor() {
        return sponsor;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }
}
