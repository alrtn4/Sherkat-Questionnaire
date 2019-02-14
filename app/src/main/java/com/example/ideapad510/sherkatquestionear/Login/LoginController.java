package com.example.ideapad510.sherkatquestionear.Login;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseInsertMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseSearchMethods;
import com.example.ideapad510.sherkatquestionear.ParentClass.Controller;

public class LoginController extends Controller{
/*
    private Database db;
    private DatabaseInsertMethods databaseInsertMethods;
    private DatabaseSearchMethods databaseSearchMethods;
*/
    LoginController(Context context){
        super(context);
/*        db = Database.getInstance(context);
        databaseInsertMethods = newlayout DatabaseInsertMethods(context);
        databaseSearchMethods = newlayout DatabaseSearchMethods(context);
*/    }

    public void insertToDatabase(String username, String password, String code){
        databaseInsertMethods.insertRowLogin(username,password, code);
    }

    public boolean searchInDatabase(String username, String password){
        if(!username.isEmpty() & !password.isEmpty())
            return databaseSearchMethods.searchInDatabaseLogin(username,password);
        return false;
    }

}
