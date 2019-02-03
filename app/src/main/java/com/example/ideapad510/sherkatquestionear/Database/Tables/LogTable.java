package com.example.ideapad510.sherkatquestionear.Database.Tables;

public class LogTable {
    public static final String TABLE_NAME = "log";
    public static final String COLUMN_ID = "id";
    public static final String Jmr_code = "jmrcode";
    public static final String Time = "time";
    public static final String Column_do = "do";

    private int id;
    private String jmr_code;
    private String time;
    private String column_do;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + Jmr_code + " TEXT,"
                    + Time + " TEXT,"
                    + Column_do + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public LogTable(int id, String jmr_code, String time, String column_do ) {
        this.id = id;
        this.jmr_code = jmr_code;
        this.time = time;
        this.column_do = column_do;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getJmr_code() {return jmr_code;}

    public String getTime() {return time;}

    public String getColumn_do() {return column_do;}
}