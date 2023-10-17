import java.util.Scanner;

/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:10-10-2023
 */
public class Stack {
    public static int top=0;
    public static int maxSize=10;
    public static int[] arr=new int[maxSize];
    public void push(int data){
        if(top<maxSize){
            arr[top++]=data;
        }
        else
        {
            System.out.println("Stack Overflow!!");
            return;
        }
        System.out.println("INserted Succesfully!!");
    }
    public void pop(){
        --top;
        System.out.println("Element Popped!");
    }
    public void peek(){
        System.out.println("The top element is: "+arr[top]);
    }
    public void display() {
        System.out.println("The elements in stack are:");
        for (int i = 0; i < top; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int ch;
        do {
            Scanner in=new Scanner(System.in);
            System.out.println("Enter your choice:");
            System.out.println("1.Push");
            System.out.println("2.Pop");
            System.out.println("3.Peek");
            System.out.println("4.Display");
            System.out.println("Choice: ");
            int c=in.nextInt();
            Stack obj = new Stack();
            switch(c){
                case 1:{
                    int cho;
                    do {
                        System.out.print("Enter data to be inserted in stack: ");
                        int data = in.nextInt();
                        obj.push(data);
                        System.out.println("DO you want to continue?(y=1,n=0)");
                        cho = in.nextInt();
                    }while(cho!=0);
                    break;
                }
                case 2:{
                    obj.pop();
                    break;
                }
                case 3:{
                    obj.peek();
                    break;
                }
                case 4: {
                    obj.display();
                    break;
                }
                default:
                    System.out.println("Wrong option Entered!!");
            }
            System.out.println("DO you want to continue?(y=1,n=0)");
            ch=in.nextInt();
        }while(ch!=0);


    }
}