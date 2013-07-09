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

public class PartsStore {

	public static void main(String[] args) {

		AutoPart test1 = new AutoPart("autochanger", "dodge", "info", 4000, 10);
		AutoPart test2 = new AutoPart("brakes", "toyota", "info", 3000, 13);
		AutoPart test3 = new AutoPart("czarkiller", "ford", "info", 5000, 5);
		AutoPart test4 = new AutoPart("door", "tonka", "info", 200, 9);
		AutoPart test5 = new AutoPart("desk", "dodge", "info", 4000, 10);
		AutoPart test6 = new AutoPart("956", "toyota", "info", 3000, 13);
		AutoPart test7 = new AutoPart("sarborator", "ford", "info", 5000, 5);
		AutoPart test8 = new AutoPart("feta", "tonka", "info", 200, 9);
		HydraList list = new HydraList();
		
		list.insert(test5);
		list.insert(test4);
		list.insert(test2);
		list.insert(test1);
		list.insert(test8);
		list.insert(test7);
		list.insert(test6);
		list.insert(test3);
		
		list.updatePrice(test4, 1000);
		System.out.println(list.fetch("door"));
		
		list.printAll();
		
		list.delete("czarkiller");		
		list.delete("fraekes");
		list.delete("zeta");
		list.delete("carborator");
		list.delete("brakes");
		list.delete("brakes");
		list.printAll();
		System.out.println(list.fetch("door"));

		System.out.println(list.fetch("hogus"));
		list.updateNumInStock(test4, 23);
		list.updatePrice(test4, 9000);
		System.out.println(list.fetch("door"));


		
	}

}
