package com.example.ideapad510.sherkatquestionear.Questions;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;

public class AnswerControler {
    private Database db;

    AnswerControler(Context context){
        db = Database.getInstance(context);

    }

    public String getRowQuestion(int questionId){
        return db.getRowQuestion(questionId).getQuestion();
    }

    public void insertRow(String questionID, String answer, String mode, String position){
        db.insertRowAnswer(questionID, answer, mode, position);
    }

    public int getRowCount(){
        return db.getRowsCountAnswer();
    }

    public AnswerTable getRow(int id){
        return db.getRowAnswer(id);
    }

}
