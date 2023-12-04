/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:28-11-2023
 * Project: Fibonacci.java
 */
public class ThreadHW extends Thread {
        public void run() {
            System.out.println("Hello, World!");
        }

        public static void main(String[] args) {
            ThreadHW thread = new ThreadHW();
            thread.start();
        }
}
