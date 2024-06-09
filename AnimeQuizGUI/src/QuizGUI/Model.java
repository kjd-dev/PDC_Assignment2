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
   
    public void selectTopic(String topic)
    {
        switch(topic)
        {
            case "1":
            {
                
                System.out.print("You have chosen Attack on Titan! ");
                break;
            }
            case "2":
            {
                System.out.print("You have chosen Bleach! ");
                break;
            }
            case "3":
            {
                System.out.print("You have chosen Demon Slayer! ");
                break;
            }
            case "4":
            {
                System.out.print("You have chosen Dragon Ball! ");
                break;
            }
            case "5":
            {
                System.out.print("You have chosen Hunter x Hunter! ");
                break;
            }
            case "6":
            {
                System.out.print("You have chosen Jujutsu Kaisen! ");
                break;
            }
            case "7":
            {
                System.out.print("You have chosen Naruto! ");
                break;
            }
            case "8":
            {
                System.out.print("You have chosen One Piece! ");
                break;
            }
            case "9":
            {
                System.out.print("You have chosen One Punch Man! ");
                break;
            }
            case "10":
            {
                System.out.print("You have chosen That Time I Got Reincarnated as a Slime! ");
                break;
            }
        }
    }
    
    public void listRounds()
    {
        
    }
}
