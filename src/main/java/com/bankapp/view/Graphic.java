package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphic extends JPanel implements ActionListener {
    private int[] data = new int[100];
    private int xOffset = 10; // Отступ слева
    private int yOffset = 10; // Отступ сверху
    private int xScale = 10; // Масштаб по горизонтали
    private int yScale = 10; // Масштаб по вертикали
    private Timer timer;

    public Graphic() {
        timer = new Timer(3000, this);
        timer.start();

        // Заполнение массива данными (для примера)
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 30);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Отрисовка осей координат
        g2d.setColor(Color.BLACK);
        g2d.drawLine(xOffset, height - yOffset, width - xOffset, height - yOffset); // Ось X
        g2d.drawLine(xOffset, height - yOffset, xOffset, yOffset); // Ось Y

        // Отрисовка графика
        g2d.setColor(Color.BLUE);
        for (int i = 0; i < data.length - 1; i++) {
            int x1 = i * xScale + xOffset;
            int y1 = height - data[i] * yScale - yOffset;
            int x2 = (i + 1) * xScale + xOffset;
            int y2 = height - data[i + 1] * yScale - yOffset;
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sliding Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.add(new Graphic());
        frame.setVisible(true);
    }
}
