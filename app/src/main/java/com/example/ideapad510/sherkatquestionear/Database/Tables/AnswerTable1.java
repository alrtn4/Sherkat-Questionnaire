package com.example.ideapad510.sherkatquestionear.Database.Tables;

public class AnswerTable1 {
    public static final String TABLE_NAME = "answer1";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_QUESTION_ID = "questionID";
    public static final String COLUMN_ANSWER = "answerTXT";
    public static final String COLUMN_MODE = "mode";
    public static final String COLUMN_POSITION = "position";
    public static final String COLUMN_GOTO = "goto";
    public static final String COLUMN_SCOUR = "scour";
    public static final String COLUMN_FUNCTION = "function";

    private int id;
    private String questionID;
    private String answer;
    private String mode;
    private String position;
    private String goTo;
    private String scour;
    private String function;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_QUESTION_ID + " TEXT,"
                    + COLUMN_ANSWER + " TEXT,"
                    + COLUMN_MODE + " TEXT,"
                    + COLUMN_POSITION + " TEXT,"
                    + COLUMN_GOTO + " TEXT,"
                    + COLUMN_SCOUR + " TEXT,"
                    + COLUMN_FUNCTION + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + ")";


    public AnswerTable1(int id, String questionID, String answer, String mode, String position,
                        String goTo, String scour, String function) {
        this.id = id;
        this.questionID = questionID;
        this.answer = answer;
        this.mode = mode;
        this.position = position;
        this.goTo = goTo;
        this.scour = scour;
        this.function = function;
    }


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getQuestionID() {return questionID;}

    public String getAnswer() {return answer;}

    public String getMode() {return mode;}

    public String getPosition() {return position;}


}