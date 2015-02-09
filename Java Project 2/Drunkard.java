//***************************
// By Benjamin Makansi - bkm2122
// October 6, 2014
// Programming Project 2 - Drunkard
//****************************
public class Drunkard{
	//Declare instance variables
	int avenue; //Used for current avenue location
	int street; //Used for current street location
	int initial_x; //Initial avenue location
	int initial_y; //Initial street location
	
	public Drunkard( int xvalue , int yvalue){
		/*Constructor method. Assigns user-inputed starting points
		 to corresponding instance variables. */
		avenue = xvalue;
		street = yvalue;
		initial_x = xvalue;
		initial_y = yvalue;
	}
	
	public void step() {
		/*Moves the drunkard one step in either
		the east, west, south or north direction,
		designated by a random integer between 0 and 3
		corresponding to each*/
		
		int direction = (int)(Math.random()*4);
		/*Randomly choose integer 0 through 3 to designate direction
		with equal probability:
		0 means move east
		1 means move west
		2 means move south
		3 means move north*/
		if ( direction == 0){ //MOVE EAST
			avenue = avenue - 1;
		}
		else if (direction == 1){ //MOVE WEST
			avenue = avenue + 1;
		}
		else if (direction == 2){ //MOVE SOUTH
			street = street - 1;	
		}
		else if (direction == 3){ //MOVE NORTH
			street = street + 1;
		}
		
							
		}
	public void fastForward( int steps){
		/* Moves the drunkard steps intersections from his current location
		by runs step() method steps number of times */
		int count = 1;
		/*Initialize count, which will
		keep track of how many times step() has been executed. */
		
		while (count <= steps){ //Stop once step() has been done 
			step();
			count++; /*Add one to count to show that
			step() has been executed again */
		}		
	}
	public String getLocation(){
		/* Gets current location of the drunkard by converting
		 * the avenue and street integers to strings and returning
		 * these coordinates as a string a string with avenue,street */

		String str_ave = String.valueOf(avenue);
		//Convert integer avenue to string

		String str_street = String.valueOf(street);
		//Convert integer street to string

		return str_ave + "," + str_street; //Return coordinates as string
	}
	public int howFar(){
		//Returns the distance in blocks from starting point
		int distance = Math.abs(avenue - initial_x) +
		 Math.abs(street - initial_y);
		return distance;
		
	}
}
