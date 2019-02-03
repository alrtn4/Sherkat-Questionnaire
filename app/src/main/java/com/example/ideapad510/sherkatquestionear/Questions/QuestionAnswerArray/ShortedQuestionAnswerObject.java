package com.example.ideapad510.sherkatquestionear.Questions.QuestionAnswerArray;


import java.util.ArrayList;

public class ShortedQuestionAnswerObject {
    public String question;
    public String answerStartString;
    public String answerEndString;
    private String questionId;

    ShortedQuestionAnswerObject(String question, String answerStartString, String answerEndString, String questionId){
        this.question = question;
        this.answerStartString = answerStartString;
        this.answerEndString = answerEndString;
        this.questionId = questionId;
    }

    public ArrayList<String> getAnswer(){
        ArrayList<String> answers = new ArrayList<>();
        answers.add(answerStartString);
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
