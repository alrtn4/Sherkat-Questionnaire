package com.example.ideapad510.sherkatquestionear.Questions;

//this class is based on QT column of questionnaire table that shows which question tables we need


public class QuestionDemandObject {
    private String questionTableName;
    private String startPosition;

    QuestionDemandObject(String questionTableName, String startPosition){
        this.questionTableName = questionTableName;
        this.startPosition = startPosition;
    }

    public String getQuestionTableName(){ return questionTableName;}

    public String getStartPosition(){ return startPosition;}
}