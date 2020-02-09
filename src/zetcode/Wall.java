package zetcode;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Wall extends Actor {

    private Image image;

    public Wall(int x, int y) {
        super(x, y);

        initWall();
    }

    private void initWall() {

        ImageIcon iicon = new ImageIcon("src/resources/wood.png");
        image = iicon.getImage().getScaledInstance(50,50,50);
        setImage(image);
    }
}
