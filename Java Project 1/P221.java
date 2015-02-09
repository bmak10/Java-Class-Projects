//*****************************
// Programming Project 1 - P2.21
// September 22, 2014
// By Benjamin Makansi - bkm2122
//*****************************

import java.util.Scanner;

public class P221{

	public static void main(String[] args) {
		Scanner input1 = new Scanner(System.in);
		System.out.println("What is the amount due in cents?");
		int cost = input1.nextInt();
		Scanner input2 = new Scanner(System.in);
		System.out.println("How much did the customer give you in cents?");
		int paid = input2.nextInt();


		int difference = paid - cost;

		if (difference < 0){
			System.out.println("Sorry, but the customer did not pay enough.");
		}

		else if (difference==0){
			System.out.println("The customer gave exact change. Woohoo!");
		}

		else {
			int dollars = difference/100;
			int remainder_dollars = difference - dollars*100;
			int quarters = remainder_dollars/25;
			int remainder_quarters = remainder_dollars - 25*quarters;
			int dimes = remainder_quarters/10;
			int remainder_dimes = remainder_quarters - 10*dimes;
			int nickels = remainder_dimes/5;
			int remainder_nickels = remainder_dimes - 5*nickels;
			int pennies = remainder_nickels;
			System.out.println("Give the customer " + dollars + " dollars, "
			 + quarters + " quarters, " + dimes + " dimes, " + nickels +
			  " nickels, and " + pennies + " pennies. ");

		}


	}
}