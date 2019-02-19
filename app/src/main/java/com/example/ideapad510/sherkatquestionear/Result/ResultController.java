package com.example.ideapad510.sherkatquestionear.Result;

//this class connects result classes to database

import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Tables.ResultTable;
import com.example.ideapad510.sherkatquestionear.ParentClass.Controller;

import java.util.ArrayList;

public class ResultController extends Controller{

    public ResultController(Context context){
        super(context);
    }

    public void insertToDatabase(String questionId, String answerId, String porseshnameId, String user, String pasokhgoo){
        databaseInsertMethods.insertRowSave(questionId, answerId, porseshnameId, user, pasokhgoo);
    }

    public ResultTable getRowSave(int id){
        return databaseGetMethods.getRowSave(id);
    }

    public ArrayList<ResultObject> getAllResults(String user, String pasokhgoo){
        return databaseSearchMethods.getAllResults(user, pasokhgoo);
    }

}
