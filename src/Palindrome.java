import java.util.Scanner;

public class Palindrome {
    boolean Pal(int n){
        int temp=n,r,sum=0;
        while(n>0){
            r=n%10;
            n/=10;
            sum=(sum*10)+r;
        }
        return temp==sum;
    }
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        Palindrome obj=new Palindrome();
        int n=in.nextInt();
        boolean p= obj.Pal(n);
        if(p)
            System.out.println("Palindrome!!");
        else
            System.out.println("Not Palindrome!!!");
    }
}
