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
                model.checkName(username, password);
                break;
                
            case "Select":
                String topic = this.view.getTopic();
                int topicNumber = Integer.parseInt(topic);
                if(topic.matches("\\d+") &&  inBoundsTopic(topicNumber))
                {
                    model.selectTopic(topic);
                }
                else
                {
                    System.out.println("error");
                }
                break;
                
            case "Start":
                String rounds = this.view.getRounds();
                int roundNumber = Integer.parseInt(rounds);
                if(rounds.matches("\\d+") && inBoundsRound(roundNumber))
                {
//                    model.selectTopic(topic);
                    System.out.println(rounds);
                }
                else
                {
                    System.out.println("error");
                }
                break;
                
            case "Back":
                model.goBack();
        }
    }
    
    public boolean inBoundsTopic(int number)
    {
        if(number <= 10 && number > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean inBoundsRound(int number)
    {
        if(number <= 4 && number > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
