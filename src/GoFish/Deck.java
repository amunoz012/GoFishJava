 /* Class holding methods specific to the decks
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

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(int num){
        deck = new ArrayList<Card>();

        for(int i = 0; i <num; i++){
            deck.add(new Card(i));
        }
    }

    public Card getCard(){
        Random r = new Random();
        int num = r.nextInt(deck.size());

        Card c = deck.get(num);
        deck.remove(num);

        return c;

    }

    public Deck stealCard(Card.Number n){

        Deck d =new Deck(0);
        for (int i=deck.size()-1; i>=0; i--){
            if ( deck.get(i).getNumber() == n ){
                d.addCard(deck.get(i));
                deck.remove(i);
            }
        }
        return d;

    }

    public void addCard(Card c){
        deck.add(c);
    }
    public void addCards(Deck d){
        for(int i = 0; i<d.getSize(); i++) {
            deck.add(d.peekCard(i));
        }
    }

    public int getSize(){
        return deck.size();
    }

    public Card peekCard(int i){
        return deck.get(i);
    }

    public boolean checkFour(Card.Number n){
        int count = 0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i=0; i<deck.size(); i++){

            if ( deck.get(i).getNumber() == n ){
                count++;
                nums.add(i);
            }
        }

        if (count==4){
            System.out.println("-------------BEFORE");
            for (int i=0; i<deck.size(); i++){
                System.out.println((i+1)+". "+deck.get(i).toString());
            }
            stealCard(n);
//            System.out.println(deck.remove(nums.get(3)) );
//            System.out.println(deck.remove(nums.get(2)));
//            System.out.println(deck.remove(nums.get(1)));
//            System.out.println(deck.remove(nums.get(0)));
            System.out.println("-------------AFTER");
            for (int i=0; i<deck.size(); i++){
                System.out.println((i+1)+". "+deck.get(i).toString());
            }
            return true;
        }
        return false;
    }
    public Card.Number getMostNumber(){
        ArrayList<Integer> counts = new ArrayList<Integer>();
        int c;
        for ( int i = 0; i<13; i++){
            c = 0;
            for(int j =0; j < deck.size(); j++){
                if(deck.get(j).getNumber()== Card.parseNum(i)){
                    c++;
                }
            }
            counts.add(c);
        }
        c=0;
        for ( int i = 1; i<13; i++) {
            if(counts.get(i)>counts.get(c)){
                c = i;
            }
        }
        return Card.parseNum(c);
    }
}
