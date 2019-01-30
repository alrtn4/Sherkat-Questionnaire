package com.example.ideapad510.sherkatquestionear.Questions;


public class QuestionListDemandObject {
    private String questionTableName;
    private String startPosition;

    QuestionListDemandObject(String questionTableName, String startPosition){
        this.questionTableName = questionTableName;
        this.startPosition = startPosition;
    }

    public String getQuestionTableName(){ return questionTableName;}

    public String getStartPosition(){ return startPosition;}
}
