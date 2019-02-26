package com.example.ideapad510.sherkatquestionear.ql;

import android.content.Context;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseOtherMethods;
import com.example.ideapad510.sherkatquestionear.Database.Tables.qlTable;

public class qlController {

    Context context;
    DatabaseOtherMethods databaseOtherMethods = new DatabaseOtherMethods(context);
    Database database = Database.getInstance(context);

    public qlController(Context context){
        this.context = context;
    }



    public String getFunction(String jmrCode){
        return databaseOtherMethods.searchInqlTable(jmrCode);
    }

    public String getJmrcode(String username){
        return databaseOtherMethods.getJmrcodeFromLoginTable(username);
    }

    public int getCount(){
        return database.getRowsCount(qlTable.TABLE_NAME);
    }

}
