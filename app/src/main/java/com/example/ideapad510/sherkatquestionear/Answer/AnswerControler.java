package com.example.ideapad510.sherkatquestionear.Answer;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Question.QuestionTable;

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
