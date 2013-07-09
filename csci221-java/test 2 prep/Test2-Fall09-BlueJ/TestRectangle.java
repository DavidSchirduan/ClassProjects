/**
 * class TestRectangle
 * 
 * @author Pharr
 * @version 11/11/2009
 */
public class TestRectangle
{
	public void test1()
	{
		Rectangle r = new Rectangle(3, 4);
		System.out.println(r);
	}
	
	public void test2()
	{
		Polygon p1 = new Polygon(4);
        Polygon p2 = new Rectangle(2, 3);
        Rectangle r = new Rectangle(4, 5);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(r);
	}
	
	public void test3()
	{
        Rectangle r = new Rectangle(2, 4);
        Polygon p = r;
        System.out.println(p);
	}
	
}
