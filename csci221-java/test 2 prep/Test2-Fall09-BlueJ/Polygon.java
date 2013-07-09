/**
 * class Polygon
 * 
 * @author Pharr 
 * @version 11/11/2009
 */
public class Polygon
{
	private int numberOfSides;

	/**
	 * Constructor for objects of class Polygon
	 */
	public Polygon(int numSides)
	{
		numberOfSides = numSides;
	}

	/**
	 * method area()
	 * 
	 * @param  none
	 * @return  ZERO (constant) 
	 */
	public double area()
	{
		return 0.0;
	}

	/**
	 * method toString()
	 * 
	 * @param  none
	 * @return  string 
	 */
	public String toString()
	{
		return "Number of sides = " + numberOfSides;
	}
}
