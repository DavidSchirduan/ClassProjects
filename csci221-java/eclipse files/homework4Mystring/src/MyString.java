/*Author:   David Schirduan
Date:       2/18/10
Class:     CSCI-221-002 Java Programming
Assignment: MyString
Task:       Create a class Money without using doubles
Input:      No user unput. Except what is changed in the code
Output:     Outputs a print statement as well as several variables
Certification of Authenticity:   
         I certify that this lab is entirely my own work.  
*/
public class MyString
   {
      public int length;            //length of arraylist
      public char[] contents;       //chararray of MyString
      
      //contructor with toCharArray() method
      public MyString(String newstring)
      {
       contents = newstring.toCharArray();
       length = contents.length;
      }
      
      //simple constructor; copies newstring to equal MyString
      public MyString(MyString newString)
         {
            contents = newString.getcontents();
         }
      
      private char[] getcontents()
         {
            return contents;
         }
           
      //toString method for MyString
      public String toString()
         {
           int index;             //temp variable for for loops
           String s = "";              //temp variable for ToString method
           
           for (index = 0; index < length; index ++)
              {
                 s = s + contents[index];
              }
            
           return s; 
         }
      
      //returns the length of MyString
      public int length()
         {
            return length;
         }
      
      //returns the char at index i
      public char atChar(int i)
         {
            char result;           //temp variable to prevent multiple exits

            if (i < length)
               {
               result = contents[i];
               }
            else
               {
               result = 'X';
               }
         return result;
         }
      
      //private constructor
      private MyString(char[] newcontents)
         {
            contents = newcontents;
            length = contents.length;
         }
      
      //clones the current charstring
      public MyString clone()
         {
            MyString clone;        //temp variable used in the clone

            clone = new MyString(contents);
            return clone;
         }
      
      //compares two mystring to see if they are equal or not
      public boolean equals(MyString s)
         {
            boolean equal = true;         //temp variable used in equals
            int index;             //temp variable for for loops
             
            if (s.length() != length) //test for length equality
               {
                  equal = false;
               }
            else
               {
               for (index = 0; index < s.length; index++)
                  {
                     if (s.atChar(index) != contents[index])
                        {
                           equal = false;
                        }
                  }
               }
               
            return equal;
         }
   
      //returns a mystring object with m added to it
      public MyString concat(MyString m)
         {
            char[] newcontents = m.getcontents();
            MyString newtemp;      //temp variable for new MyString
            int index = 0;
            int i = 0;
            
            //create new array to hold all values
            char[] temparray = new char[m.length() + length];
            
            //clones contents of current MyString
            for (index = 0; index < length; index ++)
               {
                  temparray[index] = contents[index];
               }
            //adds new mcontents
            for (i = 0, index = length; index < (m.length() + length); i++, index++)
               {
                  temparray[index] = newcontents[i];
               }
            //creates MyString with new contents
            newtemp = new MyString(temparray);
            
            return newtemp;
         }
      
      //returns the first occurance of c >= index i
      public int indexOf(char c, int i)
         {
            boolean found;         //temp for indexOf
            int iresult;           //temp variable to prevent multiple exits

            found = false;
            iresult = -1;
            if (i < length && i >=0)
               {
                  while((i) < length && !found)
                     {
                        i++;
                        if (contents[(i-1)] == c)
                           {
                              iresult = (i-1);
                              found = true;
                           }
                       
                     }
               }
            return iresult;
         }
   
      //creates a new MyString with the substring of another MyString
      public MyString substring(int i, int j)
         {
            MyString substring;
            int index;
            int counter = 0;
            char[] sub = new char[(j-i)];
            
            if (i >= 0 && j < length)
               {
                  for (index = i; index < j; index++, counter++)
                     {
                        sub[counter] = contents[index];
                     }
                  substring = new MyString(sub);
               }
            else
               {
                 substring = new MyString("doesn't match");
               }
            
            return substring;
         }
      
      //returns the first occurance of c >= index i
      public int indexOf(MyString s, int i)
         {
            boolean found;         //temp for indexOf
            int iresult;           //temp variable to prevent multiple exits
            int slength = s.length();
            MyString currentsub; 

            found = false;
            iresult = -1;
            
            if (i < length && i >= 0)
               {
                  while((i - 1) <= length && !found)
                     {
                        i++;
                        
                        currentsub = this.substring((i), (i + slength));
                        
                        if (s.equals(currentsub))
                           {
                              iresult = (i);
                              found = true;
                           }
                       
                     }
               }
            return iresult;
         }

      //replaces part of MyString with a new MyString
      public char[] replace(MyString oldpart, MyString newpart)
         {
            int index;
            int temp;
            int ending;
            int start = this.indexOf(oldpart, 0);
            int finish = start + oldpart.length() - 1;
            int newlength = length - oldpart.length() + newpart.length();
            char[] newcontents = new char[newlength];
            char[] newpartcontents = newpart.getcontents();
            
            //tests to see if oldpart is in string
            if (start > 0)
               {  //places whatever is before oldpart into the new contents
                  for (index = 0; index < start; index++)
                     {
                        newcontents[index] = contents[index];
                     }
                  //adds new contents
                  for (temp = 0; index < finish; index++, temp++)
                     {
                        newcontents[index] = newpartcontents[temp];
                     }
                  //adds on the rest of the string
                  for (ending = 0; index < newcontents.length; ending++, index++, finish++)
                     {
                        newcontents[index] = contents[finish + 1];
                     }
               }
            
            
            return newcontents;
                        
         }
   }



