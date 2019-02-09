package com.example.ideapad510.sherkatquestionear.Questions.Answer;


import android.content.Context;
import android.util.Log;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Database.Database2;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseGetMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseInsertMethods;
import com.example.ideapad510.sherkatquestionear.Database.Tables.AnswerTable1;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionAnswerArray.ShortedQuestionAnswerObject;

import java.util.ArrayList;



public class AnswerController {
    private Database2 db;
    private DatabaseInsertMethods databaseInsertMethods;
    private DatabaseGetMethods databaseGetMethods;
    public String TAG = "answercontroller";

    public AnswerController(Context context){
        db = Database2.getInstance(context);
        databaseInsertMethods = new DatabaseInsertMethods(context);
        databaseGetMethods =new DatabaseGetMethods(context);
        Log.d(TAG, "AnswerController: ");
    }

    public void insertToDatabase(String questionID, String answer, String mode, String position){
        databaseInsertMethods.insertRowAnswer(questionID, answer, mode, position);
    }

    public int getRowCount(){
        return db.getRowsCount(AnswerTable1.TABLE_NAME);
    }

    public AnswerTable1 getRow(int id){
        return databaseGetMethods.getRowAnswer(id);
    }

    public void insertAnswerArray(ArrayList<ShortedQuestionAnswerObject> array){
       //i is for questionANDanswer array count , j is for count of answers in each member of array
        for(int i = 0; i < array.size(); i++)
            for(int j = 0; j <= 9; j++)
                insertToDatabase(array.get(i).getQuestionId() ,
                        array.get(i).getAnswer().get(j), "0", "0"); //getAnswer method returns an array of answers
                                                                                   //that belong to this specific question
    }

}
