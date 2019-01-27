package com.example.ideapad510.sherkatquestionear.Questions;

public class QuestionObject {
    String questionText;
    int questionId;

    public QuestionObject(String questionText, int questionId){
        this.questionText = questionText;
        this.questionId = questionId;
    }

    public String getQuestionText(){
        return questionText;
    }

    public int getQuestionId(){
        return questionId;
    }

}
