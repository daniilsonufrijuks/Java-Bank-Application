import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;   

public class StartWindow extends JFrame {  
    Container container = getContentPane();

    StartWindow() {
        setLayoutManager();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

}  