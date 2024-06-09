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
                login();
                break;
                
            case "Select":
                checkSelectTopic();
                break;
                
            case "Start":
                checkSelectRounds();
                break;
                
            case "Back":
                model.goBack();
                break;
                
            case "Next":
                checkInput();
                model.checkAnswer();
                break;
                
            case "Quit":
                model.quitGame();
                break;
                
            default:
                view.popError("Error");
        }
    }
    
    public void login()
    {
        String username = this.view.getUsername();
        String password = this.view.getPassword();
        model.checkName(username, password);
    }
    
    public void checkSelectTopic()
    {
        String topic = this.view.getTopic();
        if (!isValidEntry(topic)) 
        {
            view.popError("Invalid topic.");
            return;
        }

        int topicNumber = Integer.parseInt(topic);
        if (inBoundsTopic(topicNumber)) 
        {
            model.selectTopic(topic);
        } else 
        {
            view.popError("Selection out of bounds.");
        }
    }
    
    public void checkSelectRounds()
    {
        String rounds = this.view.getRounds();
        if (!isValidEntry(rounds)) 
        {
            view.popError("Invalid topic.");
            return;
        }

        int roundsNumber = Integer.parseInt(rounds);
        if (inBoundsRounds(roundsNumber)) {
            
            model.selectRounds(rounds);
        } else 
        {
            view.popError("Selection out of bounds.");
        }
    }
    
    public void checkInput()
    {
        String answer = this.view.getAnswer();
        if (!isValidAnswer(answer)) 
        {
            view.popError("Invalid answer");
            return;
        }
    }
    
    public boolean isValidEntry(String entry)
    {
        return entry.matches("\\d+");
    }
    
    public boolean isValidAnswer(String answer)
    {
        String upperAnswer = answer.toUpperCase();
        return upperAnswer.compareTo("A") >= 0 && upperAnswer.compareTo("D") <= 0;
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
    
    public boolean inBoundsRounds(int number)
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
