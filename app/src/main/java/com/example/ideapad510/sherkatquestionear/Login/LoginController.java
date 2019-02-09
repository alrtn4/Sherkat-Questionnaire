package com.example.ideapad510.sherkatquestionear.Login;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database2;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseInsertMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseSearchMethods;

public class LoginController {
    private Database2 db;
    private DatabaseInsertMethods databaseInsertMethods;
    private DatabaseSearchMethods databaseSearchMethods;

    LoginController(Context context){

        db = Database2.getInstance(context);
        databaseInsertMethods = new DatabaseInsertMethods(context);
        databaseSearchMethods = new DatabaseSearchMethods(context);
    }

    public void insertToDatabase(String username, String password, String code){
        databaseInsertMethods.insertRowLogin(username,password, code);
    }

    public boolean searchInDatabase2(String username, String password){
        if(!username.isEmpty() & !password.isEmpty())
            return databaseSearchMethods.searchInDatabaseLogin(username,password);
        return false;
    }

}
