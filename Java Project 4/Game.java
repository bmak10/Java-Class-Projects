//***********************************
//Programming Project 4
//By Benjamin Makansi - bkm2122
//November 19, 2014
//***********************************
import java.util.Scanner;

public class Game {

	private Deck deck;
	private Player player;
	private Dealer dealer;
	private Scanner input;
	
	//Additional instance variables
	private boolean playerTurn; //Is it the player's turn?
	private boolean GameOver; //Indicating whether game is over
	private boolean playerOver21; /*Indicating whether player
								*goes over 21*/
	private boolean dealerOver21; /*Indicating whether dealer
	 								*goes over 21*/
	
	public Game()
	{//Constructor method
		GameOver = false;
		deck = new Deck();
		player = new Player(deck);
		dealer = new Dealer(deck);
		playerTurn = true;
		playerOver21 = false;
		dealerOver21 = false;
	}
	
	public void play()
	{ //Everything needed to play the game
		
		deck.shuffle(); //Shuffle deck
		player.dealPlayer();//Deal the player
		dealer.dealDealer(); //Deal the dealer
		player.dealPlayer();//Deal the player a 2nd card
		//Remember that Player cannot see dealer's second card
		player.playerCards();
		
		System.out.println("Dealer has received: "+dealer.dealerCards());
		dealer.dealDealer();
		
		while (GameOver==false) //As long as game is still going
		{
			while (playerTurn!=false) //As long as it is the player's turn
			{
				Scanner in = new Scanner(System.in);
				System.out.print("Another hit? Yes or No: ");
				//Ask if player wants to hit or stand
				String hit = in.next();				
				if (hit.equals("Yes")) //If player wants to hit
					{
						player.dealPlayer(); //Deal again
						player.playerCards(); //Print cards
						
						//Stop turn if player reaches 21 or over
							if (player.getTotal()>=21){
								playerTurn = false;
							
						//Tell player if he/she is over 21
								if (player.getTotal() > 21)	{
									GameOver = true;
									playerOver21 = true;
									System.out.println("You've gone over 21");
									}
								
							}
							
						}
					else if (hit.equals("No")){
					playerTurn = false; //player has chosen to stand						
					}
			}
				
					if (!GameOver)
						
					{
						System.out.println("Dealer's previous hand: "+ dealer.dealerCards());
						while (17>dealer.getTotal())
							//Dealer stands on anything 17 or above
						{
							dealer.dealDealer();
							if (dealer.getTotal() > 21){
							
								dealerOver21 = true;
							}
						}
					}
					
					//Print results of dealer's turn
					System.out.println("Dealer's new cards: "
							+ dealer.dealerCards() + ".");
					player.playerCards();
					System.out.println("Dealer's hand: " 
							+ dealer.dealerCards());
					System.out.println("Dealer's total: "
							+ dealer.getTotal());
					
					if (dealerOver21 == true || 
							(player.getTotal()>dealer.getTotal()&&!playerOver21))
					{
						System.out.print("Player wins.");
					}
					if (dealerOver21 == false && (player.getTotal()
						<= dealer.getTotal() || playerOver21 == true))
						{
							System.out.print("Dealer wins.");
						}
					Scanner response = new Scanner (System.in);
					System.out.println();
					//Ask if player wants another round
					System.out.print("Play Again? Yes or No: ");
					String responseString = response.next();
					System.out.println();
					if (responseString.equals("Yes"))
						//Start a new game
					{
						Game blackjack = new Game();
						blackjack.play();
					}
					else return;
					}
				}
	}
					
			
	
		



