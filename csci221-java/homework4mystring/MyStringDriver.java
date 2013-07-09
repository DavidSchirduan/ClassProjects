
public class MyStringDriver
   {
      static MyString string1 = new MyString("hellosir");
      static MyString string2 = new MyString("ola");
      static MyString stringtest = new MyString("ello");

      
      public static void main(String[] args)
         {
            //test length()
            System.out.println(string1.length());
            //test atChar()
            System.out.println(string1.atChar(8));
            System.out.println(string1.atChar(3));
            //test equals()
            System.out.println(string1.equals(string2));
            //test clone()
            System.out.println(string1.clone()); 
            //test concat()
            System.out.println(string1.concat(string2));
            //test indexOf()
            System.out.println(string1.indexOf('l', 2));
            //test substring()
            System.out.println(string1.substring(0, 4));
            //test other indexOf()
            System.out.println(string2.indexOf(string1, 5));
            //test replace()
            System.out.println(string1.replace(stringtest, string2));
            
            
         }

   }
