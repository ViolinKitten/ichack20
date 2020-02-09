package wordsearch;

import java.awt.*;

public class Cell {

  private int row;
  private int column;
  private char letter;
  private boolean selected;
  private boolean correct;
  private static int width;

  public Cell(int row, int column) {
    this.row = row;
    this.column = column;
    this.letter = ' ';
  }

  public Cell(int row, int column, char letter) {
    this.row = row;
    this.column = column;
    this.letter = letter;
  }

  public char getLetter() {
    return letter;
  }

  public void setLetter(char letter) {
    this.letter = letter;
  }

  public void select() {
    this.selected = true;
  }

  public void correct() {
    this.correct = true;
  }

  public static int getWidth() {
    return width;
  }

  public static void setWidth(int width) {
    Cell.width = width;
  }

  public void draw(Graphics g) {
    if (correct) {
      g.setColor(Color.GREEN);
      g.fillRect(column * width, row * width, width, width);
      g.setColor(Color.black);
      g.drawRect(column * width, row * width, width, width);
    } else if (selected) {
      g.setColor(Color.YELLOW);
      g.fillRect(column * width, row * width, width, width);
      g.setColor(Color.black);
      g.drawRect(column * width, row * width, width, width);
    } else {
      g.setColor(Color.decode("#CCE5FF"));
      g.fillRect(column * width, row * width, width, width);
      g.setColor(Color.black);
      g.drawRect(column * width, row * width, width, width);
    }

    Font font = new Font("Helvetica", Font.PLAIN, width / 2);
    g.setFont(font);
    g.setColor(Color.black);
    g.drawString(
        Character.toString(letter).toUpperCase(),
        (int) (column * width + (.33 * width)),
        (int) (width * row + (.75 * width)));
  }

  @Override
  public String toString() {
    return "Cell [row=" + row + ", column=" + column + ", selected=" + selected + "]";
  }
}
