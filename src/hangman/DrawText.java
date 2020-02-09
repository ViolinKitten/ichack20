package hangman;

import javax.swing.*;
import java.awt.*;

public class DrawText extends JPanel {

  private String word;

  public DrawText(String word) {
    this.word = word;
  }

  @Override
  public void paintComponent(Graphics graphics) {
    Graphics2D graphics2D = (Graphics2D) graphics;
    String message = "Spell " + word + " correctly in French... but chose your letters carefully"
        + " for a life is at stake!";
    graphics2D.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
    graphics2D.drawString(message, 60, 15);
  }
}