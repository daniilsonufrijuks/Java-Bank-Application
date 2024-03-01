import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // gui start
        GUILogReg frame = new GUILogReg();
        frame.setTitle("MONOLIT Bank");
        // ImageIcon icon = new ImageIcon("icon.png"); // Путь к вашей иконке
        // setIconImage(icon.getImage());
        frame.setVisible(true);
        frame.setBounds(10, 10, 1200, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}