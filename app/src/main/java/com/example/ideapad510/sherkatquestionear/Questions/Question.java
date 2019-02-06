package com.example.ideapad510.sherkatquestionear.Questions;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Database.Tables.QuestionTable1;
import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerController;
import com.example.ideapad510.sherkatquestionear.R;
import com.example.ideapad510.sherkatquestionear.Save.Result;
import com.example.ideapad510.sherkatquestionear.Save.SaveController;
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
    private String username;
    private SaveController saveController = new SaveController(this);
    private Chosens chosens = new Chosens(this, username);
    String porseshnameId;




    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

        questionDemandArray = getListOfQuestionTables();
        refreshPage(pageNumber);

        //getting username and porseshnameId from last activities and use it for filling savetable for now
        username = getIntent().getStringExtra("user");
        porseshnameId = getIntent().getStringExtra("porseshnameId");
        saveResult = new SaveResult(this, porseshnameId, username);

        Database db = Database.getInstance(this);
//        db.deletSingleRowSaveTable(1);
//        db.deletSingleRowSaveTable(2);
//        db.deletSingleRowSaveTable(3);

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onResume(){
        super.onResume();

        refreshPage(pageNumber);
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
//        saveResult.saveToDatabase();
        Intent intent = new Intent(Question.this, Result.class);
        intent.putExtra("user",username);
        startActivity(intent);
    }

    private void refreshPage(int positionInQuestionLIST){
        setContentView(R.layout.question);
        refreshTime++;
        checkedListener();

        questionText = findViewById(R.id.questionTitle);
        partNumberText = findViewById(R.id.part);

        questionObjectArray = getQuestionArray(getListOfQuestionTables());

        partNumberText.setText("PART : " + questionObjectArray.get(positionInQuestionLIST).getQuestionPart());
        questionText.setText((pageNumber+1)+" : "+(questionObjectArray.get(positionInQuestionLIST)).getQuestionText());
        findingAnswers();
        addRadioButtons(answers.size());

    }

    public void addRadioButtons(int number) {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        SaveController saveController = new SaveController(this);

        for (int i = 1; i <= number; i++) {
            RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId(i);
            rdbtn.setTextSize(15);
            RadioGroup.LayoutParams lp = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rdbtn.setLayoutParams(lp);
            if(saveController.isAnswerSelected(pageNumber+1, i, username)) {
                rdbtn.setBackgroundResource(R.drawable.rectangle2);
//                Log.d(TAG, "radio button is chosed "+i);
            }
            else
                rdbtn.setBackgroundResource(R.drawable.rectangle);
            rdbtn.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            rdbtn.setText(answers.get(i - 1));
            radioGroup.addView(rdbtn);
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
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //using pagenumber as questionId
                String questionId = String.valueOf(pageNumber+1);
                String answerId = String.valueOf( checkedId);
//                if(!chosens.isChosen(pageNumber+1, checkedId, username)) {
                    saveResult.saveToDatabase(questionId, answerId);
                    refreshPage(pageNumber);
                    Log.d(TAG, "onCheckedChanged: answer is chosen "+answerId);
//                }
//                deletSelectedTwice(checkedId);
//                Log.d(TAG, "id of selected answer is "+
//                        saveController.idOfselectedAnswer(pageNumber+1,checkedId,username,porseshnameId));
//                 if(chosens.isChosen(pageNumber+1 , checkedId , username)){
//                    RadioButton rdbtn = findViewById(checkedId);
//                    rdbtn.setBackgroundResource(R.drawable.rectangle);
                    long idOfSelectedAnswer = saveController.idOfselectedAnswer(pageNumber+1,
                            checkedId,username,porseshnameId);
//                    saveController.deleteSelectedAnswer(idOfSelectedAnswer);
//                    saveController.deleteSelectedAnswer(1);

//                    refreshPage(pageNumber);
                    Log.d(TAG, "onCheckedChanged: answer is not chosen " + idOfSelectedAnswer);
//                }

            }
        });

    }
/*
    private boolean isChosenBefore(RadioGroup rg){
//        SaveController svctl = new SaveController(this);
        int selectedId = rg . getCheckedRadioButtonId();
        Log.d(TAG, "checked button is : "+selectedId);
        RadioButton rb = findViewById(selectedId);
//        rb.setBackgroundResource(R.drawable.rectangle);
        Log.d(TAG, "background is "+rb.getBackground().getConstantState());
        Log.d(TAG, "drawable is  "+getResources().getDrawable(R.drawable.rectangle2).getConstantState());
//        if( (rb.getBackground().getConstantState()).equals(getResources().getDrawable(R.drawable.rectangle2).getConstantState()))
        if( (rb.getBackground()).equals(getResources().getDrawable(R.drawable.rectangle2)))
            Log.d(TAG, " the button is blue");
        return true;
    }
*/
    //this method delets the answer that is selected twice in a row i.e. we can delete a choice by choicing it again
    private void deletSelectedTwice(int checkedId){
                if(chosens.isChosen(pageNumber+1 , checkedId , username)){
//            Log.d(TAG, "chosen checked ");
        //        if(chosens.isChosen(pageNumber+1 , checkedId , username)){
            RadioButton rdbtn = findViewById(checkedId);
            rdbtn.setBackgroundResource(R.drawable.rectangle);
//            long idOfSelectedAnswerInSaveTable = saveController.idOfselectedAnswer(pageNumber+1,
//                    checkedId,username,porseshnameId);
//                    Log.d(TAG, "id of answer is  "+idOfSelectedAnswerInSaveTable);
//            saveController.deleteSelectedAnswer(idOfSelectedAnswerInSaveTable);
//            saveController.deleteSelectedAnswer(2);
                }

    }

}
