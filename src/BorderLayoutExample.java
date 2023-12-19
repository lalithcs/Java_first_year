/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:12-12-2023
 * Project: Fibonacci.java
 */
import java.awt.*;
import javax.swing.*;

public class BorderLayoutExample {
    JFrame frameObj;

    BorderLayoutExample() {
        frameObj = new JFrame();
        frameObj.setLayout(new BorderLayout(20, 25)); // Set layout first
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        frameObj.add(b1, BorderLayout.NORTH);
        frameObj.add(b2, BorderLayout.SOUTH);
        frameObj.add(b3, BorderLayout.EAST);
        frameObj.add(b4, BorderLayout.WEST);
        frameObj.add(b5, BorderLayout.CENTER);
        frameObj.setSize(300, 300);
        frameObj.setVisible(true);
    }

    public static void main(String argvs[]) {
        new BorderLayoutExample();
    }
}
