/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:12-12-2023
 * Project: Fibonacci.java
 */
import java.awt.*;
import javax.swing.*;
public class GridLayoutExample
{
    JFrame frameObj;
    GridLayoutExample()
    {
        frameObj = new JFrame();
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        frameObj.add(b1);
        frameObj.add(b2);
        frameObj.add(b3);
        frameObj.add(b4);
        frameObj.add(b5);
        frameObj.setLayout(new GridLayout());
        frameObj.setSize(300, 300);
        frameObj.setVisible(true);
    }
    public static void main(String args[])
    {
        new GridLayoutExample();
    }
}