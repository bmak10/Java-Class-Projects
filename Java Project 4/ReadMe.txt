ReadMe for Programming Project 4

Benjamin Makansi - bkm2122

Deck.java

Important design decisions for Deck() method:
This is my constructor method, which I used to instantiate an array of 52
elements to later store the cards. I also instantiated the int deckPos to keep track
of the location in the deck as cards are dealt.

Important design decisions for draw() method.
Deals the top card by returning the top card and moving to the next card, as
designated by deckPos.

Important design decisions for shuffle():
This shuffles the deck. It runs through a for loop 5000 times to make sure the
shuffle is thorough. Each time, two temporary locations in the deck are randomly
generated and the positions of the cards are switched. 5000 times should be enough
for this small-scale shuffling method to end up shuffling the whole deck many times.

Important design decisions for toString():
This method stores the cards as on big string. It simply iterates through the array
of cards, converts each element to a string, and adds each element string to the big string,
cardString.

Important design decisions for deckGenerator():
This actually generates the deck of 52 cards. It uses 4 for loops, one for each suit.
i keeps track of the index in the entire deck, while j designates which of the 13 types of 
possible cards the card is.

Game.java

Important design decisions for Game():
This is my constructor method. I new I would have to keep track of several booleans, and
instantiated them here to be used in later methods. I also instantiated player and dealer such
that they would be using the same deck.

Important design decisions for play():
This method plays the game. First, the deck is shuffled. Then the player is dealt a card,
the dealer is dealt a card, and the player is dealt a second card. The player doesn't get to see
the dealer's other card because those are the rules. The player's and dealer's cards are printed
to the player, and a while loop is used to play the game as long as the game isn't over. Based
on the cards shown, the player chooses whether he/she wants to hit or stand. If player wants to hit,
he is dealt another card and the cards are printed along with the total. After each card dealt, the loop
checks if the player reaches 21 or over and performs the appropriate action based on the rules.
If the player chooses to stand, then it becomes the dealer's turn. The assignment stipulates that
the dealer stand whenever the total is 17 or above, so the dealer is only dealt more cards while his/her
total is less than 17, represented as a while loop. Once the while loop ends, the results of the game are
printed and the winner is determined.

Dealer.java

Important design decisions for Dealer()
deck is passed into this constructor method so that the methods in Deck can
be used in this class.
handTotal is used to keep track of the total value of the dealer's hand and
hand is an array used to keep track of all the cards in the dealer's hand.

dealDealer():
This simply puts a dealt card into the Dealer's hand using the draw method from
Deck class. Then it refreshes the total value of the hand using the dealerTotal()
method.

dealerTotal():
This method returns the total value of the dealer's hand. Face card and ace card
values have different values from their numerical designation using getValue(), so
I stored their values in their own variables. Aces can be either 1 or 11, so a while
loop checks whether the total is over 21 and if so, each ace is switched from its
initial value of 11 to 1 until the total is below 21.

dealerCards():
This method returns a string of all the dealer's cards so that they can be printed
to the user. This is done simply through a for loop which iterates over the hand and adds
each card to a string dealerCards.

Player.java
This class is essentially the same as Dealer.java except for the Player instead of
the Dealer. The only addition is that in playerCards, which is used to print the
hand to the user, the total is also printed. The dealer's cards cannot be printed to 
the user until the very end of the game because there is one card whose value is unknown
, so dealerCards in Dealer.java does not print the total. Player, however, is able to see
all the cards in his/her hand so after each hit, playerCards() must print the total.