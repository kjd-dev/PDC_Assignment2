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
    boolean loginFlag = false; // Check if the user successfully login the system.
    boolean quitFlag = false; // Check if the user quit the system.
    boolean topicSelectFlag = false; // Check if the user has selected a topic
    boolean roundSelectFlag = false;
    boolean startFlag = false;
    int currentScore = 0; // Store user's cumulative scores.
    String topicChoice;
    String question = "Is this working?";
    String option1 = "A) Test 1";
    String option2 = "B) Test 2";
    String option3 = "C) Test 3";
    String option4 = "D) Test 4";
    int qNum = 1;
}
