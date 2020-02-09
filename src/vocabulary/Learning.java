package vocabulary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

public class Learning extends JFrame implements ActionListener {

    ArrayList<String> words;
    VocabularyList translations;
    JButton listenB1 = new JButton("Listen");
    JButton listenB2 = new JButton("Listen");
    JButton listenB3 = new JButton("Listen");
    JButton listenB4 = new JButton("Listen");
    JButton listenB5 = new JButton("Listen");
    JButton playButton = new JButton("Play game!");


    public Learning(ArrayList<String> words, VocabularyList translations) {
        this.words = words;
        this.translations = translations;
    }

    private void initUI() {

        setTitle("Learning");

        setSize( 650, 650);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        for(int i = 0; i < words.size(); i++){
            String word = words.get(i);
            JLabel label1 = new JLabel(word);
            JLabel label2 = new JLabel(translations.getWord(word));
            label1.setBounds(200, 10+i*50, 100, 50);
            label2.setBounds(300, 10+i*50, 100, 50);
            add(label1);
            add(label2);
        }
        listenB1.setBounds(400, 10+0*50, 80, 50);
        add(listenB1);
        listenB1.addActionListener(this);

        listenB2.setBounds(400, 10+1*50, 80, 50);
        add(listenB2);
        listenB2.addActionListener(this);

        listenB3.setBounds(400, 10+2*50, 80, 50);
        add(listenB3);
        listenB3.addActionListener(this);

        listenB4.setBounds(400, 10+3*50, 80, 50);
        add(listenB4);
        listenB4.addActionListener(this);

        listenB5.setBounds(400, 10+4*50, 80, 50);
        add(listenB5);
        listenB5.addActionListener(this);

        playButton.setBounds(250, 400, 160, 50);
        add(playButton);
        playButton.addActionListener(this);


        JLabel label1 = new JLabel("");
        label1.setBounds(500, 500, 100, 50);
        add(label1);
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


    public static void main(String[] args){
        int level = 0;
        Vocabulary englishVocab = new Vocabulary();
        ArrayList<ArrayList<String>> vocabularyE = englishVocab.getVocabulary();
        ArrayList<String> listE = vocabularyE.get(level);

        FrenchVocabulary frenchVocab = new FrenchVocabulary();
        ArrayList<ArrayList<String>> vocabularyF = frenchVocab.getVocabulary();
        ArrayList<String> listF = vocabularyF.get(level);

        Learning frame= new Learning(listE, new VocabularyList(listE, listF));
        frame.initUI();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == listenB1) {
            playSound("src/audio/Family.wav");
        }
        if (src == listenB2) {
            playSound("src/audio/Mother.wav");
        }
        if (src == listenB3) {
            playSound("src/audio/Father.wav");
        }
        if (src == listenB4) {
            playSound("src/audio/Sister.wav");
        }
        if (src == listenB5) {
            playSound("src/audio/Brother.wav");
        }
        if (src == playButton) {
            //something
        }
    }
}
