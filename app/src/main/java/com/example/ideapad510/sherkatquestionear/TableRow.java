package com.example.ideapad510.sherkatquestionear;

public class TableRow {
    public static final String TABLE_NAME = "userpass";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOTE1 = "username";
    public static final String COLUMN_NOTE2 = "password";

    private int id;
    private String note1;
    private String note2;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_NOTE1 + " TEXT,"
                    + COLUMN_NOTE2 + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public TableRow(String note1, String note2, int id) {
        this.id = id;
        this.note1 = note1;
        this.note2 = note2;
    }


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNote1() {return note1;}

    public String getNote2() {return note2;}


}