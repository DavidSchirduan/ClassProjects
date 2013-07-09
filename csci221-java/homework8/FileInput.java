// Lists contents of a user-specified file 	
	
import java.util.*;	
import java.io.*;	
	
public class FileInput {	
	
    public static void main(String [] args) throws IOException {
    		
        Scanner stdin = new Scanner(System.in);	
        
        System.out.print("File: ");	
        String name = stdin.nextLine();	
        System.out.println();	
        
        File file = new File(name);	
        Scanner fileIn = new Scanner(file);	
        
        while (fileIn.hasNext()) {	
            String currentLine = fileIn.nextLine();	
            System.out.println(currentLine);	
        } // end while
        
    } // end main

} // end FileInput