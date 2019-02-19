package com.example.ideapad510.sherkatquestionear.Login;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.ParentClass.Controller;

public class LoginController extends Controller{

    LoginController(Context context){
        super(context);
    }

    public void insertToDatabase(String username, String password, String code){
        databaseInsertMethods.insertRowLogin(username,password, code);
    }

    public boolean searchInDatabase(String username, String password){
        if(!username.isEmpty() & !password.isEmpty())
            return databaseSearchMethods.searchInDatabaseLogin(username,password);
        return false;
    }

}
