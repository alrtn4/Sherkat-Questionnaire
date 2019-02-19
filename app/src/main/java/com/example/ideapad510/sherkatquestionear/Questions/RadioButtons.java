package com.example.ideapad510.sherkatquestionear.Questions;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseInsertMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseOtherMethods;
import com.example.ideapad510.sherkatquestionear.Params.Params;
import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerController;
import com.example.ideapad510.sherkatquestionear.R;
import com.example.ideapad510.sherkatquestionear.Result.ResultController;
//import com.example.ideapad510.sherkatquestionear.Save.SaveResult;

import java.util.ArrayList;

/**
 * Created by Ideapad 510 on 2/7/2019.
 */

public class RadioButtons {
    Activity activity;
    Context context;
    String username;
    String porseshnameId;
    int pageNumber;
    ResultController resultController;
    Database db;
    QuestionController questionController;
    AnswerController answerController;
    Lists lists;
    Params params = Params.getInstance();
    String TAG = "RadioButtons";

    public RadioButtons(Activity activity, Context context, String username, String porseshnameId,
                        int pageNumber ){
        this.activity = activity;
        this.context = context;
        this.username = username;
        this.porseshnameId = porseshnameId;
        this.pageNumber = pageNumber;
        resultController = new ResultController(context);
        db = Database.getInstance(context);
        questionController = new QuestionController(context);
        answerController = new AnswerController(context);
        lists = new Lists(activity, pageNumber, context);
    }



    public void addRadioButtons(int number, ArrayList<String> answers, int pageNumber) {
        RadioGroup radioGroup = activity.findViewById(R.id.radioGroup);

        for (int i = 1; i <= number; i++) {
            RadioButton rdbtn = new RadioButton(context);
            rdbtn.setId(i);
            rdbtn.setTextSize(15);

            RadioGroup.LayoutParams lp = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rdbtn.setLayoutParams(lp);

            String questionId = String.valueOf(pageNumber+1);
            String answerId = String.valueOf(i);
            String pasokhgoo = params.getPasokhgoo();

            if(questionController.searchInSave(porseshnameId, username, questionId, answerId, pasokhgoo)) {
                rdbtn.setBackgroundResource(R.drawable.rectangle2);
            }
            else
                rdbtn.setBackgroundResource(R.drawable.rectangle7);

            rdbtn.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            rdbtn.setText(answers.get(i - 1));
            radioGroup.addView(rdbtn);
        }
    }

    public void checkedListener(){
        final RadioGroup radioGroup = activity.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            //using pagenumber as questionId
            String questionId = String.valueOf(pageNumber+1);
            String answerId = String.valueOf( checkedId);
            String pasokhgoo = params.getPasokhgoo();

            DatabaseOtherMethods databaseSearchMethods = new DatabaseOtherMethods(context);
            DatabaseInsertMethods databaseInsertMethods = new DatabaseInsertMethods(context);

            RadioButton radioButton = activity.findViewById(checkedId);
            if(!questionController.searchInSave(porseshnameId, username, questionId, answerId, pasokhgoo)) {
                resultController.insertToDatabase(questionId, answerId, porseshnameId, username, pasokhgoo);
                radioButton.setBackgroundResource(R.drawable.rectangle2);
            }
            else {
                databaseSearchMethods.deletSavedResult(porseshnameId, username, questionId, answerId, pasokhgoo);
                radioButton.setBackgroundResource(R.drawable.rectangle4);
            }

            }
        });

    }


    public void refreshPage(int positionInQuestionList ){
        activity.setContentView(R.layout.question);
        checkedListener();

        TextView questionText = activity.findViewById(R.id.questionTitle);
        TextView partNumberText = activity.findViewById(R.id.part);

        ArrayList<QuestionObject> questionObjectArray = lists.getQuestionArray(lists.getListOfQuestionTables());

        partNumberText.setText("PART : " + questionObjectArray.get(positionInQuestionList).getQuestionPart());
//        questionText.setText((positionInQuestionList+1)+" - "+(questionObjectArray.get(positionInQuestionList)).getQuestionText());
        questionText.setText((questionObjectArray.get(positionInQuestionList)).getQuestionText());

        ArrayList <String> answers = lists.findingAnswers(positionInQuestionList);
        addRadioButtons(answers.size(), answers, positionInQuestionList);

    }


}
