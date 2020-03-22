
import java.util.ArrayList;
import java.util.Collections;


public class Deck {
  private final ArrayList<Card> cards;


  public Deck() {
    this.cards = new ArrayList<Card>();

    for (SuitType suit : SuitType.values()) {
      for (RankType rank : RankType.values()) {

        Card card = new Card(suit, rank);
        this.cards.add(card);
      }

    }
    Collections.shuffle(this.cards);
  }
//
//  public String returnCard(int index){
//    Card card = this.cards.get(index);
//    String message = card.getRank().toString() + " Of " + card.getSuit().toString();
//     return message;
//  }

  public int lengthDeck() {
    return this.cards.size();
  }




   public Card dealCard(){
     return this.cards.remove(0);
   }



  }






