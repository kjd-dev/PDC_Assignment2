/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QuizGUI;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author james
 */
public class View2 extends JFrame implements Observer{

    /**
     * Creates new form View2
     */
    public View2() 
    {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    public String getUsername() 
    {
        return usernameField.getText();
    }

    public String getPassword() 
    {
        return new String(passwordField.getPassword());
    }
    
    public void selectTopic()
    {
        loginPanel.setVisible(false);
        topicPanel.setVisible(true);
    }
    
    public String getTopic() 
    {
        return new String(topicField.getText());
    }
    
    public void addActionListener(ActionListener listener)
    {
        this.loginButton.addActionListener(listener);
        this.topicButton.addActionListener(listener);
    }
    
    @Override
    public void update(Observable o, Object arg)
    {
       Data data = (Data) arg;
        if(!data.loginFlag)
        {
            this.usernameField.setText("");
            this.passwordField.setText("");
        }
        else if (!data.topicSelectFlag)
        {
            this.selectTopic();
            data.topicSelectFlag = true;
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
        topicField.setText("Enter selection e.g \"1\"");
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
        jLabel9.setText("2) Demon Slayer");

        jLabel10.setBackground(new java.awt.Color(168, 173, 173));
        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(134, 138, 138));
        jLabel10.setText("3) Dragonball");

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

        javax.swing.GroupLayout topicPanelLayout = new javax.swing.GroupLayout(topicPanel);
        topicPanel.setLayout(topicPanelLayout);
        topicPanelLayout.setHorizontalGroup(
            topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topicPanelLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
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
                .addContainerGap(62, Short.MAX_VALUE))
        );
        topicPanelLayout.setVerticalGroup(
            topicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
            .addGroup(topicPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
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
                        .addComponent(topicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(topicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Parent.add(topicPanel, "card3");

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Parent;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordIcon;
    private javax.swing.JButton topicButton;
    private javax.swing.JTextField topicField;
    private javax.swing.JPanel topicPanel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameIcon;
    // End of variables declaration//GEN-END:variables
}
