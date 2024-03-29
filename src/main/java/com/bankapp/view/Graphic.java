package view;


import javax.swing.*;

import managers.FileManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphic extends JPanel implements ActionListener {
    private int[] data = new int[100];
    private Timer timer;

    // Область, в которой будет отображаться график
    private Rectangle graphArea = new Rectangle(50, 50, 1100, 350); // x, y, width, height

    public Graphic() {
        timer = new Timer(2500, this);
        timer.start();

        // Заполнение массива данными (для примера)
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100);
        }
        FileManager fileManager = new FileManager();
        for (int value : data) {
            fileManager.WriteToAFileTXT("resources/graphic.txt", value);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Отрисовка области графика
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(graphArea);

        // Отрисовка графика в заданной области
        g2d.setColor(Color.BLUE);
        int x = graphArea.x;
        int y = graphArea.y + graphArea.height;
        int xScale = graphArea.width / data.length;
        int yScale = graphArea.height / 100;
        for (int i = 0; i < data.length - 1; i++) {
            int x1 = x + i * xScale;
            int y1 = y - data[i] * yScale;
            int x2 = x + (i + 1) * xScale;
            int y2 = y - data[i + 1] * yScale;
            g2d.drawLine(x1, y1, x2, y2); // Отрисовка линий между точками
            g2d.fillOval(x1 - 2, y1 - 2, 4, 4); // Отрисовка точек
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Смещение данных (для примера)
        for (int i = 0; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[data.length - 1] = (int) (Math.random() * 100); // Генерация нового значения для последней точки
        repaint();
    }

    // public static void main(String[] args) {
    //     JFrame frame = new JFrame("Sliding Graph");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(400, 300);
    //     frame.add(new Graphic());
    //     frame.setVisible(true);
    // }
}
