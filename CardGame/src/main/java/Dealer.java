import java.util.ArrayList;

public class Dealer {
    private final String name;
    private ArrayList<Card> hand;



    public Dealer(){
        this.name = "The Dealer";
        this.hand = new ArrayList<Card>();

    }


    public String getName(){
        return name;
    }




    public int cardCount(){
        return this.hand.size();
    }
    public void takeCard(Card card){
        this.hand.add(card);
    }
    public String showCard(int index){
        return this.hand.get(index).cardName();
    }

    public int firstCard(){
        return this.hand.get(0).getValueFromEnum();
    }

    public int handTotal() {
        int total = 0;
        for (Card card : this.hand){

            int value = card.getValueFromEnum();
            total += value;
        }
        return total;
    }

    public boolean isBlackJack(){

        return handTotal() == 21;
    }

    public boolean isBust(){
        return (handTotal() > 21);

    }

    public boolean wantsToHit(ArrayList<Player> players){
        Boolean result = false;
        if(players.size() == 0 ) {

            if (handTotal() <= 17) {
                result = true;
            }
        }
        return result;

    }



}