/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:28-11-2023
 * Project: Fibonacci.java
 */
import java.util.*;
class threadA implements Runnable{

    @Override
    public void run() {
        System.out.println("Running....");
    }
}

public class RunnableINterface {

    public static void main(String[] args) {
        System.out.println("Main Thread...");
        threadA obj=new threadA();
        Thread t=new Thread(obj);
        t.start();

    }
}
