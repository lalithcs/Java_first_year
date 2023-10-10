/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:10-10-2023
 */
public class ConstructorOverloading {
    ConstructorOverloading(){
        System.out.println("Default Constructor!");
    }
    ConstructorOverloading(int i){
        System.out.println("Parameterized Constructor");
        System.out.println(i);
    }

    public static void main(String[] args) {
        ConstructorOverloading obj=new ConstructorOverloading();
        ConstructorOverloading obj1=new ConstructorOverloading(1);
    }
}
