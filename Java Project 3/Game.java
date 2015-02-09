//**********************************************
// By Benjamin Makansi - bkm2122
// October 21, 2014
// Programming Project 3
//**********************************************

import java.util.Scanner;

public class Game{

    int count; //Keep track of how many tries
    Oracle computer;
    String guess;
    Scanner userInput;
       
    // you may need more instance variables here


    public Game(){
    // your code for the Game constructor goes here
    	    	
    	count = 0; //Zero tries to start off with
    	
    	
    	userInput = new Scanner(System.in);
    	System.out.println("Guess a four-digit number:");
    	guess = userInput.next(); //Get a guess from the user
    	
    	
    	computer = new Oracle(); //Create new Oracle object

    }


    public void playGame(){
    /*Compares user's guess to computer's solution. If they don't match,
     * outputs the number of bulls and cows and lets the user guess again.
     * If they do match, congratulates the user and prints the 
     *tries he/she took.*/
    	
    	Boolean stillGuessing = true; /*Keep track of whether user
                                       *is still guessing.*/
         	            
        while (stillGuessing)
        {
            if (computer.howManyBulls(guess) == 4){
            	/*If there are 4 bulls, we know all digits match
            	 * and the user is no longer guessing.*/
            	count ++; //Another guess has been made.
            	stillGuessing= false;
                }
            
            else{
            	/*Store bull and cow totals as integers. Make sure to
            	 * calculate bulls first because the number of cows
            	 * depends on whether there is already a bull of the same
            	 * value.
            	 */
            	int bulls1 = computer.howManyBulls(guess);
            	int cows1 = computer.howManyCows(guess);
            	//Print number of bulls and cows based on the user's guess.
            	System.out.println(" Bulls: " + bulls1 +
            			" Cows: " + cows1 + " ; Try again.");
            	guess = userInput.next(); //Take user input again.
            	count ++ ; //Another guess has been made.
            
                }
            }
            //User guessed correctly, so print number of tries.
        System.out.println("You guessed correctly after "+count+" tries.");
                     
    }

    public void playOneTurn(){
    // your code for the Game playOneTurn method goes here
    	/*Did not need this method*/

    }

    public void setPattern(String solution){
    // This method is complete. Don't touch it.
    // it is here to allow us and you to test your code. 
    // You should only use this method to help you test
    // your code while developing.

        computer.setPattern(solution);
    }

    public String getPattern(){
    // This method is complete. Don't touch it.
    // This method is here to allow us and you
    // to test your code. You should only use 
    // this method to help you test your code
    // while you are developing your program.

        return computer.getPattern();
    }



}
