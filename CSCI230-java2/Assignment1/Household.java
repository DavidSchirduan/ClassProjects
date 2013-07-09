package Homework1;
/*Author:   David Schirduan
Date:       8/31/10
Class:     CSCI-230 Java Programming
Assignment: HouseHold/assignment 1
Task:       review java arrays
Input:      creation of an array of simlated families
Output:     an array with which to gather and process data
Certification of Authenticity:   
         I certify that this lab is entirely my own work.  
*/
public class Household {
	
	public int ID;
	public double income;
	public int houseNum;
	
	public Household (int id, double money, int housenum){
		ID = id;
		income = money;
		houseNum = housenum;
	}
	
	public int getID(){
		return ID;
	}
	
	public double getIncome(){
		return income;
	}
	
	public int getHousenum(){
		return houseNum;
	}
}

