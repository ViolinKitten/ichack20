package zetcode;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Exit extends Actor {
  private Image image;

  public Exit(int x, int y) {
    super(x, y);

    initWall();
  }

  private void initWall() {

    ImageIcon iicon = new ImageIcon("src/resources/lock.png");
    image = iicon.getImage().getScaledInstance(50,50,50);
    setImage(image);
  }

}
