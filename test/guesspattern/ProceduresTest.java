/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesspattern;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author DAT
 */
public class ProceduresTest {

    private Scanner scanner = null;
    private ArrayList<Question> listQuestions = null;

    public ProceduresTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.listQuestions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getListQuestions method, of class Procedures.
     */
    @Test
    public void testGetListQuestions() {
        System.out.println("getListQuestions");
        Procedures instance = new Procedures();
        ArrayList<Question> expResult = null;
        ArrayList<Question> result = instance.getListQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setListQuestions method, of class Procedures.
     */
    @Test
    public void testSetListQuestions() {
        System.out.println("setListQuestions");
        ArrayList<Question> listQuestions = null;
        Procedures instance = new Procedures();
        instance.setListQuestions(listQuestions);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of test method, of class Procedures.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Procedures instance = new Procedures(listQuestions);
        instance.test();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createNewQuestions method, of class Procedures.
     */
    @Test
    public void testCreateNewQuestions() {
        System.out.println("createNewQuestions");
        Procedures instance = new Procedures(listQuestions);
        instance.createNewQuestions();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(4, listQuestions.size());
    }

    /**
     * Test of generateAnswersForQuestions method, of class Procedures.
     */
    @Test
    public void testGenerateAnswersForQuestions() {
        System.out.println("generateAnswersForQuestions");
        Procedures instance = new Procedures(listQuestions);
        instance.createNewQuestions();
        instance.generateQuestions();

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(4, listQuestions.size());
        for (Question question : instance.getListQuestions()) {
            assertNotSame("", question.getInfo());
            for (Answer answer : question.getListAnswer()) {
                assertNotSame("", answer.getAnswer());
            }
        }

    }

    /**
     * Test of generateQuestions method, of class Procedures.
     */
    @Test
    public void testGenerateQuestions() {
        System.out.println("generateQuestions");
        Procedures instance = new Procedures(listQuestions);
        instance.createNewQuestions();
        instance.generateQuestions();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(4, listQuestions.size());
        for (Question question : listQuestions) {
            assertNotNull(question.getInfo(), this);
        }

    }

    /**
     * Test of generateCorrectAnswers method, of class Procedures.
     */
    @Test
    public void testGenerateCorrectAnswers() {
        System.out.println("generateCorrectAnswers");
        Procedures instance = new Procedures(listQuestions);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        instance.createNewQuestions();
        instance.generateQuestions();
        instance.generateCorrectAnswers();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(4, listQuestions.size());
        for (Question question : instance.getListQuestions()) {
            assertNotSame("", question.getCorrectAnswer());

        }
    }

    /**
     * Test of playGame method, of class Procedures.
     *
     *
     */
    @Test
    public void testPlayGame() {
        System.out.println("playGame");
        Procedures instance = new Procedures(listQuestions);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        instance.createNewQuestions();
        instance.generateQuestions();
        instance.generateCorrectAnswers();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(4, listQuestions.size());

        int point = 0;
        for (Question question : listQuestions) {
            System.out.println("Question " + question.getNumber() + ":");
            System.out.println(question.getInfo());
            for (Answer answer : question.getListAnswer()) {
                System.out.println("Answer " + answer.getNumber() + ": " + answer.getAnswer());
                assertNotSame("", answer.getAnswer());
            }
            int chooseAnswer = 0;
            boolean validChecker = true;

            String warning = "Enter number of your answer:";
            assertEquals(chooseAnswer, 0);
            assertEquals(validChecker, true);

            do {
                System.out.println(warning);

                try {
                    String data = "Users Input";
                    System.setIn(new ByteArrayInputStream(data.getBytes()));

                    Scanner scanner = new Scanner(System.in);
                    chooseAnswer = scanner.nextShort();
                    assertEquals(2, chooseAnswer);
                    if (chooseAnswer <= question.getListAnswer().size() && chooseAnswer > 0) {
                        System.out.println("Answer accepted");
                        System.out.println("size:" + question.getListAnswer().size());
                        if (question.getCorrectAnswer().equals(question.getListAnswer().get(chooseAnswer - 1).getAnswer())) {
                            point++;

                        }
                        validChecker = true;
                        assertEquals(true, validChecker);
                    } else {
                        warning = "Invalid number! Enter number of your answer:";
                        validChecker = false;
                        assertNotSame("Enter number of your answer:", warning);
                        assertEquals(false, validChecker);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input");
                    break;
                }
            } while (validChecker == false);
        }
    }

}
