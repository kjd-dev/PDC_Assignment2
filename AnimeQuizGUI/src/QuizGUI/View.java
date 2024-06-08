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
    public JTextField unInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);
    
    
    public View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.userPanel.add(uName, BorderLayout.CENTER);
        this.userPanel.add(unInput, BorderLayout.CENTER);
        this.userPanel.add(pWord, BorderLayout.CENTER);
        this.userPanel.add(pwInput, BorderLayout.CENTER);
        this.add(userPanel);
        this.setVisible(true);
    }
    
    @Override
    public void update(Observable o, Object arg)
    {
        
    }
}
