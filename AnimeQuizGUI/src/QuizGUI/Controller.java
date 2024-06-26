package QuizGUI;

/**
 *
 * @author james
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    
    public View view;
    public Model model;
    
    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    
    //Reads what button was pressed and assigned the appropriate action
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
    
    //Check methods to ensure users input is a valid entry, then passes input to the model class
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
            if(roundsNumber == 4)
            {
                view.popError("Good luck...");
            }
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
        boolean isCorrect = model.checkAnswer(answer);
        if(model.isStreak())
        {
            int streak = model.getStreak();
            int points = model.getPoints();
            view.showStreak(streak, points);
        }
        else
        {
            view.hideStreak();
        }
        view.showAnswer(isCorrect);
    }
    
    public boolean isValidEntry(String entry)
    {
        return entry.matches("\\d+");
    }
    
    public boolean isValidAnswer(String answer)
    {
        return answer.length() == 1 && "abcd".contains(answer.toLowerCase());
    }
    
    public boolean inBoundsTopic(int number)
    {
        return number <= 10 && number > 0;
    }
    
    public boolean inBoundsRounds(int number)
    {
        return number <= 4 && number > 0;
    }
}
