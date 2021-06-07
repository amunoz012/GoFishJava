 /* File that creates players to be used in the game and makes them play
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String name;
    private Deck deck;
    private int books;

    public Player(boolean ai) throws Exception{
        deck = new Deck(0);
        books = 0;
        ArrayList<String> names = new ArrayList<String>();

        if (ai){
            File file = new File("C:\\Users\\admin\\IdeaProjects\\Final Project\\src\\GoFish\\name.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ( (st = br.readLine()) != null  ){
                names.add(st);
            }
            Random r = new Random();
            int n = r.nextInt(names.size());
            name = names.get(n);
        }
        else{
            name = "Tony Munching";
        }
    }

    public Deck stealCards(Card.Number n){
        Deck d = deck.stealCard(n);
        return d;
    }

    public String getName(){
        return name;
    }
    public int getBooks(){
        return books;
    }
    public int getCards(){
        return deck.getSize();
    }

    public void addCard(Card c){
        deck.addCard(c);
    }

    public void addCards(Deck d){
        deck.addCards(d);
    }

    public ArrayList<String> cardStrings(){
        ArrayList<String> s = new ArrayList<String>();

        for (int i=0; i<deck.getSize(); i++){
            s.add(deck.peekCard(i).toString());
        }

        return s;
    }
    public boolean checkFour(Card.Number n){
        if(deck.checkFour(n)){
            books++;
            return true;
        }
        else{
            return false;
        }

    }
    public Card.Number getMostNumber(){
        return deck.getMostNumber();
    }
    public Deck getDeck(){
        return deck;
    }
}
