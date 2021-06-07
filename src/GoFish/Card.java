 /* Class holding methods specific to the cards
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

import java.util.Random;
import java.util.spi.CalendarDataProvider;

public class Card {
    enum Suit{
        HEARTS, CLUBS, SPADES, DIAMONDS;
    }
    enum Number{
        ACE, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
    }
    private Suit suit;
    private Number number;

    public Card(){
        Random r = new Random();
        int num = r.nextInt(52);

        switch (num / 13) {
            case 0:
                suit = Suit.HEARTS;
                break;
            case 1:
                suit = Suit.CLUBS;
                break;
            case 2:
                suit = Suit.SPADES;
                break;
            case 3:
                suit = Suit.DIAMONDS;
                break;
        }
        switch (num % 13){
            case 0:
                number = Number.ACE;
                break;
            case 1:
                number = Number.TWO;
                break;
            case 2:
                number = Number.THREE;
                break;
            case 3:
                number = Number.FOUR;
                break;
            case 4:
                number = Number.FIVE;
                break;
            case 5:
                number = Number.SIX;
                break;
            case 6:
                number = Number.SEVEN;
                break;
            case 7:
                number = Number.EIGHT;
                break;
            case 8:
                number = Number.NINE;
                break;
            case 9:
                number = Number.TEN;
                break;
            case 10:
                number = Number.JACK;
                break;
            case 11:
                number = Number.QUEEN;
                break;
            case 12:
                number = Number.KING;
                break;

        }
    }

    public Card(int num){

        switch (num / 13) {
            case 0:
                suit = Suit.HEARTS;
                break;
            case 1:
                suit = Suit.CLUBS;
                break;
            case 2:
                suit = Suit.SPADES;
                break;
            case 3:
                suit = Suit.DIAMONDS;
                break;
        }
        switch (num % 13){
            case 0:
                number = Number.ACE;
                break;
            case 1:
                number = Number.TWO;
                break;
            case 2:
                number = Number.THREE;
                break;
            case 3:
                number = Number.FOUR;
                break;
            case 4:
                number = Number.FIVE;
                break;
            case 5:
                number = Number.SIX;
                break;
            case 6:
                number = Number.SEVEN;
                break;
            case 7:
                number = Number.EIGHT;
                break;
            case 8:
                number = Number.NINE;
                break;
            case 9:
                number = Number.TEN;
                break;
            case 10:
                number = Number.JACK;
                break;
            case 11:
                number = Number.QUEEN;
                break;
            case 12:
                number = Number.KING;
                break;

        }
    }

    public Suit getSuit(){
        return suit;
    }

    public Number getNumber(){
        return number;
    }

    public static Number parseNum(int index){
        switch (index){
            case 0:
                return Number.ACE;
            case 1:
                return Number.TWO;
            case 2:
                return Number.THREE;
            case 3:
                return Number.FOUR;
            case 4:
                return Number.FIVE;
            case 5:
                return Number.SIX;
            case 6:
                return Number.SEVEN;
            case 7:
                return Number.EIGHT;
            case 8:
                return Number.NINE;
            case 9:
                return Number.TEN;
            case 10:
                return Number.JACK;
            case 11:
                return Number.QUEEN;
            case 12:
                return Number.KING;
        }
        return null;
    }

    public String toString(){
        String s = "";
        switch (number){
            case ACE:
                s += "ACE";
                break;
            case TWO:
                s += "2";
                break;
            case THREE:
                s += "3";
                break;
            case FOUR:
                s += "4";
                break;
            case FIVE:
                s += "5";
                break;
            case SIX:
                s += "6";
                break;
            case SEVEN:
                s += "7";
                break;
            case EIGHT:
                s += "8";
                break;
            case NINE:
                s += "9";
                break;
            case TEN:
                s += "10";
                break;
            case JACK:
                s += "JACK";
                break;
            case QUEEN:
                s += "QUEEN";
                break;
            case KING:
                s += "KING";
                break;
        }
        switch (suit){
            case CLUBS:
                s += " OF CLUBS";
                break;
            case DIAMONDS:
                s += " OF DIAMONDS";
                break;
            case HEARTS:
                s += " OF HEARTS";
                break;
            case SPADES:
                s += " OF SPADES";
                break;
        }
        return s;
    }
}
