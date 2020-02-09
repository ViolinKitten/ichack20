package zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Sokoban extends JFrame {

    private final int OFFSET = 30;
    String sprite;
    String level;

    public Sokoban(String sprite, String level) {
        this.level = level;
        this.sprite = sprite;
        initUI();
    }

    private void initUI() {
        
        Board board = new Board(this, sprite, level);
        add(board);

        setTitle("Alpie");
        
        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2 * OFFSET);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

  /*  public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            
            Sokoban game = new Sokoban();
            game.setResizable(false);

            game.setVisible(true);
        });
    } */
}
