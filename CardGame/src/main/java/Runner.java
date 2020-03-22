
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

import static java.lang.Integer.parseInt;

    public class Runner {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            Dealer dealer = new Dealer();
            Deck deck = new Deck();
            Game game = new Game(deck, dealer);

            System.out.println("Welcome to BlackJack");
            System.out.println("How many players would you like to play?");

            String input = scanner.next();
            int players = parseInt(input);

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

                    if (output2.equalsIgnoreCase("Twist")) {
                        player.takeCard(deck.dealCard());
                        System.out.println(player.handTotal());
                        if (player.isBust()) {
                            System.out.println(player.getName() + " busted and got a total of " + player.handTotal() );
                            game.removePlayer(player);

                        }
                        output2 = "";

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
                    List<Player> winners;
                    //DRAW CARD
                    if (dealer.wantsToHit(game.getPlayers())) {
                        dealer.takeCard(deck.dealCard());
                        if (dealer.isBlackJack()) {
                            System.out.println("Blackjack! Dealer won.");
                            System.exit(0);
                        }
                        if (dealer.isBust()) {
                            System.out.println("Dealer busted and got a total of " + dealer.handTotal());

                            winners = game.checkWinner();
                            for(Player player: winners) {
                                System.out.println(String.format(player.getName() + " Wins"));
                            }
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Dealer has chosen to stay!");

                        winners = game.checkWinner();
                        for(Player player: winners) {
                            System.out.println(String.format(player.getName() + " Wins"));
                        }
                        System.exit(0);
                    }

                } while (!stay);


            }


        }



