/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:10-10-2023
 */
public class MethodOverloading {
    MethodOverloading(){
        System.out.println("Default Constructor!");
    }
    MethodOverloading(int i){
        System.out.println("Parameterized Constructor");
        System.out.println(i);
    }

    public static void main(String[] args) {
        MethodOverloading obj=new MethodOverloading();
        MethodOverloading obj1=new MethodOverloading(1);
    }
}
