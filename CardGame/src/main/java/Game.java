import java.util.*;

public class Game {
    ArrayList<Player> players;
    Deck deck;
    Dealer dealer;
    Boolean draw;
    Boolean win;

    public Game(Deck deck, Dealer dealer) {
        this.players = new ArrayList<Player>();
        this.deck = deck;
        this.dealer = dealer;
        this.draw = false;
        this.win = false;

    }
    public ArrayList<Player> getPlayers() {
        return players;
    }




    public ArrayList<String> getPlayersNames() {
        ArrayList<String> names = new ArrayList<String>() ;
        for(Player player : this.players){

             names.add(player.getName());

        }
        return names;
    }

    public int playerCount() {
        return this.players.size();
    }

    public void removePlayer(Player player){
        if(2 > playerCount() ) {
            int index =players.indexOf(player);
            players.remove(index);
        }
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public String start() {
        Card card1 = deck.dealCard();
        Card card2 = deck.dealCard();
        dealer.takeCard(card2);
        dealer.takeCard(card1);

        for (Player player : this.players) {

                Card card = deck.dealCard();
                player.takeCard(card);
            Card card3 = deck.dealCard();
            player.takeCard(card3);

        }

          return      dealer.showCard(0);

    }

//    public void stickOrTwist(Player player, String discuss){
//        if("y".equals(discuss)) {
//            Card card = deck.dealCard();
//            player.takeCard(card);
//        }//do nothing
//
//    }



    public boolean checkDraw() {

        for (Player player : this.players) {
            if ( dealer.isBlackJack() && player.isBlackJack()){
                draw = true;
            }
        }
        return draw;
    }




    public List<Player> checkWinner() {
        List<Player> winners = new ArrayList<Player>();
        for(Player player: players){
              if(player.handTotal() > dealer.handTotal()){

                  winners.add(player);
              }

            }


        return winners;
            }

        }




