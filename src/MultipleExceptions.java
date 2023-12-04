
/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:21-11-2023
 * Project: Fibonacci.java
 */
import java.io.*;
public class MultipleExceptions
{
    public static void main(String[] args)
    {
        int a,b,c;
        try{
            try
            {
                try
                {
                    a=0;
                    b=10;
                    c=b/a;
                    System.out.println("This line will not be executed");
                }
                catch(ArithmeticException e)
                {
                    System.out.println("Divided by zero");
                }
                String firstArg = args[0];
                System.out.println("First Argument: " + firstArg);
            }
            catch (IndexOutOfBoundsException ex)
            {
                System.out.println("There is no argument");
            }
            String s=null;
            System.out.println(s.length());
        }
        catch (NullPointerException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            System.out.println("Finally gets executed");
        }
    }
}

