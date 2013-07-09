package Homework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test1 {
    static GenericStack <CharacterGS> stak = new GenericStack<CharacterGS>();
    static File file = new File("/home/mercy/workspace/CSCI 230/src/Homework2/data.txt");
    
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
                    	CharacterGS chargs = new CharacterGS(chartest);
                    	stak.push(chargs);
                }
            }     
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        stak.showAll();
        
        while (stak.peek().isEqual(Lparen)){
			stak.pop();
		}
        System.out.println("++++++");
        stak.showAll();
    }
}
