package Homework3;
/*Author:   David Schirduan
Date:       10/29/10
Class:     CSCI-230 Java Programming
Assignment: Hydralist
Task:       learn how to use a data structure
Input:      autopart
Output:     creates a hydralist
Certification of Authenticity:   
         I certify that this lab is entirely my own work.  
*/

public class AutoPart {

	public String partNumber = "12345";
	public String makeAndModel = "Chrysler LeBaron";
	public String description = "a crappy car that still brings in the ladies";
	public float price = 1000;
	public int numberInStock = 1;
	
	public AutoPart(String partnum, String make, String descr, float cost, int numleft){
		partNumber = partnum;
		makeAndModel = make;
		description = descr;
		price = cost;
		numberInStock = numleft;
	}
	
	public void setPrice(float newprice){
		price = newprice;
	}
	
	public void setNumberInStock(int num){
		numberInStock = num;
	}
	
	public String toString(){
		return (partNumber + "--------- \nmake and model: " + makeAndModel + "\nDescription: " + description + "\nPrice: " + price + "\nNumber in Stock: " + numberInStock);
	}
}
