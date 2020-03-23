package CollectionTest;

import Collection.Deck;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class DeckTest {
    Deck deck;


    @Before
    public void before() {
        deck = new Deck();

    }

    @Test
    public void canDealCard(){
        deck.dealCard();
        assertEquals(51,deck.lengthDeck() );
    }

    @Test
    public void dealStartsAt52(){
        assertEquals(52, deck.lengthDeck());
    }

}
