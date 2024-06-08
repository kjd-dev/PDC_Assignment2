/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package QuizGUI;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author james
 */
public class ControllerTest {
    
    private int errors = 0;
    
    public ControllerTest() {
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
     * Test of actionPerformed method, of class Controller.
     */
    
    public void testLogin()
    {
        View2 view = new View2();
        view.setVisible(true);
        Model model = new Model();
        Controller controller = new Controller(view, model);
    }
    
    @Test
    public void testActionPerformed() 
    {
        ControllerTest test = new ControllerTest();
        try {
            test.testLogin();
        }
        catch(Throwable e)
        {
            test.errors++;
            throw new RuntimeException("Errors found: " + errors);
        }
    }
    
}
