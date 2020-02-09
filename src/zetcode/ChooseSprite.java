package zetcode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import vocabulary.FrenchVocabulary;
import vocabulary.Learning;
import vocabulary.Vocabulary;
import vocabulary.VocabularyList;

public class ChooseSprite implements ActionListener
{


  // elsewhere

  JFrame f1=new JFrame("Choose Sprite");
  String sprite = "";


  JLabel l1,l2, l3;
  JTextField t1,t2, t3;
  JButton b1, b2;


  public ChooseSprite() throws IOException {


    BufferedImage myImage = ImageIO.read(new File("src/resources/pick_characters.png"));




    b1=new JButton("Start");
    b2=new JButton("End");

    f1.setSize(1200,601);
    f1.setVisible(true);
    f1.setLayout(null);

    f1.setContentPane(new ImagePanel(myImage));

    f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);



    f1.getContentPane().add(b1);




    b1.setBounds(0,120,0,0);
    b2.setBounds(30,120,0,0);

    //  b1.addActionListener(this);
    b1.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_1) {
          f1.dispose();
          Sokoban game = new Sokoban("perso");
          game.setResizable(false);

          game.setVisible(true);
        } else if (e.getKeyCode() == KeyEvent.VK_2) {
          f1.dispose();
          Sokoban game = new Sokoban("alpos");
          game.setResizable(false);

          game.setVisible(true);
        }
      }
    });
    b2.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_2) {
          f1.dispose();
          Sokoban game = new Sokoban("alpos");
          game.setResizable(false);

          game.setVisible(true);
        }
      }
    });
  }

  public void actionPerformed(ActionEvent e)
  {
    f1.dispose();


    Sokoban game = new Sokoban(sprite);
    game.setResizable(false);
    game.setVisible(true);





  }
}
