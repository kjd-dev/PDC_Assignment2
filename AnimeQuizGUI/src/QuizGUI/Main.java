package QuizGUI;

/**
 *
 * @author james
 */
public class Main 
{
    public static void main(String[] args) {
        
        View2 view = new View2();
        view.setVisible(true);
        Controller controller = new Controller(view);
    }
}
