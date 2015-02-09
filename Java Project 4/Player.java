//***********************************
//Programming Project 4
//By Benjamin Makansi - bkm2122
//November 19, 2014
//***********************************

import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand; // the player's cards
    private int handTotal; // Total value of the hand
    
	private Deck deck;

    public Player(Deck deck)
    {

    	hand = new ArrayList<Card>();
    	handTotal = 0;
    	this.deck = deck;
    	
    }

    public int getTotal()
    {
        return handTotal;
    }
	
    public void dealPlayer()
    // Dealing cards to the player
    {
    	Card dealtCard = deck.draw();
    	hand.add(dealtCard);
    	handTotal = playerTotal();
    }
    
    public int playerTotal()
    {
    	int aceValue = 11;
    	int howManyAces = 0;
    	int faceCard = 10;
    	int total = 0; 
    	
    	for (Card card: hand)
    	{
    		if (card.getValue() > faceCard)
    		{
    			total = total + faceCard;
    		}
    		if ((card.getValue()==1))
    		{
    			total = total + aceValue;
    			// To handle multiple aces
    			howManyAces++;
    		}
    		if ((card.getValue()<aceValue) && (card.getValue()!=1))
    		{
    			total = total + card.getValue();
    		}
    		while ((21<total) && (howManyAces!= 0))
    		{
    			total = total - 10;
    			howManyAces--;
    		}
    	}
    	return total;
    }
    
    public void playerCards()
    {
    	String playerCards = "";
    	for(int i=0; i<hand.size(); i++)
    	{
    		String playerCard = hand.get(i).toString();
    		playerCards = playerCards + " " + playerCard;
    		
    	}
    	System.out.print("Your hand:" + " ");
    	for (int i = 0; i < hand.size(); i++) 
    	{
    		if (i > 0) 
    		{
    		System.out.print(", "); }
    		System.out.print(hand.get(i)); 
    		}
    		System.out.println();
    		System.out.println("Player's total: " + getTotal());
    	}
    }

	
