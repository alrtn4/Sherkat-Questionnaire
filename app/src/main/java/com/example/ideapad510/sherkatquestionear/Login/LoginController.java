package com.example.ideapad510.sherkatquestionear.Login;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;

public class LoginController {
    private Database db;

    LoginController(Context context){
        db = Database.getInstance(context);
    }

    public void insertToDatabase(String username, String password, String code){
        db.insertRowLogin(username,password, code);
    }

    public boolean searchInDatabase(String username, String password){
        if(!username.isEmpty() & !password.isEmpty())
            return db.searchInDatabaseLogin(username,password);
        return false;
    }
}
