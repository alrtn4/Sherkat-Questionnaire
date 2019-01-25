package com.example.ideapad510.sherkatquestionear.Answer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ideapad510.sherkatquestionear.R;

import java.util.ArrayList;

public class AnswerListAdapter2 extends ArrayAdapter {
    private final Activity context;
    private final ArrayList<String> answerArray;
    private final int qustionId;

    public AnswerListAdapter2(Activity context, ArrayList<String> answerArrayParam, int questionIdParam){

        super(context, R.layout.listview_row , answerArrayParam);

        this.context=context;
        this.answerArray = answerArrayParam;
        this.qustionId = questionIdParam;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        TextView answersTextField = rowView.findViewById(R.id.row);

        answersTextField.setText(answerArray.get(position));

        return rowView;

    }

}
