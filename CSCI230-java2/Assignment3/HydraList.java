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

public class HydraList {
	
	letterNode hletter = null;

	public HydraList(){
	}
	
	public class letterNode{
		public char letter;
		public dataNode datalist = null;
		public letterNode next = null;
	}
	
	public class dataNode{
		private AutoPart data = null;	
		private String partnum = null;
		private dataNode next = null;
	}
		
	public void insert(AutoPart part){
		System.out.println("inserting " + part.partNumber);
		char first = part.partNumber.charAt(0);	//gets the first letter of the part
		letterNode nletter = new letterNode(); 	//creates the new node
		dataNode ndata = new dataNode();		//creates a data node
		ndata.partnum = part.partNumber;		//sets the key field
		ndata.data = part;						//copies the data to it
		nletter.letter = first;
		
		if (hletter == null){					//if it's the first thing in the list, makes it hletter
			hletter = nletter;
			nletter.datalist = ndata;
		}
		
		else {									//otherwise does the following
		
		letterNode q = hletter;					//creates a q
		letterNode p = hletter.next;			//and a p
		
		while (p != null && p.letter <= nletter.letter){	//sorts through the list until p is greater than the letter
			q = p;
			p = p.next;
		}
		
		if (q.letter == nletter.letter){		//if the letter exists, inserts into the current letter
			//insert data method
			if (q.datalist == null){
				q.datalist = ndata;
			}
			
			else {
				dataNode x = q.datalist;
				dataNode y = q.datalist.next;
				
				while (y != null && y.partnum.compareTo(ndata.partnum) < 0){
					x = y;
					y = y.next;
				}
				
				if (x.partnum.compareTo(ndata.partnum) < 0){
					ndata.next = x.next;
					x.next = ndata;
				}
				
				else if (x.partnum.compareTo(ndata.partnum) > 0){
					ndata.next = q.datalist;
					q.datalist = ndata;	
				}
			}
			//end data insert method
		}
		
		else if (q.letter < nletter.letter){				//inserts the new letter node into the list
			nletter.next = q.next;
			q.next = nletter;
				nletter.datalist = ndata;
		}
		
		else if (q.letter > nletter.letter){				//if the letter is before the previous, inserts into that letter
			nletter.next = hletter;
			hletter = nletter;
			nletter.datalist = ndata;
		}
		}
	}
	
	public void delete(String delpart){
		System.out.println("deleting " + delpart);
		char first = delpart.charAt(0);	//gets the first letter of the desired delete method
		letterNode q = null;
		letterNode p = hletter;
		boolean isfound = false;
		
		while (p != null && p.letter < first && !isfound && p.next != null){						
			q = p;
			p = p.next;
			
		}
		//make sure it's on the right letter node
		if (p.letter == first){
			
			dataNode x = null;
			dataNode y = p.datalist;
			//if there is only one data node in the list, it deletes it
			if (y.partnum.compareTo(delpart) == 0 && y.next == null){
				q.next = p.next;
			}
			
			else{	//otherwise it searches through all of the data nodes
				
			while (y != null && y.partnum.compareTo(delpart) < 0 && !isfound){
				x = y;
				if (y.next == null){
					System.out.println(delpart + " was not in the list");
					isfound = true;
				}
				else{
				y = y.next;
				}
			}
			if (y != null && y.partnum.compareTo(delpart) == 0)
			x.next = y.next;
			}
		}
		
		else {
			System.out.println(delpart + " was not in the list");
			isfound = true;
		}
		
	}
	
	public AutoPart fetch(String findpart){
		System.out.println("finding " + findpart);
		char first = findpart.charAt(0);	//gets the first letter of the desired delete method
		letterNode p = hletter;
		boolean isfound = false;
					
		while (p != null && p.letter < first && !isfound && p.next != null){						
			p = p.next;
		}
		//make sure it's on the right letter node
		if (p.letter == first){
			dataNode y = p.datalist;
			//if there is only one data node in the list, it deletes it
				
			while (y != null && y.partnum.compareTo(findpart) < 0 && !isfound){
				y = y.next;
			}
			
			if (y != null && y.partnum.compareTo(findpart) == 0){
			isfound = true;
			return y.data;

			}
		
		
			else {
				System.out.println(findpart + " was not in the list");
				isfound = true;
				return null;

			}
		}
		
		else{
			System.out.println(findpart + " was not in the list");
			return null;
		}
		
	}
	
	public void updatePrice(AutoPart part, float newprice){
		System.out.println("changing price of " + part.partNumber + " to " + newprice);
		char first = part.partNumber.charAt(0);	//gets the first letter of the desired delete method
		letterNode p = hletter;
		boolean isfound = false;
		
		while (p != null && p.letter < first && !isfound && p.next != null){						
			p = p.next;
		}
		//make sure it's on the right letter node
		if (p.letter == first){
			dataNode y = p.datalist;
			//if there is only one data node in the list, it deletes it
				
			while (y != null && y.partnum.compareTo(part.partNumber) < 0 && !isfound){
				if (y.next == null){
					System.out.println(part.partNumber + " testwas not in the list");
					isfound = true;
				}
				
				else{
				y = y.next;
				}
			}
			
			if (y != null && y.partnum.compareTo(part.partNumber) == 0)
			isfound = true;
			y.data.setPrice(newprice);
			}
		
	}
	
	public void updateNumInStock(AutoPart part, int newnum){
		System.out.println("There are now " + newnum + " of " + part.partNumber + " in stock.");
		char first = part.partNumber.charAt(0);	//gets the first letter of the desired delete method
		letterNode p = hletter;
		boolean isfound = false;
		
		while (p != null && p.letter < first && !isfound && p.next != null){						
			p = p.next;
		}
		//make sure it's on the right letter node
		if (p.letter == first){
			dataNode y = p.datalist;
			//if there is only one data node in the list, it deletes it
				
			while (y != null && y.partnum.compareTo(part.partNumber) < 0 && !isfound){
				if (y.next == null){
					System.out.println(part.partNumber + " was not in the list");
					isfound = true;
				}
				
				y = y.next;
			}
			
			if (y != null && y.partnum.compareTo(part.partNumber) == 0){
			isfound = true;
			y.data.setNumberInStock(newnum);
			}
		
		
		else {
			System.out.println(part.partNumber + " was not in the list");
			isfound = true;

		}
		}
		
	}
	
	public void printAll(){
		System.out.println("here is the current store inventory: ");
		letterNode q = hletter;
		while (q != null){
			dataNode x = q.datalist;
			System.out.println(q.letter);
			//prints out data nodes under that letter
			while (x != null){
				System.out.println(x.partnum);
				x = x.next;
			}
			q = q.next;
		}
	}
}
