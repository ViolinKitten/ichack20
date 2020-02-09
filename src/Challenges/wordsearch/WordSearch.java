package Challenges.wordsearch;

import Challenges.Challenge;
import Challenges.CongratulationWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordSearch extends JFrame implements Challenge {
  public static WordSearch currentGame;
  private JPanel contentPanel;

  private Board board;
  private WordList wordList;
  private int wordsLeft;
  private Map<String, String> pairs;
  private final ArrayList<String> chinese = new ArrayList<>();
  private final ArrayList<String> english = new ArrayList<>();

  public WordSearch(HashMap<String, String> pairs) {
    this.pairs = pairs;
    for (String s : pairs.keySet()) {
      chinese.add(s);
      english.add(pairs.get(s));
    }
    $$$setupUI$$$();
    this.setBackground(Color.decode("#CCE5FF"));
    setContentPane(contentPanel);
    setTitle("Word Search Challenge");

    currentGame = this;
    setSize(900, 800);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public boolean checkFinished() {
    return wordsLeft == 0;
  }

  public WordList getWordList() {
    return wordList;
  }

  private void createUIComponents() {
    contentPanel = new JPanel();
    contentPanel.setLayout(new BorderLayout());

    JLabel titleLabel = new JLabel("Word Search Challenge");
    titleLabel.setFont(new Font("Helvetica", Font.BOLD, 40));
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    contentPanel.add(titleLabel, BorderLayout.NORTH);

    wordsLeft = english.size();
    wordList = new WordList(chinese);
    contentPanel.add(wordList, BorderLayout.EAST);
    wordList.revalidate();

    board = new Board(15, 15, english);
    contentPanel.add(board, BorderLayout.CENTER);
    board.revalidate();

    this.repaint();
  }

  private String getKey(String value) {
    String match = null;
    for (String s : pairs.keySet()) {
      if (pairs.get(s).equals(value)) {
        match = s;
      }
    }
    return match;
  }

  public void runWord() {

    Point start = board.getMousePress();
    Point end = board.getMouseRelease();

    String word;

    if (checkValidSelection(start, end)) {
      // check forwards
      word = board.getWordAt(start, end);
      String backword = new StringBuffer(word).reverse().toString();

      String match = null;

      if (checkValidWord(word)) {
        match = getKey(word);
      }
      // check backword
      else if (checkValidWord(backword)) {
        match = getKey(backword);
      }

      if (match != null && !wordList.getWordList().get(match).isSelected()) {
        this.highlightWords(start, end);
        wordList.checkBox(match);
        wordsLeft--;
      }

      if (checkFinished()) {
        CongratulationWindow window = new CongratulationWindow(this);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
      }
    }
  }

  private void highlightWords(Point start, Point end) {
    // vertical word downwards
    if (start.x == end.x && start.y < end.y) {
      for (int i = start.y; i <= end.y; ++i) {
        board.select(i, start.x);
      }
    }
    // vertical word upwards
    if (start.x == end.x && start.y > end.y) {
      for (int i = start.y; i >= end.y; --i) {
        board.select(i, start.x);
      }
    }
    // horizontal word left->right
    else if (start.y == end.y && start.x < end.x) {
      for (int i = start.x; i <= end.x; ++i) {
        board.select(start.y, i);
      }
    }
    // horizontal word right->left
    else if (start.y == end.y && start.x > end.x) {
      for (int i = start.x; i >= end.x; --i) {
        board.select(start.y, i);
      }
    }
    // / diagonal word upper right to lower left
    else if (start.x + start.y == end.x + end.y && start.x > end.x) {
      for (int i = 0; i <= (start.x - end.x); ++i) {
        board.select(start.y + i, start.x - i);
      }
    }
    // / diagonal word lower left to upper right
    else if (start.x + start.y == end.x + end.y && start.x < end.x) {
      for (int i = 0; i <= (end.x - start.x); ++i) {
        board.select(start.y - i, start.x + i);
      }
    }
    // \ diagonal upper left to lower right
    else if (end.x - start.x == end.y - start.y && start.x < end.x) {
      for (int i = 0; i <= (end.x - start.x); ++i) {
        board.select(start.y + i, start.x + i);
      }
    }
    // \ diagonal lower right to upper left
    else if (end.x - start.x == end.y - start.y && start.x > end.x) {
      for (int i = 0; i <= (start.x - end.x); ++i) {
        board.select(start.y - i, start.x - i);
      }
    }
    board.repaint();
  }

  private boolean checkValidWord(String word) {
    return getKey(word) != null;
  }

  private boolean checkValidSelection(Point start, Point end) {
    // checks rows, cols, \ diagonal, / diagonal
    boolean flag = false;
    if (start.x == end.x) {
      flag = true;
    } else if (start.y == end.y) {
      flag = true;
    } else if ((start.x - start.y) == (end.x - end.y)) {
      flag = true;
    } else if ((start.x + start.y) == (end.x + end.y)) {
      flag = true;
    }
    return flag;
  }

  public void decreaseWordsLeft() {
    this.wordsLeft--;
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    createUIComponents();
    contentPanel.setBackground(new Color(-3348993));
    contentPanel.setForeground(new Color(-3348993));
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return contentPanel;
  }

  @Override
  public boolean open() {
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    board.listen();
    return true;
  }
}
