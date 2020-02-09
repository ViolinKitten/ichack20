package Challenges.hangman;

import Challenges.Challenge;

import javax.swing.*;

public class MainHangman implements Challenge {

  private JFrame frame;
  private String english;
  private String french;

  public MainHangman(String english, String french) {
    this.english = english;
    this.french = french;
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
