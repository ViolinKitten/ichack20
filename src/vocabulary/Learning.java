package vocabulary;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Learning extends JFrame {

    ArrayList<String> words;
    VocabularyList translations;

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
            JButton button = new JButton("Listen");
            label1.setBounds(200, 10+i*50, 100, 50);
            label2.setBounds(300, 10+i*50, 100, 50);
            button.setBounds(400, 10+i*50, 100, 50);
            add(label1);
            add(label2);
            add(button);
        }
        JLabel label1 = new JLabel("");
        label1.setBounds(500, 500, 100, 50);
        add(label1);


    }

    public static void main(String[] args){
        Vocabulary englishVocab = new Vocabulary();
        ArrayList<ArrayList<String>> vocabularyE = englishVocab.getVocabulary();
        ArrayList<String> listE = vocabularyE.get(0);

        FrenchVocabulary frenchVocab = new FrenchVocabulary();
        ArrayList<ArrayList<String>> vocabularyF = frenchVocab.getVocabulary();
        ArrayList<String> listF = vocabularyF.get(0);

        Learning frame= new Learning(listE, new VocabularyList(listE, listF));
        frame.initUI();
        frame.setVisible(true);
    }

}
