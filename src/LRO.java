/**
 * Author: Challa Saraswathi Lalith
 * Contact at:lalithcspersonal@gmail.com
 * Date:19-12-2023
 * Project: Fibonacci.java
 */
import java.awt.*;

import java.awt.event.*;
import java.io.Serial;

import javax.swing.*;



class LRO extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    private String s = "user drawn string";



    public LRO() {

        super("drawing lines, rectangles & ovals");

        setSize(400, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        setLayout(new FlowLayout());



        setVisible(true);

    }



    public void paint(Graphics g) {

        super.paint(g);

        g.setColor(Color.RED);

        g.drawLine(5, 30, 350, 30);

        g.setColor(Color.BLUE);

        g.drawRect(2, 40, 90, 55);

        g.fillRect(100, 40, 90, 55);

        g.setColor(Color.CYAN);

        g.drawRoundRect(195, 40, 90, 55, 20, 20);

        g.fillRoundRect(150, 20, 90, 55, 20, 20);

        g.setColor(Color.YELLOW);

        g.draw3DRect(5, 100, 90, 55, false);

        g.fill3DRect(100, 100, 90, 55, true);

        g.setColor(Color.MAGENTA);

        g.drawOval(195, 100, 90, 55);

        g.fillOval(20, 100, 90, 55);

    }



    public static void main(String args[]) {

        LRO a = new LRO();

        a.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                System.exit(0);}

        });

    }

}



