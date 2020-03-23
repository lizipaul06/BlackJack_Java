
import Collection.Deck;
import Game.Game;
import Participant.*;

    import java.util.List;
    import java.util.Scanner;

import static java.lang.Integer.parseInt;

    public class Runner {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            Dealer dealer = new Dealer("Dealer");
            Deck deck = new Deck();
            Game game = new Game(deck, dealer);
;
            System.out.println("Welcome to BlackJack");

            int players = 0;
            do {
                System.out.println("How many players would you like to play?");

                int input = scanner.nextInt();
                if (3 >= input) {
                    players = input;

                } else {
                    System.out.println("Please enter number between 1-3");

                }
            }while(players == 0);

            for (int i = 0; i < players; i++) {
                String prompt = String.format("Player %s, enter your name: ", (i + 1));
                System.out.println(prompt);
                String playerName = scanner.next();
                Player player = new Player(playerName);
                game.addPlayer(player);
            }


            game.start();


            String output2 = scanner.nextLine();
            System.out.println("Dealer has: " + dealer.showCard(0));
            System.out.println("Dealer Hand total: " + dealer.firstCard());


            for (Player player : game.getPlayers()) {
                //PLAYER
                String output = String.format("%s has:", player.getName());
                System.out.println(output);
                for (int i = 0; i < player.cardCount(); i++) {
                    System.out.println(player.showCard(i));
                }
                System.out.println(String.format("%s Hand total: %s", player.getName(), player.handTotal()));
            }
            System.out.println("- Dealers reveal -");
            System.out.println(dealer.handTotal());

            for (Player player : game.getPlayers()) {
                do {

                    System.out.println(String.format(player.getName() + " Stick or Twist ?"));
                    output2 = scanner.nextLine();
                    if(player.isBlackJack()){
                        System.out.println(player.getName() + "Has blackjack!");
                        break;
                    }
                    if (output2.equalsIgnoreCase("Twist")) {
                        player.takeCard(deck.dealCard());
                        System.out.println(player.handTotal());
                        if (player.isBust()) {
                            System.out.println(player.getName() + " busted and got a total of " + player.handTotal() );
                            game.removePlayer(player);
                           break;
                        }



                    }

                    //STAY
                    if (output2.equalsIgnoreCase("Stick")) {
                        System.out.println(player.getName() + " has chosen to stay. Your hand: " + player.handTotal());
                    }



            } while (output2.equalsIgnoreCase("Twist")) ;

        }
            System.out.println("- Dealers turn -");
                //DEALER
                boolean stay = false;


                do {
                    List<Player> winners = game.checkWinner();
                    //DRAW CARD
                    if(winners.size() == 0){
                        System.out.println("Dealer has won, all players bust");
                        System.exit(0);
                    }
                    else if (winners.size() > 0 && dealer.wantsToHit()) {
                        dealer.takeCard(deck.dealCard());
                        System.out.println("Dealer hand:" + dealer.handTotal());
                        if (dealer.isBlackJack()) {
                            System.out.println("Blackjack! Dealer won.");
                            System.exit(0);
                        }
                        if (dealer.isBust()) {
                            System.out.println("Dealer busted and got a total of " + dealer.handTotal());


                            for(Player player: winners) {
                                System.out.println(String.format(player.getName() + " Wins"));
                            }
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Dealer has chosen to stay with a total of: " + dealer.handTotal());

                        winners = game.checkWinner();
                        for(Player player: winners) {
                            System.out.println(String.format(player.getName() + " Wins"));
                        }
                        System.exit(0);
                    }

                } while (!stay);


            }


        }



