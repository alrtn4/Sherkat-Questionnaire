package com.example.ideapad510.sherkatquestionear.Save;

//this class saves results of answer to questions
//this class is created because we had a username and porseshnameId that repeated in every question
//so it removes every time inputing this variables

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class SaveResult {
    ArrayList<SaveObject> saveArray = new ArrayList<>();
    String porseshnameId = "";
    String user = "";
    Context context;
    String TAG = "SaveResult";

    public SaveResult(Context context, String porseshnameId, String user){
        this.context = context;
        this.porseshnameId = porseshnameId;
        this.user = user;
    }

    public void saveToDatabase(String questionId, String answerId, String delete){
        SaveController saveController = new SaveController(context);
        saveController.insertToDatabase(questionId, answerId, porseshnameId, user, delete);
    }
}
