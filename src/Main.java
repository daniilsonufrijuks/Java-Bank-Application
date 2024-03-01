import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        GUILogReg frame = new GUILogReg();
        frame.setTitle("MONOLIT Bank");
        frame.setVisible(true);
        frame.setBounds(10, 10, 1200, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}