package QuizGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author james
 */
public class View extends JFrame implements Observer {
    
    private JPanel userPanel = new JPanel();
    private JPanel calcPanel = new JPanel();
    private JLabel uName = new JLabel("Username: ");
    private JLabel pWord = new JLabel("Password: ");
    
    
    public View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.userPanel.add(uName);
        this.userPanel.add(pWord);
        this.add(userPanel);
        this.setVisible(true);
    }
    
    @Override
    public void update(Observable o, Object arg)
    {
        
    }
}
