package com.example.ideapad510.sherkatquestionear.Questions.Answer;


import android.content.Context;
import android.util.Log;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Questions.QuestionAndAnswerObject;

import java.util.ArrayList;



public class AnswerController {
    private Database db;
    public String TAG = "answercontroler";

    public AnswerController(Context context){
        db = Database.getInstance(context);
    }

    public void insertToDatabase(String questionID, String answer, String mode, String position){
        db.insertRowAnswer(questionID, answer, mode, position);
    }

    public int getRowCount(){
        return db.getRowsCountAnswer();
    }

    public AnswerTable1 getRow(int id){
        return db.getRowAnswer(id);
    }

    public void insertAnswerArray(ArrayList<QuestionAndAnswerObject> array){
       //i is for questionANDanswer array count , j is for count of answers in each member of array
        Log.d(TAG, "is "+array.size());
        for(int i = 0; i < array.size(); i++)
            for(int j = 0; j <= 9; j++)
                insertToDatabase(array.get(i).getQuestionId() ,
                        array.get(i).getAnswer().get(j), "0", "0");
    }

}
