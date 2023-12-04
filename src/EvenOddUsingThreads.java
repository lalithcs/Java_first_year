/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:28-11-2023
 * Project: Fibonacci.java
 */
public class EvenOddUsingThreads {
        private static class EvenThread extends Thread {
            public void run() {
                for (int i = 2; i <= 20; i += 2) {
                    System.out.println("Even Thread: " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private static class OddThread extends Thread {
            public void run() {
                for (int i = 1; i <= 19; i += 2) {
                    System.out.println("Odd Thread: " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void main(String[] args) {
            EvenThread evenThread = new EvenThread();
            OddThread oddThread = new OddThread();

            evenThread.start();
            oddThread.start();
        }
}

