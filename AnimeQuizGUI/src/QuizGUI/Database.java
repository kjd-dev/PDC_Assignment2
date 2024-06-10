/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizGUI;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuitatauofiti
 */

public class Database 
{
    Connection conn = null;
    String url = "jdbc:derby://localhost:1527/Users";  
    String db_username = "JT";  
    String db_password = "2009";   
    
    public void dbsetup() 
    {
        try 
        {
            conn = DriverManager.getConnection(url, db_username, db_password);
            Statement statement = conn.createStatement();
            String tableName = "USERS";

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (Username VARCHAR(20), Password VARCHAR(10), High_Score INT)");
            }
            statement.close();

        }
        catch (Throwable e) 
        {
            e.printStackTrace();
        }
    }
    
    /**
     * @param username
     * @param password
     * @return data
     */
    
    public Data checkName(String username, String password)
    {
        Data data = new Data(); // Initialize an instance of Data.
        
        try 
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT Username, Password, High_score FROM USERS " +
                                                  "WHERE Username = '" + username + "'");
            if (rs.next()) 
            {
                String pass = rs.getString("Password");
                /**
                 * If the if the user exists and the password is correct, update their high score
                 */
                
                if (password.compareTo(pass) == 0) 
                {
                    data.highScore = rs.getInt("High_score");
                    data.loginFlag = true;
                }
                else 
                {
                    data.loginFlag = false;
                }
            } 
            else
            {
                /**
                 * If the user does not exist in the USERS table, then
                 * create a new account 
                 */
                statement.executeUpdate("INSERT INTO USERS "
                        + "VALUES('" + username + "', '" + password + "', 0)");
                data.highScore = 0;
                data.loginFlag = true;
                
            }
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        
        return data; 
    }

    private boolean checkTableExisting(String newTableName) 
    {
        boolean flag = false;
        try {
            System.out.println("Checking existing tables...");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            
            try (ResultSet rsDBMeta = dbmd.getTables(null, null, newTableName.toUpperCase(), types)) {
                while (rsDBMeta.next()) {
                    String tableName = rsDBMeta.getString("TABLE_NAME");
                    if (tableName.equalsIgnoreCase(newTableName)) {
                        System.out.println(tableName + " already exists");
                        flag = true;
                        break;
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }
    
    public void quitGame(int score, int highScore, String username) 
    {
        Statement statement;
        
        try 
        {
            if(score > highScore)
            {
                statement = conn.createStatement();
                statement.executeUpdate("UPDATE USERS SET High_score = " + score + "WHERE Username = '" + username + "'");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}