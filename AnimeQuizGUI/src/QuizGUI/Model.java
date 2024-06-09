package QuizGUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

/**
 *
 * @author tuitauofiti
 */

public class Model extends Observable
{
    public Database db;
    public Questions q;
    public Data data;
    public String username;
    
    public String topicChoice;
    public int roundsSelected;
    public List<String> randomQuestions;
/*    
    public String question;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public String answer;
    public String difficulty;
    
    public List<String> easyQuestions;
    public List<String> mediumQuestions;
    public List<String> hardQuestions;
    public List<String> extremeQuestions;
 */   
    public int streak = 0;
        
    public Model()
    {
        this.db = new Database();
        this.db.dbsetup();
        this.q = new Questions();
    }
   
    public void checkName(String username, String password)
    {
        this.username = username;
        this.data = this.db.checkName(username, password);
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public int generateNumber(int range)
    {
        Random generator = new Random();
        int i = generator.nextInt(range);
        return i;
    }
   
    public void selectTopic(String topic)
    {
        this.topicChoice = topic;
        String fileName = "";
        List<String> questionList = new ArrayList<>();
        
        switch(topic)
        {
            case "1":
                fileName = "./anime_questions/AOT_questions.txt";
                System.out.println("aot");
                break;
            case "2":
                fileName = "./anime_questions/Bleach_questions.txt";
                break;
            case "3":
                fileName = "./anime_questions/DS_questions.txt";
                break;
            case "4":
                fileName = "./anime_questions/DB_questions.txt";
                break;
            case "5":
                fileName = "./anime_questions/HxH_questions.txt";
                break;
            case "6":
                fileName = "./anime_questions/JJK_questions.txt";
                break;
            case "7":
                fileName = "./anime_questions/Naruto_questions.txt";
                break;
            case "8":
                fileName = "./anime_questions/OP_questions.txt";
                break;
            case "9":
                fileName = "./anime_questions/OPM_questions.txt";
                break;
            case "10":
                fileName = "./anime_questions/Tensura_questions.txt";
                break;
            default:
                break;
        }
        
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            
            while((line = br.readLine()) != null)
            {
                String[] parts = line.split("\\|");
                String question = parts[0];
                    String option1 = parts[1];
                    String option2 = parts[2];
                    String option3 = parts[3];
                    String option4 = parts[4];
                    String answer = parts[5];
                    String difficulty = parts[6];
                    System.out.println(question);
                    System.out.println(option1);
                    q.addQuestion(question, option1, option2, option3, option4, answer, difficulty);
            }
            
            br.close();
        }
        catch(IOException ex)
        {
            System.err.println("IOException Error: " + ex.getMessage());
        }
        
//        String[] questionArray = questionList.get(questionList.size()-1).split("\\|");
//        
//        this.data.question = questionArray[0];
//        this.data.option1 = questionArray[1];
//        this.data.option2 = questionArray[2];
//        this.data.option3 = questionArray[3];
//        this.data.option4 = questionArray[4];
//        this.data.answer = questionArray[5];
//        this.data.difficulty = questionArray[6];
        this.data.topicSelectFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void selectRounds(String rounds)
    {
        this.roundsSelected = Integer.parseInt(rounds);        
        
        switch(rounds)
        {
            case "1":
            {
                System.out.print("You have chosen 10 rounds! ");
                randomQuestions = q.getRandomQuestions(10);
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
        
        String question = randomQuestions.get(0);
//        
        this.data.question = question;
        this.data.option1 = q.getOption1(question);
        this.data.option2 = q.getOption2(question);
        this.data.option3 = q.getOption3(question);
        this.data.option4 = q.getOption4(question);
        this.data.answer = q.getAnswer(question);
        this.data.difficulty = q.getDifficulty(question);
        this.data.roundSelectFlag = true;
        this.data.startFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public boolean checkAnswer(String uAnswer)
    {
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
        this.data.qNum++;
        String question = randomQuestions.get(this.data.qNum - 1);
//        
        this.data.question = question;
        this.data.option1 = q.getOption1(question);
        this.data.option2 = q.getOption2(question);
        this.data.option3 = q.getOption3(question);
        this.data.option4 = q.getOption4(question);
        this.data.answer = q.getAnswer(question);
        this.data.difficulty = q.getDifficulty(question);
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
}
