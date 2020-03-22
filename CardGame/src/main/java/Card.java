import java.util.ArrayList;

public class Card {
    private final SuitType suit;
    private final RankType rank;
//    private ArrayList<Card> cards;



    public Card(SuitType suit, RankType rank) {
        this.suit = suit;
        this.rank = rank;
    }


//    public SuitType getSuit() {
//        return this.suit;
//    }
//
//    public RankType getRank() {
//        return this.rank;
//    }

    public int getValueFromEnum() {
        return this.rank.getValue();
    }

   public String cardName(){
        return String.format("The " + this.rank + " Of " + this.suit);
   }

}
