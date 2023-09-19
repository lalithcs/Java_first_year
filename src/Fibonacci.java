import java.util.*;
class Fibonacci{
    int Fibonacci1(int n){
        if(n<=1)
            return n;
        else 
            return Fibonacci1(n-1)+Fibonacci1(n-2);
    }
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        Fibonacci obj=new Fibonacci();
        System.out.println("Enter the number of numbers in the sequence:");
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int m=obj.Fibonacci1(i);
            System.out.print(m+" ");
        }
    }
}