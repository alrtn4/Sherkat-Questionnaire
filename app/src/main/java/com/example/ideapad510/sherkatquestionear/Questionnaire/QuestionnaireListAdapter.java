package com.example.ideapad510.sherkatquestionear.Questionnaire;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

public class QuestionnaireListAdapter extends ArrayAdapter {
    private final Activity context;
    private final ArrayList<String> questionnaireArray;

    public QuestionnaireListAdapter(Activity context, ArrayList<String> questionnaireArray){
        super(context, R.layout.answerlist_row, questionnaireArray);

        this.context=context;
        this.questionnaireArray = questionnaireArray;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.answerlist_row, null,true);

        TextView questionnaireTextField = rowView.findViewById(R.id.row);

        questionnaireTextField.setText(questionnaireArray.get(position));

        return rowView;
    }
}
