import javax.swing.*;
import java.awt.*;

public class Modal extends JDialog {

    /*
        Method creating panels for messages
     */
    public Modal( JFrame parent, String title, String message){
        super(parent, title, true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);


        panel.add(label);
        getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Should be EXIT_ON_CLOSE
        pack();
        setVisible(true);

    }
    /*
        Modal Render
     */
    public static void render(JFrame parent, String title, String message) {
        new Modal(parent, title,message);
    }

}
