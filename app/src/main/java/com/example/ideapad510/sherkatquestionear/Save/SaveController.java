package com.example.ideapad510.sherkatquestionear.Save;

//this class connects save classes to database

import android.content.Context;
import android.util.Log;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Database.Tables.SaveTable;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class SaveController {
    private Database db;
    String TAG = "savecontroller";

    public SaveController(Context context){
        db = Database.getInstance(context);
    }

    public void insertToDatabase(String questionId, String answerId, String porseshnameId, String user){
        db.insertRowSave(questionId, answerId, porseshnameId, user);
    }

    public SaveTable getRowSave(int id){
        return db.getRowSave(id);
    }

    public ArrayList<SaveObject> getAllSaves(String user){
        return db.getAllSaves(user);
    }

    public ArrayList getAnswersCheckedFromDatabase(int questionId , String user){
        ArrayList arrayList = new ArrayList();
        for(SaveObject savobj : getAllSaves(user))
            if(savobj.getQuestionId().equals(String.valueOf(questionId)))
                arrayList.add(savobj.getAnswerId());
        return arrayList;
    }

    public boolean isAnswerSelected(int questionId, int answerId, String user){
        boolean answerSelected = false;
        int numberOfAnswersForThisQuestion = getAnswersCheckedFromDatabase(questionId, user).size();
        for(int i = 0; i < numberOfAnswersForThisQuestion; i++) {
            boolean isThisAnswerRecordedInDatabase = getAnswersCheckedFromDatabase(questionId, user).get(i).
                    equals(String.valueOf(answerId));
            if (isThisAnswerRecordedInDatabase) {
                answerSelected = true;
            }
        }
        return answerSelected;
    }

    public long idOfselectedAnswer(int questionId, int answerId, String user, String porseshnameId){
        return db.getIdOfSelectedAnswer(porseshnameId , user, String.valueOf(questionId), String.valueOf(answerId));
    }

    public void deleteSelectedAnswer(long id){
        db.deletSingleRowSaveTable(id);
    }
}
