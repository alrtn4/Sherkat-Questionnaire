package com.example.ideapad510.sherkatquestionear.Database.Tables;

public class LoginTable {
    public static final String TABLE_NAME = "userpass";
    public static final String COLUMN_ID = "id";
    public static final String jmr_user = "username";
    public static final String jmr_pass = "password";
    public static final String jmr_code = "jmrcode";

    private int id;
    private String username;
    private String password;
    private String code;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + jmr_user + " TEXT,"
                    + jmr_pass + " TEXT,"
                    + jmr_code + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public LoginTable(String user, String pass, String code, int id) {
        this.id = id;
        this.username = user;
        this.password = pass;
        this.code = code;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public String getCode() {return code;}
}