CREDIT CARD

For Instance Variables:

I knew I needed three instance variables:

1. The string cardnum, which would represent the credit card number as a string
and be used in multiple methods to manipulate the digits as needed.
2. The integer errorCode, which would be initialized as 0 and changed only if
an error occurs, in which case it would be changed to the number corresponding to
that error.
3. The boolean isValid, which would be initialized as false and changed only if
there is no error (that is, only if errorCode = 0 after all the checks have been
done). I knew storing isValid as false and then checking if I should change it to true
was the most convenient way to store the boolean because then only ONE check 
needed to be done (is errorCode = 0?), rather than having multiple if statements. More robust way of
coding it.

For CreditCard() constructor method:

Initializes the string cardnum as the user-inputed card number string.
Initializes errorCode to the value 0, so that it only changes if an error occurs.
Initializes isValid to be false, so that only one check needs to be done on the
value of errorCode in check() method.

For check() method:

The check method checks if an error occurs, changes the value of errorCode to the corresponding
error number if an error does occur, and changes the boolean isValid to true if 
no error occurs.

To do the checks, I had to first parse all the necessary digits, which I did by
the substring(begin, end) method for each necessary digit or group of digits. Then I
had to convert these parsed digits into integers to do mathematical operations for the checks,
which I did by Integer.parseInt(string). I recognize that there might be a more
 efficient way to do this. For instance, converting the whole number into a list
 would definitely be more efficient, because then you could just specify the digits by 
their position in the list, but I didn't do that because we hadn't yet learned how to do lists in java.

Then, I used if statements to check if each of the 6 checks failed. I checked if they FAILED, not if
they were PASSED, because it is only when a check FAILS that the value of errorCode gets changed. For 
some of the operations needed, I stored them first as integers to make the if statements more concise
 and organized. If one of the checks failed, I changed the value of errorCode to match the number corresponding
to the check that failed.

At the end of the check() method, I checked if any error had occured with an if statement checking
the value of errorCode. If errorCode was still 0, as it was initialized in the constructor method, then
no error occurred and the value of the boolean isValid was changed to true. If errorCode's value was something other
than 0 (ie if an error had occurred), then isValid was left as false, as it was initialized in the
constructor method.

For the isValid method:

This simply returns the value of boolean isValid, which was determined in check().

For the getErrorCode() method:

This simply returns the value of the integer errorCode, which was initialized as 0 and 
unaltered if there was no error. If there was an error, then errorCode was changed to 
the integer corresponding to that error.