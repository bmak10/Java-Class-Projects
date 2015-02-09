ReadME - Drunkard.java

Explanation of instance variables:

The avenue and street variables obviously needed to be used in several methods
so I declared them as integer instance variables.

I also knew that I would have to somehow store the initial position of the
drunkard to calculate the distance in howFar(), so I declared two more 
instance variables, initial_x and initial_y.

For the Drunkard() method:

I stored the initial avenue and street positions in variables called avenue
and street, which could then be altered by the step() method because they are
instance variables.

I also stored the initial avenue and street positions in the instance 
variables called initial_x and initial_y, which would not be altered by any
method, so that I could later find the distance in howFar().

For step() method:

I knew I needed there to be an equal probability that the drunkard move in each
of the four directions. And I knew the four directions he could move in: negative/positive
avenue direction, and negative/positive street direction. I used Math.random()*4 to
generate a random integer, stored as int direction, from 0 to 3 (inclusive),
each of which is equally probably, and each of which corresponds to one of the
 four grid directions the drunkard can move. To execute the move, I wrote 4 if
 statements which change the value of avenue or street depending on the value of the
integer variable, direction.

For fastForward() method:

This simply executes the step() method steps number of times. To make sure that
step() is executed steps times, I set up a while loop with a counter that increases
by one each time step() is executed, and the while loop stops as soon as count becomes
greater than steps.

For getLocation() method:

This simply returns the avenue and street coordinates as a string. To do that,
I had to convert the avenue and street integer variables to string variables
using the String.valueOf(integerToBeConverted) method, and stored the results as
local variables. After converting them to strings, I was able to return one string
with the two coordinates (strings) concatenated.

For howFar() method:

The only thing this method returns is the distance in blocks, which is found by taking
the sum of the absolute values of the differences between the drunkard's current coordinates
and the drunkard's initial coordinates. This is why I had to store the initial coordinates as
separate instance variables, initial_x and initial_y. I stored the distance in blocks as an integer
variable, distance, and returned it.
