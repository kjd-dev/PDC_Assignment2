package QuizGUI;

/**
 *
 * @author james and tuita
 */

public class Main 
{
    public static void main(String[] args) 
    {        
        View2 view = new View2();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        model.addObserver(view);
    }
}
