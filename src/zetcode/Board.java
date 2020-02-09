package zetcode;

import wordsearch.WordSearch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.*;

public class Board extends JPanel  implements ActionListener {

    private final int OFFSET = 30;
    private final int SPACE = 50;
    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;
    private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);
    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    private final JFrame frame;

    private ArrayList<Wall> walls;
    private ArrayList<Baggage> baggs;
    private ArrayList<Area> areas;
    private ArrayList<Exit> exits;
    private int[] scores;

    private Player labyrinth;

    private int w = 0;
    private int h = 0;
    private int score;

    private boolean isCompleted = false;


    /* LEVEL PRACTICE:
     "    ######\n"
            + "    ##   #\n"
            + "    ##$  #\n"
            + "  ####  $##\n"
            + "  ##  $ $ #\n"
            + "#### # ## #   ######\n"
            + "##   # ## #####  ..#\n"
            + "## $  $          ..#\n"
            + "###### ### #@##  ..#\n"
            + "    ##     #########\n"
            + "    ########\n";
     */

    private String level
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

    public Board(JFrame frame) {
        this.frame = frame;
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        initWorld();

    }

    public int getBoardWidth() {
        return this.w;
    }

    public int getBoardHeight() {
        return this.h;
    }

    private void initWorld() {

        walls = new ArrayList<>();
        baggs = new ArrayList<>();
        areas = new ArrayList<>();
        exits = new ArrayList<>();
        scores = new int[3];
        score = 0;
        int x = OFFSET;
        int y = OFFSET;

        Wall wall;
        Baggage b;
       // Area a;
        Exit e;

        for (int i = 0; i < level.length(); i++) {

            char item = level.charAt(i);

            switch (item) {

                case '\n':
                    y += SPACE;

                    if (this.w < x) {
                        this.w = x;
                    }

                    x = OFFSET;
                    break;

                case '#':
                    wall = new Wall(x, y);
                    walls.add(wall);
                    x += SPACE;
                    break;

                case '$':
                    b = new Baggage(x, y);
                    baggs.add(b);
                    x += SPACE;
                    break;

                case '.':
           //         a = new Area(x, y);
             //       areas.add(a);
                    x += SPACE;
                    break;

                case '@':
                    labyrinth = new Player(x, y);
                    x += SPACE;
                    break;
                case 'E':
                    e = new Exit(x, y);
                    exits.add(e);
                    break;

                case ' ':
                    x += SPACE;
                    break;

                default:
                    break;
            }

            h = y;
        }
    }


    private void buildWorld(Graphics g) {

        g.setColor(new Color(204, 229, 255));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        ArrayList<Actor> world = new ArrayList<>();

        world.addAll(walls);
       // world.addAll(areas);
        world.addAll(baggs);
        world.add(labyrinth);
        world.addAll(exits);
        drawScore((Graphics2D) g);

        for (int i = 0; i < world.size(); i++) {

            Actor item = world.get(i);

            if (item instanceof Player || item instanceof Baggage) {

                g.drawImage(item.getImage(), item.x() + 2, item.y() + 2, this);
            } else {

                g.drawImage(item.getImage(), item.x(), item.y(), this);
            }

            if (isCompleted) {
                g.setColor(new Color(0, 0, 0));
                g.drawString("Completed", 25, 20);
            }

        }
    }

    private void drawScore(Graphics2D g) {

        int i;
        String s;

        g.setFont(smallFont);
        g.setColor(new Color(0, 0, 0));
        s = "Keys: " + score + "/3";
        g.drawString(s, 10, 20);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        buildWorld(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (isCompleted) {
                return;
            }

            int key = e.getKeyCode();

            switch (key) {

                case KeyEvent.VK_LEFT:
                    labyrinth.initPlayer(3);

                    if (checkWallCollision(labyrinth,
                        LEFT_COLLISION)) {
                        return;
                    }

                    if (checkBagCollision(LEFT_COLLISION)) {
                        return;
                    }
                    if (checkExitCollision(labyrinth, LEFT_COLLISION)) {
                        return;
                    }


                    labyrinth.move(-SPACE, 0);

                    break;

                case KeyEvent.VK_RIGHT:
                    labyrinth.initPlayer(2);

                    if (checkWallCollision(labyrinth, RIGHT_COLLISION)) {
                        return;
                    }

                    if (checkBagCollision(RIGHT_COLLISION)) {
                        return;
                    }
                    if (checkExitCollision(labyrinth, RIGHT_COLLISION)) {
                        return;
                    }

                    labyrinth.move(SPACE, 0);

                    break;

                case KeyEvent.VK_UP:
                    labyrinth.initPlayer(1);

                    if (checkWallCollision(labyrinth, TOP_COLLISION)) {
                        return;
                    }

                    if (checkBagCollision(TOP_COLLISION)) {
                        return;
                    }
                    if (checkExitCollision(labyrinth, TOP_COLLISION)) {
                        return;
                    }

                    labyrinth.move(0, -SPACE);

                    break;

                case KeyEvent.VK_DOWN:
                    labyrinth.initPlayer(1);

                    if (checkWallCollision(labyrinth, BOTTOM_COLLISION)) {
                        return;
                    }

                    if (checkBagCollision(BOTTOM_COLLISION)) {
                        return;
                    }
                    if (checkExitCollision(labyrinth, BOTTOM_COLLISION)) {
                        return;
                    }

                    labyrinth.move(0, SPACE);

                    break;

                case KeyEvent.VK_R:

                    restartLevel();

                    break;

                default:
                    break;
            }

            repaint();
        }
    }

    private boolean checkWallCollision(Actor actor, int type) {

        switch (type) {

            case LEFT_COLLISION:

                for (int i = 0; i < walls.size(); i++) {

                    Wall wall = walls.get(i);

                    if (actor.isLeftCollision(wall)) {

                        return true;
                    }
                }

                return false;

            case RIGHT_COLLISION:

                for (int i = 0; i < walls.size(); i++) {

                    Wall wall = walls.get(i);

                    if (actor.isRightCollision(wall)) {
                        return true;
                    }
                }

                return false;

            case TOP_COLLISION:

                for (int i = 0; i < walls.size(); i++) {

                    Wall wall = walls.get(i);

                    if (actor.isTopCollision(wall)) {

                        return true;
                    }
                }

                return false;

            case BOTTOM_COLLISION:

                for (int i = 0; i < walls.size(); i++) {

                    Wall wall = walls.get(i);

                    if (actor.isBottomCollision(wall)) {

                        return true;
                    }
                }

                return false;

            default:
                break;
        }

        return false;
    }

    private boolean checkBagCollision(int type) {

        switch (type) {

            case LEFT_COLLISION:

                for (int i = 0; i < baggs.size(); i++) {

                    Baggage bag = baggs.get(i);

                    if (labyrinth.isLeftCollision(bag)) {

                        for (int j = 0; j < baggs.size(); j++) {

                            Baggage item = baggs.get(j);


                            if (!bag.equals(item)) {

                                if (bag.isLeftCollision(item)) {

                                    return true;
                                }
                            }

                            if (checkWallCollision(bag, LEFT_COLLISION)) {
                                return true;
                            }
                        }
                        scores[i] = 1;
                        recalculateScore();

                    //    bag.move(-SPACE, 0);
                        // isCompleted();
                    }
                }
                repaint();
                return false;

            case RIGHT_COLLISION:

                for (int i = 0; i < baggs.size(); i++) {

                    Baggage bag = baggs.get(i);

                    if (labyrinth.isRightCollision(bag)) {

                        for (int j = 0; j < baggs.size(); j++) {

                            Baggage item = baggs.get(j);

                            if (!bag.equals(item)) {

                                if (bag.isRightCollision(item)) {
                                    scores[j] = 1;
                                    recalculateScore();
                                    return true;
                                }
                            }

                            if (checkWallCollision(bag, RIGHT_COLLISION)) {
                                return true;
                            }
                        }
                        scores[i] = 1;
                        recalculateScore();
                   //     bag.move(SPACE, 0);
                    //    isCompleted();
                    }
                }
                repaint();
                return false;

            case TOP_COLLISION:

                for (int i = 0; i < baggs.size(); i++) {

                    Baggage bag = baggs.get(i);

                    if (labyrinth.isTopCollision(bag)) {

                        for (int j = 0; j < baggs.size(); j++) {

                            Baggage item = baggs.get(j);

                            if (!bag.equals(item)) {

                                if (bag.isTopCollision(item)) {
                                    scores[j] = 1;
                                    recalculateScore();
                                    return true;
                                }
                            }

                            if (checkWallCollision(bag, TOP_COLLISION)) {
                                return true;
                            }
                        }
                        scores[i] = 1;
                        recalculateScore();
                    //    bag.move(0, -SPACE);
                        // isCompleted();
                    }
                }
                repaint();
                return false;

            case BOTTOM_COLLISION:

                for (int i = 0; i < baggs.size(); i++) {

                    Baggage bag = baggs.get(i);

                    if (labyrinth.isBottomCollision(bag)) {

                        for (int j = 0; j < baggs.size(); j++) {

                            Baggage item = baggs.get(j);

                            if (!bag.equals(item)) {

                                if (bag.isBottomCollision(item)) {
                                    scores[j] = 1;
                                    recalculateScore();
                                    return true;
                                }
                            }

                            if (checkWallCollision(bag,BOTTOM_COLLISION)) {

                                return true;
                            }
                        }
                        scores[i] = 1;
                        recalculateScore();
                      //  bag.move(0, SPACE);
                    //    isCompleted();
                    }
                }
                repaint();
                break;

            default:
                break;
        }
        repaint();
        return false;
    }

    private void recalculateScore() {
        score = Arrays.stream(scores).sum();
        open();
        if (score == 3) {
            JOptionPane.showMessageDialog(null,"Congratulations! You have collected all the keys!","Information",JOptionPane.INFORMATION_MESSAGE);
        }
        repaint();
    }

    private void open() {
        HashMap<String, String> map = new HashMap<>();
//    map.put("苹果", "apple");
//    map.put("香蕉", "banana");
        map.put("apple", "苹果");
        map.put("banana", "香蕉");
        WordSearch game = new WordSearch(map);
    }

    private boolean checkExitCollision(Actor actor, int type) {

        switch (type) {

            case LEFT_COLLISION:
                for (int i = 0; i < exits.size(); i++) {

                    Exit exit = exits.get(i);

                    if (actor.isLeftCollision(exit)) {
                        ImageIcon icon = new ImageIcon("src/resources/lock.png");
                        UIManager UI=new UIManager();
                        UI.put("OptionPane.background", Color.white);
                        UI.put("Panel.background", Color.white);

                        if (score != 3) {
                            JOptionPane.showMessageDialog(null,"Collect all the keys to open the lock!","Information",JOptionPane.INFORMATION_MESSAGE, icon);
                        } else {
                            int n = JOptionPane.showOptionDialog(new JFrame(), "Well done! You have completed this level!",
                                    "Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                    null, new Object[] {"Next Level", "Menu"}, JOptionPane.YES_OPTION);

                            if (n == JOptionPane.YES_OPTION) {
                                System.out.println("Yes");
                                restartLevel();
                            } else if (n == JOptionPane.NO_OPTION) {
                                frame.dispose();
                                Pro f1 = new Pro();
                                System.out.println("No");
                            } else if (n == JOptionPane.CLOSED_OPTION) {
                                System.out.println("Closed by hitting the cross");
                            }
                         //   JOptionPane.showMessageDialog(null,"Well done! You have completed this level!","Information",JOptionPane.INFORMATION_MESSAGE, icon);
                        }
                        return true;
                    }
                }

                return false;

            default:
                break;
        }

        return false;
    }

  /*  public void isCompleted() {

        int nOfBags = baggs.size();
        int finishedBags = 0;

        for (int i = 0; i < nOfBags; i++) {

            Baggage bag = baggs.get(i);

            for (int j = 0; j < nOfBags; j++) {

                Area area =  areas.get(j);

                if (bag.x() == area.x() && bag.y() == area.y()) {

                    finishedBags += 1;
                }
            }
        }

        if (finishedBags == nOfBags) {

            isCompleted = true;
            repaint();
        }
    } */

    private void restartLevel() {

        areas.clear();
        baggs.clear();
        walls.clear();
        exits.clear();

        initWorld();
        repaint();
    /*    if (isCompleted) {
            isCompleted = false;
        }*/
    }
}
