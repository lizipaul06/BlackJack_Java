package ParticipantTest;

import Collection.Card.*;
import Collection.Deck;
import Game.Game;
import Participant.Dealer;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DealerTest {
    Dealer dealer;
    Card card1;
    Card card2;
    Game game;
    Deck deck;


    @Before
    public void before(){

        dealer = new Dealer("Participant.Participant.Dealer");
        deck = new Deck();
        card1 = new Card(SuitType.HEARTS, RankType.FIVE);
        card2 = new Card(SuitType.HEARTS, RankType.TEN);
        game = new Game(deck, dealer);

    }

    @Test
    public void canGetName(){
        assertEquals("Participant.Participant.Dealer", dealer.getName());
    }

    @Test
    public void canGetCard(){
        dealer.takeCard(card1);
        assertEquals(1, dealer.cardCount());

    }

    @Test
    public void canShowCard(){
        dealer.takeCard(card1);
        assertEquals("The FIVE Of HEARTS", dealer.showCard(0));
    }

    @Test
    public void canHandTotal(){
        dealer.takeCard(card1);
        dealer.takeCard(card2);
        assertEquals(15, dealer.handTotal());
    }

    @Test
    public void canWantHit(){
        dealer.takeCard(card1);
        dealer.takeCard(card2);
        assertTrue(dealer.wantsToHit());
    }

    @Test
    public void canNotHit(){
        dealer.takeCard(card1);
        dealer.takeCard(card2);
        dealer.takeCard(card1);
        assertEquals(false, dealer.wantsToHit());
    }

}
