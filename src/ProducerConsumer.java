/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:05-12-2023
 * Project: Fibonacci.java
 */
public class ProducerConsumer {
    static class Buffer {
        private int[] buffer = new int[5];
        private int size = 0;
        private int capacity = 5;
        private int index = 0;

        public synchronized void produce() throws InterruptedException {
            while (size == capacity) {
                wait(); // Wait if the buffer is full
            }

            int item = (int) (Math.random() * 100);
            buffer[index] = item;
            index = (index + 1) % capacity;
            size++;
            System.out.println("Produced: " + item);
            notify(); // Notify consumer that an item is available
        }

        public synchronized void consume() throws InterruptedException {
            while (size == 0) {
                wait(); // Wait if the buffer is empty
            }

            int item = buffer[(index - size + capacity) % capacity];
            size--;
            System.out.println("Consumed: " + item);
            notify(); // Notify producer that space is available
        }
    }

    static class Producer extends Thread {
        private Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.produce();
                    Thread.sleep(1000); // Simulating production time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer extends Thread {
        private Buffer buffer;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.consume();
                    Thread.sleep(1500); // Simulating consumption time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}

