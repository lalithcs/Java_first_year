import java.util.Scanner;
public class SmOf3Nums {
    static int Small(int a, int b, int c){
        return (a<=b&&a<=c)?(a):((b<=a&&b<=c)?b:c);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Number 1:");
        int a=in.nextInt();
        System.out.println("Enter Number 2:");
        int b= in.nextInt();
        System.out.println("Enter Number 3:");
        int c= in.nextInt();
        int d=Small(a,b,c);
        System.out.println("The Smallest of Three Numbers is:"+d);

    }
}
