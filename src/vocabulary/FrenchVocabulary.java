package vocabulary;

import java.util.ArrayList;

public class FrenchVocabulary {

    public FrenchVocabulary() {}

    enum FrenchLevels {
        LEVEL1FRENCH,
        LEVEL2FRENCH,
        LEVEL3FRENCH,
        LEVEL4FRENCH,
        LEVEL5FRENCH;

    }


    private static final int size = FrenchLevels.values().length;

    FrenchLevels[] array = FrenchLevels.class.getEnumConstants();
    
    public ArrayList<ArrayList<String>> getVocabulary() {
        
        ArrayList<ArrayList<String>> vocabulary = new ArrayList<ArrayList<String>>();
        vocabulary.add(Level1French.values()[0].toList());
        vocabulary.add(Level2French.values()[0].toList());
        vocabulary.add(Level3French.values()[0].toList());
        vocabulary.add(Level4French.values()[0].toList());
        vocabulary.add(Level5French.values()[0].toList());

       return vocabulary;
   }

    enum Level1French {
        FAMILY("FAMILLE"),
        MOTHER("MÈRE"),
        FATHER("PÈRE"),
        SISTER("SOEUR"),
        BROTHER("FRÈRE");

    public final String name;       

    private Level1French(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }

    private static final int size = Level1French.values().length;

    Level1French[] array = Level1French.class.getEnumConstants();

    private ArrayList<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(array[i].name());
        }

        return list;
    }
    }

    enum Level2French {
        COLOUR("COULEUR"),
        RED("ROUGE"),
        GREEN("VERT"),
        BLUE("BLEU"),
        YELLOW("JAUNE");
    
    public final String name;       

    private Level2French(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }

     private static final int size = Level2French.values().length;

    Level2French[] array = Level2French.class.getEnumConstants();

    private ArrayList<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(array[i].name());
        }

        return list;
    }

    }

    enum Level3French {
        CAT("CHAT"),
        DOG("CHIEN"),
        BIRD("OISEAU"),
        FISH("POISSON"),
        MOUSE("SOURIS");

    public final String name;       

    private Level3French(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }

    private static final int size = Level3French.values().length;

    Level3French[] array = Level3French.class.getEnumConstants();

    private ArrayList<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(array[i].name());
        }

        return list;
    }

    }
    enum Level4French {
        CHAIR("CHAISE"),
        TABLE("TABLE"),
        SOFA("CANAPÉ"),
        BED("LIT"),
        LAMP("LAMPE");

    public final String name;       

    private Level4French(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }
     private static final int size = Level4French.values().length;

    Level4French[] array = Level4French.class.getEnumConstants();

    private ArrayList<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(array[i].name());
        }

        return list;
    }

    }

    enum Level5French {
        APPLE("POMME"),
        PEAR("POIRE"),
        BANANA("BANANE"),
        CHERRY("CERISE"),
        ORANGE("ORANGE");
    
    public final String name;       

    private Level5French(String s) {
        name = s;
    }

    public String toString() {
       return this.name;
    }

     private static final int size = Level5French.values().length;

    Level5French[] array = Level5French.class.getEnumConstants();

    private ArrayList<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(array[i].name());
        }

        return list;
    }

    }

}