package com.example.ideapad510.sherkatquestionear.Database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ideapad510.sherkatquestionear.Database.Tables.AnswerTable1;
import com.example.ideapad510.sherkatquestionear.Database.Tables.LoginTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionnaireTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.ResultTable;
import com.example.ideapad510.sherkatquestionear.Database.Tables.phone;

public class Database extends SQLiteOpenHelper {
    private static final String TAG = "Database";

    private static Database instance;
    private static final int DATABASE_VERSION = 1;

    private static String DATABASE_NAME = "Table_db";

    private Context context;

    private Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public static Database getInstance(Context context){
        if (instance == null){
            instance = new Database(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LoginTable.CREATE_TABLE);
        db.execSQL(QuestionTable.CREATE_TABLE);
        db.execSQL(AnswerTable1.CREATE_TABLE);
        db.execSQL(QuestionnaireTable.CREATE_TABLE);
        db.execSQL(ResultTable.CREATE_TABLE);
        db.execSQL(phone.CREATE_TABLE);
//        db.execSQL(LogTable.CREATE_TABLE);
//        db.execSQL(n1001_a.CREATE_TABLE);
//        db.execSQL(n2001_a.CREATE_TABLE);
//        db.execSQL(n3001_a.CREATE_TABLE);
//        db.execSQL(n1001_q.CREATE_TABLE);
//        db.execSQL(n2001_q.CREATE_TABLE);
//        db.execSQL(n3001_q.CREATE_TABLE);
//        db.execSQL(qlcode_r.CREATE_TABLE);
//        db.execSQL(qlcode_t.CREATE_TABLE);
//        db.execSQL(qlTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LoginTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AnswerTable1.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionnaireTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ResultTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + phone.TABLE_NAME);
        onCreate(db);
    }



    public int getRowsCount(String tableName) {
        String countQuery = "SELECT  * FROM " + tableName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }


}
