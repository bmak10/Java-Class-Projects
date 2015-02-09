//**********************************************
// By Benjamin Makansi - bkm2122
// October 21, 2014
// Programming Project 3
//**********************************************


import java.util.Random;

public class Oracle{
    
    private String solution;
    String bullString; /*Stores bulls to later check agains cows*/

    public Oracle(){
    	//Constructor method
	
    	Random randomDigit = new Random();
    	
    	//Randomize the computer's 4-digit number
    	String digit1 = Integer.toString(randomDigit.nextInt(9));
    	String digit2 = Integer.toString(randomDigit.nextInt(9));
    	String digit3 = Integer.toString(randomDigit.nextInt(9));
    	String digit4 = Integer.toString(randomDigit.nextInt(9));
    	
    	solution = digit1+digit2+digit3+digit4; /*Concatenate digits into 
                                                 *one string*/
   
    	while ((digit1 == digit2 )|| (digit1 == digit3) || (digit1==digit4) ||
    			(digit2==digit3) || (digit2==digit4) || (digit3==digit4))
        {//Generate another 4-digit number until there are no repeating digits
    		String new1 = Integer.toString(randomDigit.nextInt(9));
            String new2 = Integer.toString(randomDigit.nextInt(9));
            String new3 = Integer.toString(randomDigit.nextInt(9));
            String new4 = Integer.toString(randomDigit.nextInt(9));
            solution = new1 + new2 + new3 + new4;
        }
    
    }
    
    public void setPattern(String solution){
    // This method is complete. Don't touch it.
    // This method is here to allow us and you
    // to test your code. You should only use 
    // this method to help you test your code
    // while you are developing your program.

        pattern = solution;
    }

    public String getPattern(){
    // This method is complete. Don't touch it.
    // This method is here to allow us and you
    // to test your code. You should only use 
    // this method to help you test your code
    // while you are developing your program.

        return pattern;
    }

    public int howManyBulls(String guess){
    /*Iterates over the String solution and the String guess
     * to return the number of bulls.*/
    	
        int bullTotal = 0;
        
        for (int i = 0; i<solution.length(); i++){
        	/*For each digit in String solution,
        	 *iterate over String guess to compare.*/
        	
            for (int j = 0; j<guess.length(); j++){
            	//For each item in String solution
            	
                if (solution.charAt(i)==guess.charAt(j) && i == j){
                	/*guess digit must have the same value and position
                	 * as in String solution to be a bull*/
                	bullString = bullString + guess.charAt(j);
                	
                	          	
                    bullTotal = bullTotal + 1;
                }
            }
            }
        return bullTotal;

        }

    public int howManyCows(String guess){
        /*Iterates over the String solution and the String guess
         * to return the number of cows.*/
    	
        int cowTotal = 0;
        
        for (int i = 0; i < 4 ; i++){
        	/*For each digit in String solution,
        	 * iterate over String guess.*/
        	
            for(int j = 0; j < 4 ; j++){
            	
                if((solution.charAt(i)==guess.charAt(j)) && (i!=j) &&
                		(!(bullString.contains(guess.substring(j))))){
                	/*Digit is a cow if it is found in String guess
                	 * but not in the same position.*/
                	
                    cowTotal++;
                    j=4; //End nested loop so cow isn't counted twice
                }
            }
        }
        return cowTotal;
    }
}