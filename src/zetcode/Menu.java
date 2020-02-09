package zetcode;

//Second JFrame
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import vocabulary.FrenchVocabulary;
import vocabulary.Learning;
import vocabulary.Vocabulary;
import vocabulary.VocabularyList;
import zetcode.Sokoban;

public class Menu implements ActionListener
{


  // elsewhere

  JFrame f1=new JFrame("Menu");


  JLabel l1,l2, l3;
  JTextField t1,t2, t3;
  JButton b1;
  String level1;


  Menu(String level1) throws IOException {
    this.level1 = level1;
    l1=new JLabel("Level 0");

    BufferedImage myImage = ImageIO.read(new File("src/resources/startscreen.png"));




    b1=new JButton("Start");

    f1.setSize(1200,620);
    f1.setVisible(true);
    f1.setLayout(null);
    f1.setContentPane(l1);

    f1.setContentPane(new ImagePanel(myImage));

    f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    f1.add(l1);


    f1.getContentPane().add(b1);

    l1.setBounds(0,30,100,30);


    b1.setBounds(0,120,0,0);

  //  b1.addActionListener(this);
    b1.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
          f1.dispose();
          int level = 0;
          Vocabulary englishVocab = new Vocabulary();
          ArrayList<ArrayList<String>> vocabularyE = englishVocab.getVocabulary();
          ArrayList<String> listE = vocabularyE.get(level);

          FrenchVocabulary frenchVocab = new FrenchVocabulary();
          ArrayList<ArrayList<String>> vocabularyF = frenchVocab.getVocabulary();
          ArrayList<String> listF = vocabularyF.get(level);

          Learning frame= new Learning(listE, new VocabularyList(listE, listF), level1);
           frame.initUI();

          frame.setVisible(true);
        }
      }
    });
  }

  public void actionPerformed(ActionEvent e)
  {
    f1.dispose();
   // Learning game = new Learning();




  }
}