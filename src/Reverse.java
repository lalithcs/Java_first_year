import java.util.Scanner;
public class Reverse {
    int rev(int n){
        int r,sum=0;
        while(n>0){
            r=n%10;
            n/=10;
            sum=(sum*10)+r;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Reverse obj=new Reverse();
        int n=in.nextInt();
        int ne=obj.rev(n);
        System.out.println("The Reversed Number is:"+ne);
    }
}
