package zetcode;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Player extends Actor {

    public Player(int x, int y, String sprite) {
        super(x, y);

        initPlayer(sprite);
    }

    private void initPlayer(String sprite) {
        ImageIcon iicon = new ImageIcon("src/resources/" + sprite + ".png");

        Image image = iicon.getImage().getScaledInstance(45,45,45);
        setImage(image);
    }

    public void initPlayer(int status, String sprite) {
        ImageIcon iicon;
        Image image;
        switch(status) {
            case 1:
                iicon = new ImageIcon("src/resources/" + sprite + ".png");
                image = iicon.getImage().getScaledInstance(45,45,45);
                break;
            case 2:
                iicon = new ImageIcon("src/resources/" + sprite + "_droite.png");
                image = iicon.getImage().getScaledInstance(40,40,40);
                break;
            case 3:
                iicon = new ImageIcon("src/resources/" + sprite + "_gauche.png");
                image = iicon.getImage().getScaledInstance(40,40,40);
                break;
            default:
                iicon = new ImageIcon("src/resources/" + sprite + ".png");
                image = iicon.getImage().getScaledInstance(45,45,45);
                break;
        }


        setImage(image);
    }


    public void move(int x, int y) {

        int dx = x() + x;
        int dy = y() + y;

        setX(dx);
        setY(dy);
    }
}
