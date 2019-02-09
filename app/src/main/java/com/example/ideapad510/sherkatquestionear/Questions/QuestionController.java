package com.example.ideapad510.sherkatquestionear.Questions;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database2;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseInsertMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseSearchMethods;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionAnswerArray.ShortedQuestionAnswerObject;

import java.util.ArrayList;

public class QuestionController {
    private Database2 db;
    private DatabaseInsertMethods databaseInsertMethods;
    private DatabaseSearchMethods databaseSearchMethods;

    public QuestionController(Context context){
        db = Database2.getInstance(context);
        databaseInsertMethods = new DatabaseInsertMethods(context);
        databaseSearchMethods = new DatabaseSearchMethods(context);
    }

    public void insertToDatabase(String question, String position, String part){
        databaseInsertMethods.insertRowQuestion(question, position, part);
    }

    public void insertQuestionArray(ArrayList<ShortedQuestionAnswerObject> array){
        for(int i = 0; i < array.size(); i++)
            insertToDatabase(array.get(i).getQuestion(),
                    "0", "1");
    }

    public ArrayList<QuestionObject> getQuestionsFromQuestionTable(String start){
        return databaseSearchMethods.getQuestionsFromQuestionTable2( start);
    }

}
