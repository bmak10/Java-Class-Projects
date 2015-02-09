//***********************************
//Programming Project 4
//By Benjamin Makansi - bkm2122
//November 19, 2014
//***********************************
import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> hand; // Dealer's cards
    private int handTotal; // value of hand
    public Deck deck;
	
    
    public Dealer(Deck deck)
    {
    	this.deck = deck;
    	handTotal = 0;
    	hand = new ArrayList<Card>();
    	
    }
    
    public int getTotal()
    {
        return handTotal;
    }
    
    public void dealDealer()
    {
    	Card dealtCard = deck.draw();
    	hand.add(dealtCard); //Put dealt card in Dealer's hand
    	
    	handTotal = dealerTotal();
    }
    
    public int dealerTotal()
    {
    	
    	int howManyAces = 0;
    	int aceValue = 11;
    	int faceCard = 10;
    	int total = 0;
    	
    	for (Card card : hand)
    	{

    		if ((card.getValue()==1))
    		{
    			total = total + aceValue;
    			howManyAces++;
    		}
    		
    		if (faceCard<card.getValue())
    		{
    			total = total + faceCard;
    		}
    		
    		if ((card.getValue()!=1)&&(card.getValue()<aceValue))
    		{
    			total = total + card.getValue();
    		}
    		
    		while ((total > 21) && (howManyAces != 0))
    		{
    			total = total - 10;
    			
    			howManyAces--;
    			//Effectively, an ace of value 11 is lost
    		}
    			
    	}
    	return total;
    }
    
    public String dealerCards()
    {
    	String dealerCards = "";
    	for (int i=0;i<hand.size(); i++)
    	{
    		String dealerCard = hand.get(i).toString();
    		if (i != 0)
    		{
    			dealerCards = dealerCards + ", " + dealerCard;
    		}
    		else dealerCards = dealerCards + " " + dealerCard;
    	}
    	return dealerCards;
    }

}
