import java.util.*;
class Pri{
    boolean Pr(int p){
        int i,count=0;
        for(i=1;i<=p;i++){
            if(p%i==0)
                count++;
        }
        return count == 2;
    }
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        int p=in.nextInt();
        Pri obj=new Pri();
        boolean n=obj.Pr(p);
        if(n)
            System.out.print("Prime!!");
        else
            System.out.print("Not Prime!!");
    }
}