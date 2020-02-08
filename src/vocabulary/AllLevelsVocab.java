package vocabulary;

import java.util.HashMap;
import java.util.ArrayList;

public class AllLevelsVocab {

    ArrayList<ArrayList<String>> sourceLanguage;
    ArrayList<ArrayList<String>> targetLanguage;
    private HashMap<String, VocabularyList> vocabMaps = new HashMap<>();

    public AllLevelsVocab(ArrayList<ArrayList<String>> sourceLanguage, ArrayList<ArrayList<String>> targetLanguage) {
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;

        for (int i = 0; i < sourceLanguage.size(); i++) {
        String key = "Level" + i;
        vocabMaps.put(key, new VocabularyList(sourceLanguage.get(i), targetLanguage.get(i)));
    }
    }

        public VocabularyList getLevelVocab(String level){
        return vocabMaps.get(level);
    } 

   
}