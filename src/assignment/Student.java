package assignment;
//*******probelm 1******
import java.util.Scanner;
/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:22-12-2023
 * Project: Fibonacci.java
 */
public class Student {
    private final String name;
    private final int rollNumber;
    private final int[] marks = new int[6];
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
    public void submitMarks(int[] m) {
        if (m.length == marks.length) {
            System.arraycopy(m, 0, marks, 0, m.length);
        } else {
            System.out.println("Invalid number of marks provided.");
        }
    }
    public double percentage() {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return (double) totalMarks / marks.length;
    }
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks:");
        System.out.println("OOPS: "+marks[0]);
        System.out.println("DS: "+marks[1]);
        System.out.println("DD: "+marks[2]);
        System.out.println("DBMS: "+marks[3]);
        System.out.println("EC: "+marks[4]);
        System.out.println("ES: "+marks[5]);
        System.out.println("Percentage: " + percentage() + "%");
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String name= in.nextLine();
        int rno=in.nextInt();
        // Create a new student
        Student student = new Student(name,rno);
        System.out.println("Enter the marks course wise: ");
        System.out.print("OOPS: ");
        int oops=in.nextInt();
        System.out.print("DS: ");
        int ds=in.nextInt();
        System.out.print("DD: ");
        int dd=in.nextInt();
        System.out.print("DBMS: ");
        int dbms=in.nextInt();
        System.out.print("EC: ");
        int ec=in.nextInt();
        System.out.print("ES: ");
        int es=in.nextInt();
        int[] aliceMarks = {oops, ds, dd, dbms, ec, es};
        student.submitMarks(aliceMarks);
        student.display();
    }
}
