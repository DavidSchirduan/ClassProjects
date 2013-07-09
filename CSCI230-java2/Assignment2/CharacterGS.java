package Homework2;

/*Author:   David Schirduan
Date:       9/29/10
Class:     CSCI-230 Java Programming
Assignment: Balanced/ homework2
Task:       learn how to use stacks
Input:   ds   creation of an stack of ()[]
Output:     whether it is balanced or not
Certification of Authenticity:   
         I certify that this lab is entirely my own work.  
*/

public class CharacterGS implements GenericNode {
	private char ch = 'X';
	
	public CharacterGS(char c){
		ch = c;
	}
	
	public char getChar(){
		return ch;
	}
	
	public void setChar( char newchar){
		ch = newchar;
	}
	
	public CharacterGS deepCopy(){
		CharacterGS clone = new CharacterGS(ch);
		return clone;
	}
	
	public String toString(){
		String s = ("the char is" + ch);
		return s;
	}
	
	public boolean isEqual(CharacterGS compare){
		if (ch == compare.ch){
			return true;
		}
		else{
			return false;
		}
	}
}
