/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:31-10-2023
 * Project: Fibonacci.java
 */
class Outer
{
    int count;
    public void display()
    {
        for(int i=0;i<5;i++)
        {
            class Inner //Inner class defined inside for loop
            {
                public void show()
                {
                    System.out.println("Inside inner "+(count++));
                }
            }
            Inner in=new Inner();
            in.show();
        }
    }
}
public class Test
{
    public static void main(String[] args)
    {
        Outer ot=new Outer();
        ot.display();
    }
}
