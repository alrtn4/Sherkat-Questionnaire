package com.example.ideapad510.sherkatquestionear.Questions.Answer;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;

public class AnswerController {
    private Database db;

    public AnswerController(Context context){
        db = Database.getInstance(context);
    }

    public void insertToDatabase(String questionID, String answer, String mode, String position){
        db.insertRowAnswer(questionID, answer, mode, position);
    }

    public int getRowCount(){
        return db.getRowsCountAnswer();
    }

    public AnswerTable getRow(int id){
        return db.getRowAnswer(id);
    }

}
