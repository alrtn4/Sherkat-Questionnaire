package com.example.ideapad510.sherkatquestionear.ParentClass;


import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseGetMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseInsertMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseOtherMethods;

public class Controller {
    protected Database db;
    protected DatabaseGetMethods databaseGetMethods;
    protected DatabaseInsertMethods databaseInsertMethods;
    protected DatabaseOtherMethods databaseOtherMethods;

    public Controller(Context context){
        db = Database.getInstance(context);
        databaseGetMethods = new DatabaseGetMethods(context);
        databaseInsertMethods = new DatabaseInsertMethods(context);
        databaseOtherMethods = new DatabaseOtherMethods(context);
    }


}
