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
    public fileHandler file;
    public Data data;
    public String username;
    
    public String topicChoice;
    public int roundsSelected;
    public List<String> randomQuestions;
    
        
    public Model() //Inititalises database class, questions class and fileHandler class
    {
        this.db = new Database();
        this.db.dbsetup();
        this.q = new Questions();
        this.file = new fileHandler();
    }
   
    public void checkName(String username, String password) //Pases input to database class to check if user exists in table
    {
        this.username = username;
        this.data = this.db.checkName(username, password);
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    //Passes user input to file reader to assign the appropriate questions according to selected topic
    public void selectTopic(String topic) 
    {
        this.topicChoice = topic;
        file.readQuestions(topic);
        this.q = file.getQuestions();
        this.data.topicSelectFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    //Creates a new question list with randomly selected questions, the list length is equal to selected roudns
    public void selectRounds(String rounds)
    {
        randomQuestions = q.setQuestionAmount(rounds);
        setQuestions();
    }
    
    //Method to set the question data in order for the view panel to update correctly
    private void setQuestions()
    {
        if(this.data.qNum == randomQuestions.size()) //If amount of rounds selected is reached, quit game automatically
        {
            quitGame();
        }
        else {
        String question = randomQuestions.get(this.data.qNum);
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
    }
    
    public boolean checkAnswer(String uAnswer) //When next button is clicked, check the users answer and set relevant information
    {
        
        
        if (uAnswer.toLowerCase().equals(data.answer.toLowerCase())) 
        {
            data.streak++;
            increaseScore(this.data.difficulty, data.streak);
            data.correct = true;
        }
        else
        {
            data.streak = 0;
            data.correct = false;
        }

        this.data.qNum++;
        setQuestions();
        
        return data.correct;
    }
    
    private void increaseScore(String tier, int streak) //Increase users current score, if they have a streak assign bonus points
    {
        int points = q.getPoints(tier);
        double multiplier = 1d;
        if(streak >= 3)
        {
            multiplier = 1 + ((streak / 10d)*streak);
        }
        data.bonusPoints = points *= multiplier;
        this.data.currentScore += data.bonusPoints;
    }
    
    public boolean isStreak()
    {
        return this.data.streak >= 3;
    }
    
    public int getStreak()
    {
        return this.data.streak;
    }
    
    public int getPoints()
    {
        return this.data.bonusPoints;
    }
    
    public void goBack()
    {
        this.data.topicSelectFlag = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    //Uses database to insert a users score if it is higher than their highest score, then flags quitgame
    public void quitGame()
    {
        this.db.quitGame(this.data.currentScore, this.data.highScore, this.username);
        if(this.data.currentScore >= this.data.highScore)
        {
            this.data.highScore = this.data.currentScore;
        }
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
}
