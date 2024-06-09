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
    public int streak = 0;
        
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
        
        this.data.topicSelectFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void selectRounds(String rounds)
    {
        switch(rounds)
        {
            case "1":
            {
                
                System.out.print("You have chosen 10 rounds! ");
                break;
            }
            case "2":
            {
                System.out.print("You have chosen 16 rounds! ");
                break;
            }
            case "3":
            {
                System.out.print("You have chosen 22 rounds! ");
                break;
            }
            case "4":
            {
                System.out.print("You have chosen the deathrun!");
                break;
            }
        }
        
        this.data.roundSelectFlag = true;
        this.data.startFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public boolean checkAnswer(String uAnswer)
    {
        data.question = "YES";
        data.option1 = "A) YES";
        data.option2 = "B) YES";
        data.option3 = "C) YES";
        data.option4 = "D) YES";
        
        if (uAnswer.toLowerCase().equals(data.answer.toLowerCase())) 
            {
//                System.out.println("Correct! ");
//                streak++;
//                increaseScore(tier, streak);
//                newScore = score;
                data.correct = true;
            }
        else
        {
            data.correct = false;
        }
//            else 
//            {
//                answer = q.getAnswer(question);
//                if(streak >= 3)
//                {
//                    System.out.println("Incorrect! The correct answer was " + answer + ".");
//                    System.out.println("STREAK BONUS LOST\n");
//                }
//                else
//                {
//                    System.out.println("Incorrect! The correct answer was " + answer + ".\n");
//                }
//                streak = 0;
//            }
        data.qNum++;
        this.setChanged();
        this.notifyObservers(this.data);
        
        return data.correct;
    }
    
    public void goBack()
    {
        this.data.topicSelectFlag = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void quitGame()
    {
        this.db.quitGame(this.data.currentScore, this.username);
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void listRounds()
    {
        
    }
}
