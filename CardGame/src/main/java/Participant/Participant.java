package Participant;

import Collection.Card.Card;

import java.util.ArrayList;

public abstract class  Participant {
    private String name;
    private ArrayList<Card> hand;


    public Participant(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();

    }

    public String getName(){
        return name;
    }

    public int cardCount(){
        return this.hand.size();
    }

    public ArrayList<Card> getHand(){
        return hand;
    }
    public void takeCard(Card card){
        this.hand.add(card);
    }
    public String showCard(int index){
        return this.hand.get(index).cardName();
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

