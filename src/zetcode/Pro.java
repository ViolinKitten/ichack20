package zetcode;

//First JFrame

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;

public class Pro implements ActionListener
{

  JFrame f1=new JFrame("Log In");
  JLabel l1,l2, l3;
  JTextField t1,t2, t3;
  JButton b1;
  JComboBox c;

  String level;
  Pro(String level)
  {
    this.level = level;
    String[] patternExamples = {
        "Select",
        "Spanish",
        "French",
        "Chinese"
    };
    l1=new JLabel("User Name");
    l2=new JLabel("Password");
    l3=new JLabel("Language");
    t1=new JTextField(20);
    t2=new JTextField(20);
   // t3=new JTextField(20);
    b1=new JButton("OK");
    c = new JComboBox(patternExamples);
    c.setPreferredSize(new Dimension(10, 20));






    f1.setSize(400,400);
    f1.setVisible(true);
    f1.setLayout(null);

    f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    f1.add(l1);
    f1.add(c);
    f1.add(t1);
    f1.add(l2);
    f1.add(l3);
   // f1.add(t3);
    f1.add(t2);

    f1.getContentPane().add(b1);

    l1.setBounds(0,30,100,30);
    t1.setBounds(110,30,100,30);
    l2.setBounds(0,70,100,30);
    l3.setBounds(0,110,100,30);
    t2.setBounds(110,70,100,30);
  //  t3.setBounds(110,110,100,30);
    b1.setBounds(0,150,100,30);
    c.setBounds(110, 110,100,30);
    c.setEditable(true);
   // c.addActionListener(this);

    b1.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e)
  {
    f1.dispose();
    try {
      Menu p2=new Menu(level);
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }
  public static void main(String ag[])
  {
     String level
        =  "####################\n"
        + "#    #             #\n"
        + "#    #   #  $ #    #\n"
        + "#  ###   #    #    #\n"
        + "E        ## #########\n"
        + "#####              #\n"
        + "# $           #    #\n"
        + "########  #####    #\n"
        + "# $ #     @   #    #\n"
        + "#   #  #   #########\n"
        + "#      #           #\n"
        + "####################\n";
    Pro p1=new Pro(level);
  }



}
