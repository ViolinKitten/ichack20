package Challenges.wordsearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

class StringLengthComparator implements Comparator<String> {

  @Override
  public int compare(String o1, String o2) {
    if (o1.length() != o2.length()) {
      return o1.length() - o2.length();
    }
    return o1.compareTo(o2);
  }
}

public class Board extends JPanel {

  private int rows;
  private int columns;
  private Cell[][] grid;
  private Point mousePress;
  private Point mouseRelease;

  public Board(int rows, int columns, ArrayList<String> words) {
    this.rows = rows;
    this.columns = columns;
    this.grid = new Cell[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        grid[i][j] = new Cell(i, j);
      }
    }
    this.setBackground(Color.decode("#CCE5FF"));
    generateGrid(words);
  }

  private void generateGrid(ArrayList<String> words) {
    words.sort(new StringLengthComparator());

    for (String s : words) {
      insertWord(s, 0);
    }

    Random random = new Random();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    //    String alphabet = "啊吧陈的饿富关好景看来哦朴没女日团我行行在娜你不美女让他";
    char letter;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (getCellAt(i, j).getLetter() == ' ') {
          letter = alphabet.charAt(random.nextInt(alphabet.length()));
          getCellAt(i, j).setLetter(letter);
        }
      }
    }
  }

  private Cell getCellAt(int i, int j) {
    return grid[i][j];
  }

  private void insertWord(String s, int n) {
    if (n < 400) {
      Random rand = new Random();

      int row = 0;
      int column = 0;
      int direction = rand.nextInt(4);

      switch (direction) {
        // horizontal
        case 0:
          row = rand.nextInt(rows);
          column = rand.nextInt(columns - s.length());
          if (checkValidLocation(new Point(column, row), new Point(column + s.length(), row), s)) {
            for (int i = 0; i < s.length(); i++) {
              getCellAt(row, column + i).setLetter(s.charAt(i));
            }
          } else {
            insertWord(s, ++n);
          }
          break;
        // vertical
        case 1:
          row = rand.nextInt(rows - s.length());
          column = rand.nextInt(columns);
          if (checkValidLocation(new Point(column, row), new Point(column, row + s.length()), s)) {
            for (int i = 0; i < s.length(); i++) {
              getCellAt(row + i, column).setLetter(s.charAt(i));
            }
          } else {
            insertWord(s, ++n);
          }
          break;
        // / diagonal
        case 2:
          row = rand.nextInt(rows - s.length()) + s.length();
          column = rand.nextInt(columns - s.length());
          if (checkValidLocation(
                  new Point(column, row), new Point(column + s.length(), row - s.length()), s)) {
            for (int i = 0; i < s.length(); i++) {
              getCellAt(row - i, column + i).setLetter(s.charAt(i));
            }
          } else {
            insertWord(s, ++n);
          }
          break;
        // \ diagonal
        case 3:
          row = rand.nextInt(rows - s.length());
          column = rand.nextInt(columns - s.length());
          if (checkValidLocation(
                  new Point(column, row), new Point(column + s.length(), row + s.length()), s)) {
            for (int i = 0; i < s.length(); i++) {
              getCellAt(row + i, column + i).setLetter(s.charAt(i));
            }
          } else {
            insertWord(s, ++n);
          }
          break;
        default:
          break;
      }
    } else {
      WordSearch.currentGame.getWordList().removeWord(s);
    }
  }

  private boolean checkValidLocation(Point start, Point end, String s) {
    // vertical word
    if (start.x == end.x) {
      for (int i = start.y; i < end.y; i++) {
        if (getCellAt(i, start.x).getLetter() != ' '
                && getCellAt(i, start.x).getLetter() != s.charAt(i - start.y)) {
          return false;
        }
      }
    }
    // horizontal word
    else if (start.y == end.y) {
      for (int i = start.x; i < end.x; i++) {
        if (getCellAt(start.y, i).getLetter() != ' '
                && getCellAt(start.y, i).getLetter() != s.charAt(i - start.x)) {
          return false;
        }
      }
    }
    // / diagonal word
    else if (start.x + start.y == end.x + end.y) {
      for (int i = 0; i < (end.x - start.x); ++i) {
        if (getCellAt(start.y - i, start.x + i).getLetter() != ' '
                && getCellAt(start.y - i, start.x + i).getLetter() != s.charAt(i)) {
          return false;
        }
      }
    }
    // \ diagonal
    else if (end.x - start.x == end.y - start.y) {
      for (int i = 0; i < (end.x - start.x); ++i) {
        if (getCellAt(start.y + i, start.x + i).getLetter() != ' '
                && getCellAt(start.y + i, start.x + i).getLetter() != s.charAt(i)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int height = this.getHeight() / rows;
    int width = this.getWidth() / columns;
    if (width <= height) Cell.setWidth(width);
    else Cell.setWidth(height);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        grid[i][j].draw(g);
      }
    }
  }

  public void listen() {
    this.addMouseListener(
            new MouseListener() {
              @Override
              public void mouseClicked(MouseEvent arg0) {
              }

              @Override
              public void mouseEntered(MouseEvent arg0) {
              }

              @Override
              public void mouseExited(MouseEvent arg0) {
              }

              @Override
              public void mousePressed(MouseEvent arg0) {
                int x = arg0.getX() / Cell.getWidth();
                int y = arg0.getY() / Cell.getWidth();
                mousePress = new Point(x, y);
              }

              @Override
              public void mouseReleased(MouseEvent arg0) {
                int x = arg0.getX() / Cell.getWidth();
                int y = arg0.getY() / Cell.getWidth();
                mouseRelease = new Point(x, y);
                WordSearch.currentGame.runWord();
              }
            });
  }

  public String getWordAt(Point start, Point end) {
    StringBuilder word = new StringBuilder();
    // vertical word downwards
    if (start.x == end.x && start.y < end.y) {
      for (int i = start.y; i <= end.y; ++i) {
        word.append(grid[i][start.x].getLetter());
      }
    }
    // vertical word upwards
    else if (start.x == end.x && start.y > end.y) {
      for (int i = start.y; i >= end.y; --i) {
        word.append(grid[i][start.x].getLetter());
      }
    }
    // horizontal word left->right
    else if (start.y == end.y && start.x < end.x) {
      for (int i = start.x; i <= end.x; ++i) {
        word.append(grid[start.y][i].getLetter());
      }
    }
    // horizontal word right->left
    else if (start.y == end.y && start.x > end.x) {
      for (int i = start.x; i >= end.x; --i) {
        word.append(grid[start.y][i].getLetter());
      }
    }
    // / diagonal word upper right to lower left
    else if (start.x + start.y == end.x + end.y && start.x > end.x) {
      for (int i = 0; i <= (start.x - end.x); ++i) {
        word.append(grid[start.y + i][start.x - i].getLetter());
      }
    }
    // / diagonal word lower left to upper right
    else if (start.x + start.y == end.x + end.y && start.x < end.x) {
      for (int i = 0; i <= (end.x - start.x); ++i) {
        word.append(grid[start.y - i][start.x + i].getLetter());
      }
    }
    // \ diagonal upper left to lower right
    else if (end.x - start.x == end.y - start.y && start.x < end.x) {
      for (int i = 0; i <= (end.x - start.x); ++i) {
        word.append(grid[start.y + i][start.x + i].getLetter());
      }
    }
    // \ diagonal lower right to upper left
    else if (end.x - start.x == end.y - start.y && start.x > end.x) {
      for (int i = 0; i <= (start.x - end.x); ++i) {
        word.append(grid[start.y - i][start.x - i].getLetter());
      }
    }
    return word.toString();
  }

  public Point getMousePress() {
    return mousePress;
  }

  public Point getMouseRelease() {
    return mouseRelease;
  }

  public void select(int i, int j) {
    grid[i][j].select();
  }

  {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    final JPanel panel1 = new JPanel();
    panel1.setLayout(new BorderLayout(0, 0));
    panel1.setBackground(new Color(-3348993));
    panel1.setForeground(new Color(-3348993));
  }
}
