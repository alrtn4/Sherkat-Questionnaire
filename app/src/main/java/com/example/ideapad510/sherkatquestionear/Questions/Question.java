package com.example.ideapad510.sherkatquestionear.Questions;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionTable1;
import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerController;
import com.example.ideapad510.sherkatquestionear.R;
import com.example.ideapad510.sherkatquestionear.Save.Result;
import com.example.ideapad510.sherkatquestionear.Save.SaveResult;

import java.util.ArrayList;

public class Question extends Activity {
    private TextView questionText;
    private TextView partNumberText;
    private ArrayList<String> answers;
    private AnswerController answerControler = new AnswerController(this);
    private QuestionController questionControler = new QuestionController(this);
    private ArrayList<QuestionObject> questionObjectArray = new ArrayList<>();
    private int pageNumber = 0;
    private ArrayList<QuestionDemandObject> questionDemandArray = new ArrayList<>();
    private static final String TAG = "question";
    private SaveResult saveResult;
//    RadioGroup radioGroup;
    private int refreshTime = 0;



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

//        Log.d(TAG, "onCreate: ");
//        new QuestionController(this).insertQuestionArray(new QuestionsAnswersArray());
//        new AnswerController(this).insertAnswerArray(new QuestionsAnswersArray());

        questionDemandArray = getListOfQuestionTables();
        refreshPage(pageNumber);

        //getting username and porseshnameId from last activities and use it for filling savetable for now
        String username = getIntent().getStringExtra("user");
        String porseshnameId = getIntent().getStringExtra("porseshnameId");
        Log.d(TAG, " porseshname id is "+porseshnameId);
        Log.d(TAG, "user is "+username);
        saveResult = new SaveResult(this, porseshnameId, username);

//        radioGroup = findViewById(R.id.radioGroup);

//        checkedListener();
    }


    private void findingAnswers(){
        //this method finds answers that belong to specific question based on
        // question id of question and answer's question id
        answers = new ArrayList<>();
        int positionInArray = pageNumber;
        answers = new ArrayList<>();
        for(int i = 1; i <= answerControler.getRowCount(); i++) {
            boolean answerIdEqualsQuestionId = (answerControler.getRow(i).getQuestionID()).
                    equals(String.valueOf(questionObjectArray.get(positionInArray).getQuestionId()));
            if (answerIdEqualsQuestionId)
                answers.add(answerControler.getRow(i).getAnswer());
        }
    }

    public void onBackClicked(View view){
        if(!(pageNumber == 0)) {
            pageNumber--;
            refreshPage(pageNumber);
        }
    }

    public void onForwardClicked(View view){
        if(!(pageNumber == questionObjectArray.size() - 1)) {
            pageNumber++;
            refreshPage(pageNumber);
        }
    }

    public  void onDoneClicked(View view){
//        Log.d(TAG, "is saved to data base or not ");
        saveResult.saveToDatabase();
        Intent intent = new Intent(Question.this, Result.class);
        startActivity(intent);
    }

    private void refreshPage(int positionInQuestionLIST){
        setContentView(R.layout.question);
//        radioGroup = findViewById(R.id.radioGroup);
        refreshTime++;
        checkedListener();

        questionText = findViewById(R.id.questionTitle);
        partNumberText = findViewById(R.id.part);

//        questionObjectArray = getQuestionArray(questionDemandArray);
        questionObjectArray = getQuestionArray(getListOfQuestionTables());

        partNumberText.setText("PART : " + questionObjectArray.get(positionInQuestionLIST).getQuestionPart());
        questionText.setText((questionObjectArray.get(positionInQuestionLIST)).getQuestionText());
        findingAnswers();
        addRadioButtons(answers.size());

    }

    public void addRadioButtons(int number) {
        RadioGroup ll = findViewById(R.id.radioGroup);

        for (int i = 1; i <= number; i++) {
            RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId(View.generateViewId());
//                rdbtn.setScaleX((float)0.5);
//                rdbtn.setScaleY((float)0.5);
            rdbtn.setTextSize(15);
            RadioGroup.LayoutParams lp = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rdbtn.setLayoutParams(lp);
//            rdbtn.getLayoutParams().width = RadioGroup.LayoutParams.MATCH_PARENT;
            rdbtn.setBackgroundResource(R.drawable.rectangle);
            rdbtn.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            rdbtn.setText(answers.get(i - 1));
            ll.addView(rdbtn);
        }
    }
/*
    private void getListOfQuestionTables(){
        String demand = getIntent().getStringExtra("QT");
        String[] questionTables = demand.split("-");
        for(String s: questionTables) {
            String[] s1 = s.split("/");
            String startPosition = s1[1];

            String[] s2 = s1[0].split("\"");
            String questionTableName = s2[1];

            QuestionDemandObject questionDemand = new QuestionDemandObject(questionTableName, startPosition);
            questionDemandArray.add(questionDemand);
        }
    }
*/

    private ArrayList<QuestionDemandObject> getListOfQuestionTables(){
        ArrayList<QuestionDemandObject> questionDemandArray = new ArrayList<>();

        String demand = getIntent().getStringExtra("QT");
        String[] questionTables = demand.split("-");
        for(String s: questionTables) {
            String[] s1 = s.split("/");
            String startPosition = s1[1];

            String[] s2 = s1[0].split("\"");
            String questionTableName = s2[1];

            QuestionDemandObject questionDemand = new QuestionDemandObject(questionTableName, startPosition);
            questionDemandArray.add(questionDemand);
        }

        return questionDemandArray;
    }


    private ArrayList<QuestionObject> getQuestionArray(ArrayList<QuestionDemandObject> questionDemandArray){
        ArrayList<QuestionObject> questionArray = new ArrayList<>();

        for(QuestionDemandObject questionDemand : questionDemandArray)
            switch(questionDemand.getQuestionTableName()){
                case QuestionTable1.TABLE_NAME:
                    questionArray.addAll(questionControler.getQuestionsFromQuestionTable1(questionDemand.getStartPosition()));
            }

        return questionArray;
    }

    private void checkedListener(){
//        Log.d(TAG, "checkedListener is working");
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //using pagenumber as questionId
                String questionId = String.valueOf(pageNumber);
                //every time screen refreshes checkedId increases by ten even if we go back in pages
                //so this temporary formula solves the problem
                checkedId = checkedId - 10 * (refreshTime - 1);
                String answerId = String.valueOf( pageNumber * 10 + checkedId);
                saveResult.addToArray(questionId, answerId);
                Log.d(TAG, "is added to array "+ questionId+" "+answerId);
            }
        });

    }
}
