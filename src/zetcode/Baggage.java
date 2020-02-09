package zetcode;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Baggage extends Actor {

    public Baggage(int x, int y) {
        super(x, y);

        initBaggage();
    }

    private void initBaggage() {

        ImageIcon iicon = new ImageIcon("src/resources/key.png");
        Image image = iicon.getImage().getScaledInstance(50,50,50);
        setImage(image);
    }

    public void move(int x, int y) {

        int dx = x() + x;
        int dy = y() + y;

        setX(dx);
        setY(dy);
    }
}
