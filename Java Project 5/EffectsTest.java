//********************
//Programming Project 5
//By Benjamin Makansi
//**********************
import java.util.*;
import java.io.*;

public class EffectsTest
{
	private Effects effects;
	public static File[] fileObjects;
	public static String inputString;


	public EffectsTest(Effects effects){
		/*Constructor method. Takes Effects object effects
		as an argument and makes it available to use in the main.*/
		this.effects = effects;
	}	
	public static void main(String[] args) throws IOException
	{ /*Main method. Asks user for images to be filtered and desired output
		file name. Writes this new file using methods in Effects.java
		and then allows the option of flipping the image horizontally or
		converting it to greyscale.*/

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the names of your files,"+ 
			" separated by spaces: ");

		//take the entire line of input and store it in the string inputString
		inputString = input.nextLine();
		Scanner newFileAsk = new Scanner(System.in);
		System.out.println("Enter desired output filename, with extension: ");
		String newFileInput = newFileAsk.nextLine();

		//Split up inputString into the separate filenames
		String[] elements = inputString.split(" ");

		//and store those as separate elements in an array elements[]
		fileObjects = new File[elements.length];
		//fileObjects[] is empty array whose size is the same as elements[]
		
		for (int i=0; i<elements.length;i++)
		{
			//store each filename as a file object in fileObjects[]
			fileObjects[i] = new File((elements[i]));
		}
		Effects effects = new Effects(elements);

		//Make new desired file with desired filename.
		effects.filter(fileObjects, newFileInput);

		//Ask if the user wants to flip the image horizontally.
		Scanner horizontal=new Scanner(System.in);
		System.out.println("Flip horizontal? Enter 'y' or 'n'.");
		String horString=horizontal.nextLine();
		if (horString.equals("y")==true){ //if yes, flip image horizontally
			System.out.println("Will now flip horizontal.");

			effects.flipHorizontal();
		}

		//Ask if the user wants to convert the image to greyscale.
		Scanner grey=new Scanner(System.in);
		System.out.println("Greyscale? Enter 'y' or 'n'.");
		String greyString=grey.nextLine();
		if (greyString.equals("y")==true){ 
		//If yes, convert the image to greyscale.
			System.out.println("Will now convert to greyscale.");
			effects.greyScale();
		}
		System.out.println("Processing completed.");
		}
}
