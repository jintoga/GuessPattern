/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesspattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAT
 */
public class Procedures {

    private final static Scanner scanner = new Scanner(System.in);
    private ArrayList<Question> listQuestions = null;

    public ArrayList<Question> getListQuestions() {
        return listQuestions;
    }

    public void setListQuestions(ArrayList<Question> listQuestions) {
        this.listQuestions = listQuestions;
    }

    public Procedures() {
    }

    public Procedures(ArrayList<Question> listQuestions) {
        this.listQuestions = listQuestions;

    }

    public void test() {
        for (Question question : getListQuestions()) {
            System.out.println("Question #:" + question.getNumber());
            System.out.println("Info:" + "\n" + question.getInfo());
        }
    }

    public void createNewQuestions() {

        Question q1 = new Question();
        q1.setNumber(1);
        Question q2 = new Question();
        q2.setNumber(2);
        Question q3 = new Question();
        q3.setNumber(3);
        Question q4 = new Question();
        q4.setNumber(4);
        listQuestions.add(q1);
        listQuestions.add(q2);
        listQuestions.add(q3);
        listQuestions.add(q4);
    }

    public void generateCorrectAnswers() {
        BufferedReader br = null;
        String everything = null;
        if (listQuestions != null) {
            for (Question question : listQuestions) {

                try {
                    br = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "questions" + File.separator + "q" + question.getNumber() + "correct" + ".txt"));

                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();
                    while (line != null) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                    }
                    everything = sb.toString();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GuessPattern.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GuessPattern.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        br.close();
                    } catch (IOException ex) {
                        Logger.getLogger(GuessPattern.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                question.setCorrectAnswer(everything);

            }
        }
    }

    public void generateAnswersForQuestions() {
        BufferedReader br = null;
        String everything = null;
        if (listQuestions != null) {
            for (Question question : listQuestions) {

                if (question.createNewAnswers().size() > 0) {
                    for (Answer answer : question.createNewAnswers()) {
                        try {
                            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "questions" + File.separator + "q" + question.getNumber() + "a" + answer.getNumber() + ".txt"));
                            //System.out.println("readed: " + "q" + question.getNumber() + "a" + answer.getNumber() + ".txt");
                            StringBuilder sb = new StringBuilder();
                            String line = br.readLine();
                            while (line != null) {
                                sb.append(line);
                                sb.append(System.lineSeparator());
                                line = br.readLine();
                            }
                            everything = sb.toString();

                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(GuessPattern.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(GuessPattern.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            try {
                                br.close();
                            } catch (IOException ex) {
                                Logger.getLogger(GuessPattern.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        answer.setAnswer(everything);
                    }
                }
            }
        }
    }

    public void generateQuestions() {

        BufferedReader br = null;
        String everything = null;

        if (listQuestions != null) {
            for (Question question : listQuestions) {

                try {
                    br = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "questions" + File.separator + "q" + question.getNumber() + ".txt"));
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();
                    while (line != null) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                    }
                    everything = sb.toString();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GuessPattern.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GuessPattern.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        br.close();
                    } catch (IOException ex) {
                        Logger.getLogger(GuessPattern.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                question.setInfo(everything);
            }

        }

    }

    public void playGame() {
        //ArrayList<Integer> listNumberOfAnswers = new ArrayList<>();
        int point = 0;
        for (Question question : listQuestions) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Question " + question.getNumber() + ":");
            System.out.println(question.getInfo());
            for (Answer answer : question.getListAnswer()) {
                System.out.println("Answer " + answer.getNumber() + ": " + answer.getAnswer());
                //listNumberOfAnswers.add(answer.getNumber());
            }
            int chooseAnswer = 0;
            boolean validChecker = true;
            String warning = "Enter number of your answer:";
            do {
                System.out.println(warning);

                try {
                    chooseAnswer = scanner.nextShort();
                    if (chooseAnswer <= question.getListAnswer().size() && chooseAnswer > 0) {
                        System.out.println("Answer accepted\n\n");
                        //System.out.println("size:" + question.getListAnswer().size());
                        if (question.getCorrectAnswer().equals(question.getListAnswer().get(chooseAnswer - 1).getAnswer())) {
                            point++;

                        }
                        validChecker = true;
                    } else {
                        warning = "Invalid number! Enter number of your answer:";
                        validChecker = false;
                    }
                } catch (InputMismatchException e) {

                    System.out.println("Invalid input");

                    break;
                }

            } while (validChecker == false);
        }

        System.out.println("Your Result:" + point + "/" + listQuestions.size());
    }
}
