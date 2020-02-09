package wordsearch;

import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();
//    map.put("苹果", "apple");
//    map.put("香蕉", "banana");
    map.put("apple", "苹果");
    map.put("banana", "香蕉");
    WordSearch game = new WordSearch(map);
  }
}
