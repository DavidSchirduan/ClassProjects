package Homework2;
// Author: McAllister
public interface GenericNode { 
    public abstract GenericNode deepCopy(); // clones the invoking object
    public abstract String toString();      // added to prevent Object's toString method from
                                            // executing. Technically not syntactically necessary.
}

