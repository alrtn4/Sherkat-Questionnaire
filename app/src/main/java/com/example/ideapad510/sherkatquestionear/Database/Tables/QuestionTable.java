package com.example.ideapad510.sherkatquestionear.Database.Tables;

public class QuestionTable {
    public static final String TABLE_NAME = "question1";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_QUESTION = "questionTXT";
    public static final String COLUMN_POSITION = "position";
    public static final String COLUMN_PART = "part";
    public static final String COLUMN_CODE = "code";
    public static final String COLUMN_FUNC = "func";


    private int id;
    private String question;
    private String position;
    private String part;
    private String code;
    private String func;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_QUESTION + " TEXT,"
                    + COLUMN_POSITION + " TEXT,"
                    + COLUMN_PART + " TEXT,"
                    + COLUMN_CODE + " TEXT,"
                    + COLUMN_FUNC + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";

    public QuestionTable(String question, String position, String part, int id, String code, String func) {
        this.id = id;
        this.question = question;
        this.position = position;
        this.part = part;
        this.code = code;
        this.func = func;
    }


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getQuestion() {return question;}

    public String getPosition() {return position;}

    public String getPart() {return part;}

}