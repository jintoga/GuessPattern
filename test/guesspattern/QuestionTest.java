/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesspattern;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DAT
 */
public class QuestionTest {
    
    public QuestionTest() {
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
     * Test of getNumber method, of class Question.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        Question instance = new Question();
        int expResult = 0;
        int result = instance.getNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumber method, of class Question.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 0;
        Question instance = new Question();
        instance.setNumber(number);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo method, of class Question.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        Question instance = new Question();
        String expResult = "";
        String result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInfo method, of class Question.
     */
    @Test
    public void testSetInfo() {
        System.out.println("setInfo");
        String info = "";
        Question instance = new Question();
        instance.setInfo(info);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListAnswer method, of class Question.
     */
    @Test
    public void testGetListAnswer() {
        System.out.println("getListAnswer");
        Question instance = new Question();
        ArrayList<Answer> expResult = null;
        ArrayList<Answer> result = instance.getListAnswer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListAnswer method, of class Question.
     */
    @Test
    public void testSetListAnswer() {
        System.out.println("setListAnswer");
        ArrayList<Answer> listAnswer = null;
        Question instance = new Question();
        instance.setListAnswer(listAnswer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewAnswers method, of class Question.
     */
    @Test
    public void testCreateNewAnswers() {
        System.out.println("createNewAnswers");
        Question instance = new Question();
        ArrayList<Answer> expResult = null;
        ArrayList<Answer> result = instance.createNewAnswers();
        assertEquals(2, instance.createNewAnswers().size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
