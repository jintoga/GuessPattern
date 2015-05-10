/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesspattern;

import java.util.ArrayList;

/**
 *
 * @author DAT
 */
public class GuessPattern {

    /**
     * @param args the command line arguments
     */
    private static final ArrayList<Question> listQuestions = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        Procedures instance = new Procedures(listQuestions);
        instance.createNewQuestions();
        instance.generateQuestions();
        instance.generateAnswersForQuestions();
        instance.generateCorrectAnswers();
        instance.playGame();

    }

}
