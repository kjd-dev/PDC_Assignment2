package QuizGUI;

import java.util.Observable;
import java.util.Scanner;

/**
 *
 * @author tuitauofiti
 */

public class Model extends Observable
{
    public Database db;
    public Data data;
    public int topicChoice;
    public String username;
        
    public Model()
    {
        this.db = new Database();
        this.db.dbsetup();
    }
   
    public void checkName(String username, String password)
    {
        this.username = username;
        this.data = this.db.checkName(username, password);
       
//       if(data.loginFlag)
//       {
//           this.selectTopic();
//       }
       
        this.setChanged();
        this.notifyObservers(this.data);
    }
   
//    public void selectTopic(String topic)
//    {
//        this.topicChoice
//    }
    
    public void listRounds()
    {
        
    }
}
