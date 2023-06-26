package it.unibo.playbasket.db.views;

public class Performance {
    
    private String nome;
    private String cognome;
    private String nomeSquadra;
    private int rimbalzi;
    private int assist;
    private int falliFatti;
    private int falliSubiti;
    private int minuti;
    private int tiri2;
    private int tiri3;
    private int tiriLiberi;
    private int tiri2_segnati;
    private int tiri3_segnati;
    private int tiriLiberi_segnati;
    private int palle_rubate;
    private int palle_perse;
    private int stoppate;

    public Performance(String nome, String cognome, String nomeSquadra, int rimbalzi, int assist, int falliFatti,
            int falliSubiti, int minuti, int tiri2, int tiri3, int tiriLiberi, int tiri2_segnati, int tiri3_segnati,
            int tiriLiberi_segnati, int palle_rubate, int palle_perse, int stoppate) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeSquadra = nomeSquadra;
        this.rimbalzi = rimbalzi;
        this.assist = assist;
        this.falliFatti = falliFatti;
        this.falliSubiti = falliSubiti;
        this.minuti = minuti;
        this.tiri2 = tiri2;
        this.tiri3 = tiri3;
        this.tiriLiberi = tiriLiberi;
        this.tiri2_segnati = tiri2_segnati;
        this.tiri3_segnati = tiri3_segnati;
        this.tiriLiberi_segnati = tiriLiberi_segnati;
        this.palle_rubate = palle_rubate;
        this.palle_perse = palle_perse;
        this.stoppate = stoppate;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getNomeSquadra() {
        return this.nomeSquadra;
    }

    public int getRimbalzi() {
        return this.rimbalzi;
    }

    public int getAssist() {
        return this.assist;
    }

    public int getFalliFatti() {
        return this.falliFatti;
    }

    public int getFalliSubiti() {
        return this.falliSubiti;
    }

    public int getMinuti() {
        return this.minuti;
    }

    public int getTiri2() {
        return this.tiri2;
    }

    public int getTiri3() {
        return this.tiri3;
    }

    public int getTiriLiberi() {
        return this.tiriLiberi;
    }

    public int getTiri2_segnati() {
        return this.tiri2_segnati;
    }

    public int getTiri3_segnati() {
        return this.tiri3_segnati;
    }

    public int getTiriLiberi_segnati() {
        return this.tiriLiberi_segnati;
    }

    public int getPalle_rubate() {
        return this.palle_rubate;
    }

    public int getPalle_perse() {
        return this.palle_perse;
    }

    public int getStoppate() {
        return this.stoppate;
    }

    
}
