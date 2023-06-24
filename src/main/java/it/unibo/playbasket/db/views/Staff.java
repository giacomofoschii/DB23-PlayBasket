package it.unibo.playbasket.db.views;

public class Staff {

    private String nome;
    private String cognome;
    private String CF;
    private String tesseraFip;
    private int eta;
    private boolean preparatore_fisico;
    private boolean allenatore;
    private boolean aiuto_allenatore;
    private boolean medico;
    private boolean massaggiatore;
    private boolean accompagnatore;
    private boolean scorer;
    private boolean addetto_arbitro;
    private int anno_patentino;
    private String specializzazione;

    public Staff(String nome, String cognome, String CF, String tesseraFip, int eta, boolean preparatore_fisico,
                 boolean allenatore, boolean aiuto_allenatore, boolean medico, boolean massaggiatore,
                 boolean accompagnatore, boolean scorer, boolean addetto_arbitro, int anno_patentino, String specializzazione) {
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
        this.tesseraFip = tesseraFip;
        this.eta = eta;
        this.preparatore_fisico = preparatore_fisico;
        this.allenatore = allenatore;
        this.aiuto_allenatore = aiuto_allenatore;
        this.medico = medico;
        this.massaggiatore = massaggiatore;
        this.accompagnatore = accompagnatore;
        this.scorer = scorer;
        this.addetto_arbitro = addetto_arbitro;
        this.anno_patentino = anno_patentino;
        this.specializzazione = specializzazione;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCF() {
        return CF;
    }

    public String getTesseraFip() {
        return tesseraFip;
    }

    public int getEta() {
        return eta;
    }

    public boolean isPreparatore_fisico() {
        return preparatore_fisico;
    }

    public boolean isAllenatore() {
        return allenatore;
    }

    public boolean isAiuto_allenatore() {
        return aiuto_allenatore;
    }

    public boolean isMedico() {
        return medico;
    }

    public boolean isMassaggiatore() {
        return massaggiatore;
    }

    public boolean isAccompagnatore() {
        return accompagnatore;
    }

    public boolean isScorer() {
        return scorer;
    }

    public boolean isAddetto_arbitro() {
        return addetto_arbitro;
    }

    public int getAnno_patentino() {
        return anno_patentino;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

}
