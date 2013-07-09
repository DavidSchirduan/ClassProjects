/**
 * class Rectangle
 * subclass of Polygon
 * 
 * @author Pharr 
 * @version 11/11/2009
 */
public class Rectangle extends Polygon
{
	private double height;
	private double width;

	/**
	 * Constructor for objects of class Rectangle
	 */
	public Rectangle(double h, double w)
	{
	    super(4);
		height = h;
		width = w;
	}

	/**
	 * method area()
	 * 
	 * @param  none
	 * @return  height * width 
	 */
	public double area()
	{
		return height * width;
	}

	/**
	 * method toString()
	 * 
	 * @param  none
	 * @return  string 
	 */
	public String toString()
	{
	    String s = "Ractangle\n";
		s = s + super.toString() + "\n";
		s = s + "Area = " + area();
		return s;
	}
}
