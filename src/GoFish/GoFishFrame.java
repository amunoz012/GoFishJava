 /* GoFish card game with GUI and behavior specified in file
  *
  *
  *
  *
  *
  * @author Antonio Munoz
  * @version Final Project
  * @bugs
  */



package GoFish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

public class GoFishFrame extends JFrame {

    private JFrame frame;
    private JButton prev;
    private JButton next;
    private Player p1;
    private Player ai1;
    private Player ai2;
    private Player ai3;
    private Deck deck;
    private int showCard;
    private ArrayList<String>[] cardNames;
    private JLabel curCard;
    private Font myFont;
    private JPanel pNorth;
    private JLabel deckNum;
    private JPanel pCenterLeft;
    private JLabel nextPlay;
    private JButton play;
    private JComboBox playerList;
    private JComboBox cardList;
    private JPanel pCenterCenter;
    private JPanel pCenterRight;
    private JLabel label1;
    private JLabel name1;
    private JLabel info1;
    private JLabel name2;
    private JLabel info2;
    private JLabel name3;
    private JLabel info3;
    private JLabel name4;
    private JLabel info4;

    public GoFishFrame() throws Exception {
        ai1 = new Player(true);
        ai2 = new Player(true);
        ai3 = new Player(true);
        deck = new Deck(52);
        p1 = new Player(false);

        for ( int i=0; i<7; i++ ){
            p1.addCard(deck.getCard());
            ai1.addCard(deck.getCard());
            ai2.addCard(deck.getCard());
            ai3.addCard(deck.getCard());
        }

        showCard = 0;
    }

    public void resetCardScroll(GoFishFrame gff){
        gff.cardNames = new ArrayList[]{gff.p1.cardStrings()};
        gff.showCard = 0;
        gff.curCard.setText(gff.cardNames[0].get(gff.showCard));
        gff.prev.setEnabled(false);
        gff.next.setEnabled(true);
    }

    public int getTarget(int index){

        if (index == 1){
            if(ai2.getCards() > ai3.getCards() && ai2.getCards() > p1.getCards()){
                return 2;
            }
            else if ( ai3.getCards() > ai2.getCards() && ai3.getCards() > p1.getCards() ){
                return 3;
            }
            else{
                return 0;
            }
        }
        else if (index == 2){
            if(ai1.getCards() > ai3.getCards() && ai1.getCards() > p1.getCards()){
                return 1;
            }
            else if ( ai3.getCards() > ai1.getCards() && ai3.getCards() > p1.getCards() ){
                return 3;
            }
            else{
                return 0;
            }
        }
        else{
            if(ai1.getCards() > ai2.getCards() && ai1.getCards() > p1.getCards()){
                return 1;
            }
            else if ( ai2.getCards() > ai1.getCards() && ai2.getCards() > p1.getCards() ){
                return 2;
            }
            else{
                return 0;
            }
        }
    }

    public static void main(String args[]) throws Exception {

        GoFishFrame gff = new GoFishFrame();
        gff.frame = new JFrame("Go Fish!");
        gff.frame.setSize(1400,455);
        gff.frame.setLocation(100,50);
        gff.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gff.frame.setLayout(new BorderLayout());
        gff.myFont = new Font("SansSerif", Font.BOLD, 32);
        gff.pNorth = new JPanel();
        gff.pNorth.setLayout(new GridLayout());
        gff.pNorth.setSize(1440,200);
        gff.pNorth.setBackground(Color.red);

        gff.deckNum = new JLabel("Cards left on Deck: "+ gff.deck.getSize());
        gff.deckNum.setForeground(Color.GREEN);
        gff.deckNum.setFont(gff.myFont);
        gff.deckNum.setHorizontalAlignment(SwingConstants.CENTER);
        gff.pNorth.add(gff.deckNum);

        gff.pCenterLeft = new JPanel();
        gff.pCenterLeft.setBackground(Color.cyan);
        gff.pCenterLeft.setLayout(new BoxLayout(gff.pCenterLeft, BoxLayout.PAGE_AXIS));

        gff.nextPlay = new JLabel("Next Play:");
        gff.nextPlay.setFont(gff.myFont);
        gff.play = new JButton("Play!");
        gff.play.setFont(gff.myFont);

        String[] players = {"SELECT PLAYER", gff.ai1.getName(), gff.ai2.getName(), gff.ai3.getName()};
        String[] cards = {"SELECT A CARD","A", "2","3","4","5","6","7","8","9","10","J","Q","K"};
        gff.playerList = new JComboBox(players);
        gff.cardList = new JComboBox(cards);

        gff.playerList.setFont(gff.myFont);
        gff.cardList.setFont(gff.myFont);
        gff.pCenterLeft.add(gff.nextPlay);
        gff.pCenterLeft.add(gff.playerList);
        gff.pCenterLeft.add(gff.cardList);
        gff.pCenterLeft.add(gff.play);

        gff.pCenterCenter = new JPanel();
        gff.pCenterCenter.setBackground(Color.GREEN);
        gff.pCenterCenter.setLayout(new BoxLayout(gff.pCenterCenter, BoxLayout.LINE_AXIS));

        gff.prev = new JButton("<<Prev<<");
        if(gff.showCard == 0){
            gff.prev.setEnabled(false);
        }
        gff.prev.setFont(gff.myFont);
        gff.next = new JButton(">>Next>>");
        gff.next.setFont(gff.myFont);
        gff.cardNames = new ArrayList[]{gff.p1.cardStrings()};
        gff.curCard = new JLabel(gff.cardNames[0].get(gff.showCard));
        gff.curCard.setFont(gff.myFont);

        gff.pCenterCenter.add(gff.prev);
        gff.pCenterCenter.add(gff.curCard);
        gff.pCenterCenter.add(gff.next);

        gff.pCenterRight = new JPanel();
        gff.pCenterRight.setBackground(Color.gray);
        gff.pCenterRight.setLayout(new BoxLayout(gff.pCenterRight,BoxLayout.PAGE_AXIS));

        gff.label1 = new JLabel("             Player's Status");
        gff.label1.setFont(gff.myFont);
        gff.name1 = new JLabel(" "+players[1]);
        gff.name1.setFont(gff.myFont);
        gff.info1 = new JLabel("   # of Cards: "+ gff.ai1.getCards() +" | # of Books: "+ gff.ai1.getBooks()+" ");
        gff.info1.setFont(gff.myFont);
        gff.name2 = new JLabel(" "+players[2]);
        gff.name2.setFont(gff.myFont);
        gff.info2 = new JLabel("   # of Cards: "+ gff.ai2.getCards() +" | # of Books: "+ gff.ai2.getBooks()+" ");
        gff.info2.setFont(gff.myFont);
        gff.name3 = new JLabel(" "+players[3]);
        gff.name3.setFont(gff.myFont);
        gff.info3 = new JLabel("   # of Cards: "+ gff.ai3.getCards() +" | # of Books: "+ gff.ai3.getBooks()+" ");
        gff.info3.setFont(gff.myFont);
        gff.name4 = new JLabel(" "+gff.p1.getName());
        gff.name4.setFont(gff.myFont);
        gff.info4 = new JLabel("   # of Cards: "+ gff.p1.getCards() +" | # of Books: "+ gff.p1.getBooks()+" ");
        gff.info4.setFont(gff.myFont);

        gff.pCenterRight.add(gff.label1);
        gff.pCenterRight.add(gff.name1);
        gff.pCenterRight.add(gff.info1);
        gff.pCenterRight.add(gff.name2);
        gff.pCenterRight.add(gff.info2);
        gff.pCenterRight.add(gff.name3);
        gff.pCenterRight.add(gff.info3);
        gff.pCenterRight.add(gff.name4);
        gff.pCenterRight.add(gff.info4);

        gff.frame.getContentPane().add(gff.pNorth, BorderLayout.NORTH);
        gff.frame.getContentPane().add(gff.pCenterLeft,BorderLayout.LINE_START);
        gff.frame.getContentPane().add(gff.pCenterCenter, BorderLayout.CENTER);
        gff.frame.getContentPane().add(gff.pCenterRight, BorderLayout.LINE_END);
        gff.frame.setVisible(true);
        gff.frame.repaint();

        ArrayList<String> strs = gff.p1.cardStrings();
        System.out.println("CARDS p1: ");
        for(int i = 0; i<strs.size(); i++){
            System.out.println(strs.get(i));
        }
        strs = gff.ai1.cardStrings();
        System.out.println("CARDS ai1: ");
        for(int i = 0; i<strs.size(); i++){
            System.out.println(strs.get(i));
        }
        strs = gff.ai2.cardStrings();
        System.out.println("CARDS ai2: ");
        for(int i = 0; i<strs.size(); i++){
            System.out.println(strs.get(i));
        }
        strs = gff.ai3.cardStrings();
        System.out.println("CARDS ai3: ");
        for(int i = 0; i<strs.size(); i++){
            System.out.println(strs.get(i));
        }

        gff.next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gff.showCard++;
                gff.curCard.setText(gff.cardNames[0].get(gff.showCard));
                gff.prev.setEnabled(true);
                if( gff.showCard+1 == gff.p1.getCards() ){
                    gff.next.setEnabled(false);
                }
            }
        });

        gff.prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gff.showCard--;
                gff.curCard.setText(gff.cardNames[0].get(gff.showCard));
                gff.next.setEnabled(true);
                if( gff.showCard == 0 ){
                    gff.prev.setEnabled(false);
                }
            }
        });

        gff.play.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                boolean goFish = false;
                Deck d;
                if ( gff.playerList.getSelectedIndex() == 0)
                    showMessageDialog(null,"Please, select a player");
                else if(  gff.cardList.getSelectedIndex() == 0)
                    showMessageDialog(null, "Please, select a card number");
                else{
                    switch (gff.playerList.getSelectedIndex()){
                        case 1:

                            showMessageDialog(null,"You are trying to steal "+ cards[gff.cardList.getSelectedIndex()] +" from "+gff.ai1.getName());
                            d = gff.ai1.stealCards(Card.parseNum(gff.cardList.getSelectedIndex()-1));
                            if(d.getSize()==0){
                                showMessageDialog(null, "GO FISH!");
                                goFish = true;
                            }
                            else{
                                showMessageDialog(null, "You stole "+d.getSize()+" cards!");
                                gff.p1.addCards(d);
                                if(gff.p1.checkFour(Card.parseNum(gff.cardList.getSelectedIndex()-1))){
                                    showMessageDialog(null, "You got a book!");
                                }
                                gff.resetCardScroll(gff);

                                gff.info1.setText("   # of Cards: "+ gff.ai1.getCards() +" | # of Books: "+ gff.ai1.getBooks()+" ");
                                gff.info4.setText("   # of Cards: "+ gff.p1.getCards() +" | # of Books: "+ gff.p1.getBooks()+" ");
                            }
                            break;
                        case 2:
                            showMessageDialog(null,"You are trying to steal "+ cards[gff.cardList.getSelectedIndex()] +" from "+gff.ai2.getName());
                            d = gff.ai2.stealCards(Card.parseNum(gff.cardList.getSelectedIndex()-1));
                            if(d.getSize()==0){
                                showMessageDialog(null, "GO FISH!");
                                goFish = true;
                            }
                            else{
                                showMessageDialog(null, "You stole "+d.getSize()+" cards!");
                                gff.p1.addCards(d);
                                if(gff.p1.checkFour(Card.parseNum(gff.cardList.getSelectedIndex()-1))){
                                    showMessageDialog(null, "You got a book!");
                                }
                                gff.info2.setText("   # of Cards: "+ gff.ai2.getCards() +" | # of Books: "+ gff.ai2.getBooks()+" ");
                                gff.info4.setText("   # of Cards: "+ gff.p1.getCards() +" | # of Books: "+ gff.p1.getBooks()+" ");
                            }
                            break;
                        case 3:
                            showMessageDialog(null,"You are trying to steal "+ cards[gff.cardList.getSelectedIndex()] +" from "+gff.ai3.getName());
                            d = gff.ai3.stealCards(Card.parseNum(gff.cardList.getSelectedIndex()-1));
                            if(d.getSize()==0){
                                showMessageDialog(null, "GO FISH!");
                                goFish = true;
                            }
                            else{
                                showMessageDialog(null, "You stole "+d.getSize()+" cards!");
                                gff.p1.addCards(d);
                                if(gff.p1.checkFour(Card.parseNum(gff.cardList.getSelectedIndex()-1))){
                                    showMessageDialog(null, "You got a book!");
                                }
                                gff.info3.setText("   # of Cards: "+ gff.ai3.getCards() +" | # of Books: "+ gff.ai3.getBooks()+" ");
                                gff.info4.setText("   # of Cards: "+ gff.p1.getCards() +" | # of Books: "+ gff.p1.getBooks()+" ");
                            }
                            break;
                    }
                }

                int target;
                Card.Number mustGet;

                if(goFish) {
                    //ai1 playing
                    while (goFish) {
                        if (gff.ai1.getCards() == 0 && gff.deck.getSize() > 0)
                            gff.ai1.addCard(gff.deck.getCard());
                        if (gff.ai1.getCards() > 0) {
                            target = gff.getTarget(1);
                            switch (target) {
                                case 0:
                                    mustGet = gff.ai1.getMostNumber();
                                    showMessageDialog(null, gff.ai1.getName() + " wants to steal from " + gff.p1.getName());
                                    d = gff.p1.stealCards(mustGet);
                                    if (d.getSize() > 0) {
                                        gff.ai1.addCards(d);
                                        if(gff.ai1.checkFour(mustGet)){
                                            showMessageDialog(null, gff.ai1.getName()+" got a book!");
                                        }
                                    }
                                    else{
                                        goFish = false;
                                    }
                                    gff.info1.setText("   # of Cards: " + gff.ai1.getCards() + " | # of Books: " + gff.ai1.getBooks() + " ");
                                    gff.info4.setText("   # of Cards: " + gff.p1.getCards() + " | # of Books: " + gff.p1.getBooks() + " ");
                                    break;
                                case 2:
                                    mustGet = gff.ai1.getMostNumber();
                                    showMessageDialog(null, gff.ai1.getName() + " wants to steal from " + gff.ai2.getName());
                                    d = gff.ai2.stealCards(mustGet);
                                    if (d.getSize() > 0) {
                                        gff.ai1.addCards(d);
                                        if(gff.ai1.checkFour(mustGet)){
                                            showMessageDialog(null, gff.ai1.getName()+" got a book!");
                                        }
                                    }
                                    else{
                                        goFish = false;
                                    }
                                    gff.info1.setText("   # of Cards: " + gff.ai1.getCards() + " | # of Books: " + gff.ai1.getBooks() + " ");
                                    gff.info2.setText("   # of Cards: " + gff.ai2.getCards() + " | # of Books: " + gff.ai2.getBooks() + " ");
                                    break;
                                case 3:
                                    mustGet = gff.ai1.getMostNumber();
                                    showMessageDialog(null, gff.ai1.getName() + " wants to steal from " + gff.ai3.getName());
                                    d = gff.ai3.stealCards(mustGet);
                                    if (d.getSize() > 0) {
                                        gff.ai1.addCards(d);
                                        if(gff.ai1.checkFour(mustGet)){
                                            showMessageDialog(null, gff.ai1.getName()+" got a book!");
                                        }
                                    }
                                    else{
                                        goFish = false;
                                    }
                                    gff.info1.setText("   # of Cards: " + gff.ai1.getCards() + " | # of Books: " + gff.ai1.getBooks() + " ");
                                    gff.info3.setText("   # of Cards: " + gff.ai3.getCards() + " | # of Books: " + gff.ai3.getBooks() + " ");
                                    break;
                            }
                        } else {
                            showMessageDialog(null, gff.ai1.getName() + " is out of the game!");
                            goFish = true;
                        }
                    }
                    goFish = true;
                    //ai2 playing
                    while (goFish) {
                        if (gff.ai2.getCards() == 0 && gff.deck.getSize() > 0)
                            gff.ai2.addCard(gff.deck.getCard());
                        if (gff.ai2.getCards() > 0) {
                            target = gff.getTarget(2);
                            switch (target) {
                                case 0:
                                    mustGet = gff.ai2.getMostNumber();
                                    showMessageDialog(null, gff.ai2.getName() + " wants to steal from " + gff.p1.getName());
                                    d = gff.p1.stealCards(mustGet);
                                    if (d.getSize() > 0) {
                                        gff.ai2.addCards(d);
                                        if(gff.ai2.checkFour(mustGet)){
                                            showMessageDialog(null, gff.ai2.getName()+" got a book!");
                                        }
                                    }
                                    else{
                                        goFish = false;
                                    }
                                    gff.info2.setText("   # of Cards: " + gff.ai2.getCards() + " | # of Books: " + gff.ai2.getBooks() + " ");
                                    gff.info4.setText("   # of Cards: " + gff.p1.getCards() + " | # of Books: " + gff.p1.getBooks() + " ");
                                    break;
                                case 1:
                                    mustGet = gff.ai2.getMostNumber();
                                    showMessageDialog(null, gff.ai2.getName() + " wants to steal from " + gff.ai1.getName());
                                    d = gff.ai1.stealCards(mustGet);
                                    if (d.getSize() > 0) {
                                        gff.ai2.addCards(d);
                                        if(gff.ai2.checkFour(mustGet)){
                                            showMessageDialog(null, gff.ai2.getName()+" got a book!");
                                        }
                                    }
                                    else{
                                        goFish = false;
                                    }
                                    gff.info2.setText("   # of Cards: " + gff.ai2.getCards() + " | # of Books: " + gff.ai2.getBooks() + " ");
                                    gff.info1.setText("   # of Cards: " + gff.ai1.getCards() + " | # of Books: " + gff.ai1.getBooks() + " ");
                                    break;
                                case 3:
                                    mustGet = gff.ai2.getMostNumber();
                                    showMessageDialog(null, gff.ai2.getName() + " wants to steal from " + gff.ai3.getName());
                                    d = gff.ai3.stealCards(mustGet);
                                    if (d.getSize() > 0) {
                                        gff.ai2.addCards(d);
                                        if(gff.ai2.checkFour(mustGet)){
                                            showMessageDialog(null, gff.ai2.getName()+" got a book!");
                                        }
                                    }
                                    else{
                                        goFish = false;
                                    }
                                    gff.info2.setText("   # of Cards: " + gff.ai2.getCards() + " | # of Books: " + gff.ai2.getBooks() + " ");
                                    gff.info3.setText("   # of Cards: " + gff.ai3.getCards() + " | # of Books: " + gff.ai3.getBooks() + " ");
                                    break;
                            }
                        } else {
                            showMessageDialog(null, gff.ai2.getName() + " is out of the game!");

                        }
                    }
                    goFish = true;
                    //ai3 playing
                    while (goFish) {
                        if (gff.ai3.getCards() == 0 && gff.deck.getSize() > 0)
                            gff.ai3.addCard(gff.deck.getCard());
                        if (gff.ai3.getCards() > 0) {
                            target = gff.getTarget(3);
                            switch (target) {
                                case 0:
                                    mustGet = gff.ai3.getMostNumber();
                                    showMessageDialog(null, gff.ai3.getName() + " wants to steal from " + gff.p1.getName());
                                    d = gff.p1.stealCards(mustGet);
                                    if (d.getSize() > 0) {
                                        gff.ai3.addCards(d);
                                        if(gff.ai3.checkFour(mustGet)){
                                            showMessageDialog(null, gff.ai3.getName()+" got a book!");
                                        }
                                    }
                                    else{
                                        goFish = false;
                                    }
                                    gff.info3.setText("   # of Cards: " + gff.ai3.getCards() + " | # of Books: " + gff.ai3.getBooks() + " ");
                                    gff.info4.setText("   # of Cards: " + gff.p1.getCards() + " | # of Books: " + gff.p1.getBooks() + " ");
                                    break;
                                case 1:
                                    mustGet = gff.ai3.getMostNumber();
                                    showMessageDialog(null, gff.ai3.getName() + " wants to steal from " + gff.ai1.getName());
                                    d = gff.ai1.stealCards(mustGet);
                                    if (d.getSize() > 0) {
                                        gff.ai3.addCards(d);
                                        if(gff.ai3.checkFour(mustGet)){
                                            showMessageDialog(null, gff.ai3.getName()+" got a book!");
                                        }
                                    }
                                    else{
                                        goFish = false;
                                    }
                                    gff.info3.setText("   # of Cards: " + gff.ai3.getCards() + " | # of Books: " + gff.ai3.getBooks() + " ");
                                    gff.info1.setText("   # of Cards: " + gff.ai1.getCards() + " | # of Books: " + gff.ai1.getBooks() + " ");
                                    break;
                                case 2:
                                    mustGet = gff.ai3.getMostNumber();
                                    showMessageDialog(null, gff.ai3.getName() + " wants to steal from " + gff.ai2.getName());
                                    d = gff.ai2.stealCards(mustGet);
                                    if (d.getSize() > 0) {
                                        gff.ai3.addCards(d);
                                        if(gff.ai3.checkFour(mustGet)){
                                            showMessageDialog(null, gff.ai3.getName()+" got a book!");
                                        }
                                    }
                                    else{
                                        goFish = false;
                                    }
                                    gff.info3.setText("   # of Cards: " + gff.ai3.getCards() + " | # of Books: " + gff.ai3.getBooks() + " ");
                                    gff.info2.setText("   # of Cards: " + gff.ai2.getCards() + " | # of Books: " + gff.ai2.getBooks() + " ");
                                    break;
                            }

                        } else {
                            showMessageDialog(null, gff.ai3.getName() + " is out of the game!");

                        }
                        goFish = false;
                    }
                }
                if ( gff.p1.getCards() == 0 && gff.deck.getSize()>0){
                    gff.p1.addCard(gff.deck.getCard());
                }
                ArrayList<String> strs = gff.p1.cardStrings();
                System.out.println("CARDS p1: ");
                for(int i = 0; i<strs.size(); i++){
                    System.out.println(strs.get(i));
                }
                strs = gff.ai1.cardStrings();
                System.out.println("CARDS ai1: ");
                for(int i = 0; i<strs.size(); i++){
                    System.out.println(strs.get(i));
                }
                strs = gff.ai2.cardStrings();
                System.out.println("CARDS ai2: ");
                for(int i = 0; i<strs.size(); i++){
                    System.out.println(strs.get(i));
                }
                strs = gff.ai3.cardStrings();
                System.out.println("CARDS ai3: ");
                for(int i = 0; i<strs.size(); i++){
                    System.out.println(strs.get(i));
                }
                if (gff.p1.getCards() == 0 && gff.ai1.getCards() == 0 && gff.ai2.getCards() == 0 && gff.ai3.getCards() == 0 & gff.deck.getSize()==0){
                    int max = gff.p1.getBooks();
                    int pos = 3;
                    if (gff.ai1.getBooks() > max)
                        pos = 0;
                    if (gff.ai2.getBooks() > max)
                        pos = 1;
                    if (gff.ai3.getBooks() > max)
                        pos = 2;
                    switch(pos){
                        case 0:
                            showMessageDialog(null, "Game is over, winner is " + gff.ai1.getName());
                            break;
                        case 1:
                            showMessageDialog(null, "Game is over, winner is " + gff.ai2.getName());
                            break;
                        case 2:
                            showMessageDialog(null, "Game is over, winner is " + gff.ai3.getName());
                            break;
                        case 3:
                            showMessageDialog(null, "Game is over, winner is " + gff.p1.getName());
                            break;
                    }

                }
            }
        });
    }

}