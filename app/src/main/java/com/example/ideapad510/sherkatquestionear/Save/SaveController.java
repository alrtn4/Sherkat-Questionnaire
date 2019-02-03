package com.example.ideapad510.sherkatquestionear.Save;

//this class connects save classes to database

import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Database.Tables.SaveTable;

import java.util.ArrayList;

public class SaveController {
    private Database db;

    public SaveController(Context context){db = Database.getInstance(context);}

    public void insertToDatabase(String questionId, String answerId, String porseshnameId, String user){
        db.insertRowSave(questionId, answerId, porseshnameId, user);
    }

    public SaveTable getRowSave(int id){
        return db.getRowSave(id);
    }

    public ArrayList<SaveObject> getAllSaves(){
        return db.getAllSaves();
    }
}
