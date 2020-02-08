import java.util.HashMap;

public class VocabularyList(enum words, enum translation) {


    private HashMap<String, String> wordMap = new HashMap<String, String>();

    for (int i = 0, i < words.values().length, i++) {
        wordMap.put(words.values()[i].name, translation.values()[i].name)
    }

    public static String getTranslation(String word){
        return wordMap.get(word)
    } 

}