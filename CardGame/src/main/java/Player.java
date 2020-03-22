import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private boolean stick;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.stick = false;
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

    public Boolean getStick(){
        return stick;
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
        boolean blackjack = false;
                if(handTotal() == 21 && cardCount() >= 2){
                    blackjack = true;
                }
                return blackjack;
    }

    public boolean isBust(){
        boolean bust = false;
        if(handTotal() > 21){
            bust = true;
        }
        return bust;
    }



}
