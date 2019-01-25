package com.example.ideapad510.sherkatquestionear.Answer;

public class AnswerTable2 {
    public static final String TABLE_NAME = "answer";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_QUESTION_ID = "questionID";
    public static final String COLUMN_ANSWER = "answerTXT";
    public static final String COLUMN_MODE = "mode";
    public static final String COLUMN_POSITION = "position";

    private int id;
    private String questionID;
    private String answer;
    private String mode;
    private String position;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_QUESTION_ID + " TEXT,"
                    + COLUMN_ANSWER + " TEXT,"
                    + COLUMN_MODE + " TEXT,"
                    + COLUMN_POSITION + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public AnswerTable2(int id, String questionID, String answer, String mode, String position) {
        this.id = id;
        this.questionID = questionID;
        this.answer = answer;
        this.mode = mode;
        this.position = position;
    }


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getQuestionID() {return questionID;}

    public String getAnswer() {return answer;}

    public String getMode() {return mode;}

    public String getPosition() {return position;}


}