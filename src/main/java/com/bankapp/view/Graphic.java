package view;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphic extends JPanel implements ActionListener {
    private Color color; // graphic color 

    private int[] data = new int[100];
    private Timer timer; // timer for updating the graph every 2.5 seconds (2500 ms)

    // The area in which the graph will be displayed
    private Rectangle graphArea = new Rectangle(0, 0, 1100, 300); // x, y, width, height

    public Graphic(Color color) {
        this.color = color;
        timer = new Timer(15000, this);
        timer.start();

        // Filling an array with data (for example)
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100);
        }
        // FileManager fileManager = new FileManager();
        // for (int value : data) {
        //     fileManager.WriteToAFileTXT(filepath, value);
        // }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        float thickness = 3f; // Change this value to change the thickness
        g2d.setStroke(new BasicStroke(thickness));

        // Drawing the graph area
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(graphArea);

        // Drawing a graph in a specified area
        g2d.setColor(color);
        int x = graphArea.x;
        int y = graphArea.y + graphArea.height;
        //int xScale = graphArea.width / data.length; 
        int xScale = graphArea.width / data.length; //(int) (graphArea.width / (data.length * 0.75)); // 75% of the original distance
        int yScale = graphArea.height / 100;
        for (int i = 0; i < data.length - 1; i++) {
            int x1 = x + i * xScale;
            int y1 = y - data[i] * yScale;
            int x2 = x + (i + 1) * xScale;
            int y2 = y - data[i + 1] * yScale;
            g2d.drawLine(x1, y1, x2, y2); // Drawing lines between points
            g2d.fillOval(x1 - 3, y1 - 2, 6, 6); // Drawing points
        }

        // Draw the last point
        //int xLast = x + (data.length - 1) * xScale;
        //int yLast = y - data[data.length - 1] * yScale;
        //g2d.fillOval(xLast - 2, yLast - 2, 6, 6);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[data.length - 1] = (int) (Math.random() * 100); // Generating a new value for the last point
        repaint();

        for (int value : data) {
            GUIMainProgram.receiveData(value);
        }
    }
}
