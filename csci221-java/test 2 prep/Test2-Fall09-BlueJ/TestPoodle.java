/**
 * class TestPoodle 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestPoodle
{
	public void test()
	{
		Poodle poo = new Poodle("Fifi");
        Dog d = poo;
        
        System.out.println("d.draw()");
        d.draw();  // compiler error
        
        System.out.println("\np.draw()");
        Poodle p = (Poodle) d;
        p.draw();
	}
}
