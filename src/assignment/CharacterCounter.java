package assignment;

/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:22-12-2023
 * Project: Fibonacci.java
 */
/*
Features of Java:
Simple: Java was designed to be easy to use and learn. It removed complex concepts like pointers, operator overloading, etc., present in languages like C++.
Object-Oriented: Java is entirely object-oriented, supporting the four primary concepts: encapsulation, inheritance, polymorphism, and abstraction.
Platform-Independent: Java code can run on any platform with the help of the Java Virtual Machine (JVM), making it "write once, run anywhere."
Distributed: It provides libraries to create distributed applications, enabling seamless communication over a network.
Secure: Java has a robust security model that ensures the protection of systems from harmful activities.
Multithreaded: Java supports multiple threads of execution, allowing concurrent execution of tasks.
High Performance: With JIT (Just-In-Time) compilation, Java offers high performance by converting bytecode into native machine code at runtime.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        Map<Character, Integer> charCount = new HashMap<>();

        // Count occurrences of each character
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Print the count of each character
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
