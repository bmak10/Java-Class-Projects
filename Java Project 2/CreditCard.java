//********************************
// By Benjamin Makansi - bkm2122
// October 6, 2014
// Checks if credit card number is valid
//********************************

public class CreditCard{
	//Instance Variables
	String cardnum; //Store the credit card number
	int errorCode; //Store corresponding number of error
	Boolean isValid; //Store a boolean indicating whether valid
	
	public CreditCard(String user_cardnum){
		/*Constructor method. Take in string and
		assign to instance variable cardnum*/
		cardnum = user_cardnum; //Assign to instance variable cardnum
		errorCode = 0; /*Initialize errorCode default value as 0.
		Will not change unless error occurs*/
		isValid = false; /*Initialize as false.
		Will not change unless no error occurs.*/
	}
	
	public void check(){
		/*Checks if an error occurs.
		 If no error occurs, isValid becomes true.*/
		
		//Parse all necessary digits
		String digit_1 = cardnum.substring(0,1);
		String digit_2 = cardnum.substring(1,2);
		String digit_3 = cardnum.substring(2,3);
		String digit_4 = cardnum.substring(3,4);
		String digit_5 = cardnum.substring(4,5);
		String digit_6 = cardnum.substring(5,6);
		String digit_7 = cardnum.substring(6,7);
		String digit_8 = cardnum.substring(7,8);
		String digit_9 = cardnum.substring(8,9);
		String digit_10 = cardnum.substring(9,10);
		String digit_11 = cardnum.substring(10,11);
		String digit_12 = cardnum.substring(11,12);
		String first_2 = cardnum.substring(0,2);
		String str7and8 = cardnum.substring(6,8);
		
		//Convert to integers
		int int_1 = Integer.parseInt(digit_1);
		int int_2 = Integer.parseInt(digit_2);
		int int_3 = Integer.parseInt(digit_3);
		int int_4 = Integer.parseInt(digit_4);
		int int_5 = Integer.parseInt(digit_5);
		int int_6 = Integer.parseInt(digit_6);
		int int_7 = Integer.parseInt(digit_7);
		int int_8 = Integer.parseInt(digit_8);
		int int_9 = Integer.parseInt(digit_9);
		int int_10 = Integer.parseInt(digit_10);
		int int_11 = Integer.parseInt(digit_11);
		int int_12 = Integer.parseInt(digit_12);
		int int_1st_2 = Integer.parseInt(first_2);
		int int_78 = Integer.parseInt(str7and8);

		/*store some of the operations as integers to make
		the if-statements more concise and organized*/
		int product159 = int_1*int_5*int_9;
		int sum = int_1+int_2+int_3+int_4+int_5
				+int_6+int_7+int_8+int_9+int_10+
				int_11+int_12;
		int first_4 = int_1+int_2+int_3+int_4;
		int last_4 = int_9+int_10+int_11+int_12;
		
		if (int_1 != 4){
			//Check first requirement
			errorCode = 1;
		}
		else if (int_4 <= int_5){
			//Check second requirement
			errorCode = 2;
		}
		else if (product159 != 24 ){
			//Check third requirement
			errorCode = 3; //If fails, assign 3 to errorCode
		}
		else if (sum%4 != 0){
			//Check if fourth requirement fails.
			errorCode = 4; //If fails, assign 4 to errorCode
		}
		else if (first_4 != last_4 - 1){
			//Check if fifth requirement fails.
			errorCode = 5; //If fails, assign 5 to errorCode
		}
		else if (int_1st_2 + int_78 != 100){
			//Check if sixth requirement fails.
			errorCode = 6; //If fails, assign 6 to errorCode
		}
		
		if (errorCode == 0){
			//Check if an error has not occurred.
			//If error has not occurred, change isValid to true.
			isValid = true;
			}
		}
		
	public Boolean isValid(){
		/*Indicates whether card number is valid by
		 returning boolean isValid*/
		return isValid;
	}
	
	public int getErrorCode(){
		/*Indicates which error occurred if the card
		number was invalid. */
		return errorCode;
	}
		
		
		
		
	}
