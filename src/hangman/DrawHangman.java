package hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DrawHangman extends JPanel {

  private int livesCount;

  public DrawHangman() {
    livesCount = 11;
  }

  @Override
  public void paintComponent(Graphics graphics) {
    livesCount --;
    Graphics2D graphics2D = (Graphics2D) graphics;
    switch (livesCount) {
      case 1:
        graphics2D.drawLine(271, 70, 279, 70);
      case 2:
        graphics2D.drawLine(275, 95, 280, 110);
      case 3:
        graphics2D.drawLine(275, 95, 270, 110);
      case 4:
        graphics2D.drawLine(275, 65, 275, 95);
      case 5:
        graphics2D.draw(new Ellipse2D.Double(268,50, 15, 15));
      case 6:
        graphics2D.drawLine(275, 50, 275, 40);
      case 7:
        graphics2D.drawLine(275, 40, 245, 40);
      case 8:
        graphics2D.drawLine(245, 40, 245, 165);
      default:
        graphics2D.drawLine(200, 115, 330, 115);
    }
  }
}
