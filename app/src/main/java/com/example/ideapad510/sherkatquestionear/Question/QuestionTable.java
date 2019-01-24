package com.example.ideapad510.sherkatquestionear.Question;

public class QuestionTable {
    public static final String TABLE_NAME = "question";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_QUESTION = "question";
    public static final String COLUMN_POSITION = "position";
    public static final String COLUMN_PART = "part";

    private int id;
    private String question;
    private String position;
    private String part;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_QUESTION + " TEXT,"
                    + COLUMN_POSITION + " TEXT,"
                    + COLUMN_PART + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public QuestionTable(String question, String position, String part, int id) {
        this.id = id;
        this.question = question;
        this.position = position;
        this.part = part;
    }


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getQuestion() {return question;}

    public String getPosition() {return position;}

    public String getPart() {return part;}

}