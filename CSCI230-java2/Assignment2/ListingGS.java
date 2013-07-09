package Homework2;
// Author: McAllister
public class ListingGS implements GenericNode
{  
    private String name;
    private String address;
    private String number;
    
    public ListingGS(String n, String a, String num )
    {  name = n;
       address = a;
       number = num;
    }
    
    public String getKey( )
    {  return name;
    }
    
    public ListingGS deepCopy()
    {  ListingGS clone = new ListingGS(name, address, number);
        return clone;
    }
    
    public String toString()
    {  return("Name is " + name + '\n' +
              "Address is " + address + '\n' +
              "Number is " + number + '\n');
    }

    public String getNumber()
    {  return number;
    }
    
    public void setNumber(String n)
    { number = n;
    }
}
