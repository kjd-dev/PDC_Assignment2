/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuizGUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileHandler 
{
    public Questions q;
    
    public fileHandler()
    {
        this.q = new Questions();
    }
    
    public void readQuestions(String topic)
    {
        
        String fileName = "";
        switch(topic) //Uses a switch case to detect what text file to read
           {
               case "1":
                   fileName = "./anime_questions/AOT_questions.txt";
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
                    q.addQuestion(question, option1, option2, option3, option4, answer, difficulty);
            }
            
            br.close();
        }
        catch(IOException ex)
        {
            System.err.println("IOException Error: " + ex.getMessage());
        }   
    }
    
    public Questions getQuestions() //Passes questions to model class
    {
        return q;
    }
}
