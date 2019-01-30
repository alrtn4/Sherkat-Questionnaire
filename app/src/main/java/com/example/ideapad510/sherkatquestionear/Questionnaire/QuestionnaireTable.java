package com.example.ideapad510.sherkatquestionear.Questionnaire;

public class QuestionnaireTable {
    public static final String TABLE_NAME = "porseshname";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "questionnaireName";
    public static final String COLUMN_TEXT = "text";
    public static final String COLUMN_QT = "questionTable";   //Question Table
    public static final String COLUMN_AT = "answerTable";     //Answer Table

    private int id;
    private String name;
    private String text;
    private String qt;
    private String at;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_TEXT + " TEXT,"
                    + COLUMN_QT + " TEXT,"
                    + COLUMN_AT + " TEXT,"
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                    + " )";


    public QuestionnaireTable( int id, String name, String text, String qt,  String at) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.qt = qt;
        this.at = at;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public String getText() {return text;}

    public String getQT() {return qt;}

    public String getAT() {return at;}

}