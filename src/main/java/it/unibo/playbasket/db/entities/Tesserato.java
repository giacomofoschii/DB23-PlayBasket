package it.unibo.playbasket.db.entities;

public class Tesserato {

    private String nome;
    private String cognome;
    private String CF;
    private String tesseraFip;
    private int eta;
    private boolean preparatorefisico;
    private boolean medico;
    private boolean accompagnatore;
    private boolean allenatore;
    private boolean aiutoallenatore;
    private boolean massaggiatore;
    private boolean addettoarbitri;
    private boolean scorer;
    private int annopatentino;
    private String specializzazione;

    public Tesserato(String nome, String cognome, String CF, String tesseraFip, int eta, boolean preparatorefisico, boolean medico,
                     boolean accompagnatore, boolean allenatore, boolean aiutoallenatore, boolean massaggiatore,
                     boolean addettoarbitri, boolean scorer) {
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
        this.tesseraFip = tesseraFip;
        this.eta = eta;
        this.preparatorefisico = preparatorefisico;
        this.medico = medico;
        this.accompagnatore = accompagnatore;
        this.allenatore = allenatore;
        this.aiutoallenatore = aiutoallenatore;
        this.massaggiatore = massaggiatore;
        this.addettoarbitri = addettoarbitri;
        this.scorer = scorer;
        this.annopatentino = 0;
        this.specializzazione = "";
    }

    public Tesserato(String nome, String cognome, String CF, String tesseraFip, int eta, boolean preparatorefisico, boolean medico,
                     boolean accompagnatore, boolean allenatore, boolean aiutoallenatore, boolean massaggiatore,
                     boolean addettoarbitri, boolean scorer, int annopatentino, String specializzazione) {
        super();
        this.annopatentino = annopatentino;
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

    public boolean isPreparatorefisico() {
        return preparatorefisico;
    }

    public boolean isMedico() {
        return medico;
    }

    public boolean isAccompagnatore() {
        return accompagnatore;
    }

    public boolean isAllenatore() {
        return allenatore;
    }

    public boolean isAiutoallenatore() {
        return aiutoallenatore;
    }

    public boolean isMassaggiatore() {
        return massaggiatore;
    }

    public boolean isAddettoarbitri() {
        return addettoarbitri;
    }

    public boolean isScorer() {
        return scorer;
    }

    public int getAnnopatentino() {
        return annopatentino;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

}
