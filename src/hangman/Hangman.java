package hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hangman extends JPanel {

  private String englishWord;
  private String frenchWord;

  private static String firstRow[] = {"É", "È"};
  private static String secondRow[] = {"Q","W","E","R","T","Y","U","I","O","P"};
  private static String thirdRow[] = {"A","S","D","F","G","H","J","K","L"};
  private static String fourthRow[] = {"Z","X","C","V","B","N","M"};

  private JButton first[];
  private JButton second[];
  private JButton third[];
  private JButton fourth[];

  private JTextField[] textboxes;
  private DrawHangman hangman;

  private int counter;


  public Hangman(String englishWord, String frenchWord) {
    counter = 0;
    this.englishWord = englishWord;
    this.frenchWord = frenchWord;
    hangman = new DrawHangman();
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    // Set the instructions
    add(new DrawText(englishWord));

    Panel panelHangman = new Panel(new FlowLayout());

    // Set the hangman tree
    panelHangman.add(hangman);
    add(panelHangman);

    // Set the text boxes
    int length = frenchWord.length();
    textboxes = new JTextField[length];

    Panel panelTextBoxes = new Panel(new GridLayout(1, length));
    JPanel panelOne = new JPanel(new GridLayout(1, length));
    for (int i = 0; i < length; i++) {
      JTextField textField = new JTextField(1);
      textboxes[i] = textField;
      panelOne.add(this.textboxes[i]);
    }
    panelTextBoxes.add(panelOne);
    add(panelTextBoxes);

    CheckCharAction action = new CheckCharAction();

    // Set the keyboard
    Panel panelKeyboard = new Panel(new GridLayout(4, secondRow.length));
    JPanel panel = new JPanel(new GridLayout(1, firstRow.length));
    first = new JButton[firstRow.length];
    for (int i = 0; i < firstRow.length; i++) {
      JButton button = new JButton(firstRow[i]);
      button.addActionListener(action);
      button.setBackground(Color.CYAN);
      button.setPreferredSize(new Dimension(50, 30));
      first[i] = button;
      panel.add(this.first[i]);
    }
    panelKeyboard.add(panel);

    second = new JButton[secondRow.length];
    panel = new JPanel(new GridLayout(1, secondRow.length));
    for (int i = 0; i < second.length; i++) {
      JButton button = new JButton(secondRow[i]);
      button.addActionListener(action);
      button.setBackground(Color.CYAN);
      button.setPreferredSize(new Dimension(50, 30));
      second[i] = button;
      panel.add(this.second[i]);
    }
    panelKeyboard.add(panel);

    third = new JButton[thirdRow.length];
    panel = new JPanel(new GridLayout(1, thirdRow.length));
    for (int i = 0; i < thirdRow.length; i++) {
      JButton button = new JButton(thirdRow[i]);
      button.addActionListener(action);
      button.setBackground(Color.CYAN);
      button.setPreferredSize(new Dimension(50, 30));
      third[i] = button;
      panel.add(this.third[i]);
    }
    panelKeyboard.add(panel);

    fourth = new JButton[fourthRow.length];
    panel = new JPanel(new GridLayout(1, fourthRow.length));
    for (int i = 0; i < fourthRow.length; i++) {
      JButton button = new JButton(fourthRow[i]);
      button.addActionListener(action);
      button.setBackground(Color.CYAN);
      button.setPreferredSize(new Dimension(50, 30));
      fourth[i] = button;
      panel.add(this.fourth[i]);
    }

    panelKeyboard.add(panel);
    add(panelKeyboard);
  }

  public void paintIncorrect(Graphics graphics) {
    hangman.paintComponent(graphics);
  }

  private class CheckCharAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

      if (counter == frenchWord.length()) {
        // Congratulations file and exit
      } else {
        JButton button = (JButton) e.getSource();
        int index = frenchWord.indexOf(button.getText().charAt(0));

        if (index != -1) {
          for (int i = index; i < frenchWord.length(); i++) {
            if (frenchWord.charAt(i) == frenchWord.charAt(index)) {
              textboxes[i].setText(frenchWord.charAt(i) + "");
              if (++counter == frenchWord.length()) {
                // Exit
              }
            }
          }
        } else {
          paintIncorrect(getGraphics());
        }
      }
    }
  }
}
