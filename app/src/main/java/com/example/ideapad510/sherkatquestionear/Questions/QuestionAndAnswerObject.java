package com.example.ideapad510.sherkatquestionear.Questions;


import java.util.ArrayList;

public class QuestionAndAnswerObject {
    public String question;
    public String answerStratString;
    public String answerEndString;
    private String questionId;

    QuestionAndAnswerObject(String question, String answerStartString, String answerEndString, String questionId){
        this.question = question;
        this.answerStratString = answerStartString;
        this.answerEndString = answerEndString;
        this.questionId = questionId;
    }

    public ArrayList<String> getAnswer(){
        ArrayList<String> answers = new ArrayList<>();
        answers.add(answerStratString);
        for(int i = 2 ; i <=9 ; i++)
            answers.add(String.valueOf(i));

        answers.add(answerEndString);

        return answers;
    }

    public String getQuestion(){
        return question;
    }

    public String getQuestionId(){
        return questionId;
    }
}
