/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:19-12-2023
 * Project: Fibonacci.java
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SimpleCalculatorUsingGrid extends JFrame implements ActionListener {
    private JTextField textField;
    private double firstNumber = 0;
    private char operation = ' ';
    public SimpleCalculatorUsingGrid() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 4));

        textField = new JTextField();
        textField.setEditable(false);
        add(textField);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            add(button);
        }

        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("C")) {
            textField.setText("");
            firstNumber = 0;
            operation = ' ';
        } else if (command.equals("=")) {
            calculateResult();
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            firstNumber = Double.parseDouble(textField.getText());
            operation = command.charAt(0);
            textField.setText("");
        } else {
            textField.setText(textField.getText() + command);
        }
    }
    private void calculateResult() {
        double result = 0;
        try {
            double secondNumber = Double.parseDouble(textField.getText());
            switch (operation) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    if (secondNumber == 0) {
                        JOptionPane.showMessageDialog(this, "Error: Division by zero");
                        return;
                    }
                    result = firstNumber / secondNumber;
                    break;
            }
            textField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Invalid input");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}