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
public class Question {

    private int number;
    private String info;
    private ArrayList<Answer> listAnswer = new ArrayList<>();
    private String correctAnswer;

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Question(int number, String info) {
        this.number = number;
        this.info = info;
    }

    public Question() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<Answer> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(ArrayList<Answer> listAnswer) {
        this.listAnswer = listAnswer;
    }

    public ArrayList<Answer> createNewAnswers() {
        ArrayList<Answer> listAnswers = new ArrayList<>();
        Answer a1 = new Answer();
        a1.setNumber(1);
        Answer a2 = new Answer();
        a2.setNumber(2);
        listAnswers.add(a1);
        listAnswers.add(a2);
        this.listAnswer = listAnswers;
        return listAnswers;
    }
}
