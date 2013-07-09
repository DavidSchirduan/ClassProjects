package Homework2;
// Author: McAllister

public class MainGenericStack {    
    public static void main(String[] args) { 
        GenericStack <ListingGS>s = new GenericStack<ListingGS>(3);
        ListingGS l;
        ListingGS l1 = new ListingGS("Bill",  "1st Avenue", "123 4567" );
        ListingGS l2 = new ListingGS("Al",    "2nd Avenue", "456 3232");
        ListingGS l3 = new ListingGS("Mike",  "3rd Avenue", "333 3333");
        ListingGS l4 = new ListingGS("Carol", "4th Avenue", "444 4444");
          
        // an attempt to perform a pop on an initalized (empty) stack will return null
        System.out.println("attempt to pop from an empty stack - returns null");
        System.out.println(s.pop());

        // perform three pushes to fill the stack and then output the stack
        System.out.println("\nperform three pushes to fill the stack and then output the stack");
        System.out.println(s.push(l1));
        System.out.println(s.push(l2));
        System.out.println(s.push(l3));
        s.showAll();

//        // perform three pop operations to empty the stack
//        System.out.println("\nperform three pop operations to empty the stack");
//        l = s.pop();
//        System.out.println(l);
//        l = s.pop();
//        System.out.println(l);
//        l = s.pop();
//        System.out.println(l);
        
        //tests the new peek function
        System.out.println("the top of the stack is: ");
        System.out.println(s.peek());
        
        //uses the new reset function
        System.out.println("resets the stack to empty");
        s.reset();
        
        //tests the new isEmpty function
        System.out.println("tests whether the stack is empty or not\n");
        System.out.println(s.isEmpty());
        
         
        // an attempt to perform a pop on an empty stack will return null - test isEmpty()
        System.out.println("attempt to pop from the empty stack - returns null");
        l = s.pop();
        System.out.println(l);
 
    } // end main()
} // end class MainGenericStack
