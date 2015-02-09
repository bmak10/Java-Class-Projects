//********************
//Programming Project 5
//By Benjamin Makansi
//**********************

import java.io.*;
import java.util.*;

public class Effects
{
	public static String[] localStringArray;

	/*ArrayLists of string arrays to store all red values together,
	blue values together, and green values together*/
	public static ArrayList<String[]> allReds = new ArrayList();
	public static ArrayList<String[]> allGreens = new ArrayList();
	public static ArrayList<String[]> allBlues = new ArrayList();

	//To store special values at the top of the file
	public static String magicNumber;
	public static String rows;
	public static String columns;
	public static String max_value;

	//To store the final R,G and B values after unwanted values are removed.
	public static String[] finalReds;
	public static String[] finalGreens;
	public static String[] finalBlues;

	//To store the final array of strings to be written to the file.
	public static String[] finalString;

	//To store desired filename to be available throughout the class.
	public static String overallFile;

	public Effects(String[] filenameArray){
		/*Constructor method. Takes an array of file objects
		 * and an array of strings and makes them available for use
		 * throughout the class.*/
		localStringArray = filenameArray;
		}

	public static void filter(File[] fileArray, String newFile)
	throws IOException
	{ /*Given an array of file objects and a desired output filename,
		writes the new file. Adds each file's R,G,and B values
		to big arrays containing all files' R,G, and B values.
		Compares RGBs to find the desired values, puts them in order
		in one big string array, and then writes them to a file whose
		name is passed as an argument. */
		
		overallFile=newFile;
		for (int i=0; i<localStringArray.length;i++){
 		/*Each file's reds, greens, and blues are added
 		 to allReds, allGreens, and allBlues
 		*/	getRGBarraysForOneImage(localStringArray[i]);
			}

		//findMode() is called on each to get rid of unwanted RGB values		
			finalReds = findMode(allReds);
			System.out.println("Final red values calculated.");
			finalGreens = findMode(allGreens);
			System.out.println("Final green values calculated.");
			finalBlues = findMode(allBlues);
			System.out.println("Final blue values calculated.");
			
		//put R,G and B values in one big string array to be written to file
			finalString= putInOrder(finalReds,finalGreens,finalBlues);
			writeFile(finalString,overallFile);
			
	}

	public static void writeFile(String[] writeString,String newFile)
	 throws FileNotFoundException, UnsupportedEncodingException{
	 	/*Writes the modified string array containing all RGB values to
	 	a file, whose desired name is passed as an argument.
	 	*/

		StringBuilder builder = new StringBuilder();
		for (String num : writeString){
			builder.append(num+" ");
		}
		String text = builder.toString();
		System.out.println("Writing to "+newFile+".");
		PrintWriter writeObject = new PrintWriter(newFile, "UTF-8");
		writeObject.println(text);
		writeObject.close();
		System.out.println(newFile+" completed.");
	}

	public static String[] putInOrder(String[] reds, 
		String[] greens, String[] blues){
		/* Given arrays with all the red, green and blue values, puts
		them in RGB form in one big String array and returns it.
		*/

		String[] inOrder = new String[reds.length+greens.length+blues.length+4];
		inOrder[0] = magicNumber;
		inOrder[1] = columns;
		inOrder[2] = rows;
		inOrder[3] = max_value;
		int j=4;
		int k=5;
		int l=6;
		for (int i=0; i<reds.length;i++){
			inOrder[j]=reds[i];
			inOrder[k]=greens[i];
			inOrder[l]=blues[i];
			j=j+3;
			k=k+3;
			l=l+3;				
		}
		return inOrder;

		
	}

	public static void getRGBarraysForOneImage(String filename)
	throws IOException{
		/*Reads a file, whose name is taken as a string argument,
		line by line. Each line is added to an ArrayList which is then
		separated into three big arrays, each containing all the red,
		green and blue values for that file. Then each R,G,and B array is
		added to an ArrayList of String arrays for all the files being used.
		*/

		//Make file readable
		FileInputStream read_file = new FileInputStream(filename);
		BufferedReader buffered_file = 
		new BufferedReader(new InputStreamReader(read_file));
		
		String line;
		ArrayList lineSplitted = new ArrayList(); //Where all lines are stored.
	
		/*Read each line and add to the ArrayList lineSplitted
		 containing all lines*/
		while(((line=buffered_file.readLine())!=null)) //while there is a line
		{
			if (line.contains(" ")) //if the line contains a space
			{
				StringTokenizer st = new StringTokenizer(line); 
				//split into StringTokenizer objects
			while (st.hasMoreTokens()) //until it runs out of tokens
			{
				lineSplitted.add((st.nextToken()).toString()); 
				//add each token to the arraylist lineSplitted
			}}
			else //if line doesn't contain a space
			{
				lineSplitted.add(line); 
				//just add that line to the arraylist lineSplitted
			}
	
		}

		//Store the the first 4 terms, which aren't RGB values.	
		magicNumber = (lineSplitted.get(0)).toString();
		columns = (lineSplitted.get(1)).toString();
		rows = (lineSplitted.get(2)).toString();
		max_value = (lineSplitted.get(3)).toString();
		
		String[] redValues = new String[(lineSplitted.size()-4)/3];
		String[] greenValues = new String[(lineSplitted.size()-4)/3];
		String[] blueValues = new String[(lineSplitted.size()-4)/3];
		int j=4;
		int k=5;
		int l=6;
		for (int i = 0; i<redValues.length; i++)
		{
			redValues[i]=((lineSplitted.get(j)).toString());
			greenValues[i]=((lineSplitted.get(k)).toString());
			blueValues[i]=((lineSplitted.get(l)).toString());
			j = j+3;
			k=k+3;
			l=l+3;
		}

		/*Add each newly created R,G,and B string array
		 to each ArrayList containing the RGB values for all files
		 */
		allReds.add(redValues);
		allGreens.add(greenValues);
		allBlues.add(blueValues);
		

		}
	public static String[] findMode(ArrayList<String[]> values1){
		/*Finds the desired R,G,and B values by comparing the
		R,G, and B values of all files. If a value occurs twice in
		different files, it must be the desired value. These desired
		values are then stored in one big string array and returned.
		*/

		String[] valuesString = new String[(values1.get(0)).length];
		for (int i=0;i<values1.size();i++) {
			for (int j=0;j<values1.size();j++){
				for (int k=0;k<valuesString.length;k++){					
				if ((((values1.get(i))[k]).equals((values1.get(j))[k]))&&i!=j){
					valuesString[k]=((values1.get(i))[k]);					
				}
				}}
		}
			return valuesString;
	}
	public static String[] arrayHorizontal(String[] indArray){
		//Reverses order of a string array.
		
		String temp;
		int size=indArray.length;
		for (int i=0;i<size/2;i++){
			temp = indArray[i];
			indArray[i]=indArray[size-1-i];
			indArray[size-1-i]=temp;
		}
			return indArray;
	}
	public static ArrayList<String[]> divideRows(String[] rgbArray){
		/*Uses the known number of columns and rows to divide
		 each long R,G,and B array into separate rows,
		each stored as a string array in an ArrayList of string Arrays.
		*/
		ArrayList<String[]> rowsArrays= new ArrayList();
		int columns_int=Integer.parseInt(columns);
		int rows_int=Integer.parseInt(rows);
		for (int i=1;i<rows_int;i++){
			rowsArrays.add(Arrays.copyOfRange(rgbArray,
				((i-1)*columns_int),(i*columns_int)));	
			
	}

		return rowsArrays;
	}
	public static void flipHorizontal()
	throws FileNotFoundException, UnsupportedEncodingException{
		/*Flips the newly created image horizontally.
		Divides each array of R,G,and B values into their separate
		rows, and each row is stored as its own ArrayList of string arrays.
		Each row is reversed and stored in order in a big string array, which
		is then written to a new file.
		*/

		System.out.println("Flipping image horizontally.");

		//Store rows as string arrays in an ArrayList.
		ArrayList<String[]> redRows = divideRows(finalReds);
		ArrayList<String[]> greenRows = divideRows(finalGreens);
		ArrayList<String[]> blueRows = divideRows(finalBlues);


		String[] horizontalReds=new String[finalReds.length];
		String[] horizontalGreens=new String[finalGreens.length];
		String[] horizontalBlues=new String[finalBlues.length];
		//Reverse the order of each row.
		for (int i=0;i<redRows.size()-1;i++){
			String[] tempArray=arrayHorizontal(redRows.get(i));
			int beginIndex = (i)*tempArray.length;
			System.arraycopy(tempArray, 0, horizontalReds, beginIndex,
			 tempArray.length);
		}		
		for (int i=0;i<greenRows.size()-1;i++){
			String[] tempArray=arrayHorizontal(greenRows.get(i));
			int beginIndex = (i)*tempArray.length;
			System.arraycopy(tempArray, 0, horizontalGreens, beginIndex,
			 tempArray.length);			
		}		
		for (int i=0;i<blueRows.size()-1;i++){
			String[] tempArray=arrayHorizontal(blueRows.get(i));
			int beginIndex = (i)*tempArray.length;
			System.arraycopy(tempArray, 0, horizontalBlues, beginIndex,
			 tempArray.length);			
		}		
		System.out.println("RGB values flipped.");

		//Put flipped rows in order in one big string array.
		String[] horizontalOrder = putInOrder(horizontalReds,horizontalGreens,
			horizontalBlues);

		//Write new horizontally flipped file.
		System.out.println("RGB values put in order.");
		String horizontalFile="horizontal"+overallFile;
		System.out.println("Writing "+horizontalFile+".");
		writeFile(horizontalOrder,horizontalFile);
	}

	public static void greyScale() 
	throws FileNotFoundException, UnsupportedEncodingException{
		/*Converts newly created image to greyscale.
		Uses string array already made for the new image, converts
		it to an integer array, finds the avg value for each RGB and
		puts them into a string array which is then written to a new
		greyscale image file.
		*/

		String[] greyStringArray=finalString;

		//Make int[] same size to store RGB values as integers
		int[] greyInt = new int[greyStringArray.length];

		for (int i=4;i<greyStringArray.length;i++){
			greyInt[i]=Integer.parseInt(greyStringArray[i]);									
		}

		//Using integer array, find avg for each RGB
		for (int i=0;i<(greyInt.length-3)/3;i++){
			int red=greyInt[3*i+4];
			int green=greyInt[3*i+5];
			int blue=greyInt[3*i+6];
			int average=(red+green+blue)/3;
			greyInt[3*i+4]=average;
			greyInt[3*i+5]=average;
			greyInt[3*i+6]=average;
			}

		//convert back to string array with new avg values
		for (int i=4;i<greyInt.length;i++){
			greyStringArray[i]=String.valueOf(greyInt[i]);
		}

		//Write greyscale file.
		String greyFileName="grey"+overallFile;
		writeFile(greyStringArray,greyFileName);
	}

}
