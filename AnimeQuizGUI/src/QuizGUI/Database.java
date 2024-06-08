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
    String url = "jdbc:derby://localhost:1527/Users";  //url of the DB host
                                                       //jdbc:derby://localhost:1527/Users
    String db_username = "JT";  //your DB username
    String db_password = "2009";   //your DB password
    
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
            System.out.println("Error has been detected!");
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
            ResultSet rs = statement.executeQuery("SELECT Users, Password, High_score FROM USERS " +
                                                  "WHERE Users = '" + username + "'");
            if (rs.next()) 
            {
                String pass = rs.getString("Password");
                System.out.println("***" + pass);
                System.out.println("User has been found!");
                /**
                 * If the username exists in the USERS table, and the
                 * password is correct, change the value of relating attributes
                 * of data. Otherwise, keep loginFlag as false.
                 */
                
                if (password.compareTo(pass) == 0) 
                {
                    data.currentScore = rs.getInt("High_score");
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
                 * If the username does not exist in the USERS table, then
                 * create a new account by using the inputted username and
                 * password.
                 */
                
                System.out.println("This user does not exist within the database!");
                statement.executeUpdate("INSERT INTO USERS " + "VALUES('" + username + "', '" + password + "', 0)");
                data.currentScore = 0;
                data.loginFlag = true;
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data; //Back to checkName() of Model.java.
    }

    private boolean checkTableExisting(String newTableName) 
    {
        boolean flag = false;
        
        try 
        {

            System.out.println("Checking if there is an existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            //Statement dropStatement=null;
            
            while (rsDBMeta.next()) 
            {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                
                if (tableName.compareToIgnoreCase(newTableName) == 0) 
                {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) 
            {
                rsDBMeta.close();
            }
        }
        catch (SQLException ex) 
        {
        }
        return flag;
    }

    public void quitGame(int score, String username) 
    {
        Statement statement;
        
        try 
        {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE USERS SET High_score = " + score + "WHERE Username = '" + username + "'");

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}