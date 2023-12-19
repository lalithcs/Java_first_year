public class EvenOddUsingThreads {
    public static class Printer {
        private volatile boolean isEvenPrinted = false;

        public synchronized void printEven(int number) {
            while (isEvenPrinted) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Even Thread: " + number);
        }

        public synchronized void printOdd(int number) {
            isEvenPrinted = true;
            System.out.println("Odd Thread: " + number);
            notify();
        }
    }

    private static class EvenThread extends Thread {
        private final Printer printer;

        public EvenThread(Printer printer) {
            this.printer = printer;
        }

        public void run() {
            for (int i = 2; i <= 20; i += 2) {
                printer.printEven(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            printer.printOdd(0); // Signaling odd thread to start after even thread completes
        }
    }

    private static class OddThread extends Thread {
        private final Printer printer;

        public OddThread(Printer printer) {
            this.printer = printer;
        }

        public void run() {
            synchronized (printer) {
                while (!printer.isEvenPrinted) {
                    try {
                        printer.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            for (int i = 1; i <= 19; i += 2) {
                printer.printOdd(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();

        EvenThread evenThread = new EvenThread(printer);
        OddThread oddThread = new OddThread(printer);

        evenThread.start();
        oddThread.start();

    }
}
