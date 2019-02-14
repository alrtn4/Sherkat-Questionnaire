package com.example.ideapad510.sherkatquestionear.Questions;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.Database.Database;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseInsertMethods;
import com.example.ideapad510.sherkatquestionear.Database.DatabaseSearchMethods;
import com.example.ideapad510.sherkatquestionear.Params.Params;
import com.example.ideapad510.sherkatquestionear.Questions.Answer.AnswerController;
import com.example.ideapad510.sherkatquestionear.R;
import com.example.ideapad510.sherkatquestionear.Save.SaveController;
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
//    ArrayList<String> answers;
    SaveController saveController;
    Database db;
    QuestionController questionController;
    AnswerController answerController;
    Lists listcontroller;
    Params params = Params.getInstance();

    public RadioButtons(Activity activity, Context context, String username, String porseshnameId,
                        int pageNumber ){
        this.activity = activity;
        this.context = context;
        this.username = username;
        this.porseshnameId = porseshnameId;
        this.pageNumber = pageNumber;
        saveController = new SaveController(context);
        db = Database.getInstance(context);
        questionController = new QuestionController(context);
        answerController = new AnswerController(context);
        listcontroller = new Lists(activity, pageNumber, context);
    }



    public void addRadioButtons(int number, ArrayList<String> answers, int pageNumber) {
        RadioGroup radioGroup = activity.findViewById(R.id.radioGroup);
//        SaveController saveController = newlayout SaveController(context);
//        Chosens chosens =newlayout Chosens(context, username);

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
//                rdbtn.setChecked(true);
            }
            else
                rdbtn.setBackgroundResource(R.drawable.rectangle);
//            rdbtn.setChecked(true);
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
                DatabaseSearchMethods databaseSearchMethods = new DatabaseSearchMethods(context);
                DatabaseInsertMethods databaseInsertMethods = new DatabaseInsertMethods(context);

                RadioButton radioButton = activity.findViewById(checkedId);
                if(databaseSearchMethods.searchInSave(porseshnameId, username, questionId, answerId, pasokhgoo)) {
                    databaseInsertMethods.insertRowSave(questionId, answerId, porseshnameId, username, pasokhgoo);
                    radioButton.setBackgroundResource(R.drawable.rectangle2);
                }
                else {
                    databaseSearchMethods.deletSavedAnswer(porseshnameId, username, questionId, answerId, pasokhgoo);
                    radioButton.setBackgroundResource(R.drawable.rectangle);
                }
//                refreshPage(pageNumber);

            }
        });

    }


    public void refreshPage(int positionInQuestionList ){
//        pageNumber = positionInQuestionList;
        activity.setContentView(R.layout.question);
        checkedListener();

        TextView questionText = activity.findViewById(R.id.questionTitle);
        TextView partNumberText = activity.findViewById(R.id.part);

        ArrayList<QuestionObject> questionObjectArray = listcontroller.getQuestionArray(listcontroller.getListOfQuestionTables());

        partNumberText.setText("PART : " + questionObjectArray.get(positionInQuestionList).getQuestionPart());
        questionText.setText((positionInQuestionList+1)+" : "+(questionObjectArray.get(positionInQuestionList)).getQuestionText());
        ArrayList <String> answers = listcontroller.findingAnswers(positionInQuestionList);
        addRadioButtons(answers.size(), answers, positionInQuestionList);

    }


}
