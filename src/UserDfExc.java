/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:21-11-2023
 * Project: Fibonacci.java
 */
import java.io.*;
import java.lang.*;
class MyException extends Exception
{
    String str1;
    MyException(String str2)
    {
        str1=str2;
    }
    public String toString()
    {
        return ("Output String = "+str1) ;
    }
}
public class UserDfExc
{
    public static void main(String args[])
    {
        try
        {
            throw new MyException("user defined exception");
        }
        catch(MyException e)
        {
            System.out.println("Hi this is my catch block") ;
            System.out.println(e) ;
        }
    }
}