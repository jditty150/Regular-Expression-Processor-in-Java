// Jinesh Shah
// CSI 311 Principle of Programming Language
// Project 1: Regular Expression Proccessor in Java
import java.util.ArrayList;
// Be using array list
import java.io.*;
// Using the file reader
public class project1
{
    public static void main(String[] args)
    {
        // created the string class here and connected it with the command line argument
    	// where the regular expressions will be
    	String regularExpression = args[0];
    	// this is where I define the array list here it's called "whaat"
    	// This will be used as a way to create the states to store the regex operations
    	// into the states itself and store it
        ArrayList<String> whaat = new ArrayList<String>();
        // index  normal set up for array 
        int index = 0;
        // making temp normal set up for array and making the temp string into an empty set
        String temp = "";
        // using a truth value for regex for setting false conditions in place later down in the code
        // be using false for allowing that value to continue 
        boolean regexTruthValue = false;
        // numberLineDictate variable created for the actual line the code will read for the regex
        // when it is saying from output of the programming assignment information
        // "Match Found..."
        int numberLineDictate = 0;
        // startPoint variable created for the place the regex can first be looked at to start from
        // based on which regex value put into the argument which will say from programming
        // assignment information "Starting at..."
        int startPoint = 0;
        // endPoint variable created for the place the regex will end from whence it started
        // from which is based on which regex value put into the argument which will say
        // from the programming assignment information "ending at..."
        int endPoint = 1;
        // this will print out what's in the command line argument it will be the regex
        System.out.println(args[0]);
        // this will print out what's in the command line argument it will be the file
        System.out.println(args[1]);
       
        // this if statement is used for the very beginning of the state since most of the arguments that
        // will be made is for being in a loop with having if statements being the actual regex character
        // that will be stored instead of having an empty set that will be store
        // This if statement will store anything that is not an empty set into the states
        if(temp != "")
    	{
            whaat.add(temp);
            temp="";
    	}
        // will be creating a while loop
        // this loop will be called states since this is pretty much where the state where be created
        // this loop will keep on going when the states is less than the length of the regularExpression string
        // that was created earlier
        int states = 0;
        while( states < regularExpression.length())
        {
            // creating an if statement if the states does not equal the length of the regularExpression string 
        	// and  the character value that is being returned "+" 
        	if(states != regularExpression.length() -1 && regularExpression.charAt(states + 1) == '+')
            {
                // if the elements in the array is not an empty set
        		if(temp != "")
                {
                    // it will add elements from the array
        			whaat.add(temp);
                    // into the actual string that is part of the substring below in order to get the "+"
        			temp = regularExpression.substring(states, states + 1);
                    // which will add elements from the array
        			whaat.add(temp);
                    // until the array will be an empty set
        			temp = "";
                }
            }
        	// else if the states does not equal the length of the regular expression string and
        	// the character value that is being return "*"
        	else
        		if(states != regularExpression.length()-1 && regularExpression.charAt(states + 1) == '*')
        		{
        			// if the elements in the array is not an empty set
                    if(temp != "")
                    {
                    	// it will add elements from the array
                    	whaat.add(temp);
                    	// into the actual string that is part of the substring below in order to get the "*"
                        temp = regularExpression.substring(states, states + 1);
                        // which will add elements from the array
                        whaat.add(temp);
                        // until the array will be an empty set
                        temp = "";
                    }
        		}
        	// else if the character value that is returning is not the "+" regex character
        	else
        	    if(regularExpression.charAt(states) != '+')    
        	    {
        	    	
        	    	// the elements in the array will be the all of the elements in the states of the 
        	    	// array itself that does not have the "+" regex character in it
        	        temp = temp + regularExpression.charAt(states);
        	    }        
        	// else if the character value that is returning is not the "*" regex character
        	else
        	    if(regularExpression.charAt(states) != '*')
        	        {
        	    		// the elements in the array will be all of the elements in the states of the
        	    	    // array itself that does not have the "*" regex character in it
        	            temp = temp + regularExpression.charAt(states);
        	        }
            // else if the character value that is returning is the "[" regex character
        	else
                if(regularExpression.charAt(states) == '[')
                {
                	// if the elements in the array is not an empty set
                	if(temp != "")
                	{
                	    // it will add elements from the array
                		whaat.add(temp);
                        // the array will be adding elements from the string into the substring itself under
                		// the index of the "]" regex character which will be in the states
                		temp = regularExpression.substring(states, index = regularExpression.indexOf(']', states) + 1);
                        // making sure the states will be able to add both the "[" and the "]" character 
                		// without having the index be the same as the state and just adding one of the regex characters
                		states = index - 1;
                        // will continue to add elements from the array
                		whaat.add(temp);
                        // until the array itself becomes an empty set
                		temp = "";
                	}	
                }
        	// This is the end of the while loop for building up the states using the regex characters described earlier
        	// in the while loop
            states++;
        }
    
        // using try for more resources than just file reader
        try
        {
            // Be defining file reader to be used to read the text file 
        	// will be sending it to the command line argument used for reading the text file
        	FileReader fileReader = new FileReader(args[1]);
            // the buffered reader is defined here to the file reader
        	// this will help read the text in the text file assigned in the argument
        	BufferedReader bufferReader = new BufferedReader(fileReader);
            // we are creating a new regex string that is an empty set
        	String regex = ""; 
            // we are creating a character string to read the lines of the text file
        	String character;
        	// creating a while loop where the character line will be equal to the 
        	// line being read from the buffered reader while that value is not null
        	// and the length of the characters in the text file itself is not 0
            while((character = bufferReader.readLine()) != null && character.length() != 0)
            {
            	// creating another while loop inside the while loop above
            	// this while loop will tell us the character length of the file itself
            	// while the variable joy is less then the number of elements in the 
            	// the array list itself
                int joy = 0;
                while(joy < whaat.size())
                {
                	// if the starting point of where the character being read from the text file
                	// is greater than or equal to the length of the string that is in the text file
                	// defined by the while loop above 
                	if(startPoint >= character.length())
                    {
                		// then break the if statement right here
                        break;
                    }
                	// if the ending point of where the character being read from the text file
                	// is greater than or equal to the length of the string that is in the text file
                	// defined by the while loop above
                    if(endPoint >= character.length())
                    {
                    	// then break the if statement right here
                  	    break;
                    }
                    // if by using the regexTruthValue statement that has been defined as a boolean earlier
                    // to be in the false category
                    if(regexTruthValue)
                    {
                    	// setting the state value to be 0
                        states = 0;
                        // having the boolean regexTruthValue statement to be defined as false 
                        regexTruthValue = false;
                        // the program will repeat the while loop that has been stated earlier if it falls into the if
                        // statements that have been defined above and move on to the next if statements
                        continue; 
                    }
                    // this is where we define a new position for the regex characters to be returned to
                	regex = whaat.get(joy);
                	// if the regex length has been defined to be returned to is equal to 2 and the character that is being
                	// printed out from the array is the regex character "+"
                    if(regex.length() == 2 && regex.charAt(1) == '+' )
                    {
                    	// if the starting point of the characters is greater than or equal to the length of the
                    	// characters inside the text file
                    	if(startPoint >= character.length())
                        {
                    		// then break and end the if statement right here
                            break;
                        }
                    	// if the ending point of the characters is greater than or equal to the length of the 
                    	// characters inside the text file
                        if(endPoint >= character.length())
                        {
                        	// then break and end the if statement right here
                      	    break;
                        }
                        // if by using the regexTruthValue statement that has been defined as a boolean earlier
                        // to be in the false category 
                    	if(regexTruthValue)
                         {
                    		// by setting the states value to 0
                            states = 0;
                            // having the boolean regexTruthValue statement to be defined as false
                            regexTruthValue = false;
                            // the program will repeat the if statement of the "+" regex character inside of the
                            // while loop when being in the if statements above and continue on the next if statements 
                            // in the while loop below
                            continue;
                         }           
                        // if the boolean is true that it contains the string value at the specific index point identified
                    	if(character.contains(String.valueOf(regex.charAt(0))))
                        {
                    		// if the index identified that is being returned is equal to the end point
                        	if(character.indexOf(String.valueOf(regex.charAt(0)), endPoint) == endPoint)
                            {
                        		// using a while loop here
                        		// if the return character value which is the end point and that index value
                        		// is equal to the specified character that is being returned
                                while(character.charAt(endPoint) == regex.charAt(0))
                                {
                                	// then it will increment the end points 
                                	// in other words increment the ending position read from the text file
                                	endPoint++;
                                }
                            }
                        	// else if the state array itself is equal to 0
                        	else
                        		if(states == 0)
                        		{
                        			// creating another while loop here
                        			// if the returning charcater value of the specified index which
                        			// is end point + 1 is equal to the specified character value being 
                        			// returned
                        	        while(character.charAt(endPoint + 1) == regex.charAt(0))
                        	        {
                        	        	// then it will increment the end points
                        	        	// in other words increment the ending position read from the text file
                                        endPoint++;
                        	        }
                        	        // inside the states equal 0 if statement
                        	        // have the starting point be equal to the first occurence of the
                        	        // string that has been identified of the returning character value
                        	        startPoint = character.indexOf(String.valueOf(regex.charAt(0)), startPoint);
                        	        // once all of those conditions is placed inside the if statement have the 
                        	        // end point equal to the start point
                        	        // in other words have the ending position equal the starting position when being read
                                    endPoint = startPoint;
                        		}
                        	// else if that if statement of states does not apply
                            else
                            {
                            	// replace the character value that is being summoned to the substring
                            	// by the literal replacement sequences
                                character.replace(character.substring(0, endPoint), "");      
                            }
                        }
                    	// else if the boolean statement of the if statement does not follow the procedure right
                        else
                        {
                        	// then end the boolean if statement right here
                            break;
                        }    
                    }
                    // else if the regex character length is equal to 2 and it gives out the "*"
                    // regex character as well
                    else
                        if(regex.length() == 2 && regex.charAt(1) == '*' )
                        {
                        	// if the starting position is greater than or equal to the character length from the
                        	// text file itself
                    	 if(startPoint >= character.length())
                         {
                    		 // then end the if statement of the "*" regex character right here and now
                             break;
                         }
                    	 // if the ending position is greater than or equal to the character length from the 
                    	 // text file itself 
                         if(endPoint >= character.length())
                         {
                        	 // then end the if statement of the "*" regex character right here and now
                       	     break;
                         }
                         // if the regex truth value boolean value is given to be false
                         if(regexTruthValue)
                         {
                        	 // while the array states value itself is 0
                             states = 0;
                             // and inside the if statement the regex truth value boolean value is still fall
                             regexTruthValue = false;
                             // the program will repeat the if statement of the "*" regex character inside of the
                             // while loop when being in the if statements above and continue on the next if statements 
                             // while still being inside the while loop till it gets to what the program wants
                             continue;
                         }
                         // if the boolean character that is being contained in the string value below is true
                    	 if(character.contains(String.valueOf(regex.charAt(0))))
                    	 {
                    		 // if the character is being return to the sub string value of it's first occurence
                    		 // that has been shown is equal to the ending position
                    		 if(character.indexOf(String.valueOf(regex.charAt(0)),endPoint) == endPoint)
                    		 {
                    			 // creating a while loop here
                    			 // while the returning character specified in the while loop is coming back 
                    			 // to the appropriate index value and it is equal to the regex character that is
                    			 // being returned
                                 while(character.charAt(endPoint) == regex.charAt(0))
                                 {
                                	 // it will increment the end point
                                	 // in other words keep on incrementing the ending position of the matches 
                                	 // found from text file
                                     endPoint++;
                                 }
                    		 }
                    		 // else if the state array is equal to 0
                    	     else
                    		     if(states == 0)
                    		     {
                    		    	 // creating another while loop here
                    		    	 // while the character that is returning to the index value specified
                    		    	 // below is equal to the regex character returning from the array
                            	     while(character.charAt(endPoint + 1) == regex.charAt(0))
                            	     {
                            	    	 // it will increment the end point
                            	    	 // in other words increment the ending postion from the text file
                                         endPoint++;
                            	     }
                            	     // in the state = 0 if statement the starting position of the match
                            	     // will be equal to string value that is being return to the substring
                            	     // from its first occurence
                            	     startPoint = character.indexOf(String.valueOf(regex.charAt(0)), startPoint);
                                     // in the state = 0 if statement the ending position will equal the starting position
                            	     // while all of the conditions above has been met
                                     endPoint = startPoint;
                    		     }
                    		 // else if neither the first two if statement is valid then 
                             else
                             {
                            	 // the character string will be replacing the string to the be matched
                            	 // the specified literal replacement will occur
                                 character.replace(character.substring(0, endPoint), "");     
                             }
                    	 }
                    	 // else if the if statement for the regex character for "*" does not work
                    	 else
                    	{
                    		 // then end that if statement for the regex character for "*" right here
                    		 break;
                    	}
                        }
                        // else if the regex character being returned is the "[" and the regex character being returned
                        // is the "]" 
                        else
                            if(regex.charAt(0) == '[' && regex.charAt(regex.length() - 1) == ']')
                            {
                            	// if the staring position is greater than of equal the character length from the 
                            	// text file
                            	if(startPoint >= character.length())
                                {
                            		// then end the regex if statement right here
                                    break;
                                }
                            	// if the ending position is greater than or equal to the character length of the
                            	// text file itself
                                if(endPoint >= character.length())
                                {
                                	// then end the regex if statement right here
                              	    break;
                                }
                                // if the regex truth value boolean value is false for the regex character 
                    	        if(regexTruthValue)
                    	        {
                    	        	// when the state array is equal to 0
                                    states=0;
                                    // and when the regex truth value boolean value is still false
                                    regexTruthValue=false;
                                    // then the code will continue to run inside of the big while loop that is inside of it 
                                    // and will continue onto other if statements that is inside of the while loop
                                    // so that the code does not end
                                    continue;
                    	        }
                    	        // creating a while loop here 
                    	        // having a new integer value defined
                    	        // while this integer is less that the regex character length 
                                int regexWorth = 0;
                    	        while(regexWorth < regex.length())
                    	        {
                    	        	// of the character being contained in the string has the boolean value of true
                                    if(character.contains(String.valueOf(regex.charAt(regexWorth))))
                                    {
                                    	// if the character length of the file is equal to 0
                            	        if(joy == 0)
                            	        {
                            	        	// the starting position is equal to the character value that is being returned to 
                            	        	// the substring based on the strings first occurence
                                            startPoint = character.indexOf(String.valueOf(regex.charAt(regexWorth)), startPoint);
                                            // while these conditions apply the ending position that is matched from text file
                                            // will be equal to the starting position of the text file + 1
                                            endPoint = startPoint+1;
                                            // if that if statement does not work out for the file character length then end it
                                            // right here and now
                                            break;
                            	        }
                            	        // if the character string that is being return to the sub string based on the 
                            	        // first occurence of that string itself is equal to the ending position of the
                            	        // file itself
                            	        if(character.indexOf(String.valueOf(regex.charAt(regexWorth)), endPoint) == endPoint)
                            	        {
                            	        	// the ending position is equal to the character string that is being returned
                            	        	// to the sub string based on the first occurence of that string itself + 1
                                            endPoint = character.indexOf(String.valueOf(regex.charAt(regexWorth)), startPoint) + 1;
                                            // of the if statement does not apply then end the if statement right here and now
                                            break;
                            	        }
                            	        // else if the two if statement above does not work then
                                        else
                                        {
                                        	// the have the character string replace the literal strings that is meant to be
                                        	// the specified literal replacement sequence 
                                            character.replace(character.substring(0,endPoint), "");
                                            // it will continue to move onto the other if statements inside of the boolean if 
                                            // statement above so that the program does not end too fast and continues searching
                                            continue;
                                        }
                                    }
                                    // else if the boolean value is not true from the if statement above
                                    // then it will have the regexWorth variable to be equal to the character length of the
                                    // regex itself         
                                    else 
                            	        if(regexWorth == regex.length())
                            	        {
                            	        	// then end this entire if statement right here and now 
                            		        break;
                            	        }
                                    // having the regexWorth be incremented here so the while loop can be valid
                                    regexWorth++; 
                    	        }
                            }
                    // else if the character string is being contained in the regex string
                    else
                    	if(character.contains(regex))
                        {
                    		// if the string that is being returned to the character index based on the first 
                    		// occurence of that string is equal to the ending position
                            if(character.indexOf(regex, endPoint) == endPoint)
                            {
                            	// the end positon is equal to the character string that is being returned to the index
                            	// based on the first occurence of that string + the length of the regex string 
                                endPoint = character.indexOf(regex, endPoint) + regex.length();
                            }
                            // else if the state array is equal to 0  
                            else
                                if(states == 0)
                                {
                                	// the starting position is equal to the character string that is being returned
                                	// to the index based on the first occurence of that string
                                    startPoint = character.indexOf(regex, startPoint);
                                    // the ending positon is equal to the length of the regex string + the starting position 
                                    endPoint = regex.length() + startPoint;
                                }
                                // else if the pevious if statements don't work then
                                else
                                {
                                	// the character string will replace the substring that has been defined below 
                                	// by having the specified literal string replaced from the sequence
                                    character.replace(character.substring(0, endPoint), "");  
                                }
                        }
                        // else if the major if statement that contains the regex string does not work
                        else
                        {
                        	// then end the if statement section of the code right here that is inside this while loop
                            break;
                        }
                    // having the joy variable being incremented to make the while loop valid
                    joy++;     
                }
                // if the regex character string is equal to the whaat array elements that are being returned to - 1
                if(regex == whaat.get(whaat.size() - 1))
                {
                	// then it will print out "Match found on... " and say the line number + 1
                	System.out.print("Match found on character : " + (numberLineDictate + 1));
                	// it will print out "staring at..." and say the the number of what positions the start of the regex
                	// character has been matched
                	System.out.print(" starting at position " + startPoint);
                	// it will print out "and ending at..." and say the number of what position of the end of the regex
                	// character has been matched
                	System.out.print(" and ending at position " + endPoint);
                	// it will print out the character string that is supposed to be printed from the text file itself
                	System.out.println(" : " + character.substring(startPoint, endPoint));
                }
                // from the huge while loop above it will increment the numberLineDictate to make it valid
                numberLineDictate++;
                // it will increment the starting Point to make the while loop above valid
                startPoint++;
                // it will increment the ending point to make the while loop above valid
                endPoint++;
            }
            // this is where we close the file reader to have the text file close
            fileReader.close();
            // this is where we close the buffered reader to have the characters close from the text file
            bufferReader.close();
        }
        // will be having an exception clause to be catched here
        // this will help catch any type of exception that comes from the text file file reader things
        catch(IOException reject)
        {
        	// this will print the error and find it the error stream
            reject.printStackTrace();
        }
    }
}
