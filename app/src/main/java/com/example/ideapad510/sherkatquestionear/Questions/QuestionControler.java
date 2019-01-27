package com.example.ideapad510.sherkatquestionear.Questions;


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

    public ArrayList<QuestionObject> getPartedQuestionObjects(int part){
        return db.getPartedQuestionObjects(part);
    }

    public ArrayList<QuestionObject> getRandomQuestionObjects(int part){
        return db.getRandomPartedQuestionObjects(part);
    }

}
