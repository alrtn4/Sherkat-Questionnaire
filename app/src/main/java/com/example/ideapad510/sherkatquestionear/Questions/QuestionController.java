package com.example.ideapad510.sherkatquestionear.Questions;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;

import java.util.ArrayList;

public class QuestionController {
    private Database db;

    QuestionController(Context context){
        db = Database.getInstance(context);
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

    public void insertQuestionArray(ArrayList<QuestionAndAnswerObject> array){
        for(int i = 0; i < array.size(); i++)
            insertToDatabase(array.get(i).getQuestion(),
                    "0", "1");
    }

    public ArrayList<QuestionObject> getQuestionsFromQuestionTable1( String start){
        return db.getQuestionsFromQuestionTable1( start);
    }

}
