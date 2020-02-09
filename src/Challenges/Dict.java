package Challenges;

import vocabulary.AllLevelsVocab;
import vocabulary.FrenchVocabulary;
import vocabulary.Vocabulary;
import vocabulary.VocabularyList;
import zetcode.Menu;
import zetcode.Pro;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Dict extends JFrame implements ActionListener, Challenge {
    ArrayList<String> words;
    VocabularyList translations;
    JFrame f1=new JFrame("Log In");
    JLabel l1,l2, l3;
    JTextField t1,t2, t3;
    JButton b1;
    private int level;
    String filename;
    private int songName;
    private boolean success;

    public Dict(ArrayList<String> words, VocabularyList translations, int level)
    {
        this.words = words;
        this.translations = translations;
        Random random = new Random();
        songName = random.nextInt(4);
        filename = "src/audio/level" + level + "/" + "Sound" + songName + ".wav";
        success = false;
        l1=new JLabel("Type in the English translation of the word spoken!");
      //  l2=new JLabel("Password");
      //  l3=new JLabel("Language");
        t1=new JTextField(20);
      //  t2=new JTextField(20);
        // t3=new JTextField(20);
        b1=new JButton("Listen");






        f1.setSize(400,400);
        f1.setVisible(true);
        f1.setLayout(null);

        f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f1.add(l1);

        f1.add(t1);
      //  f1.add(l2);
      //  f1.add(l3);
        // f1.add(t3);
      //  f1.add(t2);

        f1.getContentPane().add(b1);

        l1.setBounds(40,50,300,30);
        t1.setBounds(120,100,100,30);
     //   l2.setBounds(0,70,100,30);
     //   l3.setBounds(0,110,100,30);
    //    t2.setBounds(110,70,100,30);
        //  t3.setBounds(110,110,100,30);
        b1.setBounds(120,150,100,30);
        // c.addActionListener(this);

        b1.addActionListener(this);
        t1.addActionListener(this);
    }

    public boolean accomplished() {
        return success;
    }

    private void playSound(String soundName) {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
            Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        VocabularyList levelMap = new AllLevelsVocab(new Vocabulary().getVocabulary(),new FrenchVocabulary().getVocabulary()).getLevelVocab("level" + (level + 1));
        Object src = e.getSource();
        if (src == b1) {
            playSound(filename);
        } else if (src == t1) {
            String word = new Vocabulary().getVocabulary().get(level).get(songName);
            success = t1.getText().toLowerCase().equals(word.toLowerCase());
            if (success) {
                JOptionPane.showOptionDialog(new JFrame(), "Well done! You have completed this level!",
                        "Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, new Object[] {"Ok"}, JOptionPane.YES_OPTION);
            } else {
                JOptionPane.showOptionDialog(new JFrame(), "Too bad! You have not completed this level!",
                        "Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, new Object[] {"Ok"}, JOptionPane.NO_OPTION);

            }
            setVisible(true);
            dispose();

        }
    }

   /* public static void main(String[] args) {

        int level = 0;
        Vocabulary englishVocab = new Vocabulary();
        ArrayList<ArrayList<String>> vocabularyE = englishVocab.getVocabulary();
        ArrayList<String> listE = vocabularyE.get(level);

        FrenchVocabulary frenchVocab = new FrenchVocabulary();
        ArrayList<ArrayList<String>> vocabularyF = frenchVocab.getVocabulary();
        ArrayList<String> listF = vocabularyF.get(level);

        Dict dict = new Dict(listE, new VocabularyList(listE, listF),level);

    }*/

    @Override
    public boolean open() {
        int level = 0;
        Vocabulary englishVocab = new Vocabulary();
        ArrayList<ArrayList<String>> vocabularyE = englishVocab.getVocabulary();
        ArrayList<String> listE = vocabularyE.get(level);

        FrenchVocabulary frenchVocab = new FrenchVocabulary();
        ArrayList<ArrayList<String>> vocabularyF = frenchVocab.getVocabulary();
        ArrayList<String> listF = vocabularyF.get(level);

        Dict dict = new Dict(listE, new VocabularyList(listE, listF),level);
        return true;
    }
}
