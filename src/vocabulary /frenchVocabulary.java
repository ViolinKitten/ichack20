public Class FrenchVocabulary {

enum Level1French {
        FAMILY("FAMILLE"),
        MOTHER("MÈRE"),
        FATHER("PÈRE"),
        SISTER("SOEUR"),
        BROTHER("FRÈRE");

    public final String name;       

    private Modes(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }
    }

    enum Level2French {
        COLOUR("COULEUR"),
        RED("ROUGE"),
        GREEN("VERT"),
        BLUE("BLEU"),
        YELLOW("JAUNE");
    
    public final String name;       

    private Modes(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }

    }

    enum Level3French {
        CAT("CHAT"),
        DOG("CHIEN"),
        BIRD("OISEAU"),
        FISH("POISSON"),
        MOUSE("SOURIS");

    public final String name;       

    private Modes(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }

    }
    enum Level4French {
        CHAIR("CHAISE"),
        TABLE("TABLE"),
        SOFA("CANAPÉ"),
        BED("LIT"),
        LAMP("LAMPE");

    public final String name;       

    private Modes(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }

    }

    enum Level5French {
        APPLE("POMME"),
        PEAR("POIRE"),
        BANANA("BANANE"),
        CHERRY("CERISE"),
        ORANGE("ORANGE");
    
    public final String name;       

    private Modes(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }
    }

}