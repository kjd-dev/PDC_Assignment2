/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QuizGUI;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
public class View extends JFrame implements Observer{

    /**
     * Creates new form View
     */
    public View() 
    {
        initComponents();
        this.setTitle("Anime Quiz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    //Get methods to return user inputs form text field
    public String getUsername() 
    {
        return usernameField.getText();
    }

    public String getPassword() 
    {
        return new String(passwordField.getPassword());
    }
    
    public String getTopic() 
    {
        return new String(topicField.getText());
    }
    
    public String getRounds() 
    {
        return new String(roundsField.getText());
    }
    
    public String getAnswer() 
    {
        return new String(answerField.getText());
    }
    
    //Methods to swap the displayed panel
    public void startTopic()
    {
        loginPanel.setVisible(false);
        roundsPanel.setVisible(false);
        topicPanel.setVisible(true);
    }
    
    public void startRounds()
    {
        topicPanel.setVisible(false);
        roundsPanel.setVisible(true);
    }
    
    public void startQuiz()
    {
        roundsPanel.setVisible(false);
        questionsPanel.setVisible(true);
        this.streakText.setVisible(false);
        this.fireImage.setVisible(false);
    }
    
    //Method to update the questions panel with new information
    public void setQuestion(int qNum, String question, String option1, String option2, String option3, String option4, String difficulty)
    {
        this.answerField.setText("");
        this.questionNum.setText("ROUND " + (qNum+1));
        this.difficultyText.setText(difficulty);
        this.questionName.setText(question);
        this.option1.setText(option1);
        this.option2.setText(option2);
        this.option3.setText(option3);
        this.option4.setText(option4);
        this.resultText.setVisible(false);
    }
    
    //Creates a message pop up when input is invalid
    public void popError(String error)
    {
        JOptionPane.showMessageDialog(this, error);
    }
    
    //Creates action listener for all buttons
    public void addActionListener(ActionListener listener)
    {
        this.loginButton.addActionListener(listener);
        this.topicButton.addActionListener(listener);
        this.startButton.addActionListener(listener);
        this.backButton.addActionListener(listener);
        this.nextButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
    }
    
    //Displays if a users answer was correct or not
    public void showAnswer(boolean isCorrect)
    {
        this.resultText.setVisible(true);
        if( !isCorrect)
        {
            resultText.setText("Incorrect!");
        }
        else
        {
            resultText.setText("Correct!");

        }
    }
    
    //Shows and hides a streak bonus
    public void showStreak(int streak, int points)
    {
        this.streakText.setVisible(true);
        this.streakText.setText(streak + " streak bonus! +" + points);
        this.fireImage.setVisible(true);
        
    }
    
    public void hideStreak()
    {
        this.streakText.setVisible(false);
        this.fireImage.setVisible(false);
        
    }
    
    //Quits game
    public void quitGame(int currentScore, int highestScore)
    {
        this.questionsPanel.setVisible(false);
        this.quitPanel.setVisible(true);
        this.currentScore.setText("" + currentScore);
        this.highestScore.setText("Highest score: " + highestScore);
    }
    
    @Override
    public void update(Observable o, Object arg)
    {
       Data data = (Data) arg;
       if(data.quitFlag)
        {
            this.quitGame(data.currentScore, data.highScore);
        }
       else if(!data.loginFlag)
        {
            this.usernameField.setText("Username");
            this.passwordField.setText("Password");
            popError("Invalid credentials");
        }
        else if (!data.topicSelectFlag)
        {
            this.startTopic();
        }
        else if (!data.roundSelectFlag)
        {
            this.startRounds();
        }
        else if (data.startFlag = true)
        {
            this.startQuiz();
            this.setQuestion(data.qNum, data.question, data.option1, data.option2, data.option3, data.option4, data.difficulty);
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Parent = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        usernameIcon = new javax.swing.JLabel();
        passwordIcon = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        topicPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        topicField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        topicButton = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        roundsPanel = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        roundsField = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        questionsPanel = new javax.swing.JPanel();
        questionNum = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        answerField = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        option1 = new javax.swing.JLabel();
        option2 = new javax.swing.JLabel();
        option3 = new javax.swing.JLabel();
        option4 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        questionName = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        resultText = new javax.swing.JLabel();
        difficultyText = new javax.swing.JLabel();
        streakText = new javax.swing.JLabel();
        fireImage = new javax.swing.JLabel();
        quitPanel = new javax.swing.JPanel();
        questionNum1 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        currentScore = new javax.swing.JLabel();
        questionName1 = new javax.swing.JLabel();
        highestScore = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Parent.setLayout(new java.awt.CardLayout());

        loginPanel.setBackground(new java.awt.Color(230, 236, 237));

        usernameField.setBackground(new java.awt.Color(230, 236, 237));
        usernameField.setForeground(new java.awt.Color(168, 173, 173));
        usernameField.setText("Username");
        usernameField.setToolTipText("");
        usernameField.setBorder(null);

        passwordField.setBackground(new java.awt.Color(230, 236, 237));
        passwordField.setForeground(new java.awt.Color(168, 173, 173));
        passwordField.setText("Password");
        passwordField.setBorder(null);

        jSeparator1.setBackground(new java.awt.Color(28, 55, 87));
        jSeparator1.setForeground(new java.awt.Color(28, 55, 87));

        jSeparator2.setBackground(new java.awt.Color(28, 55, 87));
        jSeparator2.setForeground(new java.awt.Color(28, 55, 87));

        usernameIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user(1).png"))); // NOI18N

        passwordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/padlock(1).png"))); // NOI18N

        loginButton.setBackground(new java.awt.Color(230, 236, 237));
        loginButton.setForeground(new java.awt.Color(28, 55, 87));
        loginButton.setText("Log in");
        loginButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(28, 55, 87)));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("AppleGothic", 2, 9)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(134, 138, 138));
        jLabel1.setText("A new profile will be created if you do not");

        jLabel2.setBackground(new java.awt.Color(187, 187, 187));
        jLabel2.setFont(new java.awt.Font("AppleGothic", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(168, 173, 173));
        jLabel2.setText("Anime Quiz");

        jLabel3.setFont(new java.awt.Font("AppleGothic", 2, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(168, 173, 173));
        jLabel3.setText("by James & Tui");

        jLabel5.setFont(new java.awt.Font("AppleGothic", 2, 9)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(134, 138, 138));
        jLabel5.setText("already have one");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LGIN(1)(1).jpg"))); // NOI18N

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(passwordField)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator2))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)))
                .addGap(51, 51, 51))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(53, 53, 53)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                            .addComponent(usernameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35))
                        .addComponent(passwordIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Parent.add(loginPanel, "card2");

        topicPanel.setBackground(new java.awt.Color(230, 236, 237));

        jLabel8.setBackground(new java.awt.Color(187, 187, 187));
        jLabel8.setFont(new java.awt.Font("AppleGothic", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(168, 173, 173));
        jLabel8.setText("SELECT TOPIC");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tpc.jpg"))); // NOI18N

        topicField.setBackground(new java.awt.Color(230, 236, 237));
        topicField.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        topicField.setForeground(new java.awt.Color(168, 173, 173));
        topicField.setBorder(null);
        topicField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topicFieldActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(28, 55, 87));
        jSeparator3.setForeground(new java.awt.Color(28, 55, 87));

        jLabel6.setBackground(new java.awt.Color(168, 173, 173));
        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(134, 138, 138));
        jLabel6.setText("1) Attack On Titan");

        jLabel7.setBackground(new java.awt.Color(168, 173, 173));
        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(134, 138, 138));
        jLabel7.setText("2) Bleach");

        jLabel9.setBackground(new java.awt.Color(168, 173, 173));
        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(134, 138, 138));
        jLabel9.setText("3) Demon Slayer");

        jLabel10.setBackground(new java.awt.Color(168, 173, 173));
        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(134, 138, 138));
        jLabel10.setText("4) Dragonball");

        jLabel12.setBackground(new java.awt.Color(168, 173, 173));
        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(134, 138, 138));
        jLabel12.setText("5) Hunter x Hunter");

        jLabel13.setBackground(new java.awt.Color(168, 173, 173));
        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(134, 138, 138));
        jLabel13.setText("6) Jujutsu Kaisen");

        jLabel14.setBackground(new java.awt.Color(168, 173, 173));
        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(134, 138, 138));
        jLabel14.setText("7) Naruto");

        jLabel15.setBackground(new java.awt.Color(168, 173, 173));
        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(134, 138, 138));
        jLabel15.setText("8) One Piece");

        jLabel16.setBackground(new java.awt.Color(168, 173, 173));
        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(134, 138, 138));
        jLabel16.setText("9) One Punch Man");

        jLabel17.setBackground(new java.awt.Color(168, 173, 173));
        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(134, 138, 138));
        jLabel17.setText("10) Tensura");

        topicButton.setBackground(new java.awt.Color(230, 236, 237));
        topicButton.setForeground(new java.awt.Color(28, 55, 87));
        topicButton.setText("Select");
        topicButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(28, 55, 87)));
        topicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topicButtonActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(168, 173, 173));
        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(168, 173, 173));
        jLabel18.setText("Enter selection e.g \"1\"");

        javax.swing.GroupLayout topicPanelLayout = new javax.swing.GroupLayout(topicPanel);
        topicPanel.setLayout(topicPanelLayout);
        topicPanelLayout.setHorizontalGroup(
            topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topicPanelLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8)
                        .addGroup(topicPanelLayout.createSequentialGroup()
                            .addGroup(topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel12)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16)
                                .addComponent(jLabel17)))
                        .addGroup(topicPanelLayout.createSequentialGroup()
                            .addGroup(topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator3)
                                .addComponent(topicField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(topicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel18))
                .addGap(114, 114, 114))
        );
        topicPanelLayout.setVerticalGroup(
            topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(topicPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addGap(28, 28, 28)
                .addGroup(topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topicPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topicPanelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addGap(37, 37, 37)
                .addGroup(topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topicPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(topicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(topicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Parent.add(topicPanel, "card3");

        roundsPanel.setBackground(new java.awt.Color(230, 236, 237));

        jLabel32.setBackground(new java.awt.Color(187, 187, 187));
        jLabel32.setFont(new java.awt.Font("AppleGothic", 1, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(168, 173, 173));
        jLabel32.setText("SELECT ROUNDS");

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rounds.jpg"))); // NOI18N

        roundsField.setBackground(new java.awt.Color(230, 236, 237));
        roundsField.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        roundsField.setForeground(new java.awt.Color(168, 173, 173));
        roundsField.setBorder(null);
        roundsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundsFieldActionPerformed(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(28, 55, 87));
        jSeparator5.setForeground(new java.awt.Color(28, 55, 87));

        jLabel34.setBackground(new java.awt.Color(168, 173, 173));
        jLabel34.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(134, 138, 138));
        jLabel34.setText("1) 10");

        jLabel35.setBackground(new java.awt.Color(168, 173, 173));
        jLabel35.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(134, 138, 138));
        jLabel35.setText("2) 16");

        jLabel36.setBackground(new java.awt.Color(168, 173, 173));
        jLabel36.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(134, 138, 138));
        jLabel36.setText("3) 22");

        jLabel37.setBackground(new java.awt.Color(168, 173, 173));
        jLabel37.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(134, 138, 138));
        jLabel37.setText("4) DEATHRUN");

        startButton.setBackground(new java.awt.Color(230, 236, 237));
        startButton.setForeground(new java.awt.Color(28, 55, 87));
        startButton.setText("Start");
        startButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(28, 55, 87)));
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jLabel44.setBackground(new java.awt.Color(168, 173, 173));
        jLabel44.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(168, 173, 173));
        jLabel44.setText("Enter selection e.g \"1\"");

        backButton.setBackground(new java.awt.Color(230, 236, 237));
        backButton.setForeground(new java.awt.Color(28, 55, 87));
        backButton.setText("Back");
        backButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(28, 55, 87)));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundsPanelLayout = new javax.swing.GroupLayout(roundsPanel);
        roundsPanel.setLayout(roundsPanelLayout);
        roundsPanelLayout.setHorizontalGroup(
            roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundsPanelLayout.createSequentialGroup()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundsPanelLayout.createSequentialGroup()
                        .addGroup(roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel35)
                            .addComponent(jLabel32))
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundsPanelLayout.createSequentialGroup()
                        .addGroup(roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundsPanelLayout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundsPanelLayout.createSequentialGroup()
                                .addGroup(roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator5)
                                    .addComponent(roundsField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))))
        );
        roundsPanelLayout.setVerticalGroup(
            roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundsPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel32)
                .addGap(29, 29, 29)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundsPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(roundsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        Parent.add(roundsPanel, "card3");

        questionsPanel.setBackground(new java.awt.Color(230, 236, 237));

        questionNum.setBackground(new java.awt.Color(187, 187, 187));
        questionNum.setFont(new java.awt.Font("AppleGothic", 1, 36)); // NOI18N
        questionNum.setForeground(new java.awt.Color(168, 173, 173));
        questionNum.setText("QUESTION 1");

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/questions.jpg"))); // NOI18N

        answerField.setBackground(new java.awt.Color(230, 236, 237));
        answerField.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        answerField.setForeground(new java.awt.Color(168, 173, 173));
        answerField.setBorder(null);
        answerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerFieldActionPerformed(evt);
            }
        });

        jSeparator6.setBackground(new java.awt.Color(28, 55, 87));
        jSeparator6.setForeground(new java.awt.Color(28, 55, 87));

        option1.setBackground(new java.awt.Color(168, 173, 173));
        option1.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        option1.setForeground(new java.awt.Color(134, 138, 138));
        option1.setText("A) Option 1");

        option2.setBackground(new java.awt.Color(168, 173, 173));
        option2.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        option2.setForeground(new java.awt.Color(134, 138, 138));
        option2.setText("B) Option 2");

        option3.setBackground(new java.awt.Color(168, 173, 173));
        option3.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        option3.setForeground(new java.awt.Color(134, 138, 138));
        option3.setText("C) Option 3");

        option4.setBackground(new java.awt.Color(168, 173, 173));
        option4.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        option4.setForeground(new java.awt.Color(134, 138, 138));
        option4.setText("D) Option 4");

        nextButton.setBackground(new java.awt.Color(230, 236, 237));
        nextButton.setForeground(new java.awt.Color(28, 55, 87));
        nextButton.setText("Next");
        nextButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(28, 55, 87)));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        jLabel45.setBackground(new java.awt.Color(168, 173, 173));
        jLabel45.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(168, 173, 173));
        jLabel45.setText("Enter selection e.g \"A\"");

        questionName.setFont(new java.awt.Font("AppleGothic", 0, 12)); // NOI18N
        questionName.setForeground(new java.awt.Color(134, 138, 138));
        questionName.setText("Question");

        quitButton.setBackground(new java.awt.Color(230, 236, 237));
        quitButton.setForeground(new java.awt.Color(28, 55, 87));
        quitButton.setText("Quit");
        quitButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(28, 55, 87)));
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        resultText.setForeground(new java.awt.Color(134, 138, 138));
        resultText.setText("Incorrect!");

        difficultyText.setFont(new java.awt.Font("AppleGothic", 2, 14)); // NOI18N
        difficultyText.setForeground(new java.awt.Color(168, 173, 173));
        difficultyText.setText("(easy)");

        streakText.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        streakText.setForeground(new java.awt.Color(168, 173, 173));
        streakText.setText("3 Streak bonus! +1500");

        fireImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flame.png"))); // NOI18N

        javax.swing.GroupLayout questionsPanelLayout = new javax.swing.GroupLayout(questionsPanel);
        questionsPanel.setLayout(questionsPanelLayout);
        questionsPanelLayout.setHorizontalGroup(
            questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionsPanelLayout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(questionsPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(questionsPanelLayout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator6)
                                    .addGroup(questionsPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(questionsPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(answerField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                            .addGroup(questionsPanelLayout.createSequentialGroup()
                                .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(option2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(option3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(option4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(questionsPanelLayout.createSequentialGroup()
                                        .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(questionName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(option1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(55, 55, 55))
                                    .addGroup(questionsPanelLayout.createSequentialGroup()
                                        .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(difficultyText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(questionNum))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(streakText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionsPanelLayout.createSequentialGroup()
                                                .addComponent(fireImage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60)))))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionsPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resultText)
                        .addGap(50, 50, 50))))
        );
        questionsPanelLayout.setVerticalGroup(
            questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(questionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(questionsPanelLayout.createSequentialGroup()
                        .addComponent(questionNum)
                        .addGap(10, 10, 10)
                        .addComponent(difficultyText))
                    .addGroup(questionsPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(fireImage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(streakText)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(questionName)
                .addGap(18, 18, 18)
                .addComponent(option1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(questionsPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(answerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        Parent.add(questionsPanel, "card3");

        quitPanel.setBackground(new java.awt.Color(230, 236, 237));

        questionNum1.setBackground(new java.awt.Color(187, 187, 187));
        questionNum1.setFont(new java.awt.Font("AppleGothic", 1, 24)); // NOI18N
        questionNum1.setForeground(new java.awt.Color(168, 173, 173));
        questionNum1.setText("THANK YOU FOR PLAYING");

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/quitImage.jpg"))); // NOI18N

        currentScore.setBackground(new java.awt.Color(168, 173, 173));
        currentScore.setFont(new java.awt.Font("AppleGothic", 0, 48)); // NOI18N
        currentScore.setForeground(new java.awt.Color(134, 138, 138));
        currentScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentScore.setText("100");

        questionName1.setFont(new java.awt.Font("AppleGothic", 0, 18)); // NOI18N
        questionName1.setForeground(new java.awt.Color(134, 138, 138));
        questionName1.setText("YOUR SCORE WAS:");

        highestScore.setFont(new java.awt.Font("AppleGothic", 0, 12)); // NOI18N
        highestScore.setForeground(new java.awt.Color(134, 138, 138));
        highestScore.setText("Highest score: 1000");

        javax.swing.GroupLayout quitPanelLayout = new javax.swing.GroupLayout(quitPanel);
        quitPanel.setLayout(quitPanelLayout);
        quitPanelLayout.setHorizontalGroup(
            quitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quitPanelLayout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(quitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quitPanelLayout.createSequentialGroup()
                        .addComponent(questionNum1)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quitPanelLayout.createSequentialGroup()
                        .addGroup(quitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(quitPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(currentScore, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(questionName1))
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quitPanelLayout.createSequentialGroup()
                        .addComponent(highestScore)
                        .addGap(198, 198, 198))))
        );
        quitPanelLayout.setVerticalGroup(
            quitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(quitPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(questionNum1)
                .addGap(57, 57, 57)
                .addComponent(questionName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highestScore)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Parent.add(quitPanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

    }//GEN-LAST:event_loginButtonActionPerformed

    private void topicFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topicFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topicFieldActionPerformed

    private void topicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topicButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topicButtonActionPerformed

    private void answerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answerFieldActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quitButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed

    private void roundsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundsFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Parent;
    private javax.swing.JTextField answerField;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel currentScore;
    private javax.swing.JLabel difficultyText;
    private javax.swing.JLabel fireImage;
    private javax.swing.JLabel highestScore;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel option1;
    private javax.swing.JLabel option2;
    private javax.swing.JLabel option3;
    private javax.swing.JLabel option4;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordIcon;
    private javax.swing.JLabel questionName;
    private javax.swing.JLabel questionName1;
    private javax.swing.JLabel questionNum;
    private javax.swing.JLabel questionNum1;
    private javax.swing.JPanel questionsPanel;
    private javax.swing.JButton quitButton;
    private javax.swing.JPanel quitPanel;
    private javax.swing.JLabel resultText;
    private javax.swing.JTextField roundsField;
    private javax.swing.JPanel roundsPanel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel streakText;
    private javax.swing.JButton topicButton;
    private javax.swing.JTextField topicField;
    private javax.swing.JPanel topicPanel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameIcon;
    // End of variables declaration//GEN-END:variables
}
