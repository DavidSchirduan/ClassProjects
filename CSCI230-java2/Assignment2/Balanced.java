package Homework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Author:   David Schirduan
Date:       9/29/10
Class:     CSCI-230 Java Programming
Assignment: Balanced/ homework2
Task:       learn how to use stacks
Input:      creation of an stack of ()[]
Output:     whether it is balanced or not
Certification of Authenticity:   
         I certify that this lab is entirely my own work.  
*/

public class Balanced {
    static GenericStack <CharacterGS> stak = new GenericStack<CharacterGS>();
    static File file = new File("/home/mercy/workspace/CSCI 230/src/Homework2/data.txt");
    static boolean isBalanced = true;
    
    public static void main(String[] args) { 
    	CharacterGS Lparen = new CharacterGS('('); //used to compare for the loop
    	CharacterGS Lsqu = new CharacterGS('['); //used to compare for the loop
    	//code taken from ScannerReadFile.java, and modified for this program
    	//scans the file
    	//needs to scan one char at a time
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) { 
                String s = scanner.nextLine();          //reads them in as a string
                for (int i = 0; i < s.length(); i++){
                    char chartest = s.charAt(i);        //converts from string to char
                    //if the char is '(' then it's pushed into the stack
                    if ((chartest == '(') || (chartest == '[')){
                    	CharacterGS chargs = new CharacterGS(chartest);
                    	stak.push(chargs);
                    }
                                        //if the char closes a parenthesis, then it pops the top of the stack
                    else if (chartest == ')'){

                    	if (stak.isEmpty()){	//in case ')' comes before another one
                        	isBalanced = false;
                    	}
                    	else if (stak.peek().isEqual(Lparen)){ //if it's not empty, then it pops the stack
                        	stak.pop();
                    	}
                    	
                    	else if (stak.peek().isEqual(Lsqu)){
                    		
                    	}
                    }
                    
                    else if (chartest == ']'){
                    	if (stak.isEmpty()){
                    		isBalanced = false;
                    	}
                    	
                    	else if (stak.peek().isEqual(Lparen)){
                    		while (!stak.isEmpty() && stak.peek().isEqual(Lparen)){
                    			stak.pop();
                    		}
                    		
                    		if (!stak.isEmpty() && stak.peek().isEqual(Lsqu)){
                    			stak.pop();
                    		}
                    	}
                    	else if (stak.peek().isEqual(Lsqu)){
                    		stak.pop();
                    	}
                    }
                }
                
                //goes through to make sure the stack is empty
                if (isBalanced && stak.isEmpty()){
                	System.out.println("This line is balanced");
                }
                
                else{
                    //show's that it's not balanced
                	System.out.println("This line is not balanced");
                }
                stak.reset();
            }     
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  
    }
}
