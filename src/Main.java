import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // gui start
        StartWindow stw = new StartWindow();
        stw.setTitle("MONOLIT Bank");
        // ImageIcon icon = new ImageIcon("icon.png");
        // setIconImage(icon.getImage());
        stw.setVisible(true);
        stw.setBounds(10, 10, 500, 750);
        stw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stw.setResizable(false);

        // log window
        GUILogReg frame = new GUILogReg();
        frame.setTitle("MONOLIT Bank");
        // ImageIcon icon = new ImageIcon("icon.png"); 
        // setIconImage(icon.getImage());
        frame.setVisible(true);
        frame.setBounds(10, 10, 1200, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}