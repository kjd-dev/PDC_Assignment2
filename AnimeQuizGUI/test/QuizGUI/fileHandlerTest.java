/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package QuizGUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author james
 */
public class fileHandlerTest {
    
    public fileHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readQuestions method, of class fileHandler.
     */
    @Test
    public void testReadQuestions() 
    {
        Questions q = new Questions();
        String topic = "./anime_questions/OP_questions.txt";
        fileHandler instance = new fileHandler();
        
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(topic));
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
                    System.out.println(option2);
                    System.out.println(option3);
                    System.out.println(option4);
                    System.out.println(difficulty);
                    q.addQuestion(question, option1, option2, option3, option4, answer, difficulty);
                    System.out.println("Added.\n");
            }
            
            br.close();
        }
        catch(IOException ex)
        {
            System.err.println("IOException Error: " + ex.getMessage());
        }   
        int expected = 10; //There should be 10 questions added to the easy questions list
        int actual = q.getSize();
        Assert.assertEquals(expected, actual);
    }

    /**
     * Test of getQuestions method, of class fileHandler.
     */
    
    
}
