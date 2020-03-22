import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.RequestWrapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    Player player;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before(){
        player = new Player("Lizzie");
        card1 = new Card(SuitType.HEARTS, RankType.FIVE);
        card2 = new Card(SuitType.HEARTS, RankType.TEN);
        card3 = new Card(SuitType.HEARTS, RankType.ACE);
    }

    @Test
    public void canGetName(){
        assertEquals("Lizzie", player.getName());
    }

    @Test
    public void canGetCard(){
        player.takeCard(card1);
        assertEquals(1, player.cardCount());

    }

    @Test
    public void canShowCard(){
        player.takeCard(card1);
        assertEquals("The FIVE Of HEARTS", player.showCard(0));
    }

    @Test
    public void canHandTotal(){
        player.takeCard(card1);
        player.takeCard(card2);
        assertEquals(15, player.handTotal());
    }

    @Test
    public void canBeBust(){
        player.takeCard(card2);
        player.takeCard(card1);
        player.takeCard(card2);
        assertTrue(player.isBust());
    }

    @Test
    public void canGetBlackJack(){
        player.takeCard(card2);
        player.takeCard(card3);
        assertTrue(player.isBlackJack());

    }

}
