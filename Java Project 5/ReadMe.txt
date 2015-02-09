ReadMe for Programming Project 5

Benjamin Makansi - bkm2122

EffectsTest.java

EffectsTest() method:
Constructor method. Takes Effects object effects as an argument and makes
it available to use in the main.

main() method:
Main method. Asks user for images to be filtered and desired output file name.
Given the list of filenames, it creates an array of strings containing the
file names and an array of file objects. Writes the new file using methods
 in Effects.java and then allows the option of flipping the image horizontally
 or converting it to greyscale.


Effects.java

-Effects() method:
This is my constructor method, which I used to instantiate the array of filenames
which was created in EffectsTest.java main method based on the user's input.

-filter() method.
Given an array of file objects and a desired output filename, writes the new
file. Adds each file's R,G, and B values to big arrays containing all file's R,G,and B
values. I compared these RGB values to find the desired values, then have them put in order
into one big string array and then write them into a file whose name is passed as
an argument.

-writeFile() method:
Writes the modified string array containing all RGB values to a file,
whose desired name is passed as an argument.

-putInOrder() method:
Given the arrays with all the red, green and blue values, this method puts them
in RGB form in one big string array and returns it.

-getRGBarraysForOneImage() method:
Reads a file, whose name is taken as a string argument,	line by line. 
Each line is added to an ArrayList which is then separated into three
 big arrays, each containing all the red, green and blue values for that
 file. Then each R,G,and B array is added to an ArrayList of String arrays
 for all the files being used.

-findMode() method:
Finds the desired R,G,and B values by comparing the R,G, and B values
 of all files. If a value occurs twice in different files,
it must be the desired value. These desired values are then stored
 in one big string array and returned.

-arrayHorizontal() method:
Just reverses the order of a string array.

-divideRows() method:
Uses the known number of columns and rows to divide each long R,G,and B
 array into separate rows, each stored as a string array in an ArrayList
 of string Arrays.


-flipHorizontal() method:
Flips the newly created image horizontally. Divides each array of R,G,and B
 values into their separate rows, and each row is stored as its own ArrayList
 of string arrays. Each row is reversed and stored in order in a big string
array, which is then written to a new file.

-greyScale() method:
Converts newly created image to greyscale. Uses string array already made
for the new image, converts it to an integer array, finds the avg value 
for each RGB and puts them into a string array which is then written 
to a new greyscale image file.