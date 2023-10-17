/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:10-10-2023
 */
class MethodO {
    static void add(int a, int b){
        int c=a+b;
        System.out.println("int datatype method:");
        System.out.println("The sum is:"+c);
    }
    static void add(double a,double b){
        double c=a+b;
        System.out.println("double data type method:");
        System.out.println("the sum is="+c);
    }
}
public class MethodOverloading {
    public static void main(String[] args) {
        MethodO.add(1,2);
        MethodO.add(2.0,3.5);
    }
}
