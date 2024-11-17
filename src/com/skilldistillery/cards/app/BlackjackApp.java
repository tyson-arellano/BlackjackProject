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

		do {
			dealInitialCards();
			System.out.println(dealer.initial() + "\n");
			System.out.println(player + "\n");
			boolean keepGoing = true;
			boolean dealerTurn = true;

			if (player.hand.isBlackjack()) {
				System.out.println("Blackjack!!!");
				round = false;
			}
			if (!dealer.hand.isBlackjack() && player.hand.isBlackjack()) {
				System.out.println(dealer + "\n" + player + "\n");
				System.out.println("You Win!!");
				round = false;
			}
			if (dealer.hand.isBlackjack() && player.hand.isBlackjack()) {
				System.out.println(dealer + "\n" + player + "\n");
				System.out.println("You and the Dealer BlackJack! This round is a push.");
				round = false;
			}
			do {
				System.out.println("Would you like to hit or stand? Type (h) for hit or (s) for stand. \n");
				String hitOrStand = sc.next();
				try {
					if (hitOrStand.equalsIgnoreCase("h")) {
						player.hit(dealer.dealCard());
						System.out.println(player + "\n");

						if (player.hand.isBust()) {
							System.out.println("Oops! You busted! Dealer wins!");
							keepGoing = false;

						}

						if (player.handValue() == 21) {
							System.out.println("You have 21! It's the Dealer's turn");
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

			

			if (player.hand.isBust()) {
				break;
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

				if (dealer.hand.isBust()) {
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
			round = false;

		} while (round);
		System.out.println("\n Thanks for playing!");
		sc.close();
	}

}
