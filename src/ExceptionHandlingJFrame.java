/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:19-12-2023
 * Project: Fibonacci.java
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ExceptionHandlingJFrame extends JFrame implements ActionListener {
    JButton div;
    JTextField tf1, tf2, tf3;
    JLabel l2, l1, l3;

    ExceptionHandlingJFrame() {
        setLayout(new FlowLayout());
        l1 = new JLabel("Enter num 1");
        l2 = new JLabel("Enter num 2");
        l3 = new JLabel("Result");
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField(10);
        div = new JButton("Division");
        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(div);
        add(l3);
        add(tf3);
        div.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
//this try block is used to check if the given numbers are in integer format or not
            int n1 = Integer.parseInt(tf1.getText());
            int n2 = Integer.parseInt(tf2.getText());
            int n3 = n1 / n2;
            tf3.setText("" + n3);
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(null, "Number Format Exception");
        } catch (ArithmeticException aie) {
            JOptionPane.showMessageDialog(null, "Arithmetic Exception");
        }
    }

    public static void main(String args[]) {
        ExceptionHandlingJFrame f = new ExceptionHandlingJFrame();
        f.setTitle("Exception Handling JFrame");
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}