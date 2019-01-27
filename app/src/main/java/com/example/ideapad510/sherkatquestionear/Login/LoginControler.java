package com.example.ideapad510.sherkatquestionear.Login;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;

public class LoginControler {
    private Database db;

    LoginControler(Context context){
        db = Database.getInstance(context);
    }

    public void insertToDatabase(String username, String password){
        db.insertRowLogin(username,password);
    }

    public boolean searchInDatabase(String username, String password){
//        return db.searchInDatabaseLogin(username,password);
        if(!username.isEmpty() & !password.isEmpty())
            return db.searchInDatabaseLogin(username,password);
        return false;
    }
}
