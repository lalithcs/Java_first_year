public class Add{
    void Add0(int a,int b){
        int c=a+b;
        System.out.println("c="+c);
    }
    void Add1(int a,int b){
        int c=a+b;
        System.out.print("a="+a+" "+"b="+b+" "+"c="+c);
    }
    void Add2(int a,int b){
        int c=a+b;
        System.out.print("\n"+"a="+a+"\n"+"b="+b+"\n"+"c="+c);    
    } 
    public static void main(String [] args){
        Add obj= new Add();
        obj.Add0(2,3);
        obj.Add1(2,3);
        obj.Add2(2,3);
    }
}