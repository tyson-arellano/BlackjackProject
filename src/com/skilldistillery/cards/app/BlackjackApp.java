package com.skilldistillery.cards.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.blackjack.BlackjackHand;
import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {

	private Dealer dealer;
	private Player player;

	private Scanner sc;

	private BlackjackApp() {
		dealer = new Dealer();
		player = new Player();
		sc = new Scanner(System.in);

	}

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.startGame();

	}

	public void dealInitialCards() {
		dealer.shuffle();
		player.hit(dealer.dealCard());
		dealer.hit(dealer.dealCard());
		player.hit(dealer.dealCard());
		dealer.hit(dealer.dealCard());
	}

	public void startGame() {
		boolean round = true;

		outer : do {
			dealInitialCards();
			System.out.println(dealer.initial() + "\n");
			System.out.println(player + "\n");
			boolean keepGoing = true;
			boolean dealerTurn = true;

			if (!dealer.getHand().isBlackjack() && player.getHand().isBlackjack()) {
				System.out.println("BLACKJACK!! And the dealer does not have Blackjack.\n \n *** YOU WIN!! *** \n");
				round = false;
				break;
			}
			if (dealer.getHand().isBlackjack() && player.getHand().isBlackjack()) {
				System.out.println("BLACKJACK!! \n");
				System.out.println(dealer + "\n");
				System.out.println(" The dealer also has BlackJack! This round is a push.\n");
				round = false;
				break;
			}
			do {
				System.out.println("Would you like to hit or stand? Type (h) for hit or (s) for stand. \n");
				String hitOrStand = sc.next();
				try {
					if (hitOrStand.equalsIgnoreCase("h")) {
						player.hit(dealer.dealCard());
						System.out.println(player + "\n");

						if (player.getHand().isBust()) {
							System.out.println("Oops! You busted! Dealer wins!");
							boolean newGame = true;
							game  : do {
							System.out.println("\n *** Would you like to play another hand? ***\n");
							System.out.println("******* Type Y for yes and N for no. *******");
							System.out.println("********************************************\n");
							String playAgain = sc.next();
							
							try {
								if (playAgain.equalsIgnoreCase("y")) {
									player.clearHand();
									dealer.clearHand();
									continue outer;
								}
								else if(playAgain.equalsIgnoreCase("n")) {
									
									newGame = false;
								}
								
								else {
									throw new InputMismatchException("Invalid input. \n");
								}
							} catch (InputMismatchException e) {
								System.out.println(e.getMessage());
								continue game;
							}
							
							}while(newGame);
							
							
							keepGoing = false;

						}

						if (player.handValue() == 21) {
							System.out.println("You have 21! It's the Dealer's turn \n");
							keepGoing = false;
						}
					} else if (hitOrStand.equalsIgnoreCase("s")) {
						keepGoing = false;
					}

					else {

						throw new InputMismatchException("Invalid input. \n");
					}

				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					System.out.println(dealer.initial() + "\n");
					System.out.println(player + "\n");
				}

			} while (keepGoing);

			

			if (player.getHand().isBust()) {
			
			}
		

			do {

				if (dealer.handValue() < 17) {
					System.out.println(dealer + "\n");
					System.out.println("Dealer must hit \n");
					dealer.hit(dealer.dealCard());
				}

				if (dealer.handValue() >= 17 && dealer.handValue() == player.handValue()) {
					System.out.println(dealer + " \n " + player + " \n ");
					System.out.println("Hands are equal. This round is a push.");
					dealerTurn = false;
				}

				if (dealer.handValue() >= 17 && dealer.handValue() <= 21 && dealer.handValue() > player.handValue()) {
					System.out.println(dealer + " \n " + player + " \n ");
					System.out.println("Dealer wins!");
					dealerTurn = false;
				}

				if (dealer.getHand().isBust()) {
					System.out.println(dealer + "\n");
					System.out.println("Dealer busts! You win!!");
					dealerTurn = false;
				}

				if (dealer.handValue() >= 17 && dealer.handValue() < player.handValue()) {
					System.out.println(dealer + "\n" + player + "\n");
					System.out.println("Your hand is higher than the Dealer's hand. You win!!");
					dealerTurn = false;
				}
			} while (dealerTurn);
			boolean newGame = true;
			game  : do {
			System.out.println("\n *** Would you like to play another hand? ***\n");
			System.out.println("******* Type Y for yes and N for no. *******");
			System.out.println("********************************************\n");
			String playAgain = sc.next();
			
			try {
				if (playAgain.equalsIgnoreCase("y")) {
					player.clearHand();
					dealer.clearHand();
					continue outer;
				}
				else if(playAgain.equalsIgnoreCase("n")) {
					
					newGame = false;
				}
				
				else {
					throw new InputMismatchException("Invalid input. \n");
				}
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				continue game;
			}
			
			}while(newGame);
			round = false;
		} while (round);
		System.out.println("\n Thanks for playing!");
		sc.close();
	}

}
