package com.example.ideapad510.sherkatquestionear.Question;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;

import java.util.ArrayList;

public class QuestionControler {
    private Database db;

    QuestionControler(Context context){
        db = Database.getInstance(context);
    }

    public ArrayList<String> getPartedQuestions(int part){
        return db.getPartedQuestions(part);
    }

    public void insertToDatabase(String question, String position, String part){
        db.insertRowQuestion(question, position, part);
    }

}
