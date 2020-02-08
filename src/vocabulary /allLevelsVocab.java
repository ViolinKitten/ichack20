public class allLevelVocab(enum sourceLanguage, enum targetLanguage) {
    
    private HashMap<String, String> vocabMaps = new HashMap<String, HashMap<String, String>()>();

    for (int i = 0, i < sourceLanguage.values().length, i++) {
        String key = "Level" + i;
        wordMap.put(key, new vocabularyList(sourceLanguage.values()[i].name, targetLanguage.values()[i].name))
    }
}