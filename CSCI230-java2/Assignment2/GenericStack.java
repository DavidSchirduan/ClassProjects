package Homework2;
//Author: McAllister

public class GenericStack<T> {  
    private T[ ] data;
    private int top;
    private int size;
    
    public int getSize(){
    	return size;
    }
    
    public int getTop(){
    	return top;
    }
   
    public GenericStack( ) {  
       top = -1;
       size = 100;
       data = (T[ ]) new Object[size];
    }
   
    public GenericStack(int n) {
       top = -1;
       size = n;
       data = (T[ ]) new Object[n];
    }
   
    public boolean push(T newNode) {   
        GenericNode node = (GenericNode) newNode;
        if (top == size-1) {
            return false;  // ** overflow error **
        }
        else {   
            top = top + 1;
            data[top] = (T) node.deepCopy();
            return true;  // push operation successful
        }
    }
   
    public T pop( ) {   
        int topLocation;
        if (top == -1) {
            return null;  // ** underflow error **
        }
        else { 
            topLocation = top;
            top = top -1;
            return data[topLocation];
        }
    }
   
    public void showAll( ) {
        for (int i = top; i >= 0; i--)
            System.out.println(data[i].toString());
    }
    
    public void reset() {
    	for (T object : data)
    	{
    		pop();
    	}
    }
    
    public boolean isEmpty(){
    	if (top == -1){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    public T peek(){
    	return data[top];
    }
}


