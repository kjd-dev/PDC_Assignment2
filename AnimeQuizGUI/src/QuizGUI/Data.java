/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizGUI;

/**
 *
 * @author tuitauofiti
 */

public class Data 
{
    //Flags.
    boolean loginFlag = false; // Check if the user successfully login the system.
    boolean quitFlag = false; // Check if the user quit the system.
    boolean topicSelectFlag = false; // Check if the user has selected a topic.
    boolean roundSelectFlag = false; // Check if the user has selected a round.
    boolean startFlag = false; // Check if the quiz has started.
    boolean correct = false; // Check if the answer to the question is correct.
    
    // User's scores recorded.
    int currentScore = 0; // Store user's cumulative scores.
    int highScore = 0;
    
    // Questions List Stored.
    String topicChoice;
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String answer;
    String difficulty;
    
    int qNum; // number of questions for the quiz based of difficulty.
}
