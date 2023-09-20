import java.util.Scanner;
class GCD {
    static int gcd(int a, int b)
    {
        int i= Math.min(a, b);
        for (i = i; i > 1; i--) {

            if (a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b= in.nextInt();
        System.out.println("GCD = " + gcd(b, a));
    }
}
