package com.example.ideapad510.sherkatquestionear.Questions;

public class QuestionObject {
    private String questionText;
    private int questionId;
    private int questionPart;

    public QuestionObject(String questionText, int questionId, int questionPart){
        this.questionText = questionText;
        this.questionId = questionId;
        this.questionPart = questionPart;
    }

    public String getQuestionText(){
        return questionText;
    }

    public int getQuestionId(){
        return questionId;
    }

    public int getQuestionPart(){
        return questionPart;
    }

}
