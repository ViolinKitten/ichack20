package vocabulary;

import java.util.ArrayList;

public class vocabulary {

    enum Levels {
        LEVEL1,
        LEVEL2,
        LEVEL3,
        LEVEL4,
        LEVEL5;
    }

    private static final int size = Levels.values().length;

    Levels[] array = Levels.class.getEnumConstants();
    
    public ArrayList<ArrayList<String>> getVocabulary() {
        
        ArrayList<ArrayList<String>> vocabulary = new ArrayList<ArrayList<String>>();
            vocabulary.add(Level1.values()[0].toList());
            vocabulary.add(Level2.values()[0].toList());
            vocabulary.add(Level3.values()[0].toList());
            vocabulary.add(Level4.values()[0].toList());
            vocabulary.add(Level5.values()[0].toList());

        return vocabulary;
    }

    enum Level1 {
        FAMILY,
        MOTHER,
        FATHER,
        SISTER,
        BROTHER;

    private static final int size = Level1.values().length;

    Level1[] array = Level1.class.getEnumConstants();

    private ArrayList<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(array[i].name());
        }

        return list;
    }

    }

    enum Level2 {
        COLOUR,
        RED,
        GREEN,
        BLUE,
        YELLOW;
    
    private static final int size = Level2.values().length;

    Level2[] array = Level2.class.getEnumConstants();

    private ArrayList<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(array[i].name());
        }

        return list;
    }

        
    }

    enum Level3 {
        CAT,
        DOG,
        BIRD,
        FISH,
        MOUSE;

    private static final int size = Level3.values().length;

    Level3[] array = Level3.class.getEnumConstants();

    private ArrayList<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(array[i].name());
        }

        return list;
    }

    }
    enum Level4 {
        CHAIR,
        TABLE,
        SOFA,
        BED,
        LAMP;

    private static final int size = Level4.values().length;

    Level4[] array = Level4.class.getEnumConstants();

    private ArrayList<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(array[i].name());
        }

        return list;
    }
        
    }

    enum Level5 {
        APPLE,
        PEAR,
        BANANA,
        CHERRY,
        ORANGE;

    private static final int size = Level5.values().length;

    Level5[] array = Level5.class.getEnumConstants();

    private ArrayList<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(array[i].name());
        }

        return list;
    }
    }

}