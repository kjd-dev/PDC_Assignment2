package QuizGUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author james
 */
public class Questions 
{
    private HashMap<String, String> questionAnswerMap;
    private HashMap<String, String> questionOption1Map;
    private HashMap<String, String> questionOption2Map;
    private HashMap<String, String> questionOption3Map;
    private HashMap<String, String> questionOption4Map;
    private HashMap<String, String> questionDifficultyMap;
    private List<String> easyQuestions;
    private List<String> mediumQuestions;
    private List<String> hardQuestions;
    private List<String> extremeQuestions;
    public Data data;
    
    public Questions() 
    {
        this.questionAnswerMap = new HashMap<>(); //Initialises multiple hashmaps to store a questions data in order for view panel to retreive them
        this.questionOption1Map = new HashMap<>();
        this.questionOption2Map = new HashMap<>();
        this.questionOption3Map = new HashMap<>();
        this.questionOption4Map = new HashMap<>();
        this.questionDifficultyMap = new HashMap<>();
        this.easyQuestions = new ArrayList<>(); //Initialises arrays to seperate questions by difficulty
        this.mediumQuestions = new ArrayList<>();
        this.hardQuestions = new ArrayList<>();
        this.extremeQuestions = new ArrayList<>();
    }
    
    //Puts questions into their appropriate array and hashmap
    public void addQuestion(String question, String option1, String option2, String option3, String option4, String answer, String difficulty) 
    {
        questionAnswerMap.put(question, answer);
        questionOption1Map.put(question, option1);
        questionOption2Map.put(question, option2);
        questionOption3Map.put(question, option3);
        questionOption4Map.put(question, option4);
        questionDifficultyMap.put(question, difficulty);
        
        switch (difficulty.trim().toLowerCase()) 
        {
            case "easy":
            {
                easyQuestions.add(question);
                break;
            }
            case "medium":
            {
                mediumQuestions.add(question);
                break;
            }
            case "hard":
            {
                hardQuestions.add(question);
                break;
            }
            case "extreme":
            {
                extremeQuestions.add(question);
                break;
            }
            default:
            {
                break;
            }
        }
    }
    
    //Randomises the questions lists and adds them to a single array based on how many rounds the user wants to play
    public List<String> getRandomQuestions(int rounds) 
    {
        List<String> selectedQuestions = new ArrayList<>();
        System.out.println(easyQuestions.size());
        Collections.shuffle(easyQuestions);
        Collections.shuffle(mediumQuestions);
        Collections.shuffle(hardQuestions);
        Collections.shuffle(extremeQuestions);

       if(rounds == 35)
       {
            addQuestionsFromTier(selectedQuestions, easyQuestions);
            addQuestionsFromTier(selectedQuestions, mediumQuestions);
            addQuestionsFromTier(selectedQuestions, hardQuestions);
            addQuestionsFromTier(selectedQuestions, extremeQuestions);
       }
        else
       {
            addQuestionsFromTier(selectedQuestions, easyQuestions, rounds/3);
            addQuestionsFromTier(selectedQuestions, mediumQuestions, rounds/3);
            addQuestionsFromTier(selectedQuestions, hardQuestions, rounds/3);
            addQuestionsFromTier(selectedQuestions, extremeQuestions, rounds%3);
       }

        return selectedQuestions;
    }
    
    private void addQuestionsFromTier(List<String> selectedQuestions, List<String> questions) 
    {
        for (int i = 0; i < questions.size(); i++) 
        {
            selectedQuestions.add(questions.get(i));
        }
    }
    
    private void addQuestionsFromTier(List<String> selectedQuestions, List<String> questions, int rounds) 
    {
        for (int i = 0; i < rounds && i < questions.size(); i++) 
        {
            selectedQuestions.add(questions.get(i));
        }
    }
    
    //Sets randomQuestion array length according to selected rounds
    public List<String> setQuestionAmount(String rounds)
    {
        List<String> randomQuestions = null;
        
        switch(rounds)
        {
            case "1":
            {
                randomQuestions = getRandomQuestions(10);
                break;
            }
            case "2":
            {
                randomQuestions = getRandomQuestions(16);
                break;
            }
            case "3":
            {
                randomQuestions = getRandomQuestions(22);
                break;
            }
            case "4":
            {
                randomQuestions = getRandomQuestions(35);
                break;
            }
            default:
                break;
        }
            
            return randomQuestions;
    }
    
    //Get methods to return a questions data
    public String getOption1(String question)
    {
        return questionOption1Map.get(question);
    }
    
    public String getOption2(String question)
    {
        return questionOption2Map.get(question);
    }
    
    public String getOption3(String question)
    {
        return questionOption3Map.get(question);
    }
    
    public String getOption4(String question)
    {
        return questionOption4Map.get(question);
    }
    
    public String getDifficulty(String question)
    {
        return questionDifficultyMap.get(question);
    }
    
    public String getAnswer(String question)
    {
        return questionAnswerMap.get(question);
    }
    
    public int getSize()
    {
        return easyQuestions.size();
    }
    
    public int getPoints(String tier) 
    {
        switch (tier.trim().toLowerCase()) 
        {
            case "easy":
                return 10; 
            case "medium":
                return 25;
            case "hard":
                return 50;
            case "extreme":
                return 100;
            default:
                return 0; 
        }
    }
    
    
}
