ReadME for Programming project 3

Benjamin Makansi - bkm2122

Oracle.java:

Important design decisions for Oracle() method:
This is my constructor method, which I used to generate a random 4-digit string
solution, and made sure that there were no repeating digits but using a while
loop to have it regenerate another string until there were none repeating.

Important design decisions for howManyBulls(String guess):
This method iterates over the String solution and the String guess to return
the number of bulls, which I did with a nested for loop. I also knew that I would
later have to make sure that no bulls were also counted as cows, so I concatenated
each bull to the String bullString which I could then later use to check if a
cow was already a bull.

Important design decisions for howManyCows(String guess):
This method iterates over the String solution and the String guess to return
the number of bulls, which I again did with a nested for loop. I also had to
make sure that no digits were counted as cows when they had previously been
counted as bulls. So in my if statement, I checked to make sure that any would-be
cow was not already contained in my String bullString, which stored all the bulls.

Game.java:

Important design decisions for Game() method:
This is my constructor method, which I used to initialize all the variables I
would need in other methods. The integer count is used to keep track of how many
guesses the human has made. Each of these guesses is stored as a String guess.
And a new Oracle() object is stored under the name computer.

Important design decisions for playGame() method:
This method compares user's guess to computer's solution. If they don't match,
outputs the number of bulls and cows and lets the user guess again.
If they do match, congratulates the user and prints the tries he/she took.
I knew that I would have to keep calculating the number of bulls and cows as
long as the user did not guess the 4-digit number correctly. This meant I needed
to use a while loop, for which I evaluated a Boolean stillGuessing that indicated
whether the user still needs to guess the computer's number. I set up an if statement
which changes the value of stillGuessing to false and ends the while loop once the
user has guessed the number correctly. In this case the user is congratulated and
the number of tries is printed. If the user doesn't guess the number correctly,
the method outputs the number of bulls and cows and asks for another guess.

One thing that was really important to playGame() was that I calculate the number
of bulls first, so that howManyBulls is executed and the string bullString
[containing all the bulls] is created before the number of cows is calculated. If
cows was calculated first, then there would be some digits counted as both cows and bulls.