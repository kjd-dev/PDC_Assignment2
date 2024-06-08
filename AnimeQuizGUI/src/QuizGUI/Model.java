package QuizGUI;

import java.util.Observable;

/**
 *
 * @author tuitauofiti
 */

public class Model extends Observable
{
    public Database db;
    public Data data;
    public String question;
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
       
       if(data.loginFlag)
       {
           this.selectTopic();
       }
       
       this.setChanged();
       this.notifyObservers(this.data);
   }
   
   public void selectTopic()
   {
       
   }
   
   public void listRounds()
   {
       
   }
}
