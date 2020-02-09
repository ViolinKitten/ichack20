package Challenges.hangman;

import Challenges.Challenge;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class MainHangman implements Challenge {

  private JFrame frame;
  private String english;
  private String french;

  public MainHangman(ArrayList<String> englishWords, Map<String, String> map) {
    int randomNum = new Random().nextInt(5);
    this.english = englishWords.get(randomNum);
    this.french = map.get(english);
  }

  @Override
  public boolean open() {
    frame = new JFrame();

    Hangman hangman = new Hangman(english, french);
    frame.add(hangman);
    frame.setResizable(false);
    frame.setSize(800,800);
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame.setVisible(true);
    return hangman.getSucess();
  }
}
