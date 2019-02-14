package com.example.ideapad510.sherkatquestionear.Database.Tables;

/**
 * Created by Ideapad 510 on 2/12/2019.
 */

public class phone {
    public static final String TABLE_NAME = "phonee";
    public static final String COLUMN_ID = "id";
    public static final String phoneNumber = "phoneNumber";

    private int id;
    private String phoneee;

/*    public static final String CREATE_TABLE =
            "CREATE TABLE "+ TABLE_NAME + " ( "
                    + phoneNumber + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
            + ")";
*/


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + phoneNumber + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public phone(int id, String phoneNumber){
        this.id = id;
        this.phoneee = phoneNumber;
    }


}
