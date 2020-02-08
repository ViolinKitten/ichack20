import java.util.HashMap;
import java.util.ArrayList;

public class allLevelsVocab {

    ArrayList<ArrayList<String>> sourceLanguage;
    ArrayList<ArrayList<String>> targetLanguage;
    private HashMap<String, vocabularyList> vocabMaps = new HashMap<>();

    public allLevelsVocab(ArrayList<ArrayList<String>> sourceLanguage, ArrayList<ArrayList<String>> targetLanguage) {
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;

        for (int i = 0; i < sourceLanguage.size(); i++) {
        String key = "Level" + i;
        vocabMaps.put(key, new vocabularyList(sourceLanguage.get(i), targetLanguage.get(i)));
    }
    }

   
}