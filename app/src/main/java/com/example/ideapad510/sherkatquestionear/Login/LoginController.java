package com.example.ideapad510.sherkatquestionear.Login;


import android.content.Context;
import android.util.Log;

import com.example.ideapad510.sherkatquestionear.ParentClass.Controller;

import static android.content.ContentValues.TAG;

public class LoginController extends Controller{
    String TAG = "logincontroller";

    LoginController(Context context){
        super(context);
        Log.d(TAG, "LoginController: "+(context == null));
    }

    public void insertToDatabase(String username, String password, String code){
        databaseInsertMethods.insertRowLogin(username,password, code);
    }

    public boolean searchInDatabase(String username, String password){
        if(!username.isEmpty() & !password.isEmpty())
            return databaseOtherMethods.searchInDatabaseLogin(username,password);
        return false;
    }

}
