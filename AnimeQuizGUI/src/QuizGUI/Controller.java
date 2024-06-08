package QuizGUI;

/**
 *
 * @author james
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    
    public View2 view;
    public Model model;
    
    public Controller(View2 view, Model model)
    {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        switch(command) 
        {
            case "Log in":
                String username = this.view.getUsername();
                String password = this.view.getPassword();
                break;
        }
    }
}
