import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Point;
import java.awt.GraphicsEnvironment;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // gui start
        //StartWindow m = new StartWindow();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        JFrame stw = new JFrame();  
        stw.setTitle("MONOLITH Bank");
        // ImageIcon icon = new ImageIcon("icon.png");
        // setIconImage(icon.getImage());
        
        //stw.add(m);
        stw.setVisible(true);
        stw.setBounds(center.x - 400 / 2, center.y - 550 / 2, 400, 550);
        stw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stw.setResizable(false);

        // -------------------------------------------------------------------------------------

        Thread.sleep(3000);
        // log window
        GUILogReg frame = new GUILogReg();
        frame.setTitle("MONOLITH Bank");
        // ImageIcon icon = new ImageIcon("icon.png"); 
        // setIconImage(icon.getImage());
        frame.setVisible(true);
        //frame.setBounds(10, 10, 1200, 750);
        frame.setBounds(center.x - 1200 / 2, center.y - 750 / 2, 1200, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}