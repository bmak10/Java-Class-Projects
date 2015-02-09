//***********************************
//Programming Project 4
//By Benjamin Makansi - bkm2122
//November 19, 2014
//***********************************

public class Deck {

    private Card[] cards;
    private int cardsDrawn;
    
	private static int deckPos; //location in deck
	
    public Deck()
    {
    cards = new Card[52]; //instantiate array with 52 cards
    cardsDrawn = 0; //how many cards drawn
    deckPos = 0; //designates location in deck
    deckGenerator();
  
    }
	
    public Card draw()
    {
    	//Deal the top card
    	Card dealtCard = cards[deckPos];
    	deckPos++;
    	return dealtCard;
    }
	
    public void shuffle()
    {
    // this method shuffles the deck 
    	Card temp;
    	for (int i = 0; i<5000; i++){
    		//Loop through enough times to make shuffle effective
    		
    		//Pick random card positions
    		int temp_loc = (int) (Math.random()*52);
    		int temp_loc2 = (int) (Math.random()*52);
    		//Shuffle the positions of the cards
    		temp = cards[temp_loc];
    		cards[temp_loc] = cards[temp_loc2];
    		cards[temp_loc2] = temp;
    	}
    }
	
    public int getCardsDrawn()
    {
	return cardsDrawn;
    }

    public String toString()
    {
    	//Initiate string to store card names
    	String cardString = "";
    	
    	//For each card, add to String cardString
    	for (int i = 0; i < cards.length; i++){
    		String card = cards[i].toString();
    		cardString = cardString + " " + card; 
    	}
    	return cardString;
    }
    
    private void deckGenerator()
    {
    	//Generates a deck of 52 cards
    	//i keeps track of the index
    	/*j is 1 through 13, each designating
    	*one of the 13 types of cards possible
    	*/
    	
    	for (int i=0,j=1;i<13;i++,j++)
    	{
    		cards[i] = new Card(j, "Clubs");
    	}
    	for (int i=13,j=1;i<26;i++,j++)
    	{
    		cards[i] = new Card(j, "Spades");
    	}
    	for (int i=26,j=1;i<39;i++,j++)
    	{
    		cards[i] = new Card(j, "Hearts");
    	}
    	for (int i=40,j=1;i<52;i++,j++)
    	{
    		cards[i] = new Card(j, "Diamonds");
    	}
    	
    }

}
