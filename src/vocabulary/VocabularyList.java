import java.util.HashMap;
import java.util.ArrayList;

public class VocabularyList {

    private HashMap<String, String> wordMap = new HashMap<String, String>();

    public VocabularyList(ArrayList<String> words, ArrayList<String> translation){
        for (int i = 0; i < words.size(); i++) {
        wordMap.put(words.get(i), translation.get(i));
    }

    }   

    public String getLevelVocab(String level){
        return wordMap.get(level);
    } 

}