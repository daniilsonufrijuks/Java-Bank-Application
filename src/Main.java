import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // gui start
        StartWindow stw = new StartWindow();
        stw.setTitle("MONOLITH Bank");
        // ImageIcon icon = new ImageIcon("icon.png");
        // setIconImage(icon.getImage());
        stw.setVisible(true);
        // int x = (screenSize.width - frame.getWidth()) / 2;  
        // int y = (screenSize.height - frame.getHeight()) / 2;  
        // //Set the new frame location  
        // stw.setLocation(x, y);  
        stw.setBounds(10, 10, 400, 550);
        stw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stw.setResizable(false);

        Thread.sleep(3000);
        // log window
        GUILogReg frame = new GUILogReg();
        frame.setTitle("MONOLITH Bank");
        // ImageIcon icon = new ImageIcon("icon.png"); 
        // setIconImage(icon.getImage());
        frame.setVisible(true);
        frame.setBounds(10, 10, 1200, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}