import Collection.Card.*;
import Collection.Deck;
import Game.Game;
import Participant.*;
import org.junit.Before;
import org.junit.Test;;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    Game game;
    Deck deck;
    Player player;
    Player player2;
    Card highCard;
    Card lowCard;
    ArrayList<Card> hand;
    Dealer dealer;

    @Before
    public void before() {
        deck = new Deck();
        dealer = new Dealer("Participant.Participant.Dealer");
        game = new Game(deck, dealer);
        player = new Player("Lizzie");
        player2 = new Player("Iain");
        game.addPlayer(player);
        game.addPlayer(player2);
        highCard = new Card(SuitType.SPADES, RankType.ACE);
        lowCard = new Card(SuitType.SPADES, RankType.JACK);
    }

    @Test
    public void canAddPlayer() {
        game.addPlayer(player);
        assertEquals(3, game.playerCount());
    }

    @Test
    public void getPlayerNames(){
            List<String> names = new ArrayList<String>();
            names.add(player.getName());
            names.add(player2.getName());

        assertEquals( names, game.getPlayersNames());
    }





  @Test
  public void canShowDealer(){
      game.start();
      assertEquals(dealer.showCard(0), game.start());
  }


    @Test
    public void gameCanCheckDraw() {
        player.takeCard(highCard);
        dealer.takeCard(highCard);
        player.takeCard(lowCard);
        dealer.takeCard(lowCard);
        assertEquals(true, game.checkDraw());
    }






//    @Test
//    public void gameCanCheckWinner() {
//        player.takeCard(highCard);
//        player.takeCard(lowCard);
//        assertEquals(player, game.checkWinner());
//    }

//    @Test
//    public void gameCanNotWinner() {
//        player.takeCard(highCard);
//        player.takeCard(lowCard);
//        assertEquals(ArrayList, game.checkWinner());
//
//    }
}
