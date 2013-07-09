
public class Box
{
      private double height;
      private double width;
      private double depth;
      
      //creates the cube contructor
      public Box(double usernum)
         {
            height = usernum;
         }
      
      //creates the constructor for a box of a different size
      public Box(double userheight, double userwidth, double userdepth)
         {
            height = userheight;
            width = userwidth;
            depth = userdepth;
         }
      
      //Calculates volume
      public double volume()
         {
            return height * width * depth;
         }
      
      //Calculates surface area
      public double surfaceArea()
         {
            return (2 * (height * width)) + (2 * (depth * width)) +  (2 * (depth * height));
         }
}
