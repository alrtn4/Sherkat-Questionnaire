package com.example.ideapad510.sherkatquestionear.Login;

public class LoginTable {
    public static final String TABLE_NAME = "userpass";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    private int id;
    private String username;
    private String password;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_USERNAME + " TEXT,"
                    + COLUMN_PASSWORD + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public LoginTable(String user, String pass, int id) {
        this.id = id;
        this.username = user;
        this.password = pass;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getUsername() {return username;}

    public String getPassword() {return password;}
}